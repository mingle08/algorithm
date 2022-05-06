package algorithm.codingInterviewChinese2;

/**
 * 查找出数组中出现次数超过一半的数字
 * 1. 方法一：类似快速排序，
 * 2. 方法二：统计每个元素出现的次数
 */
public class Q039_MoreThanHalfNumber {
    private boolean isInputInvalid = false;

    // 方法一（略）

    /**
     * 方法二
     * 在遍历数组时保存2个值：
     * 1，数组中的一个数字
     * 2，次数
     * 当遍历到下一个数字的时候，如果下一个数字和之前保存的数字相同，则次数加1；
     * 如果不同，则次数减1
     * 由于要找的数字出现的次数比其他所有数字出现的次数之和还要多，那么要找的数字肯定是最后一次把次数设为1时对应的数字
     * @param numbers
     * @param len
     * @return
     */
    public int numMoreThanHalf(int[] numbers, int len){
        if (checkInputInvalid(numbers, len))
            return 0;

        int result = numbers[0];
        int times = 1;
        for (int i = 0; i < len; i++) {
            // 如果次数为0，则保存下一个数字，即numbers[i]，并把次数设为1
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
