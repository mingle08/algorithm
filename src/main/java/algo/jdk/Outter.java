package jdk;

public class Outter {
    static class Inner {
        static int param1 = 5;
        static final int param2 = 5;
        static final int param3 = new Integer(5);
    }

    public static void main(String[] args){
        System.out.println(Outter.Inner.param1);  // 5
        System.out.println(Outter.Inner.param2);  // 5
        System.out.println(Outter.Inner.param3);  // 5
    }
}
