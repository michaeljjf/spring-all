package com.jiangjf.test;

import com.jiangjf.bean.User;
import com.jiangjf.config.SpringConfig;
import com.jiangjf.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    @Test
    public void testGetBean() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        User user = applicationContext.getBean("user", User.class);
//        System.out.println(user);
        UserServiceImpl userServiceImpl = applicationContext.getBean("userServiceImpl", UserServiceImpl.class);
        userServiceImpl.addUser(null);
    }

    @Test
    public void testGetBean2() {
        // 了解就好
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
//        User user = applicationContext.getBean("user", User.class);
//        System.out.println(user);
        UserServiceImpl userServiceImpl = applicationContext.getBean("userServiceImpl", UserServiceImpl.class);
        userServiceImpl.addUser(null);
    }
}
