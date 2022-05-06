package algorithm.leetCode;

public class LeetCode134_GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost){
        // 访问的起始点
        int start = 0;
        // 油箱里的汽油
        int total = 0;
        //
        int tank = 0;
        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
            total += tank;
            if (tank < 0){
                tank = 0;
                start = i + 1;
            }
        }
        return (total< 0) ? -1 : start;
    }

    public static void main(String[] args){
        LeetCode134_GasStation solution = new LeetCode134_GasStation();
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        int index = solution.canCompleteCircuit(gas, cost);
        System.out.println(index);
    }
}
