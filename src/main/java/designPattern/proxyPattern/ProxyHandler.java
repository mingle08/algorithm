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
        Object res = method.invoke(obj, args);
        return res;
    }

    // 生成代理类
    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
    }
}
