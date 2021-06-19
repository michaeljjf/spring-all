package com.jjf.service;

public interface AccountService {

    /**
     * 转账
     *
     * @param from 转出账号id
     * @param to 转入账号id
     * @param money 转账金额
     * @return
     */
    int transMoney(int from, int to, int money);
}
