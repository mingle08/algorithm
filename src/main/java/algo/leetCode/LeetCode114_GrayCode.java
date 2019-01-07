package algo.leetCode;

import java.util.ArrayList;
import java.util.List;

public class Q089_GrayCode {

    public static List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>(1 << n);
        res.add(0);
        for(int i=0; i < n; i++){
            int high_bit = 1 << i;
            for(int j = res.size()-1; j>=0; j--){
                res.add(high_bit | res.get(j));
            }
        }
        return res;
    }

    public static void main(String[] args){

        List<Integer> res = grayCode(2);
        System.out.println(res.size());
    }
}
