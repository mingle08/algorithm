package algorithm.search;

import algorithm.sort.BasicSort;

public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = {10, 23, 4, 3, 2, 5, 1, 2, 62,9,23,34,77,45,18};
		// 1. 排序
		BasicSort.sort(arr);
		for(int i : arr) {
			System.out.print(" " + i);
		}
		// 2. 查找
//		int index = binarySearch(arr, 9, 0, arr.length-1);
		int index = notRecBinarySearch(arr, 9);
		System.out.println();
		if(index != -1) {
			System.out.println("找到了，在第" + (index+1) + "个。");
		}else {
			System.out.println("没找到！");
		}

	}

	/**
	 * 递归方法
	 * @param arr
	 * @param key
	 * @param low
	 * @param high
	 * @return
	 */
	public static int binarySearch(int[] arr, int key, int low, int high) {
		if(low > high) {
			return -1;
		}
		int mid = (low + high) / 2;
		if(arr[mid] == key) {
			return mid;
		}
		if(arr[mid] < key) {
			return binarySearch(arr, key, mid + 1, high);
		}
		if(arr[mid] > key) {
			return binarySearch(arr, key, low, mid - 1);
		}
		return -1;
	}

	/**
	 * 非递归
	 */
	public static int notRecBinarySearch(int[] arr, int key) {
		int low = 0, high = arr.length - 1, mid;

		while(low <= high) {
			mid = (low + high) / 2;
			if(arr[mid] == key) {
				System.out.println("找到相应元素，下标为："+mid);
				return mid;
			}
			if(arr[mid] < key) {
				low = mid + 1;
			}
			if(arr[mid] > key) {
				high = mid - 1;
			}
		}
		return -1;

	}

}
