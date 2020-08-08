package com.daily_word.controller;

import com.daily_word.service.S_User;
import com.daily_word.service.S_Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class C_Word {
    @Autowired
    private S_User s_user;
    @Autowired
    private S_Word s_word;


    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "publish",method = RequestMethod.POST)
    public String publish(int user_id,String content){
        int type=1;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date_time = df.format(new Date());//调用时间函数生成
        s_word.add_word(user_id,content,type,date_time);
        return "redirect:index";
    }
}
