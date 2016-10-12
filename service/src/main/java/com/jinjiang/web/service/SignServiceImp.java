package com.jinjiang.web.service;

import com.jinjiang.web.bean.bean.SignData;
import com.jinjiang.web.bean.bean.User;
import com.jinjiang.web.dao.mapper.SignMapper;
import com.jinjiang.web.dao.mapper.UserMapper;
import com.jinjiang.web.service.inf.SignService;
import com.jinjiang.web.utils.DateConvertion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/9/8 0008.
 */
@Service
public class SignServiceImp implements SignService{
    @Autowired
    private SignMapper signMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DateConvertion dateConvertion;

    @Override
    @Transactional
    public void signData(String username, Date date,String ip) {
        User user = userMapper.findUserByUsername(username);
        Date old = signMapper.queryNewSignDate(username);
        if(user.getIpadress().equals(ip)) {
            if(old==null)
            {
                signMapper.addSignData(username, date);
                return;
            }

            if(dateConvertion.compare(old,date))
            signMapper.addSignData(username, date);
        }
    }

    @Override
    public List<SignData> queryData(String username) {
        return signMapper.queryByUsername(username);
    }
}
