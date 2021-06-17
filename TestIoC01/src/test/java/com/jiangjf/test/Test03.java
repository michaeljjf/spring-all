package com.jiangjf.test;

import com.jiangjf.bean.Cat;
import com.jiangjf.bean.Mouse;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03 {
    @Test
    public void testGetBean() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext3.xml");
        Mouse mouse1 = applicationContext.getBean("mouse1", Mouse.class);
        System.out.println(mouse1);

        Cat cat1 = applicationContext.getBean("cat1", Cat.class);
        System.out.println(cat1);
    }
}
