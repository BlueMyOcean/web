package com.jinjiang.web.dao.mapper;

import com.jinjiang.web.bean.bean.UserPrivilege;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by Administrator on 2016/9/18 0018.
 */
public interface UserPrivilegeMapper {
    @Update("")
    public void changePrivilege(UserPrivilege userPrivilege);//修改用户权限
    @Select("")
    public UserPrivilege getPrivilege();
    @Insert("")
    public void insertPrivilege();
    @Delete("")
    public void deletePrivilege();
}
