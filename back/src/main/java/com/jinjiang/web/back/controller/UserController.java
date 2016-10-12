package com.jinjiang.web.back.controller;

import com.jinjiang.web.bean.bean.User;
import com.jinjiang.web.bean.bean.UserPrivilege;
import com.jinjiang.web.dao.mapper.SignMapper;
import com.jinjiang.web.exception.DuplicateUserNameException;
import com.jinjiang.web.exception.ErrorUserNameOrPasswordException;
import com.jinjiang.web.exception.UserNotFoundException;
import com.jinjiang.web.service.UserServiceImp;
import com.jinjiang.web.service.inf.SignService;
import com.jinjiang.web.service.inf.UserPrivilegeService;
import com.jinjiang.web.service.inf.UserService;
import com.jinjiang.web.utils.SessionOP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;

/**
 * Created by Administrator on 2016/9/13 0013.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private SignService signService;

    @Autowired
    private UserPrivilegeService userPrivilegeService;
    private SessionOP sessionOP;
    @Autowired
    public void setSessionOP(SessionOP sessionOP)
    {
        this.sessionOP = sessionOP;
    }

    private UserService userService;
    @Autowired
    public void setUserServiceImp(UserService userService)
    {
        this.userService = userService;
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String regist(@Valid User user, Errors errors , HttpServletRequest request) throws  DuplicateUserNameException
    {
        if(errors.hasErrors())
        {
            return "index/index";
        }
        user.setIpadress(request.getRemoteAddr());
        user.setPernature("无");
        user.setPoint(0);
        user.setRegisterdate(new Date());
        UserPrivilege userPrivilege = new UserPrivilege();
        userPrivilege.setHardwork(0);
        userPrivilege.setUsername(user.getUsername());
        userPrivilege.setLevel(9);


        if(userService.Register(user)==null)
            throw new DuplicateUserNameException();

        userPrivilegeService.createUserPrivilege(userPrivilege);
        sessionOP.setSession(user,request);
        signService.signData(user.getUsername(),new Date(),request.getRemoteAddr());
        return "redirect:/user/"+user.getUsername();
    }

    @RequestMapping(value = "/userchange",method =  RequestMethod.POST)
    @ResponseBody
    public void changeUserInfo()
    {

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
            throw new UserNotFoundException();
        }
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password, HttpServletRequest request,Model model)
    {
        User checkUser = new User();
        checkUser.setUsername(username);
        checkUser.setPassword(password);
        User getUser = userService.Login(checkUser);
        if(getUser != null) {
            sessionOP.setSession(getUser,request);
            model.addAttribute("user",getUser);
            signService.signData(getUser.getUsername(),new Date(),request.getRemoteAddr());
            return "redirect:/";
        }
        else {
            throw new ErrorUserNameOrPasswordException();
        }
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest request,Model model)
    {
        sessionOP.destroySession(request);
        model.addAttribute(new User());
        return "redirect:/";
    }

    @RequestMapping(value = "wronguser")
    public String wronguser()
    {
        return "errors/wronguser";
    }

}
