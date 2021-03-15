package algo.girlTeacher.interIterator;

public class ListIterator {

	private Node current;
	private Node previous;
	private LinkList list;
	public ListIterator(LinkList list) {
		this.list = list;
		reset();
	}
	
	public void reset() {
		current = list.getFirst();
		previous = null;
	}
	
	public boolean atEnd() {
		return current.next == null;
	}
	
	public void nextLink() {
		previous = current;
		current = current.next;
	}
	
	public Node getCurrent() {
		return current;
	}
	/**
	 *   previous   current   [插入点]
	 * @param dd
	 */
	public void insertAfter(long dd) {
		Node node = new Node(dd);
		if(list.isEmpty()) {
			list.setFirst(node);
			current = node;
		}else {
			node.next = current.next;  // 当前节点的后节点成为新加入节点的后节点
			current.next = node;  // 新加入节点成为当前节点的后节点，因为是向后插入
			nextLink();
		}
	}
	
	/**
	 *                  
	 *    previous   [插入点]    current 
	 * @param dd
	 */
	public void insertBefore(long dd) {
		Node node = new Node(dd);
		if(previous == null) {
			node.next = list.getFirst();
			list.setFirst(node);
			reset();
		}else {
			node.next = previous.next;  // 新节点的下一个节点，就是插入之前，上一个节点的下一个节点
			previous.next = node;  // 新加入的节点成为上一个节点和当前节点之间的节点，即previous之后的节点
			current = node;  // 新节点变成当前节点
		}
	}
	
	public long deleteCurrent() {
		long val = current.dData;
		if(previous == null) {
			list.setFirst(current.next);
			reset();
		}else {
			previous.next = current.next;
			if(atEnd()) {
				reset();
			}else {
				current = current.next;
			}
		}
		return val;
	}
}

