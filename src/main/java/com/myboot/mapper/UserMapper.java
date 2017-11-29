package com.myboot.mapper;

import com.myboot.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by a on 2017/11/24.
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM SYS_USER WHERE NAME = #{name}")
    User findUserByName(@Param("name") String name);
}
