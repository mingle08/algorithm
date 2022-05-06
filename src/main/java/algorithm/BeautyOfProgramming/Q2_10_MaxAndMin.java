package algorithm.BeautyOfProgramming;

public class Q2_10_MaxAndMin {

    public int[] findMaxAndMin(int[] arr){
        int[] res = new int[2];
        res[0] = arr[0];
        res[1] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > res[0])
                res[0] = arr[i];

            if (arr[i] < res[1])
                res[1] = arr[i];
        }

        return res;
    }

    public static void main(String[] args){
        Q2_10_MaxAndMin solution = new Q2_10_MaxAndMin();
        int[] arr = {5, 6, 8, 3, 7, 9};
        int[] res = solution.findMaxAndMin(arr);
        System.out.println("最大值=" + res[0] + ", 最小值=" + res[1]);
    }
}
