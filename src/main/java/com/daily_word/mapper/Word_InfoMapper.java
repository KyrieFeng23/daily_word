package com.daily_word.mapper;

import com.daily_word.entity.Word;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Word_InfoMapper {

    @Insert("insert into word(content,time,type,user_id) " +
            "values(#{content},#{date_time},#{type},#{user_id})")
    int add_word(int user_id,String content,int type,String date_time);

    //展示某个user_id所有的word，根据user_id来筛选
    @Select("select * from word where user_id = #{user_id} order by time desc")
    List<Word> get_ones_word(int user_id);
}
