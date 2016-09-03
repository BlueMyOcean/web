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
import javax.validation.Valid;
import java.util.Date;

/**
 * Created by W on 2016/8/25.
 */
@Controller
@RequestMapping
public class IndexController {

    //private UserService userService = new UserService();

    private UserService userService;
    @Autowired
    public void setUserService(UserService userService)
    {
        this.userService =  userService;
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String showRegisterForm(Model model)
    {
        model.addAttribute(new User());
        return "register";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String regist( @Valid User user, Errors errors ,HttpServletRequest request)
    {
        if(errors.hasErrors())
        {
            return "register";
        }
        user.setIpadress(request.getRemoteAddr());
        user.setPernature("无");
        user.setPoint(0);
        user.setRegisterdate(new Date());
        userService.Register(user);
        return "redirect:/"+user.getUsername();
    }

    @RequestMapping(value = "/{username}",method = RequestMethod.GET)
    public String showUserInfo(@PathVariable String username, Model model)
    {
        User user = userService.FindUser(username);
        if(user!=null)
        model.addAttribute(user);
        return "userinfo";
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home(HttpServletRequest request,HttpServletResponse response)
    {
        return "index/index";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login()
    {
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestParam("username") String userName,
                      @RequestParam("password") String password) {
            User checkUser = new User();
            checkUser.setUsername(userName);
            checkUser.setPassword(password);
            User getUser = userService.Login(checkUser);
        if(getUser != null)
            return "redirect:/"+getUser.getUsername();
        else
            return null;
    }
}
