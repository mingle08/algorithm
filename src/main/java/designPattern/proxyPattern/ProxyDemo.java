package designPattern.proxyPattern;

public class ProxyDemo {
    public static void main(String[] args) {
        OperateService service = MyProxy.create(new OperateServiceImpl());

        System.out.println("8 + 2 = " + service.add(8, 2));
        System.out.println("8 - 2 = " + service.sub(8, 2));
        System.out.println("8 * 2 = " + service.mul(8, 2));
        System.out.println("8 / 2 = " + service.div(8, 2));
    }
}
