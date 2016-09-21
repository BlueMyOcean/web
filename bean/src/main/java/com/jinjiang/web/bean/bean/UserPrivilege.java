package com.jinjiang.web.bean.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/9/18 0018.
 */
public class UserPrivilege implements Serializable{
    //用户名
    private String username;
    //权限等级
    private int level;
    //连续签到天数>200use
    private int hardwork;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getHardwork() {
        return hardwork;
    }

    public void setHardwork(int hardwork) {
        this.hardwork = hardwork;
    }
}
