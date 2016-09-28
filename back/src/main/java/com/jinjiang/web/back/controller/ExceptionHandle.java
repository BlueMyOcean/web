package com.jinjiang.web.back.controller;

import com.jinjiang.web.exception.DuplicateUserNameException;
import com.jinjiang.web.exception.ErrorUserNameOrPasswordException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2016/9/9 0009.
 */
@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(DuplicateUserNameException.class)
    @RequestMapping(method = RequestMethod.GET)
    public String duplicateUserNameException()
    {
        return "error/userexisted";
    }

    @ExceptionHandler(ErrorUserNameOrPasswordException.class)
    @RequestMapping(method = RequestMethod.GET)
    public String errorUserNameOrPasswordException()
    {
        return "redirect:wronguser";
    }




}
