package com.jinjiang.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Administrator on 2016/9/9 0009.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "用户不存在")
public class UserNotFoundException extends RuntimeException {
}
