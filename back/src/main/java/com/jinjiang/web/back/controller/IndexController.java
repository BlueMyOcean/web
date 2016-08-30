package com.jinjiang.web.back.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by W on 2016/8/25.
 */
@Controller
@RequestMapping(value ={"/"} )
public class IndexController {

    @RequestMapping(method = RequestMethod.GET)
    public String home()
    {
        return "index";
    }
}
