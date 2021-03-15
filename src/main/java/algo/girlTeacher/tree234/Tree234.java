package algo.girlTeacher.tree234;

public class Tree234 {

	private Node root = new Node();
	
	// 查找
	public int find(long key) {
		Node curNode = root;
		int childNumber;
		while(true) {
			if((childNumber = curNode.findItem(key)) != -1) {
				return childNumber;
			}else if(curNode.isLeaf()) { // 当前节点是叶节点
				return -1;
			}else {
				curNode = getNextChild(curNode, key);
				
			}
		}
	}
	
	public Node getNextChild(Node node, long val) {
		int j;
		int numItems = node.getNumItems();
		for(j = 0; j < numItems; j++) {
			if(val < node.getItem(j).dData) {
				return node.getChild(j);
			}
		}
		return node.getChild(j);
		
	}
	
	public void insert(long val) {
		Node curNode = root;
		DataItem tempItem = new DataItem(val);
		while(true) {
			if(curNode.isFull()) {
				split(curNode);
				curNode = curNode.getParent();
				curNode = getNextChild(curNode, val);
			}else if(curNode.isLeaf()) {  // 当前节点是叶节点，而且未满
				break;
			}else {
				curNode = getNextChild(curNode, val);
			}
		}
		curNode.insertItem(tempItem);
	}
	
	/**
	 * 拆分节点
	 */
	public void split(Node node) {
		DataItem itemB, itemC;
		Node parent, child2, child3;
		int itemIndex;
		itemC = node.removeItem();  // 最大的数据项
		itemB = node.removeItem();  // 中间的数据项
		child2 = node.disconnect(2);
		child3 = node.disconnect(3);
		Node newRight = new Node();
		if(node == root) { // 如果是根节点
			root = new Node();
			parent = root;
			root.connectChild(0, node);
		}else {
			parent = node.getParent();
		}
		itemIndex = parent.insertItem(itemB);
		int n = parent.getNumItems();
		for(int j = n - 1; j > itemIndex; j--) {
			Node temp = parent.disconnect(j);
			parent.connectChild(j+1, temp);
		}
		
		parent.connectChild(itemIndex, newRight);
		newRight.insertItem(itemC);
		newRight.connectChild(0, child2);
		newRight.connectChild(1, child3);
		
	}
	
	public void displayTree() {
		recDisplayTree(root, 0, 0);
	}
	
	private void recDisplayTree(Node node, int level, int childNumber) {
		System.out.print("level="+level + " child=" + childNumber + " ");
		node.displayNode();
		
		int numItems = node.getNumItems();  // 取数据个数
		for(int j = 0; j < numItems + 1; j++) {
			Node nextNode = node.getChild(j);
			if(nextNode != null) {
				recDisplayTree(nextNode, level+1, j);   // 递归向下
			}else {
				return;
			}
		}
	}
	
}
