package algorithm.BeautyOfProgramming;

/**
 * 求数组中的第二大的数
 */
public class Q2_10_SecondMax {

    public int findSecMax(int[] arr){
        int max = arr[0];
        int second = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int tmp = max;
            if (arr[i] > max){
                max = arr[i];
                second = tmp;
            }
        }

        return second;
    }

    public static void main(String[] args){
        Q2_10_SecondMax solution = new Q2_10_SecondMax();
        int[] num = {5, 6, 8, 3, 7, 9};
        int second = solution.findSecMax(num);
        System.out.println("第二大的数是 " + second);
    }
}
