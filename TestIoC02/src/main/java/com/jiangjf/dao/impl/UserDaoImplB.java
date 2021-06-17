package com.jiangjf.dao.impl;

import com.jiangjf.bean.User;
import com.jiangjf.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImplB implements UserDao {
    @Override
    public int addUser(User user) {
        System.out.println("UserDaoImplB addUser ...");
        return 0;
    }
}
