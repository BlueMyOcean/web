package com.jinjiang.web.utils;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/9/1 0001.
 */
@Component
public class DateConvertion {
    private SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public boolean compare(Date date1,Date date2)
    {
        if(date1.getYear()>date2.getYear()||date1.getMonth()>date2.getMonth()||date1.getDay()>date2.getDay())
            return false;

        if(date1.getYear()<date2.getYear())
        if(date1.getMonth()<date2.getYear())
        if(date1.getDay()<date2.getDay())
            return true;

      return false;
    }

}
