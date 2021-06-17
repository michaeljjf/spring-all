package com.jiangjf.test;

import com.jiangjf.dao.EmpDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    @Test
    public void testAddEmp() {
        // IoC概念引入
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        EmpDao empDao = applicationContext.getBean("empDao", EmpDao.class);
        empDao.addEmp();
    }
}
