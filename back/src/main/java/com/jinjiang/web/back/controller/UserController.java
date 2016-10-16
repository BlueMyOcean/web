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
import com.jinjiang.web.utils.AutoAnalysis;
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
@RequestMapping("/user")//   /user映射的处理器
public class UserController {

    @Autowired
    private AutoAnalysis autoAnalysis;

    @Autowired
    private SignService signService;//签到的业务层

    @Autowired
    private UserPrivilegeService userPrivilegeService;//用户特权的业务层
    private SessionOP sessionOP;//封装的session工具
    @Autowired
    public void setSessionOP(SessionOP sessionOP)
    {
        this.sessionOP = sessionOP;
    }

    private UserService userService;//用户业务层
    @Autowired
    public void setUserServiceImp(UserService userService)
    {
        this.userService = userService;
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)//处理用户注册的映射  post方法
    public String regist(@Valid User user, Errors errors , HttpServletRequest request) throws  DuplicateUserNameException
    {
        user = autoAnalysis.Analysis(user);
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

    @RequestMapping(value = "/{username}",method = RequestMethod.GET)
    public String showUserInfo(@PathVariable String username, Model model)
    {
        User user = userService.FindUser(username);
        if(user!=null) {
            model.addAttribute(user);
            return "user/user_info";
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
       // System.out.println("登录拿到的ip地址："+getUser.getIpadress());
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

    /**
     *
     * @param request 获取session
     * @param model 传数据到前端
     * @return 返回退出后的页面
     */
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest request,Model model)
    {
        sessionOP.destroySession(request);
        model.addAttribute(new User());
        return "redirect:/";
    }

    /**
     *
     * @return 用户账号或密码错误
     */
    @RequestMapping(value = "wronguser")
    public String wronguser()
    {
        return "errors/wronguser";
    }

    /**
     *
     * @param user 前台传过来的json
     * @param request 获取session的请求
     * @return 返回数据更新后的json
     */
    @RequestMapping(value = "update",method = RequestMethod.POST,consumes="application/json")
    @ResponseBody
    public User change(@RequestBody User user,HttpServletRequest request)
    {
        User olduser = sessionOP.getSession(request);
        User tem=null;

        try {
            tem = olduser.clone();

            tem.setName(user.getName());
            tem.setSex(user.getSex());
            tem.setSno(user.getSno());
            tem.setMajor(user.getMajor());
            tem.setGrade(user.getGrade());
            tem.setClas(user.getClas());
            tem.setQq(user.getQq());
            tem.setEmail(user.getEmail());
            System.out.println("====================");
            System.out.println(tem.getIpadress());
            System.out.println("====================");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

      //  System.out.println(user);
        User newUser =null;
        if(tem!=null) {
            System.out.println("====================");
            System.out.println(tem);
            System.out.println("====================");
            newUser = userService.Change(tem);


        }

        if(newUser!=null) {
            sessionOP.setSession(newUser, request);
            return newUser;
        }
        else
            return olduser;
    }


}
