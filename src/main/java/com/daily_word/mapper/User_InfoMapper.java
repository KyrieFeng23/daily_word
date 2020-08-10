package com.daily_word.mapper;

import com.daily_word.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface User_InfoMapper {

    @Select("select * from user where username='${username}' and password=${password}")
    User find_user_by_name(String username, String password);

    @Update("update user set last_login_time ='${last_login_time}' where user_id = ${user_id}")
    int update_last_login_time(String last_login_time,int user_id);
}
