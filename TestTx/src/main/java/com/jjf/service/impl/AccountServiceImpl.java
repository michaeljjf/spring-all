package com.jjf.service.impl;

import com.jjf.dao.AccountDao;
import com.jjf.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    /**
     * 转账
     *
     * @param from  转出账号id
     * @param to    转入账号id
     * @param money 转账金额
     * @return
     */
    @Override
    @Transactional
    public int transMoney(int from, int to, int money) {
        int rows = 0;
        // 转出，金额使用负数
        rows += accountDao.transMoney(from, -money);
        // 模拟异常
        // int i = 1 / 0;
        // 转入
        rows += accountDao.transMoney(to, money);
        return rows;
    }
}
