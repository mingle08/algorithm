package algo.codingInterviewChinese2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static algo.util.SwapUtil.swap;

public class Q038_StringPermutation {

    public List<String> permutation(String str) {
        List<String> list = new ArrayList<>();
        permutation(str.toCharArray(), list, 0);
        Collections.sort(list);
        return list;
    }

    private void permutation(char[] chs, List<String> list, int begin) {
        if (begin == chs.length - 1) {
            list.add(new String(chs));
            return;
        }

        for (int i = begin; i < chs.length; i++) {
            if (i != begin && chs[i] == chs[begin]) {
                continue;
            }
            if (i != begin) swap(chs, begin, i);
            permutation(chs, list, begin + 1);
            if (i != begin) swap(chs, begin, i);

        }
    }
}
