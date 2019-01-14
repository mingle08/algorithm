package AOP.EasyAop;

public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello() {
        System.out.println("Hello world !");
    }
}
