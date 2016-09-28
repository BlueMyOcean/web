package com.jinjiang.web.service.inf;

import com.jinjiang.web.bean.bean.User;
import com.jinjiang.web.bean.bean.UserPrivilege;
import com.jinjiang.web.bean.pojo.PaymentDetails;

/**
 * Created by Administrator on 2016/9/18 0018.
 */
public interface UserPrivilegeService {
    boolean judgePoints(PaymentDetails paymentDetails,User user);
    void perchaseUserPrivilege(PaymentDetails paymentDetails,UserPrivilege userPrivilege);
    UserPrivilege queryUserPrivilege(String username);
    void hideUserPrivilege(UserPrivilege userPrivilege);
    void createUserPrivilege(UserPrivilege userPrivilege);
    void deleteUserPrivilege(String username);
    PaymentDetails convert(int goodnum);
    UserPrivilege convert(User user);
}
