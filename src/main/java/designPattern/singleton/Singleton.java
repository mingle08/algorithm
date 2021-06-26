package designPattern.singleton;

import java.lang.reflect.Constructor;

public class Singleton {

    /*
    1, 饿汉式
    private static Singleton instance = new Singleton();
    // 构造方法私有
    private Singleton(){}

    public static Singleton getInstance() {
        return instance;
    }
     */


    /*
    2, 懒汉式
    private static Singleton instance;
    // 构造方法私有
    private Singleton(){

    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
     */

    // 3，双重检测锁
    private static volatile Singleton instance;

    private Singleton(){

    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    // 4, 静态内部类
    /*
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }
    private Singleton() {

    }
    public static final Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

     */

    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        // 打印出的地址相同
        System.out.println(instance1);
        System.out.println(instance2);

        try {
            // 用反射可破坏单例
            Constructor constructor = Singleton.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            Singleton instance3 = (Singleton) constructor.newInstance();
            Singleton instance4 = (Singleton) constructor.newInstance();
            // 打印出的地址不同
            System.out.println(instance3);
            System.out.println(instance4);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
