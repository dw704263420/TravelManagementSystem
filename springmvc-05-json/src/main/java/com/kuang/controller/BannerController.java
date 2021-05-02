package com.kuang.controller;

import com.kuang.pojo.Banner;
import com.kuang.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

@Controller
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    @Qualifier("BannerServiceImpl")
    private BannerService bannerService;

    @GetMapping("/findAll.do")
    public String findAll(Model model)
    {
        List<Banner> allBanner = bannerService.findAllBanner();
        model.addAttribute("bannerList",allBanner);
        return "banner-list";
    }
    @GetMapping("/deleteById.do")
    public String deleteById(String bid)
    {
        bannerService.deleteById(bid);
        return  "redirect:findAll.do";
    }

    @PostMapping("/save.do")
    public String createUser(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws Exception {
       String uploadFileName= file.getOriginalFilename();
       if("".equals( uploadFileName))
       {
           return  "redirect:findAll.do";
       }
        String path = request.getServletContext().getRealPath("/images/banner");
        File realPath = new File(path);
        if (!realPath.exists()){
            realPath.mkdir();
        }
        InputStream is = file.getInputStream(); //文件输入流
        OutputStream os = new FileOutputStream(new File(realPath,uploadFileName)); //文件输出流

        //读取写出
        int len=0;
        byte[] buffer = new byte[1024];
        while ((len=is.read(buffer))!=-1){
            os.write(buffer,0,len);
            os.flush();
        }
        os.close();
        is.close();
            Banner banner = new Banner();
            banner.setbImage("images/banner/"+uploadFileName);
            bannerService.addOneBanner(banner);

        return  "redirect:findAll.do";
    }
}
