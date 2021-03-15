package algo.girlTeacher.hashChain;

public class SortedList {

	private Node first;
	public SortedList() {
		first = null;
	}
	public void insert(Node node) {
		int key = node.getKey();
		Node previous = null;
		Node current = first;
		while(current != null && key > current.getKey()) {
			previous = current;
			current = current.next;
		}
		if(previous == null) {
			first = node;
		}else {
			previous.next = node; // 与前面节点的关系
		}
		// 与后面节点的关系
		node.next = current;
	}
	
	public void delete(int key) {
		Node previous = null;
		Node current = first;
		while(current != null && key != current.getKey()) {
			previous = current;
			current = current.next;
		}
		
		if(previous == null) {  // 是第一个节点
			first = first.next;
		}else { // 不是第一个节点
			previous.next = current.next;
		}
	}
	
	public Node find(int key) {
		Node current = first;
		while(current != null && current.getKey() <= key) { // 因为是有序，从小到大升序，所以first最小
			if(current.getKey() == key) {
				return current;  // found it
			}
			
			current = current.next;
		}
		return null;
	}
	
	public void displayList() {
		System.out.print("List (first ---> last) : ");
		Node current = first;
		while(current != null) {
			current.displayNode();
			current = current.next;
		}
		System.out.println();
	}
}
