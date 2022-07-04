package algorithm.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 *
 *
 * 示例 1：
 *
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 *
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 *
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode093_RestoreIPAddress {

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        backTracking(s, 0, res, temp);
        return res;
    }

    public void backTracking(String s, int begin, List<String> res, List<String> temp) {
        if (temp.size() == 4) {
            if (begin == s.length()) {
                res.add(String.join(".", temp));
            }
            return;
        }
        // begin + 3 因为0~255最多只有3位
        for (int i = begin; i < begin + 3 && i < s.length(); i++) {
            // 每次取1到3个
            String sub = s.substring(begin, i + 1);
            if (!isValid(sub)) {
                continue;
            }
            temp.add(sub);
            backTracking(s, i + 1, res, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public boolean isValid(String sub) {
        if (sub.length() != 1 && sub.charAt(0) == '0') {
            return false;
        }
        return Integer.parseInt(sub) <= 255 ? true : false;
    }

    public static void main(String[] args) {
        LeetCode093_RestoreIPAddress solution = new LeetCode093_RestoreIPAddress();

        String ss = "25525511135";
        List<String> res = solution.restoreIpAddresses(ss);
        printArray(res);
    }

    public static void printArray(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
