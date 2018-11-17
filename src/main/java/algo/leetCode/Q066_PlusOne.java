package algo.leetCode;

public class Q066_PlusOne {
    public static void main(String[] args){
        Q066_PlusOne solution = new Q066_PlusOne();
        int[] arr = {9,9,9};
        int[] res = solution.plusOne(arr);
        System.out.println(res.length);
    }

    public int[] plusOne(int[] num){

        for (int i = num.length-1; i >= 0; i--) {
            // num.length-1下标对应的是个位数，从个位数往十位数，百位数检查
            if(num[i] == 9){
                num[i] = 0;
            }else{
                num[i]++;
                return num;
            }

        }

        int[] res = new int[num.length + 1];
        res[0] = 1;
        return res;
    }
}
