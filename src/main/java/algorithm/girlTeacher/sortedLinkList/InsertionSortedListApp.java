package algorithm.girlTeacher.sortedLinkList;

public class InsertionSortedListApp {

	public static void main(String[] args) {
		int size = 10;
		Node[] nodeArr = new Node[size];

		for (int i = 0; i < size; i++) {
			int n = (int) (Math.random() * 99);
			Node node = new Node(n);
			nodeArr[i] = node;
		}
		System.out.println("Unsorted Array: ");
		for (int i = 0; i < size; i++) {
			System.out.print(nodeArr[i].dData + " ");
		}
		System.out.println();

		SortedList sortedList = new SortedList(nodeArr);
		sortedList.displayList();

		System.out.println("Sorted Array: ");
		for (int i = 0; i < size; i++) {
			Node node = sortedList.remove();
			nodeArr[i] = node;
		}

		for (int i = 0; i < nodeArr.length; i++) {
			System.out.print(nodeArr[i].dData + " ");
		}
		System.out.println();
	}

}
