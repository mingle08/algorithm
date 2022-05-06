package algorithm.girlTeacher.sort.heapSort;

public class Heap {

	private Node[] heapArray;
	private int arraySize;
	private int currentSize;
	public Heap(int max) {
		this.arraySize = max;
		this.heapArray = new Node[arraySize];
		this.currentSize = 0;
	}

	public boolean isEmpty() {
		return currentSize == 0;
	}

	public void insertAt(int index, Node node) {
		heapArray[index] = node;
	}

	public void incrementSize() {
		currentSize++;
	}

	public void trickleUp(int index) {
		// 找父节点的索引值
		int parent = (index-1)/2;
		Node bottom = heapArray[index];
		while(index > 0 && heapArray[parent].getKey() < bottom.getKey()) {
			heapArray[index] = heapArray[parent];
			index = parent;
			parent = (parent-1)/2;
		}
		heapArray[index] = bottom;
	}

	public Node remove() {// 删除根节点
		Node root = heapArray[0];
		heapArray[0] = heapArray[--currentSize];
		trickleDown(0); // 将新的根，向下调整
		return root;
	}

	public void trickleDown(int index) {
		int largerChild;  // 大的子节点位置
		Node top = heapArray[index];  // 要向下调整的节点对象
		while(index < currentSize/2) {// 未找到最后一层
			int leftChild = 2 * index + 1;
			int rightChild = leftChild + 1;
			if(rightChild < currentSize &&
					heapArray[leftChild].getKey() < heapArray[rightChild].getKey()) {
				largerChild = rightChild;
			}else {
				largerChild = leftChild;
			}

			if(top.getKey() >= heapArray[largerChild].getKey()) {// 找到位置，不用再调换
				break;
			}
			heapArray[index] = heapArray[largerChild];
			index = largerChild;
		}
		heapArray[index] = top;
	}

	public boolean change(int index, int newVal) {
		if(index < 0 || index >= currentSize) { // 无效位置
			return false;
		}
		int oldVal = heapArray[index].getKey();
		heapArray[index].setKey(newVal);
		if(oldVal < newVal) {
			trickleUp(index);
		}else {
			trickleDown(index);
		}
		return true;
	}

	public void displayHeap() {

		// 以树状方式显示
		int nBlanks = 32;
		int itemsPerRow = 1;  // 每一层有几个节点
		int column = 0;
		int j = 0;
		String dots = ".......................";
		System.out.println(dots + dots);
		while(currentSize > 0) {
			if(column == 0) {
				for(int k=0; k < nBlanks; k++) {
					System.out.print(" ");
				}
			}
			System.out.print(heapArray[j].getKey());
			if(++j == currentSize) {
				break;
			}
			if(++column == itemsPerRow) {// 这层已打印完
				nBlanks /= 2;  // 空格，从上往下，依次减半
				itemsPerRow *= 2;   // 每一层的节点数是上一层节点数的2倍
				column = 0;
				System.out.println();
			}else {
				for (int i = 0; i < nBlanks * 2 - 2; i++) {
					System.out.print(" ");
				}
			}
		}

		System.out.println("\n" + dots + dots);
	}

	public void displayArray() {
		System.out.print("HeapArray: ");
		for (int i = 0; i < arraySize; i++) {
		    System.out.print(heapArray[i].getKey() + " ");
		}
		System.out.println();
	}
}
