package algo.girlTeacher.doublyLinkedList;
/**
 * 双端队列
 * @author huxm
 *
 */
public class DoublyLinkedList {

	private Node first;
	private Node last;
	public DoublyLinkedList() {
		first = null;
		last = null;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void insertFirst(long dd) {
		Node node = new Node(dd);
		if(isEmpty()) {
			last = node;
		}else {
			first.previous = node;
		}
		node.next = first;
		first = node;
		
	}
	
	public void insertLast(long dd) {
		Node node = new Node(dd);
		if(isEmpty()) {
			first = node;
		}else {
			last.next = node;
			node.previous = last;
		}
		
		last = node;
		
	}
	
	public Node deleteFirst() {
		Node temp = first;
		if(first.next == null) {
			last = null;
		}else {
			first.next.previous = null;
		}
		first = first.next;
		return temp;
		
	}
	
	public Node deleteLast() {
		Node temp = last;
		if(first.next == null)
			first = null;
		else
			last.previous.next = null;
		
		last = last.previous;
		return temp;
	}
	
	public boolean insertAfter(long key, long dd) {
		Node current = first;
		while(current.dData != key) {
			current = current.next;
			if(current == null)
				return false;
		}
		Node newNode = new Node(dd);
		if(current == last) {
			newNode.next = null;
			last = newNode;
		}else {
			newNode.next = current.next;
			current.next.previous = newNode;
		}
		
		newNode.previous = current;
		current.next = newNode;
		return true;
	}
	
	public Node deleteKey(long key) {
		Node current = first;
		while(current.dData != key) {
			current = current.next;
			if(current == null) 
				return null;
		}
		
		/*if(current == first) {
			// 双端队列，要维护头指针
			first = current.next;
		}else {
			// 当前节点（将被删除）之前的节点的后节点，就是当前节点（将被删除）的后节点
			current.previous.next = current.next;
		}
		
		if(current == last)
			// 双端队列，要维护last指针
			last = current.previous;
		else
			// 当前节点（将被删除）后面的节点的前节点，就是当前节点（将被删除）的前节点
			current.next.previous = current.previous;*/
		
		if(current == first) {
			// 双端队列，要维护头指针
			first = current.next;
		}else if(current == last){
			// 双端队列，要维护last指针
			last = current.previous;
		}else {
			// 维护前节点：  当前节点（将被删除）后面的节点的前节点，就是当前节点（将被删除）的前节点
			current.next.previous = current.previous;
			// 维护后节点： 当前节点（将被删除）之前的节点的后节点，就是当前节点（将被删除）的后节点
			current.previous.next = current.next;
		}
			
		return current;
	}
	/**
	 * 从前向后显示
	 */
	public void displayForward() {
		System.out.print("List (first ---> last): ");
		Node current = first;
		while(current != null) {
			current.displayNode();
			current = current.next;
		}
		System.out.println();
	}
	
	/**
	 * 从后往前显示
	 */
	public void displayBackward() {
		System.out.print("List (last ---> first): ");
		Node current = last;
		while(current != null) {
			current.displayNode();
			current = current.previous;
		}
		System.out.println();
	}
}
