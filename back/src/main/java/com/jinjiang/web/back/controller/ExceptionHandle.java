package com.jinjiang.web.back.controller;

import com.jinjiang.web.exception.DuplicateUserNameException;
import com.jinjiang.web.exception.ErrorUserNameOrPasswordException;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by Administrator on 2016/9/9 0009.
 */
@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(DuplicateUserNameException.class)
    public String duplicateUserNameException()
    {
        return "error/userexisted";
    }
    @ExceptionHandler(ErrorUserNameOrPasswordException.class)
    public String errorUserNameOrPasswordException(ModelMap map)
    {
        map.put("user",null);
        return "error/usernameorpawdwrong";
    }
}
