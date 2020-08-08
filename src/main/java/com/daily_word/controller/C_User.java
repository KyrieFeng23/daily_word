package com.daily_word.controller;

import com.daily_word.service.S_User;
import com.daily_word.service.S_Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class C_User {
    @Autowired
    private S_User s_user;
    @Autowired
    private S_Word s_word;

}
