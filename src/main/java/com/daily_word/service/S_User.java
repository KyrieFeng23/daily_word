package com.daily_word.service;

import com.daily_word.entity.User;
import com.daily_word.mapper.User_InfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class S_User {
    @Autowired
    private User_InfoMapper user_infoMapper;

    public User find_user_by_name(String username, String password){
        return user_infoMapper.find_user_by_name(username,password);
    }

    public int update_last_login_time(String last_login_time,int user_id){
        return user_infoMapper.update_last_login_time(last_login_time,user_id);
    }
}
