package algo.sort;

public class ShellSort {

	public static void main(String[] args) {
		int[] a = {49,38,44,2,0,7,28,1,-9,7,2,5,23,12,99,76};
//		int[] a = {32,43,23,13,11};
		sort2(a);
		for(int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}

	}
	
	private static void sort1(int[] arr) {
		int j = 0;
        int temp = 0;
        int increment = arr.length / 2;  // 默认增量
        do {
            System.out.println("increment:" + increment);
            for (int i = increment; i < arr.length; i++) {
                // System.out.println("i:" + i);
                temp = arr[i];
                for (j = i - increment; j >= 0; j -= increment) {
                    if (temp < arr[j]) {
                        arr[j + increment] = arr[j];
                    } else {
                        break;
                    }
                }
                arr[j + increment] = temp;
            }
            // 增量每次循环缩小一半
            increment = increment / 2;
            
        }while(increment > 0);
	}
	
	private static void sort2(int[] arr) {
		if(arr == null || arr.length <= 1){
            return;
        }
		int j;
        //增量
        int increment = arr.length/2;
        while(increment >=1){
            for(int i=increment; i<arr.length; i++){
                //进行插入排序
//                for(int j=i; j<arr.length-increment; j=j+increment){
            	for (j = i - increment; j >= 0; j -= increment) {
                    if(arr[j] > arr[j+increment]){
                        int temp = arr[j];
                        arr[j] = arr[j+increment];
                        arr[j+increment] = temp;
                    }
                }
            }
            //设置新的增量
            increment= increment/2;
        }
	}

}
