package com.jinjiang.web.bean.bean;

import java.util.Date;

/**
 * Created by W on 2016/8/27.
 */
public class SignData {

    private String id;
    private String username;
    private Date signDate;

    public SignData(String id, String username, Date signDate) {
        this.id = id;
        this.username = username;
        this.signDate = signDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }
}
