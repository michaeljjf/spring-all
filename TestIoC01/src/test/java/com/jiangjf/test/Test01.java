package com.jiangjf.test;

import com.jiangjf.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    @Test
    public void testGetBean() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user2 = applicationContext.getBean("user2", User.class);
        System.out.println(user2);
    }
}
