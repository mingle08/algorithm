package algoDemo.sort;

/**
 * 二分法插入排序
 *
 */
public class BinaryInsertSort {

	public static void main(String[] args) {
		int[] a = {49,38,65,97,23,22,76,1,5,8,2,0,-1};
		
		sort1(a);

		for(int i = 0; i < a.length; i++ ) {
			System.out.println(" " + a[i]);
		}

	}
	
	private static void sort1(int[] a) {
		for(int i = 0; i < a.length; i++) {
			int temp = a[i];
			int left = 0;
			int right = i - 1;
			int mid = 0;
			while(left <= right) {
				mid = (left + right) / 2;
				if(temp < a[mid]) {
					right = mid - 1;
				}else {// >=
					left = mid + 1;
				}
			}
			for(int j = i - 1; j >= left; j--) {
				// 比left右边大的所有元素，全部往后移一位，等待temp插入
				a[j+1] = a[j];
			}
			if(left != i) {
				a[left] = temp;
			}
		}
	}

}
