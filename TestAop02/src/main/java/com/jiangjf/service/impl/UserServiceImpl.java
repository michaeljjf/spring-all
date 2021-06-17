package com.jiangjf.service.impl;

import com.jiangjf.dao.UserDao;
import com.jiangjf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int add(int uid, String userName) {
        System.out.println("UserServiceImpl add invoke ...");
        return userDao.add(uid, userName);
    }
}
