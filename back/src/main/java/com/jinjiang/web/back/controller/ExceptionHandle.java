package com.jinjiang.web.back.controller;

import com.jinjiang.web.exception.DuplicateUserNameException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by Administrator on 2016/9/9 0009.
 */
@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(DuplicateUserNameException.class)
    public void duplicateUserNameException()
    {

    }
}
