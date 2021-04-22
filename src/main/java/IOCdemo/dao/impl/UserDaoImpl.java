package IOCdemo.dao.impl;

import IOCdemo.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public void getUser() {
        System.out.println("default get user info");
    }
}
