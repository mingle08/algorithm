package algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q049_GroupAnagrams {

    public static void main(String[] args) {
        Q049_GroupAnagrams solution = new Q049_GroupAnagrams();
        String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> list = solution.groupAnagrams(arr);
        
        System.out.println(list.size());

    }
    
    
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<List<String>>();
        int len = strs.length;
        if(len<1) return list;
        Map<String,List<String>> map = new HashMap<String,List<String>>();
        String tmp = "";
        for(int i=0;i<len;i++){
            tmp = strs[i];
            // 打散成char -> 排序  -> 字符串，比如eat，tea转成char，排序再转成String，都是aet，作为map的key
            char[] arrayOfString = tmp.toCharArray();
            Arrays.sort(arrayOfString);
            tmp = new String(arrayOfString);
            if(map.containsKey(tmp)){
                map.get(tmp).add(strs[i]);
            }else{
                List<String> item = new ArrayList<String>();
                item.add(strs[i]);
                map.put(tmp, item);
            }
        }
        for (List<String> value : map.values()) {             
            list.add(value);           
        } 
        return list;
    }
    

}
