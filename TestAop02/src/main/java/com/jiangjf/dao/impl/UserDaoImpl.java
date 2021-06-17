package com.jiangjf.dao.impl;

import com.jiangjf.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public int add(int uid, String userName) {
        System.out.println("UserDaoImpl add invoke ...");
        return 1;
    }
}
