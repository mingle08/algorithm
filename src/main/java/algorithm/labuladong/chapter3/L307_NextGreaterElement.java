package algorithm.labuladong.chapter3;

import java.util.Stack;

public class L307_NextGreaterElement {
    /*
    输入一个数组，返回一个等长的数组，对应索引存储着下一个更大的元素，如果没有更大的元素，就存-1
    比如输入数组 nums = {2, 1, 2, 4, 3}, 算法返回{4, 2, 4, -1, -1}。
    */
    int[] nextGreaterElement(int[] nums) {
        // 存放答案
        int[] ans = new int[nums.length];
        Stack<Integer> s = new Stack<>();
        // 倒着往栈里放
        for (int i = nums.length - 1; i >= 0; i--) {
            // 判定个子高矮
            while (!s.empty() && s.peek() <= nums[i]) {
                // 矮个子出列，反正也被挡住了
                s.pop();
            }
            // 这个元素身后的第一个高个子
            ans[i] = s.empty() ? -1 : s.peek();
            // 进队，接受之后的身高判定吧
            s.push(nums[i]);
        }
        return ans;
    }

    /*

    一个数组T，存放的是近几天的气温，算法需返回一个数组，计算对于每一天，还要至少等多少天才能等到一个更暖和的气温；如果等不到那一天，填0.
    比如，输入T = {73, 74, 75, 71, 69, 72, 76, 73}，算法应该返回{1, 1, 4, 2, 1, 1, 0, 0}

    */
    int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        // 存放元素索引，而不是元素
        Stack<Integer> s = new Stack<>();
        for (int i = T.length - 1; i >= 0; i--) {
            while (!s.empty() && T[s.peek()] <= T[i]) {
                s.pop();
            }
            // s.peek() - i 是索引间距
            ans[i] = s.empty() ? 0 : (s.peek() - i);
            s.push(i);
        }
        return ans;
    }

    // 循环数组
    int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        // 存放答案
        int[] ans = new int[n];
        Stack<Integer> s = new Stack<>();
        // 假装这个数组长度翻倍了
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!s.empty() && s.peek() <= nums[i % n]) {
                s.pop();
            }
            // 利用 % 求模防止索引越界
            ans[i % n] = s.empty() ? -1 : s.peek();
            s.push(nums[i % n]);
        }
        return ans;
    }


    public static void main(String[] args) {
        L307_NextGreaterElement solution = new L307_NextGreaterElement();
        int[] nums = {2, 1, 2, 4, 3};
        int[] res = solution.nextGreaterElement(nums);
        for (int i : res) {
            System.out.print(i + " ");
        }
        System.out.println();
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        res = solution.dailyTemperatures(T);
        for (int i : res) {
            System.out.print(i + " ");
        }
        System.out.println();
        res = solution.nextGreaterElements(nums);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
