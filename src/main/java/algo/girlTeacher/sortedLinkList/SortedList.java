package algo.girlTeacher.sortedLinkList;

public class SortedList {

	private Node first;
	public SortedList() {
		first = null;
	}
	
	public SortedList(Node[] nodeArr) {
		first = null;
		for (int i = 0; i < nodeArr.length; i++) {
			insert(nodeArr[i]);
		}
	}
	
	private void insert(Node node) {
		Node previous = null;
		Node current = first;
		while(current != null && node.dData > current.dData) {
			previous = current;
			current = current.next;
		}
		if(previous == null)
			first = node;
		else
			previous.next = node;
		
		node.next = current;
	}

	public void insert(long key) {
		Node node = new Node(key);
		Node previous = null;
		Node current = first;
		while(current != null && key > current.dData) {
			previous = current;
			current = current.next;
		}
		if(previous == null) 
			first = node;
		else
			previous.next = node;
		node.next = current;
	}
	
	public Node remove() {
		Node temp = first;
		first = first.next;
		return temp;
	}
	
	public void displayList() {
		System.out.print("List (first ---> last): ");
		Node current = first;
		while(current != null) {
			current.displayNode();
			current = current.next;
		}
		System.out.println();
	}
}
