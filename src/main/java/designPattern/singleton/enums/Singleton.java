package designPattern.singleton.enums;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public enum Singleton {
    INSTANCE;

    public void leavingTheBuilding() {

    }

    /**
     * java.lang.IllegalArgumentException: Cannot reflectively create enum objects
     * 	at java.lang.reflect.Constructor.newInstance(Constructor.java:417)
     * 	at designPattern.singleton.enums.Singleton.main(Singleton.java:16)
     * @param args
     */
    public static void main(String[] args) {
        try {
            // 枚举类并没有无参构造器，不要被idea骗了
            // 使用jad -sjava Singleton.class得到反编译之后的代码，可看到只有一个构造方法，参数 一个是String.class，一个是int.class
//            Constructor constructor = Singleton.class.getDeclaredConstructor();

            Constructor constructor = Singleton.class.getDeclaredConstructor(String.class, int.class);
            Singleton instance = (Singleton) constructor.newInstance();
            System.out.println(instance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
