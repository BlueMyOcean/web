package com.jinjiang.web.back.controller;

import com.jinjiang.web.bean.User;
import com.jinjiang.web.service.UserService;
import com.jinjiang.web.utils.SessionOP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;

/**
 * Created by W on 2016/8/25.
 */
@Controller
@RequestMapping
public class IndexController {

    //private UserService userService = new UserService();

    private SessionOP sessionOP;
    @Autowired
    public void setSessionOP(SessionOP sessionOP)
    {
        this.sessionOP = sessionOP;
    }
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService)
    {
        this.userService =  userService;
    }
/*
    @RequestMapping(value = "/search/baidu" ,method = RequestMethod.GET)
    public String search(@RequestParam("searchfor")String searchfor)
    {
           return "redirect:https://www.baidu.com/s?word="+searchfor+"&ie=utf-8";
    }
*/
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String regist( @Valid User user, Errors errors ,HttpServletRequest request)
    {
        if(errors.hasErrors())
        {
            return "index/index";
        }
        user.setIpadress(request.getRemoteAddr());
        user.setPernature("无");
        user.setPoint(0);
        user.setRegisterdate(new Date());
        userService.Register(user);
        sessionOP.setSession(user,request);
        return "redirect:/"+user.getUsername();
    }

    @RequestMapping(value = "/{username}",method = RequestMethod.GET)
    public String showUserInfo(@PathVariable String username, Model model)
    {
        User user = userService.FindUser(username);
        if(user!=null) {
            model.addAttribute(user);
            return "userinfo";
        }
        else
        {
            model.addAttribute(username);
            return "404";
        }
    }

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

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password, HttpServletRequest request,Model model) {
            User checkUser = new User();
            checkUser.setUsername(username);
            checkUser.setPassword(password);
            User getUser = userService.Login(checkUser);
        if(getUser != null) {
            sessionOP.setSession(getUser,request);
            model.addAttribute("user",getUser);
            return "redirect:/";
        }
        else
            return "login";
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest request,Model model)
    {

        sessionOP.destroySession(request);
        model.addAttribute(new User());
        return "redirect:"+request.getContextPath()+"/";
    }

}
