package algorithm.codingInterviewChinese2;

/**
 * 有二个数只出现一次，其它数都出现二次
 * 一个整型数组里，除2个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * 要求时间复杂度是O(n)，空间复杂度为O(1)
 * <p>
 * 例如，输入数组{2,4,3,6,3,2,5,5}，因为只有4和6这两个数字只出现了一次，其它数字都出现了两次，所以输出4和6
 * <p>
 * 异或：a ^ a = 0
 */
public class Q056_1_NumbersAppearOnce {

    public boolean findNumbersAppearOnce(int[] data, int[] num1, int[] num2) {
        if (data == null || data.length < 2)
            return false;

        int resultExclusiveOR = 0;

        // 1，依次异或每个数字，结果肯定不为0，即结果的二进制表示中至少有一位是1
        for (int datai : data) {
            resultExclusiveOR ^= datai;
        }
        // 2，找出结果的二进制表示中第一个为1的下标
        int indexOf1 = findFirstIndexOf1(resultExclusiveOR);

        // 3, 根据indexOf1是不是1，把原数组分成2个数组
        for (int dataj : data) {
            if (isBit1(dataj, indexOf1))
                num1[0] ^= dataj;
            else
                num2[0] ^= dataj;
        }

        return true;

    }

    /**
     * 找出从右到左数第一个1的索引，也是下个方法isBit1中其它数字需要右移的位数
     */
    private int findFirstIndexOf1(int num) {
        int indexBit = 0;
        // (num & 1) == 0 说明不是1，继续右移
        while ((num & 1) == 0 && indexBit < 32) {
            // 右移找到indexBit
            num = num >>> 1;
            indexBit++;
        }
        return indexBit;
    }

    /**
     * 是否是二进制的1
     * 将其他数字都右移indexBit位
     */
    private boolean isBit1(int num, int indexBit) {
        // 因为indexBit是右移找到的，所以num也要右移indexBit位
        num = num >> indexBit;
        return (num & 1) == 1;
    }

    public static void main(String[] args) {
        Q056_1_NumbersAppearOnce solution = new Q056_1_NumbersAppearOnce();

        int[] data = {2, 4, 3, 6, 3, 2, 5, 5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        boolean canFind = solution.findNumbersAppearOnce(data, num1, num2);
        if (canFind) {
            System.out.println(num1[0]);
            System.out.println(num2[0]);
        }
    }
}
