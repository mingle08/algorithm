package IOCdemo.service;

import IOCdemo.dao.UserDao;

public interface UserService {
    void getUser();
    void setUserDao(UserDao userDao);
}
