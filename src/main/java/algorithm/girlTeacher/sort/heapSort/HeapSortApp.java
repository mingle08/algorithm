package algorithm.girlTeacher.sort.heapSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HeapSortApp {

	public static void main(String[] args) throws IOException {
		int size,j;
		System.out.println("Enter number of size:");
		size = getInt();
		Heap heap = new Heap(size);

		for (j = 0; j < size; j++) {
			int random = (int) (Math.random() * 100);
			Node node = new Node(random);
			heap.insertAt(j, node);
			heap.incrementSize();
		}

		// 显示数组（随机，未排序）
		System.out.print("Random: ");
		heap.displayArray();
		heap.displayHeap();

		// 从最后一个元素的父节点开始向下调整，一直到根
		for(j = size/2-1; j >= 0; j--) {
			heap.trickleDown(j);
		}

		System.out.print("heap: ");
		heap.displayArray();
		heap.displayHeap();

		// 通过循环删除最大项，再把删除的数据放到数组中指定的位置
		// 结果：从小到大的一个有序的数组
		for(j = size-1; j >= 0; j--) {
			Node biggestNode = heap.remove();
			heap.insertAt(j, biggestNode);
		}
		System.out.println("Sorted: ");
		heap.displayArray();
	}

	public static String getString() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}

	public static char getChar() throws IOException {
		return getString().charAt(0);
	}

	public static int getInt() throws IOException {
		String str = getString();
		int i = Integer.parseInt(str);
		return i;
	}
}
