package com.jinjiang.web.service;

import com.jinjiang.web.bean.bean.User;
import com.jinjiang.web.bean.bean.UserPrivilege;
import com.jinjiang.web.bean.pojo.PaymentDetails;
import com.jinjiang.web.service.inf.UserPrivilegeService;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/9/18 0018.
 */
@Service
public class UserPrivilegeServiceImp implements UserPrivilegeService {


    @Override
    public boolean judgePoints(PaymentDetails paymentDetails,User user) {
        return false;
    }

    @Override
    public void addUserPrivilege(PaymentDetails paymentDetails,UserPrivilege userPrivilege) {

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
