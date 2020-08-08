package com.daily_word.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Word_InfoMapper {

    @Insert("insert into word(content,time,type,user_id) " +
            "values(#{content},#{date_time},#{type},#{user_id})")
    int add_word(int user_id,String content,int type,String date_time);
}
