package com.jjf.test;

import com.jjf.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestTx {

    @Autowired
    private AccountService accountService;

    @Test
    public void testTransMoney() {
        int rows = accountService.transMoney(1, 2, 100);
        System.out.println(rows);
    }
}
