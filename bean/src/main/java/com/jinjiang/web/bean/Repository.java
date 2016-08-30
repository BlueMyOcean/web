package com.jinjiang.web.bean;

import java.util.List;

/**
 * Created by W on 2016/8/25.
 */
public interface Repository {
    List<Message> findMessage(Long max,int count);
}
