package designPattern.proxyPattern;

import java.lang.reflect.Proxy;

public class MyProxy {

    /**
     * 代理类，可以放在handler中生成，也可以在handler外面（此例中是MyProxy类）生成，都是调用Proxy.newProxyInstance方法
     *
     * public static Object newProxyInstance(ClassLoader loader,
     *                                           Class<?>[] interfaces,
     *                                           InvocationHandler h)
     * 第三个参数是 InvocationHandler
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> T create(Object obj) {
        ProxyHandler handler = new ProxyHandler(obj);
        Class<?> [] interfaces = obj.getClass().isInterface() ? new Class[]{obj.getClass()} : obj.getClass().getInterfaces();
//        T result = (T) Proxy.newProxyInstance(obj.getClass().getClassLoader(), interfaces, handler);
        T result = (T)handler.getProxy();
        return  result;
    }
}
