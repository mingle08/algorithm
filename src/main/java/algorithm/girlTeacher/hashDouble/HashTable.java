package algorithm.girlTeacher.hashDouble;

public class HashTable {

	private DataItem[] hashArray;
	private int arraySize;
	private DataItem nonItem;
	public HashTable(int size) {
		this.arraySize = size;
		this.hashArray = new DataItem[arraySize];
		nonItem = new DataItem(-1);  //表示原来的数据被删除了
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

	public int hashFunc(int key){  // 第一次哈希
		return key % arraySize;
	}

	/**
	 * 第二次哈希，有2个特点：
	 * 1，不能与第一次哈希函数相同
	 * 2， 哈希值不能为0
	 * @param key
	 */
	public int hashFunc2(int key) {
		// stepSize = constant - (key % constant)
		// constant必须是质数，即素数，且小于数组容量
		return 5 - key % 5;

	}

	public void insert(int key, DataItem item) {

		int hashVal = hashFunc(key); // 首次哈希得到的下标位置
		int stepSize = hashFunc2(key); // 再哈希得到探测步长
		while(hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) { // the seat is taken
//			hashVal++;
			hashVal += stepSize;
			hashVal = hashFunc(hashVal);
		}// 跳出while循环，就表示找到空位了
		hashArray[hashVal] = item;
	}

	public DataItem delete(int key) {
		int hashVal = hashFunc(key);
		int stepSize = hashFunc2(key); // 再哈希得到探测步长
		while(hashArray[hashVal] != null) {
			if(hashArray[hashVal].getKey() == key) {// found it
				DataItem temp = hashArray[hashVal];
				hashArray[hashVal] = nonItem;
				return temp;  // found it and delete it
			}
//			hashVal++;
			hashVal += stepSize;
			hashVal = hashFunc(hashVal);
		}

		return null;  // not found
	}

	public DataItem find(int key) {
		int hashVal = hashFunc(key);
		int stepSize = hashFunc2(key); // 再哈希得到探测步长
		while(hashArray[hashVal] != null) {
			if(hashArray[hashVal].getKey() == key) {
				return hashArray[hashVal];
			}
//			hashVal++;
			hashVal += stepSize;
			hashVal = hashFunc(hashVal);  // prevent out of range error
		}
		return null;   // not found
	}
}
