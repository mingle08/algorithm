package algorithm.sort;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = {19,2,3,90,67,33,-7,24,3,56,34,5};
		sort(arr);
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}

	public static void sort(int[] arr) {
		if(arr.length > 0) {
			quickSort(arr,0,arr.length-1);
		}
	}

	/**
	 * 快速排序核心方法
	 * @param arr
	 * @param low
	 * @param high
	 */
	private static void quickSort(int[] arr, int low, int high) {
		if(low >= high) {
			return;
		}
		int mid = getMiddle(arr, low, high);
		quickSort(arr, 0, mid-1);
		quickSort(arr, mid + 1, high);

	}

	/**
	 * 找枢轴
	 * @param arr
	 * @param low
	 * @param high
	 * @return
	 */
	private static int getMiddle(int[] arr, int low, int high) {
		int pivot = arr[low];  // 以temp为基数
		while(low < high) {
			// 1. 如果arr[high]大于temp, high指针往左移
			while(low < high && arr[high] >= pivot) {
				high--;
			}
			// 2. 否则，如果arr[high] <= pivot，把小的值存在arr[low]
			arr[low] = arr[high];

			// 3. 如果arr[low] < pivot，low指针往右移
			while(low < high && arr[low] <= pivot) {
				low++;
			}
			// 4. 否则，如果arr[low] >= pivot, 把大的值存在arr[high]
			arr[high] = arr[low];

		}
		arr[high] = pivot;
		return high;
	}

}
