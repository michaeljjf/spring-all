package com.jjf.test;

import com.jjf.service.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * 两种方式：
 * 1、ExtendWith 和 ContextConfiguration一起
 * 2、SpringJUnitConfig一个注解搞定
 */
/*@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:applicationContext.xml")*/
@SpringJUnitConfig(locations = "classpath:applicationContext.xml")
public class TestTxForJunit5 {

    @Autowired
    private AccountService accountService;

    @Test
    public void testTransMoney() {
        int rows = accountService.transMoney(1, 2, 100);
        System.out.println(rows);
    }
}
