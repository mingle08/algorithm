package algorithm.leetCode;

/**
 * 表示一个区间
 */
public class Interval {
    int start;
    int end;
    Interval(){
        start = 0;
        end = 0;
    }

    public Interval(int s, int e){
        start = s;
        end = e;
    }
}
