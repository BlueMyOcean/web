package com.jinjiang.web.service.inf;

import com.jinjiang.web.bean.bean.User;
import com.jinjiang.web.bean.bean.UserPrivilege;
import com.jinjiang.web.bean.pojo.PaymentDetails;

/**
 * Created by Administrator on 2016/9/18 0018.
 */
public interface UserPrivilegeService {
    boolean judgePoints(PaymentDetails paymentDetails, User user);
    void setUserPrivilege(PaymentDetails paymentDetails,UserPrivilege userPrivilege);
    void queryUserPrivilege(String username);
    void hideUserPrivilege(UserPrivilege userPrivilege);
    void changeUserPrivilege(UserPrivilege userPrivilege);
    void deleteUserPrivilege(String username);
    PaymentDetails convert(int num);
    UserPrivilege convert(User user);
}
