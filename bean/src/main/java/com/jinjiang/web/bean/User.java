package com.jinjiang.web.bean;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * Created by W on 2016/8/26.
 */
public class User {

    private Integer id;//默认id
    @Size(min = 2,max=5)
    private String name;//姓名
    @NotNull
    @Size(min=9,max=9)
    private String sno;//学号
    @Size(min=3,max=30)
    private String major;//专业
    @Size(min=4,max=4)
    private String grade;//年级
    @Size(min=1,max=2)
    private String clas;//班级
    @Size(min=1,max=2)
    private String sex;//性别
    @Size(min=1,max=12)
    private String nickname;//昵称
    @NotNull
    @Size(min=5,max=30)
    private String username;//用户名
    @NotNull
    @Size(min=8,max=30)
    private String password;//密码
    @Size(max=50)
    private String pernature;//个性签名
    private String email;//邮箱
    @Size(max=13)
    private String qq;//qq号
    private Integer point;//积分
    private Date registerdate;//注册日期
    private String ipadress;//注册的ip地址

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getClas() {
        return clas;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public String getPernature() {
        return pernature;
    }

    public void setPernature(String pernature) {
        this.pernature = pernature;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Date getRegisterdate() {
        return registerdate;
    }

    public void setRegisterdate(Date registerdate) {
        this.registerdate = registerdate;
    }

    public String getIpadress() {
        return ipadress;
    }

    public void setIpadress(String ipadress) {
        this.ipadress = ipadress;
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this,"id","sno");
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this,obj,"id","sno");
    }
}