package com.jinjiang.web.utils;

import com.jinjiang.web.bean.bean.UserPrivilege;
import com.jinjiang.web.bean.pojo.PaymentDetails;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/9/20 0020.
 */
@Component
public class PointsRules {

    public int computNeed(PaymentDetails paymentDetails)
    {
        int sum = 0;

        if(paymentDetails.isHardwork())
        {
            sum+=200;
        }
        return sum;
    }

    public UserPrivilege changePrivelege(PaymentDetails paymentDetails, UserPrivilege userPrivilege)
    {
        userPrivilege.setHardwork(paymentDetails.isHardwork());
        return  userPrivilege;
    }


}
