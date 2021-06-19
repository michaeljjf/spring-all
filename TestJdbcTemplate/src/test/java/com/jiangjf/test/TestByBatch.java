package com.jiangjf.test;

import com.jiangjf.pojo.Dept;
import com.jiangjf.service.DeptService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestByBatch {
    @Test
    public void testBatchAdd() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        DeptService deptService = applicationContext.getBean(DeptService.class);
        List<Dept> deptList = new ArrayList<>();
        for (int i = 46; i <= 56; i++) {
            Dept dept = new Dept(i, "name" + i, "loc" + i);
            deptList.add(dept);
        }
        int[] ints = deptService.batchAdd(deptList);
        System.out.println(Arrays.toString(ints));
    }

    @Test
    public void testBatchUpdate() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        DeptService deptService = applicationContext.getBean(DeptService.class);
        List<Dept> deptList = new ArrayList<>();
        for (int i = 46; i <= 56; i++) {
            Dept dept = new Dept(i, "name-" + i, "loc-" + i);
            deptList.add(dept);
        }
        int[] ints = deptService.batchUpdate(deptList);
        System.out.println(Arrays.toString(ints));
    }

    @Test
    public void testBatchDelete() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        DeptService deptService = applicationContext.getBean(DeptService.class);
        List<Integer> deptnos = new ArrayList<>();
        for (int i = 46; i <= 56; i++) {
          deptnos.add(i);
        }
        int[] ints = deptService.batchDelete(deptnos);
        System.out.println(Arrays.toString(ints));
    }
}
