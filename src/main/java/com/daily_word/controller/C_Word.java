package com.daily_word.controller;

import com.daily_word.entity.User;
import com.daily_word.entity.Word;
import com.daily_word.service.S_User;
import com.daily_word.service.S_Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class C_Word {
    @Autowired
    private S_User s_user;
    @Autowired
    private S_Word s_word;


    @RequestMapping("index")
    public String index(Model model, HttpSession session){
        User user=(User) session.getAttribute("USER_SESSION");
        model.addAttribute("User_INFO",user);
        int user_id = user.getUser_id();
        //int user_id=1;
        Word word=new Word();
        List<Word> word_list=s_word.get_ones_word(user_id);
        model.addAttribute("word_list",word_list);
        return "index";
    }

    @RequestMapping(value = "publish",method = RequestMethod.GET)
    public String publish(int user_id,String content){
        int type=1;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date_time = df.format(new Date());//调用时间函数生成
        s_word.add_word(user_id,content,type,date_time);
        return "redirect:index";
    }

//    @RequestMapping(value = "show_ones_word")
//    public String show_ones_word(Model model, HttpSession session){
//        int user_id=1;
//        Word word=new Word();
//        List<Word> word_list=s_word.get_ones_word(user_id);
//        model.addAttribute("word_list",word_list);
//        return "index";
//    }
}
