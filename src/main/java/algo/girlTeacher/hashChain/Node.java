package algo.girlTeacher.hashChain;

public class Node {

	private int iData;
	public Node next;
	public Node(int it) {
		this.iData = it;
	}
	
	public int getKey() {
		return iData;
	}
	
	public void displayNode() {
		System.out.print(iData + " ");
	}
}
