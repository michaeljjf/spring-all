package com.jiangjf.dao.impl;

import com.jiangjf.bean.User;
import com.jiangjf.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImplA implements UserDao {
    @Override
    public int addUser(User user) {
        System.out.println("UserDaoImplA addUser ...");
        return 0;
    }
}
