package com.daily_word.service;

import com.daily_word.mapper.User_InfoMapper;
import com.daily_word.mapper.Word_InfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class S_Word {
    @Autowired
    private Word_InfoMapper word_infoMapper;

    public int add_word(int user_id,String content,int type,String date_time){
        return word_infoMapper.add_word(user_id,content,type,date_time);
    }
}
