package jdk.IntLongDemo;

public class Demo1 {
    public static void main(String[] args){
        long totalPage = Long.MAX_VALUE;
        for (int i = 0; i < totalPage; i++) {
            if(i < 0){
                System.out.println(i);
            }
        }
    }
}
