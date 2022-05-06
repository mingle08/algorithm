package algorithm.girlTeacher.sort.shellSort;

public class ShellSortApp {

	public static void main(String[] args) {
		int maxSize = 20;
		ArrayShell arr;
		arr = new ArrayShell(maxSize);
		for (int i = 0; i < maxSize; i++) {
			long n = (long) (Math.random() * 99);
			arr.insert(n);
		}
		arr.display();
		arr.shellSort();
		System.out.println("希尔排序之后：");
		arr.display();
	}

}
