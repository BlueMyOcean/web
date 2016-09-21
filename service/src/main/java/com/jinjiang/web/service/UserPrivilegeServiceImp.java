package com.jinjiang.web.service;

import com.jinjiang.web.bean.bean.User;
import com.jinjiang.web.bean.bean.UserPrivilege;
import com.jinjiang.web.bean.pojo.PaymentDetails;
import com.jinjiang.web.dao.mapper.UserMapper;
import com.jinjiang.web.dao.mapper.UserPrivilegeMapper;
import com.jinjiang.web.service.inf.UserPrivilegeService;
import com.jinjiang.web.utils.PrivilegeRules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2016/9/18 0018.
 */
@Service
public class UserPrivilegeServiceImp implements UserPrivilegeService {

    @Autowired
    private UserPrivilegeMapper userPrivilegeMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PrivilegeRules privilegeRules;

    @Override//判断积分是否足够
    public boolean judgePoints(PaymentDetails paymentDetails,User user) {
        if(user==null||paymentDetails==null)
            return false;
        int points = user.getPoint();
        int haves = privilegeRules.computNeed(paymentDetails,userPrivilegeMapper.getPrivilege(user.getUsername()));
        return points <= haves;
    }

    @Override//积分购买
    @Transactional
    public void perchaseUserPrivilege(PaymentDetails paymentDetails,UserPrivilege userPrivilege) {
        int minusPoint = privilegeRules.computNeed(paymentDetails,userPrivilege);
        User user = userMapper.findUserByUsername(userPrivilege.getUsername());
        try {
            user.setPoint(user.getPoint() - minusPoint);
            userMapper.UpdateUser(user);
            userPrivilegeMapper.changePrivilege(privilegeRules.changePrivilege(paymentDetails,userPrivilege));
        }catch (Exception e)
        {
            System.out.println("用户不存在！购买失败！");
        }

    }

    @Override//查询用户权限
    public UserPrivilege queryUserPrivilege(String username) {
        return  userPrivilegeMapper.getPrivilege(username);
    }

    @Override//隐藏权限
    @Transactional
    public void hideUserPrivilege(UserPrivilege userPrivilege) {
        userPrivilegeMapper.changePrivilege(privilegeRules.hidePrivilege(userPrivilege));
    }

    @Override//创建权限
    @Transactional
    public void createUserPrivilege(UserPrivilege userPrivilege) {
        userPrivilegeMapper.createPrivilege();
    }

    @Override//删除权限
    @Transactional
    public void deleteUserPrivilege(String username) {
        userPrivilegeMapper.deletePrivilege(username);
    }

    @Override//根据选项得出购买信息
    public PaymentDetails convert(int goodnum) {
       return privilegeRules.getPaymentDetails(goodnum);
    }

    @Override//根据用户查询权限信息
    public UserPrivilege convert(User user) {
        return queryUserPrivilege(user.getUsername());
    }
}
