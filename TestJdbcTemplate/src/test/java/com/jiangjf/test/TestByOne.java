package com.jiangjf.test;

import com.jiangjf.pojo.Dept;
import com.jiangjf.service.DeptService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestByOne {
    @Test
    public void testGetDeptCount() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        DeptService deptService = applicationContext.getBean(DeptService.class);
        int deptCount = deptService.getDeptCount();
        System.out.println(deptCount);
    }

    @Test
    public void testFindByDeptno() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        DeptService deptService = applicationContext.getBean(DeptService.class);
        Dept dept = deptService.findByDeptno(10);
        System.out.println(dept);
    }

    @Test
    public void testFindAll() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        DeptService deptService = applicationContext.getBean(DeptService.class);
        List<Dept> deptList = deptService.findAll();
        deptList.forEach(System.out::println);
    }

    @Test
    public void testUpdateDept() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        DeptService deptService = applicationContext.getBean(DeptService.class);
        Dept dept = new Dept(44, "测试", "测试");
        int rows = deptService.updateDept(dept);
        System.out.println(rows);
    }

    @Test
    public void testAddDept() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        DeptService deptService = applicationContext.getBean(DeptService.class);
        Dept dept = new Dept(null, "测试2", "测试2");
        int rows = deptService.addDept(dept);
        System.out.println(rows);
    }

    @Test
    public void testDeleteDept() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        DeptService deptService = applicationContext.getBean(DeptService.class);
        int rows = deptService.deleteDept(45);
        System.out.println(rows);
    }
}
