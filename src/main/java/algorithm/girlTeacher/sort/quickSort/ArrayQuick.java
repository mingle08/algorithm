package algorithm.girlTeacher.sort.quickSort;

public class ArrayQuick {

	private long[] arr;
	private int nElems;
	public ArrayQuick(int max) {
		this.arr = new long[max];
		this.nElems = 0;
	}

	public void insert(long val) {
		arr[nElems] = val;
		nElems++;
	}

	public int size() {
		return nElems;
	}

	public void display() {
		System.out.print("A=");
		for (int i = 0; i < nElems; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public void quickSort() {// 快速排序
		recQuickSort(0, nElems - 1);
	}

	/**
	 * 插入排序
	 * @param left
	 * @param right
	 */
	public void insertionSort(int left, int right) {
		int in, out;
		for(out = left + 1; out <= right; out++) {
			long temp = arr[out];
			in = out;
			while(in > left && arr[in - 1] >= temp) {
				arr[in] = arr[in - 1];
				--in;
			}
			arr[in] = temp;
		}
	}

	public void recQuickSort(int left, int right) {
		int size = right - left + 1;
		if(size < 10) { // 小于10个用插入排序
			insertionSort(left, right);
//		if(size <= 3) {
//			manualSort(left, right);
		}else {
//			long pivot = arr[right];  // 取分隔点的值
			long pivot = getMiddle(left, right);
			int partition = partition(left, right, pivot);
			recQuickSort(left, partition - 1);   // 递归  前一部分再划分
			recQuickSort(partition+1, right);    // 递归  后一部分再划分

		}

	}

	/**
	 * 三项数据取中间
	 * 也就是取左端、中间、右端三个数，然后进行排序，将中间数作为枢纽值。
	 * index                 0 1 2 3 4 5 6 7
	 * 原始arr                4 5 7 8 1 2 3 6
	 * 排序左、中、右端         |     |       |
	 *                       4 5 7 6 1 2 3 8
	 * 将中间值6 放到right-1位置，因为4 < 6 < 8，6不可能放在8的位置
	 * 数组变为：             4 5 7 3 1 2 6 8
	 * @param left
	 * @param right
	 * @return
	 */
	public long getMiddle(int left, int right) {
		int center = (left + right) / 2;
		if(arr[left] > arr[center]) {
			swap(left, center);
		}
		if(arr[left] > arr[right]) {
			swap(left, right);
		}
		if(arr[center] > arr[right]) {
			swap(center, right);
		}
		swap(center, right - 1); // 将枢纽值放在right-1位置
		return arr[right - 1];
	}

	/**
	 * 手动排序：用于3个数的情况
	 * @param left
	 * @param right
	 */
	public void manualSort(int left, int right) {
		int size = right - left + 1;
		if(size <= 1) return;
		if(size == 2) {
			if(arr[left] > arr[right]) {
				swap(left, right);
				return;
			}else {
				if(arr[left] > arr[right - 1]) {
					swap(left, right - 1);
				}
				if(arr[left] > arr[right]) {
					swap(left, right);
				}
				if(arr[right - 1] > arr[right]) {
					swap(right - 1, right);
				}
			}
		}
	}

	/**
	 * 划分的方法
	 * @param left
	 * @param right
	 * @param pivot
	 * @return
	 */
	public int partition(int left, int right, long pivot) {
		int leftPtr = left;
		int rightPtr = right - 1;
		while(true) {
			// 从第二位向右找大于特定值的数据项
			while(arr[++leftPtr] < pivot);
			// 如果跳出循环，就表示找到了一个大于特定值的数据项


			// 从倒数第二位往左边，找小于特定值的数据项：跳出循环，表示找到了。
			while(arr[--rightPtr] > pivot);
			// 如果跳出循环，就表示找到了一个小于特定值的数据项

			if(leftPtr >= rightPtr) {
				break;    // 退出最外面的循环
			}else {
				swap(leftPtr, rightPtr);    // 交换
			}
		}

		/*
		 此时 i >= j，将其中一个大于pivot的值与pivot交换位置
		  */
		swap(leftPtr, right - 1);
		return leftPtr;
	}

	public void swap(int index1, int index2) {
		long temp;
		temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
}
