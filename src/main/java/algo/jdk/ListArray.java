package jdk;

import java.util.Arrays;
import java.util.List;

public class ListArray {
    public static void main(String[] args){
        int[] test = new int[]{1,2,3,4};
        List list = Arrays.asList(test);
        System.out.println(list.size());  // 1
    }
}
