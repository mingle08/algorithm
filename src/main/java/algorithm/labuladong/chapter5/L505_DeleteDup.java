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

    /**
     * 重复元素全部删除，一个不留
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     *
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/remove-element
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val){
                nums[k++] = nums[i];
            }
        }
        return k;
    }


    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 2, 3, 3, 4};
        int newlen = removeDup(nums);
        System.out.println(newlen);
        for (int i : nums) {
            System.out.print(i + " ");
        }

        System.out.println();
        int[] arr = {0,1,2,2,3,0,4,2};
        int len = removeElement(arr, 2);
        System.out.println(len);
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}
