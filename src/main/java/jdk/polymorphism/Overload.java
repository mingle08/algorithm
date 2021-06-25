package jdk.polymorphism;

import java.io.Serializable;

/**
 * 不断注释方法，程序将按照char > int > long > float > double的顺序转型进行匹配，
 * 但不会匹配byte和short类型的重载，因为char到byte或short的转型不安全
 * 此例可演示编译期间选择静态分派目标的过程，这也是Java语言实现方法重载的本质
 */
public class Overload {
    public static void sayHello(Object arg) {
        System.out.println("hello Object");
    }

    public static void sayHello(int arg) {
        System.out.println("hello int");
    }

    public static void sayHello(long arg) {
        System.out.println("hello long");
    }

    public static void sayHello(Character arg) {
        System.out.println("hello Character");
    }

    public static void sayHello(char arg) {
        System.out.println("hello char");
    }

    public static void sayHello(Serializable arg) {
        System.out.println("hello Serializable");
    }

    public static void main(String[] args) {
        sayHello('a');
    }
}
