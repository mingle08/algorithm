package spring.IOCdemo.dao;

public class UserDaoSqlserverImpl implements UserDao {
    @Override
    public void getUser() {
        System.out.println("sqlserver get user info");
    }
}
