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
    public User Login(User user) {

            User localuser = userMapper.findUserByUsername(user.getUsername());
            if (localuser == null)
                return null;
            if (localuser.getPassword().equals(user.getPassword()))
                return localuser;
            else
                return null;
    }

    @Transactional
    public User Register(User user)
    {
        User localuser = userMapper.findUserByUsername(user.getUsername());
        if(localuser!=null)
            return null;
        else {
            userMapper.insertUser(user);
            return user;
        }
    }

    @Transactional
    public User Change(User user)
    {
            userMapper.UpdateUser(user);
            User newuser = userMapper.findUserByUsername(user.getUsername());
            return user;
    }
}
