package com.jinjiang.web.dao.mapper;

import com.jinjiang.web.bean.User;
import org.apache.ibatis.annotations.*;

/**
 * Created by W on 2016/8/26.
 */

public interface UserMapper {
    @Insert("insert into user(id,name,sno,major,grade,clas,sex,nickname,username,password,pernature,email,qq,point,registerdate,birthday,ipadress) values(#{id},#{name},#{sno},#{major},#{grade},#{clas},#{sex},#{nickname},#{username},#{password},#{pernature},#{email},#{qq},#{point},#{registerdate},#{birthday},#{ipadress})")
    String insertUser(User user);//增加一个用户
    @Select("select id,name,sno,major,grade,clas,sex,nickname,username,password,pernature,email,qq,point,registerdate,birthday,ipadress from user where sno = #{sno}")
    User findUserBySno(@Param("sno")String sno);//根据学号查找一个用户
    @Select("select id,name,sno,major,grade,clas,sex,nickname,username,password,pernature,email,qq,point,registerdate,birthday,ipadress from user where username = #{username}")
    User findUserByUsername(@Param("username")String username);//根据用户名查找用户
    @Update("update user set id=#{id},name=#{name},sno=#{sno},major=#{major},grade=#{grade},clas=#{clas},sex=#{sex},nickname=#{{nickname},username=#{username},password=#{password},pernature=#{pernature},email=#{email},qq=#{qq},point=#{point},registerdate=#{registerdate},birthday=#{birthday},ipadress=#{ipadress} where username = #{username}")
    String UpdateUser(User user);//更新用户信息
    @Delete("delete from user where username =#{username} ")
    String deleteUser(@Param("username")String username);//删除用户
}
