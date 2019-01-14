package AOPDemo;

import AOP.EasyAop.*;
import org.junit.Test;

public class EasyAopTest {
    @Test
    public void getProxy() throws Exception {
        // 1. 创建一个MethodInvocation 实现类
        MethodInvocation logTask = () -> System.out.println("log task start.");
        HelloServiceImpl helloServiceImpl = new HelloServiceImpl();

        // 2. 创建一个 advice
        Advice beforeAdvice = new BeforeAdvice(helloServiceImpl, logTask);

        // 3. 为目标生成代理
        HelloService helloServiceImplProxy = (HelloService) EasyAop.getProxy(helloServiceImpl, beforeAdvice);

        helloServiceImplProxy.sayHello();

    }
}
