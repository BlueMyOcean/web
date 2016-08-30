package com.jinjiang.web.service;

import com.jinjiang.web.bean.User;
import com.jinjiang.web.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * Created by W on 2016/8/27.
 */
//
@Service
public class UserService implements Serializable{

    @Autowired
    private UserMapper userMapper;

    @Transactional
    public String Login(User user)
    {
        try {
            User localuser = userMapper.findUserByUsername(user.getUsername());
            if(localuser.getPassword().equals(user.getPassword()))
                return "LoginSucceed";
            else
                return "PasswordError";
        }catch (Exception e) {
                return "LoginFail";
        }
    }

    @Transactional
    public String Register(User user)
    {
        User localuser = userMapper.findUserByUsername(user.getUsername());
        if(localuser!=null)
            return "UserExist";
        else
            try {
                userMapper.insertUser(user);
                return "InsertSucceed";
            }catch (Exception e)
            {
                return "InsertFail";
            }

    }

    @Transactional
    public String Change(User user)
    {
        try{
            userMapper.UpdateUser(user);
            return "ChangeSucceed";
        }catch (Exception e)
        {
            return "ChangeFail";
        }
    }


}
