package algo.jdk.AnonymousInnerClass;

/**
 * 匿名内部类也就是没有名字的内部类
 正因为没有名字，所以匿名内部类只能使用一次，它通常用来简化代码编写
 但使用匿名内部类还有个前提条件：必须继承一个父类或实现一个接口
 但是继承不能用extends, 实现接口不能用implements
 */
public class Demo {
    public static void main(String[] args){
        // 1. 不使用匿名内部类
        Person p = new Child();
        p.eat();
    }
}
