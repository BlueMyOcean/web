package com.jinjiang.web.back.controller;

import com.jinjiang.web.bean.bean.User;
import com.jinjiang.web.utils.SessionOP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    @RequestMapping(method = RequestMethod.GET)
    public String intoStore()
    {
        return "flows/pointsexchange/getpayinfo/pointstore";
    }


}
