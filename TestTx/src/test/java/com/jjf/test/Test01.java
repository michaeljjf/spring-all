package com.jjf.test;

import com.jjf.config.SpringConfig;
import com.jjf.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    @Test
    public void testTransMoney() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext1.xml");
        AccountService accountService = applicationContext.getBean(AccountService.class);
        int rows = accountService.transMoney(1, 2, 100);
        System.out.println(rows);
    }

    @Test
    public void testTransMoney2() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountService accountService = applicationContext.getBean(AccountService.class);
        int rows = accountService.transMoney(1, 2, 100);
        System.out.println(rows);
    }
}
