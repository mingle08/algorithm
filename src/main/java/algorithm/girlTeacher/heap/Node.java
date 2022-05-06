package algorithm.girlTeacher.heap;

public class Node {

	private int iData;
	public Node next;
	public Node(int aKey) {
		this.iData = aKey;
	}

	public int getKey() {
		return iData;
	}

	public void setKey(int val) {
		this.iData = val;
	}

	public void displayNode() {
		System.out.print(iData + " ");
	}
}
