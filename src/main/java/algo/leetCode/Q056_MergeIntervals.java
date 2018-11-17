package algo.leetCode;

import algo.leetCode.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Q056_MergeIntervals {

    public static void main(String[] args) {
        Q056_MergeIntervals solution = new Q056_MergeIntervals();
        Interval interval1 = new Interval(1,3);
        Interval interval2 = new Interval(2,6);
        Interval interval3 = new Interval(8,10);
        Interval interval4 = new Interval(15,18);
        List<Interval> list = new ArrayList<Interval>();
        list.add(interval1);
        list.add(interval2);
        list.add(interval3);
        list.add(interval4);
        
        list = solution.merge(list);
        System.out.println(list.size());

    }
    
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> list = new ArrayList<Interval>();
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
