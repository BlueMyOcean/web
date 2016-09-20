package com.jinjiang.web.service;

import com.jinjiang.web.bean.bean.User;
import com.jinjiang.web.bean.bean.UserPrivilege;
import com.jinjiang.web.bean.pojo.PaymentDetails;
import com.jinjiang.web.dao.mapper.UserPrivilegeMapper;
import com.jinjiang.web.service.inf.UserPrivilegeService;
import com.jinjiang.web.utils.PointsRules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/9/18 0018.
 */
@Service
public class UserPrivilegeServiceImp implements UserPrivilegeService {

    @Autowired
    private UserPrivilegeMapper userPrivilegeMapper;

    @Autowired
    private PointsRules pointsRule;

    @Override
    public boolean judgePoints(PaymentDetails paymentDetails,User user) {
        if(user==null||paymentDetails==null)
            return false;
        int points = user.getPoint();
        int haves = pointsRule.computNeed(paymentDetails);
        return points <= haves;
    }

    @Override
    public void setUserPrivilege(PaymentDetails paymentDetails,UserPrivilege userPrivilege) {

        userPrivilegeMapper.changePrivilege(pointsRule.changePrivelege(paymentDetails, userPrivilege));
    }

    @Override
    public void queryUserPrivilege(String username) {

    }

    @Override
    public void hideUserPrivilege(UserPrivilege userPrivilege) {

    }

    @Override
    public void changeUserPrivilege(UserPrivilege userPrivilege) {

    }

    @Override
    public void deleteUserPrivilege(String username) {

    }

    @Override
    public PaymentDetails convert(int num) {
        return null;
    }

    @Override
    public UserPrivilege convert(User user) {
        return null;
    }
}
