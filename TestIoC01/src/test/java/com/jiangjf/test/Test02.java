package com.jiangjf.test;

import com.jiangjf.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02 {
    @Test
    public void testGetBean() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext2.xml");
        User user1 = applicationContext.getBean("user1", User.class);
        System.out.println(user1);
    }
}
