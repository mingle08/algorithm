package algo.girlTeacher.interIterator;

public class LinkList {

	private Node first;
	public LinkList() {
		this.first = null;
	}
	
	public Node getFirst() {
		return first;
	}
	public void setFirst(Node f) {
		this.first = f;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void displayNode() {
		Node current = first;
		while(current != null) {
			current.displayNode();
			current = current.next;
		}
		System.out.println();
	}
	
	public ListIterator getIterator() {
		return new ListIterator(this);
	}
		
}
