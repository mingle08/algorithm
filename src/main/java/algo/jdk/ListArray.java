package algo.jdk;

import java.util.Arrays;
import java.util.List;

/**
 * 在Arrays.asList中，该方法接受一个变长参数，一般可看做数组参数，但是因为int[] 本身就是一个类型，
 * 所以a变量作为参数传递时，编译器认为只传了一个变量，这个变量的类型是int数组，所以size为1，相当于是List中数组的个数。
 * 基本类型是不能作为泛型的参数，按道理应该使用包装类型，但这里缺没有报错，因为数组是可以泛型化的，所以转换后在list中就有一个类型为int的数组
 */
public class ListArray {
    public static void main(String[] args){
        int[] test = {1,2,3,4};
        List list = Arrays.asList(test);
        System.out.println(list.size());  // 1

        Integer[] test2 = {1,2,3,4};
        List list2 = Arrays.asList(test2);
        System.out.println(list2.size());  // 4
    }
}
