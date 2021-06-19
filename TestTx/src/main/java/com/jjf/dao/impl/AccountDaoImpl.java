package com.jjf.dao.impl;

import com.jjf.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 转账
     *
     * @param id    账户id
     * @param money 转账金额
     * @return
     */
    @Override
    public int transMoney(int id, int money) {
        String sql = "update account set money = money + ? where id = ?";
        return jdbcTemplate.update(sql, money, id);
    }
}
