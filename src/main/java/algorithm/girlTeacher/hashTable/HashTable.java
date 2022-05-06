package algorithm.girlTeacher.hashTable;

public class HashTable {

	private DataItem[] hashArray;
	private int arraySize;
	private DataItem nonItem;
	public HashTable(int size) {
		this.arraySize = size;
		this.hashArray = new DataItem[arraySize];
		nonItem = new DataItem(-1);
	}

	public void displayTable() {
		System.out.print("Table: ");
		for (int i = 0; i < arraySize; i++) {
			if(hashArray[i] != null) {
				System.out.print(hashArray[i].getKey() + " ");
			}else {
				System.out.print("** ");
			}
		}
		System.out.println();
	}

	public int hashFunc(int key){
		return key % arraySize;
	}

	public void insert(DataItem item) {
		int key = item.getKey();
		int hashVal = hashFunc(key);
		while(hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) { // the seat is taken
			hashVal++;
			hashVal = hashFunc(hashVal);
		}// 跳出while循环，就表示找到空位了
		hashArray[hashVal] = item;
	}

	public DataItem delete(int key) {
		int hashVal = hashFunc(key);
		while(hashArray[hashVal] != null) {
			if(hashArray[hashVal].getKey() == key) {// found it
				DataItem temp = hashArray[hashVal];
				hashArray[hashVal] = nonItem;
				return temp;  // found it and delete it
			}
			hashVal++;
			hashVal = hashFunc(hashVal);
		}

		return null;  // not found
	}

	public DataItem find(int key) {
		int hashVal = hashFunc(key);
		while(hashArray[hashVal] != null) {
			if(hashArray[hashVal].getKey() == key) {
				return hashArray[hashVal];
			}
			hashVal++;
			hashVal = hashFunc(hashVal);  // prevent out of range error
		}
		return null;   // not found
	}
}
