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
    //连续签到天数>200
    private boolean hardwork;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isHardwork() {
        return hardwork;
    }

    public void setHardwork(boolean hardwork) {
        this.hardwork = hardwork;
    }
}
