package com.jinjiang.web.bean.pojo;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/9/18 0018.
 */
public class PaymentDetails implements Serializable{
    //权限等级
    private int level;
    //连续签到天数>200
    private int hardwork;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHardwork() {
        return hardwork;
    }

    public void setHardwork(int hardwork) {
        this.hardwork = hardwork;
    }
}
