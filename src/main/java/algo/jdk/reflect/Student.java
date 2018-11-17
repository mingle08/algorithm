package algo.jdk.reflect;

public class Student {

    public Student(){
        System.out.println("public constructor. ");
    }

    public Student(int a){
        System.out.println("default constructor. ");
    }

    public Student(String name){
        System.out.println("private constructor. ");
    }

    protected Student(int a, String name){
        System.out.println("protected constructor. ");
    }
}
