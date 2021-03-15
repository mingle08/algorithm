package algo.sort;
/**
* 归并排序：  稳定；非原地排序，时间复杂度 N*logN，空间复杂度 N
*/
public class MergeSort {

	public static void main(String[] args) {
		int[] arr = {90,3,2,67,44,-9,87,65,11,9,2,8};
		mergeSort(arr, 0, arr.length-1);
		for(int i : arr) {
			System.out.println(" "+i);
		}

	}
	
	public static void mergeSort(int[] arr, int left, int right) {

		if(left < right) {
			// 二分位置
			int mid = (left + right) / 2;
			mergeSort(arr, left, mid);    // 递归前半部分排序处理
			mergeSort(arr, mid + 1, right);    // 递归后半部分排序处理
			// 合并
			merge(arr, left, mid, right);
		}
	}

	private static void merge(int[] arr, int left, int mid, int right) {
		// 新建一个新数组，长度跟原数组一样
		int[] tempArr = new int[arr.length];
		int rightStart = mid + 1;
		int temp = left;
		int third = left;
		while(left <= mid && rightStart <= right) {
			if(arr[left] <= arr[rightStart]) {  // 拿前半部分每个元素与后半部分某元素比较
				tempArr[third++] = arr[left++];
			}else {
				tempArr[third++] = arr[rightStart++];
			}
		}
		// 如果左边数组还有数据，把它们copy到新数组
		while(left <= mid) {
			tempArr[third++] = arr[left++];
		}
		// 如果右边数组还有数据……
		while(rightStart <= right) {
			tempArr[third++] = arr[rightStart++];
		}
		
		// 复制新数组的元素至原数组，注意下标是temp, temp++
		while(temp <= right) {
			arr[temp] = tempArr[temp++];
		}
		
	}

}
