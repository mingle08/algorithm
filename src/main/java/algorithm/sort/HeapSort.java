package algorithm.sort;

public class HeapSort {

	public static void main(String[] args) {
		int[] arr = {39,44,1,0,8,66,23,67,9,15,100,70,22,3,6,54};
		heapSort(arr);
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}

	public static void heapSort(int[] arr) {
		if(arr == null || arr.length <= 1) {
			return;
		}
		// 创建大堆
		buildMaxHeap(arr);
		for(int i = arr.length - 1; i >= 1; i--) {
			// 每循环一次，就沉淀一个大元素
			swap(arr, 0, i);
			maxHeap(arr, i, 0);
		}
	}

	private static void buildMaxHeap(int[] arr) {
		int half = (arr.length - 1) / 2;  // 假设长度为9
		for(int i = half; i >=0; i--) {
			// 只需遍历4,3,2,1,0
			maxHeap(arr, arr.length, i);
		}
	}

	private static void maxHeap(int[] arr, int length, int i) {
		// 父结点
		int largest = i;
		// 左孩子
		int left = i * 2 + 1;
		// 右孩子
		int right = i * 2 + 2;
		if(left < length && arr[left] > arr[i]) { // 左孩子大于父结点，则交换位置
			largest = left;
		}

		if(right < length && arr[right] > arr[largest]) { // 右孩子大于父结点，则交换位置
			largest = right;
		}

		if(i != largest) {
			// 进行数据交换
			swap(arr, i, largest);

			maxHeap(arr, length, largest);
		}


	}

	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
