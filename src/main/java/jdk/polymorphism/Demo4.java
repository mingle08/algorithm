package jdk.polymorphism;

public class Demo4 {
    public static void main(String[] args) {
        Animal a = new Animal();

        // instanceof可避免报异常java.lang.ClassCastException
        if (a instanceof Dog) {
            Dog d = (Dog) a;
            d.eat();
        }
    }
}
