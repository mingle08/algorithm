package jdk.polymorphism;

public class Demo3 {
    public static void main(String[] args) {
        /*
        Dog dog = new Dog();
        Animal a = dog;
        // 向下转型
        dog = (Dog)a;
        dog.todo();

         */

        Dog d = new Dog();
        Cat c = new Cat();
        Animal a = d;
        d = (Dog) a;
        method(d);
        method(c);
    }


    /*
    public static void method(Dog d) {
        d.eat();
    }

    public static void method(Cat c) {
        c.eat();
    }

     */

    public static void method(Animal a) {
        a.eat();
    }
}
