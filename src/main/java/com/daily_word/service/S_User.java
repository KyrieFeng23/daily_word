package com.daily_word.service;

import com.daily_word.mapper.User_InfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class S_User {
    @Autowired
    private User_InfoMapper user_infoMapper;

}
