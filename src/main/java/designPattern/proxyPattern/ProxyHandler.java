package designPattern.proxyPattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyHandler implements InvocationHandler {

    // 被代理的接口
    private Object obj;
    public ProxyHandler(Object object) {
        this.obj = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 可以加处理逻辑，比如加日志
        log(method.getName());
        Object res = method.invoke(obj, args);
        return res;
    }

    // 生成代理类
    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
    }

    // 加日志
    private void log(String msg) {
        System.out.println("执行了" + msg + "方法");
    }
}
