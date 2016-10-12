package com.jinjiang.web.service.inf;

import com.jinjiang.web.bean.bean.SignData;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/9/18 0018.
 */
public interface SignService {
    void signData(String username, Date date,String ip);
    List<SignData> queryData(String username);
}
