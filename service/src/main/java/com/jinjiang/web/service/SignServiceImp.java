package com.jinjiang.web.service;

import com.jinjiang.web.dao.mapper.UserMapper;
import com.jinjiang.web.service.inf.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/9/8 0008.
 */
@Service
public class SignServiceImp implements SignService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public String getUnqulifiedStudent()
    {

        return "";
    }
}
