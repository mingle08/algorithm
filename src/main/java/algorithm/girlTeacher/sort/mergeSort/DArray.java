package algorithm.girlTeacher.sort.mergeSort;

public class DArray {

	private long[] arr;
	private int nElems;
	public DArray(int max) {
		this.arr = new long[max];
		nElems = 0;
	}

	public void insert(long value) {
		arr[nElems] = value;
		nElems++;
	}

	public void display() {
		for(int i = 0; i < nElems; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public void mergeSort() {
		long[] workSpace = new long[nElems];
		recMergeSort(workSpace, 0, nElems-1);
	}

	private void recMergeSort(long[] workSpace, int lowerBound, int upperBound) {
		if(lowerBound == upperBound) {
			return;
		}else {
			int mid = (lowerBound + upperBound) / 2;
			recMergeSort(workSpace, lowerBound, mid);   // 递归前半部分排序处理
			recMergeSort(workSpace, mid+1, upperBound);   // 递归后半部分排序处理
			merge(workSpace, lowerBound, mid+1, upperBound);
		}
	}

	private void merge(long[] workSpace, int lowPtr, int highPtr, int upperBound) {
		int j = 0;
		int lowerBound = lowPtr;
		int mid = highPtr - 1;
		int n = upperBound - lowerBound + 1;   // 需要归并的数量
		while(lowPtr <= mid && highPtr <= upperBound) {
			if(arr[lowPtr] < arr[highPtr]) {
				workSpace[j++] = arr[lowPtr++];
			}else {
				workSpace[j++] = arr[highPtr++];
			}
		}

		while(lowPtr <= mid) {
			workSpace[j++] = arr[lowPtr++];
		}

		while(highPtr <= upperBound) {
			workSpace[j++] = arr[highPtr++];
		}

		for(j=0; j < n; j++) {
			arr[lowerBound + j] = workSpace[j];
		}
	}

}
