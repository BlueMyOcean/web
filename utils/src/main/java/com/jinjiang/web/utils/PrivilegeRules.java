package com.jinjiang.web.utils;

import com.jinjiang.web.bean.bean.UserPrivilege;
import com.jinjiang.web.bean.pojo.PaymentDetails;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/9/20 0020.
 */
@Component
public class PrivilegeRules {

    public int computNeed(PaymentDetails paymentDetails,UserPrivilege userPrivilege)
    {
        int sum = 0;


        if(paymentDetails.getHardwork()==1)
            if(userPrivilege.getHardwork()==0)
        {
            sum+=200;
        }

        return sum;
    }

    public UserPrivilege changePrivilege(PaymentDetails paymentDetails, UserPrivilege userPrivilege)
    {
        userPrivilege.setHardwork(paymentDetails.getHardwork());
        return  userPrivilege;
    }

    public UserPrivilege hidePrivilege(UserPrivilege userPrivilege)
    {
        userPrivilege.setHardwork(2);
        return userPrivilege;
    }

    public PaymentDetails getPaymentDetails(int num)
    {
        PaymentDetails paymentDetails= new PaymentDetails();
        if(num==1)
            paymentDetails.setHardwork(1);
        return paymentDetails;
    }



}
