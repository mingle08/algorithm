package algoDemo.sort;

import java.util.ArrayList;
import java.util.List;

public class BasicSort {

	public static void main(String[] args) {
		int [] a = {136,2,6,8,9,2,8,11,23,56,34,90,89,29,145,209,320,78,3};
		sort(a);
		for(int i : a) {
			System.out.print(" " + i);
		}

	}
	
	public static void sort(int[] arr) {
		int max = 0;
		for(int i = 0; i < arr.length; i++) {
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		// 获取最大值的位数
		int times = 0;
		while(max > 0) {
			max = max / 10;
			times++;
		}
		List<ArrayList> queue = new ArrayList<ArrayList>();
		for(int i = 0; i < 10; i++) {
			ArrayList q = new ArrayList<>();
			queue.add(q);
		}
		for(int i = 0; i < times; i++) {
			for(int j = 0; j < arr.length; j++) {
				// 获取对应的位的值（i为0是个位，1是10位，2是百位）
				int x = arr[j] % (int)Math.pow(10, i+1) / (int)Math.pow(10, i);
				ArrayList q = queue.get(x);
				// 把元素添加进对应下标数组
				q.add(arr[j]);
				queue.set(x, q);
			}
			// 开始收集
			int count = 0; 
			for(int k = 0; k < 10; k++) {
				while(queue.get(k).size() > 0) {
					// 拿到每一个数组
					List<Integer> q = queue.get(k);
					arr[count] = q.get(0);
					q.remove(0);
					count++;
				}
			}
		}
	}

}
