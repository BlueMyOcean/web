package com.jinjiang.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Administrator on 2016/9/19 0019.
 */
@ResponseStatus(value= HttpStatus.NOT_FOUND,reason = "username or password error")
public class ErrorUserNameOrPasswordException extends RuntimeException {
}
