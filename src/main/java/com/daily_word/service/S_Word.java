package com.daily_word.service;

import com.daily_word.entity.Word;
import com.daily_word.mapper.User_InfoMapper;
import com.daily_word.mapper.Word_InfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class S_Word {
    @Autowired
    private Word_InfoMapper word_infoMapper;

    //添加一个word
    public int add_word(int user_id,String content,int type,String date_time){
        return word_infoMapper.add_word(user_id,content,type,date_time);
    }

    //展示某个用户的所有word,根据user_id来筛选
    public List<Word> get_ones_word(int user_id){
        return word_infoMapper.get_ones_word(user_id);
    }
}
