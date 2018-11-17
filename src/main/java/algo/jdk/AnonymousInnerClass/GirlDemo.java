package algo.jdk.AnonymousInnerClass;

/**
 * 在接口上使用匿名内部类
 */
public class GirlDemo {
    public static void main(String[] args){
        Girl girl = new Girl(){
            @Override
            public void eat(){
                System.out.println("girl eat something. ");
            }
        };
    }
}
