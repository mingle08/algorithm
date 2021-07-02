package designPattern.serviceLocatorPattern;

public class SLPDemo {
    public static void main(String[] args) {
        // 第一次查询
        JndiService service = ServiceLocator.getService("AService");
        service.execute();
        service = ServiceLocator.getService("BService");
        service.execute();
        // 第二次查询
        service = ServiceLocator.getService("AService");
        service.execute();
        service = ServiceLocator.getService("BService");
        service.execute();
    }
}
