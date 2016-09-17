package com.jinjiang.web.back.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2016/9/13 0013.
 */
@Controller
@RequestMapping(value = "/upload")
public class UploadController {

    @RequestMapping(method = RequestMethod.GET)
    public String upload()
    {
        return "/uploadfile";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String upload(@RequestPart("picture")MultipartFile picture)
    {//servlet 3.0+
        try {
            picture.transferTo(new File("/usr/files/"+picture.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "/uploadfile";
    }
}
