package com.jinjiang.web.bean.bean;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Date;

/**
 * Created by W on 2016/8/25.
 */
public class Message {

    private final Long id;//站内信ID
    private String message;//发送的信息
    private final Date time;//发送的时间
    private String sender;//发送人
    private String geter;//接收人

    public Message(Long id, String message, Date time, String sender, String geter) {
        this.id = id;
        this.message = message;
        this.time = time;
        this.sender = sender;
        this.geter = geter;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTime() {
        return time;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getGeter() {
        return geter;
    }

    public void setGeter(String geter) {
        this.geter = geter;
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this,"id","time");
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this,obj,"id","time");
    }
}
