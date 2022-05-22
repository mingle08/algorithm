package algorithm.labuladong.chapter5;

import algorithm.util.ListNode;

/**
 * 去除有序数组的重复元素
 * 输入一个有序的数组，你需要原地删除重复的元素，使得每个元素只能出现一次，返回去重后新数组的长度。
 * 比如输入nums = {0, 1, 1, 2, 3, 3, 4}，算法应该返回5，且nums的前5个元素分别为{0, 1, 2, 3 ,4}，
 * 至于后面的元素是什么，我们并不关心
 */
public class L505_DeleteDup {

    // 数组
    public static int removeDup(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int slow = 0, fast = 1;
        while (fast < n) {
            if (nums[fast] != nums[slow]) {
                slow++;
                // 维护nums[0...slow]无重复
                nums[slow] = nums[fast];
            }
            fast++;
        }
        // 长度为索引 + 1
        return slow + 1;
    }

    // 链表
    ListNode deleteDup(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, fast = head.next;
        while (fast != null) {
            if (fast.val != slow.val) {
                // nums[slow] = nums[fast]
                slow.next = fast;
                // slow++
                slow = slow.next;
            }
            // fast++
            fast = fast.next;
        }
        // 断开与后面重复元素的连接
        slow.next = null;
        return head;
    }


    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 2, 3, 3, 4};
        int newlen = removeDup(nums);
        System.out.println(newlen);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
