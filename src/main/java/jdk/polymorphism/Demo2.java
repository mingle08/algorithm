package jdk.polymorphism;

public class Demo2 {

    public static void main(String[] args) {
        Dog d = new Dog();
        Animal a = d;
        a.eat();
        // 不能调用子类的独有方法
//        a.todo();
        // 打印 2
        System.out.println(a.age);
    }
}

class Animal {
    int age = 2;
    public void eat() {
        System.out.println("Animal eat");
    }
}

class Dog extends Animal {
    int age = 3;
    public void eat() {
        System.out.println("Dog eat meat");
    }
    public void todo() {
        System.out.println("Dog guard house");
    }
}

class Cat extends Animal {
    int age = 1;
    public void eat() {
        System.out.println("Cat eat fish");
    }
}
