package com.jjf.dao;

public interface AccountDao {

    /**
     * 转账
     *
     * @param id 账户id
     * @param money 转账金额
     * @return
     */
    int transMoney(int id, int money);
}
