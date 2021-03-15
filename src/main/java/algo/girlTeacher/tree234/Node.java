package algo.girlTeacher.tree234;

public class Node {

	private static final int ORDER = 4;
	private int numItems;  // 当前节点有几个数据项
	private Node parent;  // 父节点
	private Node[] childArr = new Node[ORDER];  // 子节点
	private DataItem[] itemArr = new DataItem[ORDER - 1]; // 数据项
	public Node getChild(int childNum) {
		return childArr[childNum];
	}
	public Node getParent() {
		return parent;
	}
	
	public boolean isLeaf() {
		return childArr[0] == null;
	}
	
	public int getNumItems() {
		return numItems;
	}
	
	public DataItem getItem(int index) {
		return itemArr[index];
	}
	
	// 数据项是否满了
	public boolean isFull() {
		return (numItems == ORDER - 1) ? true : false;
	}
	
	/**
	 * 连接子节点
	 */
	public void connectChild(int childNum, Node child) {
		childArr[childNum] = child;
		if(child != null) {
			child.parent = this;
		}
	}
	
	public Node disconnect(int childNum) {
		Node tempNode = childArr[childNum];
		childArr[childNum] = null;
		return tempNode;
	}
	
	public int findItem(long key) {
		for (int i = 0; i < ORDER - 1; i++) {
			if(itemArr[i] == null) {
				break;
			}else if(itemArr[i].dData == key) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * 插入数据项
	 * @param newItem
	 * @return
	 */
	public int insertItem(DataItem newItem) {
		numItems++;
		long newKey = newItem.dData;
		for (int i = ORDER - 2; i >= 0; i--) {
			if(itemArr[i] == null) {
				continue;
			}else {
				long itemKey = itemArr[i].dData;
				if(newKey < itemKey) {
					itemArr[i + 1] = itemArr[i];
				}else {
					itemArr[i + 1] = newItem;
					return i + 1;
				}
			}
		}
		itemArr[0] = newItem;
		return 0;
	}
	
	public DataItem removeItem() {
		DataItem temp = itemArr[numItems - 1];
		itemArr[numItems - 1] = null;
		numItems--;
		return temp;
	}
	
	public void displayNode() {
		for (int i = 0; i < numItems; i++) {
			itemArr[i].displayItem();
		}
		System.out.println("/");
	}
}
