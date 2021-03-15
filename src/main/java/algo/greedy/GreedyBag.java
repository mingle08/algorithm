package algo.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GreedyBag {

	private int MAX_WEIGHT = 150;
	private int[] weights = {35,30,60,50,40,10,25};
	private int[] values = {10,40,30,50,35,40,30};
	public static void main(String[] args) {
		GreedyBag bag = new GreedyBag();
		bag.greedy(bag.MAX_WEIGHT, bag.weights, bag.values);

	}
	
	private void greedy(int capacity, int[] weights, int[] values) {
		int n = weights.length;
		double[] r = new double[n]; // 性价比
		int[] index = new int[n]; // 按性价比排序物品的下标
		for(int i = 0; i < n; i++) {
			r[i] =(double) values[i]/weights[i];
			index[i] = i;
		}
		double temp = 0;
		Map map = new HashMap();
		for(int i = 0; i < n-1; i++) {
			for(int j = i+1; j < n; j++) {
				if(r[i] < r[j]) { // 由 大 ---> 小 排列
					temp = r[i];
					r[i] = r[j];
					r[j] = temp;
					int x = index[i];
					index[i] = index[j];
					index[j] = x;
				}
			}
		}
		for(int i = 0; i < n; i++) {
			System.out.print(" " + r[i]);
		}
		System.out.println();
		for(int i = 0; i < n; i++) {
			System.out.print(" " + index[i]);
		}
		// 排序好的重量和价值分别存到数组
		int[] w1 = new int[n];
		int[] v1 = new int[n];
		for(int i = 0; i < n; i++) {
			w1[i] = weights[index[i]];
			v1[i] = values[index[i]];
		}
		System.out.println();
		for(int i = 0; i < n; i++) {
			System.out.print(" " + w1[i]);
		}
		System.out.println();
		for(int i = 0; i < n; i++) {
			System.out.print(" " + v1[i]);
		}
		System.out.println();
		// 装包
		int[] x = new int[n];
		int maxValue = 0;
		for(int i = 0; i < n; i++) {
			if(w1[i] < capacity) {
				// 还可以装得下
				x[i] = 1; // 表示该物品被装进包了
				maxValue += v1[i];
				System.out.println("重量为 " + w1[i] + " 的物品被放进包里。");
				capacity = capacity - w1[i];
			}
		}
		System.out.println("总共放下的物品数量：" + Arrays.toString(x));
		System.out.println("最大价值：" + maxValue);
	}

}
