package com.kuang.controller;

import com.kuang.pojo.Banner;
import com.kuang.pojo.RouteImg;
import com.kuang.service.RouteImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

@Controller
@RequestMapping("/routeImage")
public class RouteImagecontroller {

    @Autowired
    @Qualifier("RouteImageServiceImpl")
    private RouteImageService routeImageService;


    /**
     * 添加大小图（缩略图）
     * @param rid
     * @param bigPicFile
     * @param smallPicFile
     * @param request
     * @return
     * @throws IOException
     */
    @PreAuthorize("hasAnyRole('ROLE_KING','ROLE_ADMIN')")
    @PostMapping("/addThumbnail")
    public String addThumbnail(String rid, @RequestParam("bigPicFile") CommonsMultipartFile bigPicFile, @RequestParam("smallPicFile") CommonsMultipartFile smallPicFile, HttpServletRequest request) throws IOException {

        String uploadFileName= bigPicFile.getOriginalFilename();
        String uploadFileName_small= smallPicFile.getOriginalFilename();
        if("".equals( uploadFileName))
        {
            return  "redirect:findAll.do";
        }
        String small_path = request.getServletContext().getRealPath("/img/product/size2/");
        String big_path = request.getServletContext().getRealPath("/img/product/size4/");
        File small_realPath = new File(small_path);
        File big_realPath = new File(big_path);
        if (!small_realPath.exists()){
            small_realPath.mkdir();
        }
        if (!big_realPath .exists()){
            big_realPath .mkdir();
        }
        InputStream is1 = bigPicFile.getInputStream(); //文件输入流
        OutputStream os1 = new FileOutputStream(new File(small_realPath,uploadFileName)); //文件输出流
        InputStream is2 = smallPicFile.getInputStream(); //文件输入流
        OutputStream os2 = new FileOutputStream(new File(big_realPath,uploadFileName)); //文件输出流
        //读取写出
        int len=0;
        byte[] buffer = new byte[1024];
        while ((len=is1.read(buffer))!=-1){
            os1.write(buffer,0,len);
            os1.flush();
        }
        os1.close();
        is1.close();

        int len2=0;
        byte[] buffer2 = new byte[1024];
        while ((len2=is2.read(buffer2))!=-1){
            os2.write(buffer2,0,len2);
            os2.flush();
        }
        os2.close();
        is2.close();

        RouteImg routeImg = new RouteImg();
        routeImg.setRid(Integer.parseInt(rid));
        routeImg.setBigPic("img/product/size4/"+uploadFileName);
        routeImg.setSmallPic("img/product/size2/"+uploadFileName);
        routeImageService.addRoouteImage(routeImg);
        return  "redirect:/product/editProduct.do?id="+rid;
    }

    /**
     * 删除一组大小图（缩略图）
     * @param rgid
     * @param rid
     * @return
     */
    @PreAuthorize("hasAnyRole('ROLE_KING','ROLE_ADMIN')")
    @GetMapping("deleteById.do")
    public String deleteById(String rgid,String rid )
    {
        routeImageService.deleteById(rgid);
        return  "redirect:/product/editProduct.do?id="+rid;
    }

    /**
     * 修改单个产品的封面
     * @param rid
     * @param coverPicFile
     * @param request
     * @return
     * @throws Exception
     */
    @PreAuthorize("hasAnyRole('ROLE_KING','ROLE_ADMIN')")
    @PostMapping("/changeCover")
    public String changeCover(String rid, @RequestParam("coverPicFile") CommonsMultipartFile coverPicFile,HttpServletRequest request) throws Exception
    {
        String uploadFileName= coverPicFile.getOriginalFilename();
        if("".equals( uploadFileName))
        {
            return  "redirect:findAll.do";
        }
        String cover_path = request.getServletContext().getRealPath("/img/product/small/");

        File cover_realPath = new File(cover_path);
        if (!cover_realPath.exists()){
            cover_realPath.mkdir();
        }

        InputStream is1 =coverPicFile.getInputStream(); //文件输入流
        OutputStream os1 = new FileOutputStream(new File(cover_realPath,uploadFileName)); //文件输出流
        //读取写出
        int len=0;
        byte[] buffer = new byte[1024];
        while ((len=is1.read(buffer))!=-1){
            os1.write(buffer,0,len);
            os1.flush();
        }
        os1.close();
        is1.close();

        routeImageService.changeProductCover("img/product/small/"+uploadFileName,rid);
        return  "redirect:/product/editProduct.do?id="+rid;
    }


}
