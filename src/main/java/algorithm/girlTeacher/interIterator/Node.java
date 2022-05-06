package algorithm.girlTeacher.interIterator;

public class Node {

	public long dData;
	public Node next;
	public Node(long dd) {
		this.dData = dd;
	}

	public void displayNode() {
		System.out.print(dData + " ");
	}
}
