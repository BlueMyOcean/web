package com.jinjiang.web.bean.bean;

/**
 * Created by W on 2016/8/26.
 */
public class Administrator {
    private Integer id;//管理员ID
    private String email;//管理员邮箱
    private String nickname;//昵称
    private String username;//用户名
    private String password;//密码

    public Administrator(Integer id, String email, String nickname, String username, String password) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.username = username;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
