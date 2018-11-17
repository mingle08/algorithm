package algo.leetCode;

import algo.leetCode.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Q057_InsertInterval {

    public static void main(String[] args) {
        Q057_InsertInterval solution = new Q057_InsertInterval();
        List<Interval> intervals = new ArrayList<>();
        Interval interval1 = new Interval(1,3);
        Interval interval2 = new Interval(6,9);
        intervals.add(interval1);
        intervals.add(interval2);
        Interval interval3 = new Interval(2,5);

        intervals = solution.insert(intervals, interval3);
        System.out.println(intervals.size());
    }
    
    public List<Interval> insert(List<Interval> intervals, Interval newInterval){
        List<Interval> list = new ArrayList<Interval>();
        intervals.add(newInterval);
        if(intervals.size() == 0)
          return list;
        //排序，实现了Comparator接口
        Collections.sort(intervals,new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
              return o1.start - o2.start;//起始值升序排序
            }
        });
        Interval v1=intervals.get(0);
        for(int i=0;i<intervals.size();i++){
            Interval v2;
            if(i==intervals.size()-1){
                v2 = new Interval(Integer.MAX_VALUE, Integer.MAX_VALUE);
            }else{
                v2=intervals.get(i+1);
            }
            //合并区间 
            if(v2.start >= v1.start && v2.start <= v1.end){
                v1.end = Math.max(v1.end, v2.end);
            }else{//没有交集，直接添加
                list.add(v1);
                v1 = v2;  // v2作为新的v1
            }
        }
        return list;
     }

}
