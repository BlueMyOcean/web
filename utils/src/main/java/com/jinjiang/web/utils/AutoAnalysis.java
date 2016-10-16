package com.jinjiang.web.utils;

import com.jinjiang.web.bean.bean.User;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/10/14 0014.
 */
@Component
public class AutoAnalysis {

    public User Analysis(User user)
    {
        String sno = user.getSno();
        user.setGrade(sno.substring(1,3));
        user.setClas(sno.substring(7));
        return user;
    }
}
