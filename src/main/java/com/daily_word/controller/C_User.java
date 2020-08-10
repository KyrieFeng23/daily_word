package com.daily_word.controller;

import com.daily_word.entity.User;
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

@Controller
public class C_User {
    @Autowired
    private S_User s_user;
    @Autowired
    private S_Word s_word;

    //跳转到登录界面
    @RequestMapping(value = "to_login", method = RequestMethod.GET)
    public String toLogin() {
        System.out.println("login Get方法");
        return "login";
    }

    //登录，先写了通过username登录
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(String username, String password, Model model, HttpSession session){
        User user=s_user.find_user_by_name(username,password);
        if (user != null) {
            //将对象添加到session
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            String date_time = df.format(new Date());//调用时间函数生成
            s_user.update_last_login_time(date_time,user.getUser_id());
            session.setAttribute("USER_SESSION", user);
            session.setAttribute("b_s_id",user.getUser_id());
            //跳转到主界面
            System.out.println("user_login success");
            return "redirect:index";
        }
        model.addAttribute("msg", "用户名或密码错误，请重新输入！");
        //返回到登录界面
        return "login";
    }

    //退出登录
    @RequestMapping(value = "logout")
    public String logout(HttpSession session) {
        // 清除Session
        session.invalidate();
        System.out.println("logout退出登录");
        // 重定向到登录页面的跳转方法
        return "redirect:to_login";
    }
}
