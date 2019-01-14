package AOP.EasyAop;

import java.lang.reflect.Proxy;

public class EasyAop {
    public static Object getProxy(Object bean, Advice advice){
        return Proxy.newProxyInstance(EasyAop.class.getClassLoader(), bean.getClass().getInterfaces(), advice);
    }
}
