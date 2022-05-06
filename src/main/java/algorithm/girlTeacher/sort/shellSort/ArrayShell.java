package algorithm.girlTeacher.sort.shellSort;

public class ArrayShell {

	private long[] arr;
	private int nElems;
	public ArrayShell(int max) {
		arr = new long[max];
		nElems = 0;
	}

	public void insert(long val) {
		arr[nElems] = val;
		nElems++;
	}

	public void display() {
		System.out.print("A=");
		for(int i = 0; i < nElems; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	/**
	 * shell排序
	 */
	public void shellSort() {
		int inner, outer;
		long temp;

		int h = 1;
		while(h <= nElems / 3) {
			h = h * 3 + 1;   // 如果nElems为100，则h的值        1   4    13    40
		}

		while(h > 0) {
			for(outer = h; outer < nElems; outer++) {
				temp = arr[outer];
				inner = outer;
				while(inner > h - 1 && arr[inner - h] >= temp) {
					arr[inner] = arr[inner - h];
					inner = inner - h;
				}
				arr[inner] = temp;
			}
			h = (h - 1) / 3;
		}
	}
}
