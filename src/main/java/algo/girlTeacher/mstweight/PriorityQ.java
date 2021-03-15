package algo.girlTeacher.mstweight;
/**
 * 优先队列
 * @author huxm
 *
 */
public class PriorityQ {

	// 最多20条边
	private final int MAX_SIZE = 20;
	private Edge[] queArray;
	private int size;  // 当前边的数量
	
	public PriorityQ() {
		queArray = new Edge[MAX_SIZE];
		size = 0;
	}
	/**
	 * 队列中的元素从大到小排列
	 * @param item
	 */
	public void insert(Edge item) {
		int i;  // 数组中的位置
		for (i = 0; i < size; i++) {
			if(item.distance >= queArray[i].distance) {// 找到新增项的存储位置
				break;
			}
		}
		
		for (int j = size-1; j >= i; j--) {// 插入位置之后的元素都要往后移一位
			queArray[j+1] = queArray[j];
		}
		
		queArray[i] = item;
		size++;
	}
	
	/**
	 * 删除最小的，就是删除最后一位
	 * @return
	 */
	public Edge removeMin() {
		return queArray[--size];
	}
	
	// 删除值为n的那条边
	public void removeN(int n) {
		for(int j=n; j < size-1; j++) {
			queArray[j] = queArray[j+1];
		}
		size--;
	}
	
	// 当前边的数量
	public int size() {
		return size;
	}
	
	// 是否为空
	public boolean isEmpty() {
		return size == 0;
	}
	
	// 查看值为n的边
	public Edge peekN(int n) {
		return queArray[n];
	}
	
	// 查找 findDex边的终点顶点
	public int find(int findDex) {
		for (int i = 0; i < size; i++) {
			if(queArray[i].destVert == findDex) {
				return i;  // 找到了
			}
		}
		return -1;  // 没找到
	}
}
