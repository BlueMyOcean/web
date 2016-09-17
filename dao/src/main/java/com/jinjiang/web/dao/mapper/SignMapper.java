package com.jinjiang.web.dao.mapper;

import com.jinjiang.web.bean.SignData;
import com.jinjiang.web.bean.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2016/9/8 0008.
 */
public interface SignMapper {
    @Select("select ")
    List<SignData> getUnqualifiedStudent();
}
