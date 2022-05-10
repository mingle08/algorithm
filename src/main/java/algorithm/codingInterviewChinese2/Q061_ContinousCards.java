package algorithm.codingInterviewChinese2;

/**
 * 扑克牌中的顺子
 * 题目：从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2~10为数字本身，
 * A为1，J为11，Q为12，K为13，而大、小王可以看成任意数字。将大、小王定义为0，这样就能和其他扑克牌区分开来。
 *
 * 思路：
 * 1. 排序数组
 * 2. 统计0的个数
 * 3. 统计空隙的个数
 */
public class Q061_ContinousCards {

    public boolean isContinous(int[] num){
        if (num == null || num.length < 1)
            return false;

        int len = num.length;
        sort(num);

        int numOfZero = 0;    // 大小王有几张
        int numOfGap = 0;

        // 统计数组中0的个数
        for (int i = 0; i < len && num[i] == 0; i++) {
            numOfZero++;
        }

        // 统计数组中的间隔数，small和big都是数组下标
        // 如果有2个0，small是2，num[small]对应第三个数
        int small = numOfZero;
        // 顺子相邻的2张牌：小的是small，大的是big
        int big = small + 1;
        while (big < len){
            // 二个数相等，即对子，不可能是顺子
            if (num[small] == num[big])
                return false;

            // 空缺： 顺子相邻二数相差1，不算缺口，需再减 1
            numOfGap += num[big] - num[small] - 1;
            // small移到big的位置
            small = big;
            // big再往上移一位
            big++;
        }

        return numOfGap <= numOfZero;
    }

    // 选择排序
    private void sort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {// 做第i趟排序
            int k = i;
            for(int j = k + 1; j < arr.length; j++){// 选最小的记录
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
