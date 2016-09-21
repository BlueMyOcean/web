package com.jinjiang.web.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


import java.util.Map;
import java.util.Properties;

/**
 * Created by Administrator on 2016/9/7 0007.
 */
@Component
public class Email {
    @Autowired
    private StoreUnQulifiedUser storeUnQulifiedUser;

    @Value("${email.to}")
    private String to;

    @Value("${email.from}")
    private String from;

    @Value("${email.host}")
    private String host;

    @Value("${email.subject}")
    private String subject;

    @Value("${mail.username}")
    private String username;

    @Value("${mail.password}")
    private String password;

    private String content="";

    private Properties properties=System.getProperties();

    public void initProperties()
    {
        properties.setProperty("mail.smtp.host",host);
        properties.setProperty("mail.username",username);
        properties.setProperty("mail.password",password);

        Session mailSession = Session.getDefaultInstance(properties);

        for(Map.Entry<String,Integer> entry :storeUnQulifiedUser.getMap().entrySet())
        {
            content+="姓名:"+entry.getKey()+"缺席："+entry.getValue()+"\r\n";
        }


        try {
            MimeMessage message = new MimeMessage(mailSession);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(MimeMessage.RecipientType.TO,new InternetAddress(to));
            message.setSubject(subject);
            message.setText(content);
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
