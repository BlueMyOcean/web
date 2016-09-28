package com.jinjiang.web.service;

import com.jinjiang.web.bean.bean.User;
import com.jinjiang.web.dao.mapper.UserMapper;
import com.jinjiang.web.service.inf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by W on 2016/8/27.
 */

@Service
public class UserServiceImp implements UserService{
    private UserMapper userMapper;
    @Autowired
    public void setUserMapper(UserMapper userMapper)
    {
        this.userMapper = userMapper;
    }


    @Transactional
    @Override
    public User Login(User user) {

            User localuser = userMapper.findUserByUsername(user.getUsername());
            if (localuser == null) {
                System.out.printf("登录失败,不存在该用户！");
                return null;
            }
            if (localuser.getPassword().equals(user.getPassword())) {
                return localuser;
            }
            else
                return null;
    }

    @Transactional
    @Override
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
    @Override
    public User Change(User user)
    {
            userMapper.UpdateUser(user);
            User newuser = userMapper.findUserByUsername(user.getUsername());
            return user;
    }

    @Override
    public User FindUser(String username)
    {
        return userMapper.findUserByUsername(username);
    }
}
