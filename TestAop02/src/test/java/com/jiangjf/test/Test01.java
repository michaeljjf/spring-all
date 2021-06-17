package com.jiangjf.test;

import com.jiangjf.config.SpringConfig;
import com.jiangjf.dao.UserDao;
import com.jiangjf.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

    /**
     * 通过xml文件的方式
     */
    @Test
    public void testAopByXml() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = applicationContext.getBean(UserService.class);
        int rows = userService.add(1, "张三");
//        System.out.println(rows);

//        UserDao userDao = applicationContext.getBean(UserDao.class);
//        userDao.add();
    }

    /**
     * 通过配置类的方式
     */
    @Test
    public void testAopBySpringConfig() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = applicationContext.getBean(UserService.class);
        int rows = userService.add(1, "张三");
    }
}
