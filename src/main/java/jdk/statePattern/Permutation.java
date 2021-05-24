package jdk.statePattern;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    //求数组的所有排列
    public void permutations(int[] array, int start, int end, List<int[]> list){
        if(array == null){
            return;
        }
        if(start == end){
            int[] temp = new int[array.length];
            System.arraycopy(array,0,temp,0,array.length);
            list.add(temp);
        }
        for(int i = start; i < array.length; i++){
            //将第i个元素交换至当前index下标处
            swap(array,start,i);

            //以递归的方式对剩下元素进行全排列
            permutations(array,start + 1,end, list);

            //将第i个元素交换回原处
            swap(array,start,i);
        }
    }
    //交换元素
    public void swap(int[] array,int i,int j){
        if (i == j)
            return;

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args){
        Permutation solution = new Permutation();

        int[] arr = {1, 2, 3};
        List<int[]> res = new ArrayList<>();
        solution.permutations(arr, 0, arr.length - 1, res);

        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).length; j++) {
                System.out.print(res.get(i)[j] + " ");
            }
            System.out.println();
        }
    }
}
