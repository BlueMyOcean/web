package com.jinjiang.web.bean.bean;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by W on 2016/8/26.
 */
public class User implements Serializable,Cloneable{

    private Integer id;//默认id
    @Size(min = 2,max=5,message ="2-5个汉字")
    private String name;//姓名
    @NotNull
    @Size(min=9,max=9,message ="学号必须为9位" )
    private String sno;//学号
    @Size(min=2,max=30,message = "1-15个字")
    private String major;//专业
    @Size(min=4,max=4,message = "入学年份")
    private String grade;//年级
    @Size(min=1,max=2,message = "年级数为1-2位数字")
    private String clas;//班级
    @Size(min=1,max=2,message = "男，女，其他")
    private String sex;//性别
    @Size(min=1,max=12,message = "大哥- =，咱别非主流了行吗？12个字够了！")
    private String nickname;//昵称
    @NotNull
    @Size(min=5,max=30,message = "25个字节")
    private String username;//用户名
    @NotNull
    @Size(min=8,max=30,message = "8至30位密码")
    private String password;//密码
    @Size(max=100,message ="50个汉字")
    private String pernature;//个性签名

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sno='" + sno + '\'' +
                ", major='" + major + '\'' +
                ", grade='" + grade + '\'' +
                ", clas='" + clas + '\'' +
                ", sex='" + sex + '\'' +
                ", nickname='" + nickname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", pernature='" + pernature + '\'' +
                ", email='" + email + '\'' +
                ", qq='" + qq + '\'' +
                ", point=" + point +
                ", registerdate=" + registerdate +
                ", ipadress='" + ipadress + '\'' +
                '}';
    }

    @NotNull
    @Size(max = 50,message = "找回邮箱")
    private String email;//邮箱
    @Size(max=13,message = "5-13位的QQ号")
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
    public User clone() throws CloneNotSupportedException {
        User user = (User) super.clone();

        user.setId(this.getId());
        user.setPassword(this.getPassword());
        user.setUsername(this.getUsername());
        user.setClas(this.getClas());
        user.setEmail(this.getEmail());
        user.setGrade(this.getGrade());
        user.setMajor(this.getMajor());
        user.setIpadress(this.getIpadress());
        user.setNickname(this.getNickname());
        user.setQq(this.getQq());
        user.setPernature(this.getPernature());
        user.setSex(this.getSex());
        user.setPoint(this.getPoint());
        user.setName(this.getName());
        user.setSno(this.getSno());
        user.setRegisterdate(this.getRegisterdate());
        user.setIpadress(this.getIpadress());
//        System.out.println("=======================");
//        System.out.println(this.getIpadress());
//        System.out.println("=======================");
        return user;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this,obj,"id","sno");
    }
}
