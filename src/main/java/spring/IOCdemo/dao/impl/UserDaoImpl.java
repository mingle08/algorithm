package spring.IOCdemo.dao.impl;

import spring.IOCdemo.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public void getUser() {
        System.out.println("default get user info");
    }
}
