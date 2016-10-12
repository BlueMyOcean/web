package com.jinjiang.web.back.controller;

import com.jinjiang.web.bean.bean.User;
import com.jinjiang.web.utils.SessionOP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2016/9/13 0013.
 */
@Controller
@RequestMapping(value = "/upload")
public class UploadController {

    @Autowired
    private SessionOP sessionOP;

    @RequestMapping(method = RequestMethod.GET)
    public String upload()
    {
        return "/uploadfile";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String upload(@RequestPart("picture")MultipartFile picture, HttpServletRequest request)
    {//servlet 3.0+
        SessionOP sessionOP = new SessionOP();
        User user = sessionOP.getSession(request);
        try {
            if(user!=null) {
                picture.transferTo(new File("/usr/files/" + user.getUsername()+".jpg"));
                return "/upload_succeed";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "/uploadfile";
    }
}
