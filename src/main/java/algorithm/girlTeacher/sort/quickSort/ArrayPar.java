package algorithm.girlTeacher.sort.quickSort;

public class ArrayPar {

	private long[] arr;
	private int nElems;
	public ArrayPar(int max) {
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
	/**
	 * 划分的方法
	 * @param left
	 * @param right
	 * @param pivot
	 * @return
	 */
	public int partition(int left, int right, long pivot) {
		int leftPtr = left - 1;
		int rightPtr = right + 1;
		while(true) {
			// 从左向右找大于特定值的数据项
			while(leftPtr < right && arr[++leftPtr] < pivot);
			// 如果跳出循环，就表示找到了一个大于特定值的数据项


			// 从右往左边，找小于特定值的数据项：跳出循环，表示找到了。
			while(rightPtr > left && arr[--rightPtr] > pivot);
			// 如果跳出循环，就表示找到了一个小于特定值的数据项

			if(leftPtr >= rightPtr) {
				break;    // 退出最外面的循环
			}else {
				swap(leftPtr, rightPtr);    // 交换
			}
		}
		return leftPtr;
	}

	public void swap(int index1, int index2) {
		long temp;
		temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
}
