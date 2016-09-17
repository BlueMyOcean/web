package com.jinjiang.web.utils;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/9/8 0008.
 */
@Component
public class StoreUnQulifiedUser {
    private Map<String,Integer> map=new HashMap<>();

    public Map<String, Integer> getMap() {
        return map;
    }
    public void add(String name,Integer absentimes)
    {
        map.put(name,absentimes);
    }

    public void clear()
    {
        map.clear();
    }
}
