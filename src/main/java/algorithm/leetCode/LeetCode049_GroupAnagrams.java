package algorithm.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 *
 * 示例 1:
 *
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 示例 2:
 *
 * 输入: strs = [""]
 * 输出: [[""]]
 * 示例 3:
 *
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode049_GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<List<String>>();
        int len = strs.length;
        if (len < 1) return list;
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        String key = "";
        for (String str : strs) {
            // 打散成char -> 排序  -> 字符串，比如eat，tea转成char，排序再转成String，都是aet，作为map的key
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            key = new String(ch);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> item = new ArrayList<String>();
                item.add(str);
                map.put(key, item);
            }
        }
        for (List<String> value : map.values()) {
            list.add(value);
        }
        return list;
    }

    public static void main(String[] args) {
        LeetCode049_GroupAnagrams solution = new LeetCode049_GroupAnagrams();
        String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> list = solution.groupAnagrams(arr);

        System.out.println(list.size());
        System.out.println(list);
    }
}
