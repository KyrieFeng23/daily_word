package com.daily_word;

import com.daily_word.util.SpringUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DailyWordApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                SpringApplication.run(DailyWordApplication.class, args);
        SpringUtil.setApplicationContext(applicationContext);
        //SpringUtil.printBean();

        //SpringApplication.run(Emall3AfternoonApplication.class, args);
    }

}
