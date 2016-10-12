package com.jinjiang.web.dao.mapper;

import com.jinjiang.web.bean.bean.UserPrivilege;
import netscape.security.Privilege;
import org.apache.ibatis.annotations.*;

/**
 * Created by Administrator on 2016/9/18 0018.
 */
public interface UserPrivilegeMapper {
    @Update("update user_privilege set username = #{username},level=#{level},hardwork=#{hardwork} where username =#{username}")
    public void changePrivilege(UserPrivilege userPrivilege);//修改用户权限
    @Select("select username,level,hardwork from user_privilege where username=#{username}")
    public UserPrivilege getPrivilege(@Param("username")String username);
    @Insert("insert into user_privilege(username,level,hardwork) values(#{username},#{level},#{hardwork})")
    public void insertPrivilege(UserPrivilege userPrivilege);
    @Delete("delete from user_privilege where username =#{username}")
    public void deletePrivilege(@Param("username")String username);
    @Insert("insert into user_privilege(username,level,hardwork) values(#{username},#{level},#{hardwork})")
    public void createPrivilege(UserPrivilege privilege);
}
