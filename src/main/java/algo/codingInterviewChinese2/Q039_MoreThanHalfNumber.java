package algo.codingInterviewChinese2;

/**
 * 查找出数组中出现次数超过一半的数字
 * 1. 方法一：类似快速排序，
 * 2. 方法二：统计每个元素出现的次数
 */
public class Q039_MoreThanHalfNumber {
    private boolean isInputInvalid = false;

    // 方法一（略）

    // 方法二
    public int numMoreThanHalf(int[] numbers, int len){
        if (checkInputInvalid(numbers, len))
            return 0;

        int result = numbers[0];
        int times = 1;
        for (int i = 0; i < len; i++) {
            if (times == 0) {
                result = numbers[i];
                times = 1;
            }
            if (numbers[i] == result)
                times++;
            else
                times--;
        }

        if (!checkMoreThanHalf(numbers, len, result))
            return 0;

        return result;

    }

    private boolean checkInputInvalid(int[] numbers, int length){
        isInputInvalid = false;
        if (numbers == null || length < 0)
            isInputInvalid = true;

        return isInputInvalid;
    }

    private boolean checkMoreThanHalf(int[] numbers, int len, int num){
        int times = 0;
        for (int i = 0; i < len; i++) {
            if(num == numbers[i])
                times++;
        }

        boolean isMoreThanHalf = true;
        if (times * 2 <= len){
            isInputInvalid = true;
            isMoreThanHalf = false;
        }

        return isMoreThanHalf;

    }
}
