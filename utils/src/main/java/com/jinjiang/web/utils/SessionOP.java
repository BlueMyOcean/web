package com.jinjiang.web.utils;

import com.jinjiang.web.bean.bean.User;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by Administrator on 2016/8/31 0031.
 */
@Component
public class SessionOP {

    private HttpSession session;

    public boolean IsNew(HttpServletRequest request)
    {
        session = request.getSession();
        return session.isNew();
    }

    public void setSession(User user, HttpServletRequest request)
    {
        session = request.getSession();
        session.setMaxInactiveInterval(600);
        session.setAttribute("id",user.getId());
        session.setAttribute("name",user.getName());
        session.setAttribute("sno",user.getSno());
        session.setAttribute("major",user.getMajor());
        session.setAttribute("grade",user.getGrade());
        session.setAttribute("clas",user.getClas());
        session.setAttribute("sex",user.getSex());
        session.setAttribute("nickname",user.getNickname());
        session.setAttribute("username",user.getUsername());
        session.setAttribute("password",user.getPassword());
        session.setAttribute("pernature",user.getPernature());
        session.setAttribute("email",user.getEmail());
        session.setAttribute("qq",user.getQq());
        session.setAttribute("point",user.getPoint());
        session.setAttribute("registerdate",user.getRegisterdate());
        session.setAttribute("ipaddress",user.getIpadress());
        session.setMaxInactiveInterval(1 * 60 * 60);
    }

    public User getSession(HttpServletRequest request)
    {
        User user = new User();
        session = request.getSession();
        Integer id = (Integer) session.getAttribute("id");
        String name = (String) session.getAttribute("name");
        String sno = (String) session.getAttribute("sno");
        String major = (String) session.getAttribute("maojor");
        String grade = (String) session.getAttribute("grade");
        String clas = (String) session.getAttribute("clas");
        String sex;
        if(session.getAttribute("sex")!=null)
        sex = (String) session.getAttribute("sex");
        else
        sex="";
        String nickname = (String) session.getAttribute("nickname");
        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");
        String pernature = (String) session.getAttribute("pernature");
        String email = (String) session.getAttribute("email");
        String qq;
        if(session.getAttribute("qq")!=null)
        qq = (String) session.getAttribute("qq");
        else
        qq="";
        Integer point = (Integer) session.getAttribute("id");
        Date registerdate = (Date)session.getAttribute("registerdate");
        String ipadress = (String)session.getAttribute("ipadress");
        if(username!=null)
        {
            user.setId(id);
            user.setPassword(password);
            user.setUsername(username);
            user.setClas(clas);
            user.setEmail(email);
            user.setGrade(grade);
            user.setMajor(major);
            user.setIpadress(ipadress);
            user.setNickname(nickname);
            user.setQq(qq);
            user.setPernature(pernature);
            user.setSex(sex);
            user.setPoint(point);
            user.setName(name);
            user.setSno(sno);
            user.setRegisterdate(registerdate);
            return user;
        }
        else
            return null;
    }

    public void destroySession(HttpServletRequest request)
    {
        session = request.getSession();
        session.invalidate();
    }

}
