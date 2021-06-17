package com.jiangjf.service.impl;

import com.jiangjf.bean.User;
import com.jiangjf.dao.UserDao;
import com.jiangjf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    // 两个实现类的方式
    @Autowired
    @Qualifier("userDaoImplB")
//    @Qualifier("userDaoImplA")
    private UserDao userDao;

//    @Resource(name = "userDaoImplB")
//    private UserDao userDao;
    @Value("${sname}")
    private String sname;
    @Value("${sgender}")
    private String sgender;
    @Value("${sage}")
//    @Value("20")
    private Integer sage;

    @Override
    public int addUser(User user) {
        System.out.println("UserServiceImpl addUser ...");
        System.out.println(sname);
        System.out.println(sgender);
        System.out.println(sage);
        return userDao.addUser(user);
    }
}
