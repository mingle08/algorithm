package algorithm.sort;
/**
 * insertSort
 * @author huxm
 *
 */
public class InsertSort {

	public static void main(String[] args) {
		int[] a = {49,38,65,97,23,22,76,1,5,8,2,0,-1};

		sort1(a);

		for(int i = 0; i < a.length; i++ ) {
			System.out.println(" " + a[i]);
		}
	}

	/**
	 * first method
	 */
	public static void sort1(int[] a) {
		for(int i = 1; i < a.length; i++) {
			int temp = a[i];  // 新遍历的值，等待插入到前面的有序数组
			int j;
			for(j = i - 1; j >= 0; j--) {// move forward
				// 将大于temp的数往后面移一步
				if(a[j] > temp) {
					a[j+1] = a[j];
				}else {
					break;
				}
			}
			// 碰到a[j] <= temp时，将temp插到a[j]之后，此处的j是循环里break出来之后停留的位置
			a[j+1] = temp;
		}
	}

	/**
	 * second method
	 */
	public static void sort2(int[] a) {
		int tmp;
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    tmp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = tmp;
                }
            }
        }
	}

	public static void swap(int []arr,int a,int b){
		arr[a] = arr[a]+arr[b];
		arr[b] = arr[a]-arr[b];
		arr[a] = arr[a]-arr[b];
	}

	/**
	 * 摘自博客：
	 * http://www.cnblogs.com/chengxiao/p/6103002.html
	 * @param arr
	 */
	public static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int j = i;
			while (j > 0 && arr[j] < arr[j - 1]) {
				swap(arr,j,j-1);
				j--;
			}
		}
	}

}
