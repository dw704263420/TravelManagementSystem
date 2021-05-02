package com.kuang.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.kuang.pojo.*;
import com.kuang.service.*;
import com.kuang.utils.DateStringEditor;
import com.kuang.utils.DateUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 产品相关Controler
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    @Qualifier("ProductServiceImpl")
    private ProductService productService;
    @Autowired
    @Qualifier("FavouriteServiceImpl")
    private FavouriteService favouriteService;
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;
    @Autowired
    @Qualifier("TravellerServiceImpl")
    private TravellerService travellerService;
    @Autowired
    @Qualifier("CategoryServiceImpl")
    private CategoryService categoryService;

    /**
     * 设置时间格式编码
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        binder.registerCustomEditor(Date.class,new DateStringEditor());
    }

    /**
     * 查询所有商品
     * @param model
     * @return
     * @throws Exception
     */
    @PreAuthorize("hasAnyRole('ROLE_KING','ROLE_ADMIN')")
    @GetMapping("/findAll.do")
    public String findAll(Model model,@RequestParam(name = "page",defaultValue = "1") int page,@RequestParam(name = "size",defaultValue = "10") int size) throws Exception {

        List<Product> all = productService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(all);
        model.addAttribute("pageInfo",pageInfo);

        return "product-list1";

    }

    /**
     * 添加商品
     * @param product
     * @return
     * @throws Exception
     */
    @PreAuthorize("hasAnyRole('ROLE_KING','ROLE_ADMIN')")
    @PostMapping("/save.do")
    public String saveProduct(Product product) throws Exception {

    productService.saveProduct(product);
    return "redirect:/product/findAll.do";
    }

    /**
     * 添加产品
     * @return
     */
    @PreAuthorize("hasAnyRole('ROLE_KING','ROLE_ADMIN')")
    @GetMapping("/productAdd.do")
    public String productAddPage(Model model) throws Exception {
        List<Category> all = categoryService.findAll();
        model.addAttribute("categoryList",all);
        return "product-add";

    }

    /**
     * 编辑商品-查询商品
     * @param id
     * @param model
     * @return
     * @throws Exception
     */
    @PreAuthorize("hasAnyRole('ROLE_KING','ROLE_ADMIN')")
    @GetMapping("/editProduct.do")
    public String toEditPage(int id,Model model) throws Exception {

        Product product =  productService.findProdectDetail(id);
        product.setDepartureTime(DateUtils.EngDateToCh(product.getDepartureTime(),"yyyy-MM-dd HH:mm"));
        List<Category> all = categoryService.findAll();
        model.addAttribute("categoryList",all);
        model.addAttribute("product",product);
        return "product-edit";
    }

    /**
     * 编辑商品-修改商品
     * @param request
     * @param product
     * @return
     * @throws Exception
     */
    @PostMapping("/updateProduct.do")
    public String updateProduct(HttpServletRequest request,Product product) throws Exception {
        System.out.println(product);
        productService.updateProduct(product);
        return "redirect:/product/findAll.do";
    }

    /**
     * 删除商品
     * @param id
     * @return
     * @throws Exception
     */
    @PreAuthorize("hasRole('ROLE_KING')")
    @GetMapping("/delById")
    @ResponseBody
    public String delById(int id) throws Exception {
        productService.delById(id);
        return "ok";

    }

    /**
     * 用户界面-加载所有产品
     * @param page
     * @param size
     * @param cid
     * @param model
     * @param keyWord
     * @return
     * @throws Exception
     */
    @GetMapping("/findAllProduct")
    public String findAllProduct(@RequestParam(name = "page",required = true,defaultValue = "1")int page,@RequestParam(name = "size",required = true,defaultValue = "5")int size,@RequestParam(name = "cid",required = true,defaultValue = "1")int cid,Model model,@RequestParam(name = "keyWord",required = true,defaultValue = "")String keyWord) throws Exception {
        List<Product> all = productService.findAllByWords(page,size,keyWord,cid);
        PageInfo pageInfo = new PageInfo(all);
        String cname = categoryService.findCnameByCid(cid);
        // 取5个收藏最多的产品作为热门推荐
        List<Integer> userFavouriteTopId = favouriteService.findUserFavouriteTopId(5);
        // 查看 各自的收藏次数
        if (userFavouriteTopId.size()>0)
        {
            List<Product> productByUserFavourite = productService.findProductByUserFavourite(userFavouriteTopId);
            model.addAttribute("productList",productByUserFavourite);

        }
        model.addAttribute("keyWord",keyWord);
        model.addAttribute("cid",cid);
        model.addAttribute("cname",cname);
        model.addAttribute("pageInfo",pageInfo);
        return  "user_route_list";
    }

    /**
     * 用户界面：加载产品详情
     * @param productId
     * @param model
     * @param request
     * @return
     * @throws Exception
     */
    @GetMapping("/findProductById")
    public String findProductById(@RequestParam(name = "id",required = true)int productId,Model model,HttpServletRequest request) throws Exception
    {
        HttpSession session = request.getSession();
        // 或许处于未登录状态
        if (session.getAttribute("uid")!=null)
        {
            int uid = (Integer.parseInt((String) session.getAttribute("uid")));
            boolean isFavourite = favouriteService.findUserIsFavourite(uid, productId);
            model.addAttribute("isFavourite",isFavourite);
            model.addAttribute("uid",uid);
        }

        Product product = productService.findProdectDetail(productId);
        model.addAttribute("product",product);
        return "user_route_detail";
//        return  product.toString();

    }

    /**
     * 用户界面-改变收藏状态
     * @param productId
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @GetMapping("/changeFavourite")
    public String changeFavourite(@RequestParam("productId")int productId,HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        Map<String,Object> map = new HashMap<>();
        String userId = (String)session.getAttribute("uid");
        int uid = Integer.parseInt(userId);
        boolean flag = favouriteService.changeFavourite(uid, productId);
        Product product = productService.findProdectDetail(productId);
        map.put("flag",flag);
        map.put("favouriteTimes",product.getIsFavourTimes());
        ObjectMapper mapper = new ObjectMapper();
        return  mapper.writeValueAsString(map);
        // 返回当前还是否处于收藏状态

    }

    /**
     * 用户界面-查看我的收藏列表
     * @param uid
     * @param model
     * @return
     * @throws Exception
     */
    @GetMapping("/MyFavourite")
    public String findMyFavourite(@RequestParam(name = "uid",defaultValue = "0") int uid,Model model) throws Exception {
        String val = uid+"";
        if ("".equals(val))
        {
            return "user_login";
        }
        List<Integer> userFavouriteProId = favouriteService.findUserFavouriteProId(uid);
        if (userFavouriteProId.size()>0)
        {
            List<Product> productByUserFavourite = productService.findProductByUserFavourite(userFavouriteProId);
            model.addAttribute("productList",productByUserFavourite);
        }



        return  "user_myfavorite";
    }

    /**
     * 用户界面-top收藏最高地产品
     * @param model
     * @return
     * @throws Exception
     */
    @GetMapping("/TopFavourite")
    public String findTopFavourite(Model model) throws Exception {
        // 取前8个吧
        List<Integer> userFavouriteTopId = favouriteService.findUserFavouriteTopId(8);
        // 查看 各自的收藏次数
        if (userFavouriteTopId.size()>0)
        {
            List<Product> productByUserFavourite = productService.findProductByUserFavourite(userFavouriteTopId);
            model.addAttribute("productList",productByUserFavourite);

        }
        return  "user_favoriterank";
    }

    /**
     * 用户界面-进入下单页面
     * @param productId
     * @param uid
     * @param model
     * @return
     * @throws Exception
     */
    @GetMapping("/buyProduct")
    public String buyProduct(String productId,String uid,Model model) throws Exception {
        if ("".equals(uid) || uid==null)
        {
            return "user_login";
        }

        // 产品信息重新渲染回页面
        Product prodectDetail = productService.findProdectDetail(Integer.parseInt(productId));
        model.addAttribute("product",prodectDetail);
        // 查询用户信息（联系人真人信息）
        UserInfo userById = userService.findUserById(uid);
        model.addAttribute("uuser",userById);
        //
        return  "buy-product";
    }
}
