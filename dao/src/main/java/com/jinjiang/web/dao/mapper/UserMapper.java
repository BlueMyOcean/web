package com.jinjiang.web.dao.mapper;

import com.jinjiang.web.bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by W on 2016/8/26.
 */
@Repository
public interface UserMapper {
    @Insert("insert into user(id,name,sno,major,grade,clas,sex,nickname,username,password,pernature,email,qq,point,registerdate,ipadress) values(#{id},#{name},#{sno},#{major},#{grade},#{clas},#{sex},#{nickname},#{username},#{password},#{pernature},#{email},#{qq},#{point},#{registerdate},#{ipadress})")
    void insertUser(User user);//增加一个用户
    @Select("select id,name,sno,major,grade,clas,sex,nickname,username,password,pernature,email,qq,point,registerdate,ipadress from user where sno = #{sno}")
    User findUserBySno(@Param("sno")String sno);//根据学号查找一个用户
    @Select("select id,name,sno,major,grade,clas,sex,nickname,username,password,pernature,email,qq,point,registerdate,ipadress from user where username = #{username}")
    User findUserByUsername(@Param("username")String username);//根据用户名查找用户
    @Update("update user set id=#{id},name=#{name},sno=#{sno},major=#{major},grade=#{grade},clas=#{clas},sex=#{sex},nickname=#{{nickname},username=#{username},password=#{password},pernature=#{pernature},email=#{email},qq=#{qq},point=#{point},registerdate=#{registerdate},ipadress=#{ipadress} where username = #{username}")
    void UpdateUser(User user);//更新用户信息
    @Delete("delete from user where username =#{username}")
    void deleteUser(@Param("username")String username);//删除用户
}
