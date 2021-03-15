package algo.girlTeacher.doublyLinkedList;

public class Node {

	public long dData;
	public Node next;
	public Node previous;
	public Node(long d) {
		this.dData = d;
	}
	
	public void displayNode() {
		System.out.println(dData + " ");
	}
}
