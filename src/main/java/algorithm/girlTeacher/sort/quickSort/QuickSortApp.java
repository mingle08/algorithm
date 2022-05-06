package algorithm.girlTeacher.sort.quickSort;

public class QuickSortApp {

	public static void main(String[] args) {

		int maxSize = 16;
//		ArrayIns arr;
//		arr = new ArrayIns(maxSize);
		ArrayQuick arr;
		arr = new ArrayQuick(maxSize);

		for (int i = 0; i < maxSize; i++) {
			long n = (long) (Math.random() * 99);
			arr.insert(n);
		}

		arr.display();
		arr.quickSort();
		System.out.println("快速排序之后：");
		arr.display();
	}

}
