package algo.jdk.reflect;

import java.lang.reflect.Constructor;

public class Test {

    public static void main(String[] args) throws Exception {
        test1();
    }
    public static void test1() throws NoSuchMethodException, ClassNotFoundException {
        Class clazz = Student.class;

        System.out.println("public:");
        Constructor<?>[]  constructors = clazz.getConstructors();
        for(Constructor constructor : constructors){
            System.out.println(constructor.toGenericString());
        }

        System.out.println("===============================================");
        System.out.println("所有构造方法：包括public/protected/private/default:");
        constructors = clazz.getDeclaredConstructors();
        for(Constructor constructor : constructors){
            System.out.println(constructor.toGenericString());
        }

        System.out.println("单个方法：");
//        Class c = Class.forName("algo.jdk.reflect.Student");
        Constructor con = clazz.getConstructor();
        System.out.println(con.toGenericString());
        
        con = clazz.getConstructor(int.class);
//        con.setAccessible(true);
        System.out.println(con.toGenericString());
    }
    

}
