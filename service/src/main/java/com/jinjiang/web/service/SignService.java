package com.jinjiang.web.service;

import com.jinjiang.web.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/9/8 0008.
 */
@Service
public class SignService {
    @Autowired
    private UserMapper userMapper;

    public String getUnqulifiedStudent()
    {

        return "";
    }
}
