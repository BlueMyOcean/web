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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SignData signData = (SignData) o;

        if (id != null ? !id.equals(signData.id) : signData.id != null) return false;
        if (username != null ? !username.equals(signData.username) : signData.username != null) return false;
        return signDate != null ? signDate.equals(signData.signDate) : signData.signDate == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (signDate != null ? signDate.hashCode() : 0);
        return result;
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
