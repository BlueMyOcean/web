package com.jinjiang.web.dao.mapper;

import com.jinjiang.web.bean.bean.SignData;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/9/8 0008.
 */
public interface SignMapper {
    @Select("select * from user_sign where date < #{date}")
    @Results(
            {
                    @Result(id = true,property = "id",column = "id"),
                    @Result(property = "username",column = "username"),
                    @Result(property = "date",column = "date")
            }
    )
    void queryAllLimitedByDate(Date date);
    @Select("select username,date from user_sign where username=#{username}")
    @Results(
            {
                    @Result(id = true,property = "id",column = "id"),
                 @Result(property = "username",column = "username"),
                    @Result(property = "date",column = "date")
            }
    )
    List<SignData> queryByUsername(@Param("username")String username);
    @Delete("delete from user_sign where username = #{username} and date = #{date}")
    void deleteByUsername(@Param("username")String username,@Param("date")Date date);
    @Insert("insert into user_sign(username,date) values(#{username},#{date})")
    void addSignData(@Param("username")String username,@Param("date")Date date);
    @Update("update user_sign where username=#{username} and date =#{date}")
    void changeSignData(@Param("username")String username,@Param("date")Date date);
    @Select("select max(date) from user_sign where username = #{username}")
    Date queryNewSignDate(@Param("username")String username);

}
