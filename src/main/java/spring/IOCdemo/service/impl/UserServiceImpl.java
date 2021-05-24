package spring.IOCdemo.service.impl;

import spring.IOCdemo.dao.UserDao;
import spring.IOCdemo.service.UserService;

public class UserServiceImpl implements UserService {

    /*
//    private UserDao userDao = new UserDaoImpl();
//    private UserDao userDao = new UserDaoMysqlImpl();
    private UserDao userDao = new UserDaoOracleImpl();
*/
    public void getUser() {
        userDao.getUser();
    }

    /*
      注释掉直接new UserDaoImpl的代码，改用以下2句代码，实现控制反转
     */
    private UserDao userDao;
    // set实现 控制反转
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
