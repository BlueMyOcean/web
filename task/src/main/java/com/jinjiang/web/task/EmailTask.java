package com.jinjiang.web.task;

import com.jinjiang.web.utils.Email;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/9/8 0008.
 */
@Component
public class EmailTask {
    private Email email;

    @Scheduled(cron = "0 0 7 1 * ?")//每月第一日7点整发送
    public void emailSend()
    {
        email.initProperties();
    }
}
