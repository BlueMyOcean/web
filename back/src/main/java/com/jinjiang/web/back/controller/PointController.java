package com.jinjiang.web.back.controller;

import com.jinjiang.web.bean.bean.User;
import com.jinjiang.web.bean.bean.UserPrivilege;
import com.jinjiang.web.bean.pojo.PaymentDetails;
import com.jinjiang.web.service.inf.UserPrivilegeService;
import com.jinjiang.web.utils.SessionOP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2016/9/21 0021.
 */
@Controller
@RequestMapping("/shop")
public class PointController {

    private SessionOP sessionOP;
    @Autowired
    public void setSessionOP(SessionOP sessionOP)
    {
        this.sessionOP = sessionOP;
    }

    @Autowired
    private UserPrivilegeService userPrivilegeService;

    @RequestMapping(method = RequestMethod.GET)
    public String intoStore(HttpServletRequest request)
    {
        if(sessionOP.getSession(request)==null)
        {
            return "store/donotlogin";
        }
        return "store/pointstore";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String purchase(@RequestParam("goodnum") int goodnum,HttpServletRequest request)
    {
        User user = sessionOP.getSession(request);
        UserPrivilege userPrivilege;
        userPrivilege = userPrivilegeService.queryUserPrivilege(user.getUsername());
        PaymentDetails paymentDetails;
        paymentDetails = userPrivilegeService.convert(goodnum);
        if(userPrivilegeService.judgePoints(paymentDetails,sessionOP.getSession(request)))
        {
            userPrivilegeService.perchaseUserPrivilege(paymentDetails,userPrivilege);
            return "store/pointstore";
        }
        return "store/unable-to-pay";
    }


}
