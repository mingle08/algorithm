package algo.swordToOffer;

/**
 * 1. 排序数组
 * 2. 统计0的个数
 * 3. 统计空隙的个数
 */
public class Q061_ContinousCards {

    public boolean isContinous(int[] num, int len){
        if (num == null || len < 1)
            return false;

        sort(num, len);

        int numOfZero = 0;
        int numOfGap = 0;

        // 统计数组中0的个数
        for (int i = 0; i < len && num[i] == 0; i++) {
            numOfZero++;
        }

        // 统计数组中的间隔数
        int small = numOfZero; // 如果有2个0，small是2，num[small]对应第三个数
        int big = small + 1;
        while (big < len){
            // 二个数相等，即对子，不可能是顺子
            if (num[small] == num[big])
                return false;

            // 空缺： 相邻二数相差，再减 1
            numOfGap += num[big] - num[small] - 1;
            small = big;
            big++;
        }

        return (numOfGap > numOfZero) ? false : true;
    }


    private void sort(int[] arr, int len) {
        for(int i = 0; i < len - 1; i++) {// 做第i趟排序
            int k = i;
            for(int j = k + 1; j < len; j++){// 选最小的记录
                if(arr[j] < arr[k]){
                    k = j; //记下目前找到的最小值所在的位置
                }
            }
            //在内层循环结束，也就是找到本轮循环的最小的数以后，再进行交换
            if(i != k){  //交换a[i]和a[k]
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }
        }
    }
}
