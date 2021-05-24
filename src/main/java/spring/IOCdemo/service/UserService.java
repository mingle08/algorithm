package spring.IOCdemo.service;

import spring.IOCdemo.dao.UserDao;

public interface UserService {
    void getUser();
    void setUserDao(UserDao userDao);
}
