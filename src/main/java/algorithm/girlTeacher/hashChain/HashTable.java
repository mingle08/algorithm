package algorithm.girlTeacher.hashChain;

public class HashTable {

	private SortedList[] hashArray;
	private int arraySize;
	public HashTable(int size) {
		arraySize = size;
		hashArray = new SortedList[arraySize];
		for (int i = 0; i < arraySize; i++) {
			hashArray[i] = new SortedList();
		}
	}

	public void displayTable() {
		for (int i = 0; i < arraySize; i++) {
			System.out.print(i + " ");
			hashArray[i].displayList();
		}
	}

	public int hashFunc(int key) {
		return key % arraySize;
	}

	public void insert(Node node) {
		int key = node.getKey();
		int hashVal = hashFunc(key);
		hashArray[hashVal].insert(node);
	}

	public void delete(int key) {
		int hashVal = hashFunc(key);
		hashArray[hashVal].delete(key);
	}

	public Node find(int key) {
		int hashVal = hashFunc(key);
		Node node = hashArray[hashVal].find(key);
		return node;
	}
}
