package algo.leetCode;

import java.util.*;

public class LeetCode126_WordLadderII {

    HashMap<String,Integer> path = new HashMap<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        Set<String> set = new HashSet<>(wordList);
        if (beginWord == null || endWord == null || !set.contains(endWord))
            return res;
        bfs(beginWord, endWord, set);
        dfs(endWord, beginWord, tmp, res);
        return res;
    }

    // 广度优先搜索
    private void bfs(String start, String end, Set<String> set) {
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        path.put(start, 0);
        String current;
        while (!queue.isEmpty()) {
            current = queue.poll();
            if (current == end)
                continue;
            for (int i = 0; i < current.length(); i++) {
                char[] ca = current.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    if (ca[i] == c)
                        continue;
                    ca[i] = c;
                    String newWord = new String(ca);
                    if (newWord.equals(end) || set.contains(newWord)) {
                        if (path.get(newWord) == null) {
                            int depth = path.get(current);
                            path.put(newWord, depth + 1);
                            queue.add(newWord);
                        }
                    }
                }
            }
        }
    }

    // 深度优先搜索
    private void dfs(String beginWord, String endWord, List<String> tmp, List<List<String>> res) {
        if (beginWord.equals(endWord)) {
            tmp.add(beginWord);
            Collections.reverse(tmp);
            res.add(tmp);
            return;
        }
        if (path.get(beginWord) == null)
            return;
        tmp.add(beginWord);
        int nextDepth = path.get(beginWord) - 1;
        for (int i = 0; i < beginWord.length(); i++) {
            char[] ca = beginWord.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                if (ca[i] == c) continue;
                ca[i] = c;
                String newWord = new String(ca);
                if (path.get(newWord) != null && path.get(newWord) == nextDepth) {
                    List<String> new_tmp = new ArrayList<>(tmp);
                    dfs(newWord, endWord, new_tmp, res);
                }
            }
        }
    }

    public static void main(String[] args){
        LeetCode126_WordLadderII solution = new LeetCode126_WordLadderII();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        List<List<String>> res = solution.findLadders(beginWord, endWord, wordList);
        System.out.println(res);
    }
}
