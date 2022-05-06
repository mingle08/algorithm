package algorithm.leetCode;

import java.util.Stack;

public class LeetCode084_LargestRectangleInHistogram {
    public static void main(String[] args){
        LeetCode084_LargestRectangleInHistogram solution = new LeetCode084_LargestRectangleInHistogram();
        int[] nums = {2,1,5,6,2,3};
        int area = solution.largestRectangleArea(nums);
        System.out.println(area);
    }

    /**
     * 利用一个栈，“递增”的块则直接压入栈中，否则（停止递增时），则将栈顶出栈，
     * 乘以上一个比他矮的下标（也就是它出栈后的栈顶）与当前指针的高度，
     *
     * 这样就能表示当前指针的“前一个比它高的块”的最大面积，与最大值比较之后，需要将指针 i 再-1，
     * 用来继续探测当前指针“前一块比它高的”。
     * （从下标0一直判断到length，当下标为length的时候，高度为0）
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length < 1)
            return 0;

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            // 把堆栈中比heights[i]大的元素都pop出，并计算面积
            while (stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
                int top = stack.pop();
                // 面积计算公式：(i - 1-stack.peek() ) * heights[top])
                max = Math.max(max, (i - 1 - stack.peek()) * heights[top]);
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            int top = stack.pop();
            max = Math.max(max, (heights.length - 1 - stack.peek()) * heights[top]);
        }
        return max;
    }

    /**
     * 采用找到当前矩形的最远左右侧下标，不同的是，我们用两个数据结构int[] lessFromLeft, int[] lessFromRight
     * 分别来存储当前矩形的最远左右侧下标。当我们不采用数据结构时，寻找和计算的过程需要O(n^2）的时间复杂度。
     * 而通过数据结构，我们可以很大程度上减少遍历次数，对当前矩阵的最左侧下标可以通过lessFromLeft跳跃遍历。
     * 也就是说，如果左侧矩形比当前矩形大，则跳到左侧矩形的最左侧矩形继续判断，如果最后跳到起点，则结束遍历。
     * @param heights
     * @return
     */
    public int largestRectangleArea3(int[] heights){
        int barCount = heights.length;
        if(barCount==0) return 0;
        int[] lessThanLeft = new int[barCount];
        int[] lessThanRight = new int[barCount];
        lessThanLeft[0] = -1;
        lessThanRight[barCount-1] = barCount;
        for(int i = 1 ; i<barCount ; i++){
            int p = i-1;
            while(p>=0 && heights[p]>=heights[i]){
                p = lessThanLeft[p];
            }
            lessThanLeft[i] = p;
        }
        for(int i = barCount-2 ; i>=0 ; i--){
            int p = i+1;
            while(p<barCount && heights[p]>=heights[i]) p = lessThanRight[p];
            lessThanRight[i] = p;
        }

        int max = 0;
        for(int i = 0 ; i<barCount ; i++){
            max = Math.max(max, heights[i]*(lessThanRight[i]-lessThanLeft[i]-1));
        }
        return max;
    }

    /**
     * 网上看到一种借助栈的做法，代码很漂亮，但是解释都非常模糊，我看懂之后，决定仔细描述思路如下：
     *
     * 1、如果已知height数组是升序的，应该怎么做？
     *
     * 比如1,2,5,7,8
     *
     * 那么就是(1*5) vs. (2*4) vs. (5*3) vs. (7*2) vs. (8*1)
     *
     * 也就是max(height[i]*(size-i))
     *
     * 2、使用栈的目的就是构造这样的升序序列，按照以上方法求解。
     *
     * 但是height本身不一定是升序的，应该怎样构建栈？
     *
     * 比如2,1,5,6,2,3
     *
     * （1）2进栈。s={2}, result = 0
     *
     * （2）1比2小，不满足升序条件，因此将2弹出，并记录当前结果为2*1=2。
     *
     * 将2替换为1重新进栈。s={1,1}, result = 2
     *
     * （3）5比1大，满足升序条件，进栈。s={1,1,5},result = 2
     *
     * （4）6比5大，满足升序条件，进栈。s={1,1,5,6},result = 2
     *
     * （5）2比6小，不满足升序条件，因此将6弹出，并记录当前结果为6*1=6。s={1,1,5},result = 6
     *
     * 2比5小，不满足升序条件，因此将5弹出，并记录当前结果为5*2=10（因为已经弹出的5,6是升序的）。s={1,1},result = 10
     *
     * 2比1大，将弹出的5,6替换为2重新进栈。s={1,1,2,2,2},result = 10
     *
     * （6）3比2大，满足升序条件，进栈。s={1,1,2,2,2,3},result = 10
     *
     * 栈构建完成，满足升序条件，因此按照升序处理办法得到上述的max(height[i]*(size-i))=max{3*1, 2*2, 2*3, 2*4, 1*5, 1*6}=8<10
     *
     * 综上所述，result=10
     * https://www.cnblogs.com/ganganloveu/p/4148303.html
     */

}
