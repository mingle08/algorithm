package IOCdemo;

import IOCdemo.dao.UserDaoMysqlImpl;
import IOCdemo.service.UserService;
import IOCdemo.service.impl.UserServiceImpl;
import org.junit.Test;

/**
 * 如果客户要测试不同的DaoImpl，例如MysqlDaoImpl,OracleDaoImpl，就需要程序员去UserServiceImpl中改代码
 * 而控制反转，只需将UserServiceImpl中增加以下代码：
 *
 *     private UserDao userDao;
 *
 *     public void setUserDao(UserDao userDao) {
 *         this.userDao = userDao;
 *     }
 *  客户想测试哪个实现类，就在此test方法中new哪个实现类，无需程序员再去修改UserServiceImpl代码
 */
public class IocTest {

    @Test
    public void test() {
        UserService userService = new UserServiceImpl();
        userService.setUserDao(new UserDaoMysqlImpl());
        userService.getUser();
    }
}
