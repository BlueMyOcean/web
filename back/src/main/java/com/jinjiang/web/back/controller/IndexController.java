package com.jinjiang.web.back.controller;

import com.jinjiang.web.bean.User;
import com.jinjiang.web.service.UserService;
import com.jinjiang.web.utils.SessionOP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Created by W on 2016/8/25.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    private SessionOP sessionOP;
    @Autowired
    public void setSessionOP(SessionOP sessionOP)
    {
        this.sessionOP = sessionOP;
    }

/*
    @RequestMapping(value = "/search/baidu" ,method = RequestMethod.GET)
    public String search(@RequestParam("searchfor")String searchfor)
    {
           return "redirect:https://www.baidu.com/s?word="+searchfor+"&ie=utf-8";
    }
*/


    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home(HttpServletRequest request,HttpServletResponse response,Model model)
    {
        User user;
        user = sessionOP.getSession(request);
        if(user == null)
            user = new User();
        model.addAttribute("user",user);
        return "index/index";
    }




}
