package com.jinjiang.web.service.inf;

import com.jinjiang.web.bean.bean.User;

/**
 * Created by Administrator on 2016/9/18 0018.
 */
public interface UserService {
    public User Login(User user) ;
    public User Register(User user);
    public User Change(User user);
    public User FindUser(String username);
}
