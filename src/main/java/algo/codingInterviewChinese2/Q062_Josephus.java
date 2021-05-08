package algo.codingInterviewChinese2;

public class Q062_Josephus {

	public static int N = 20;
	public static int M = 5; // 数到M就kill一个人
	
	class Node {
		int val;  // 下标
		Node next;
		public Node(int val) {
			this.val = val;
		}
	}
	
	public void killNode() {
		Node header = new Node(1);
		Node x = header;
		for(int i = 2; i <= N; i++) {
			x = (x.next = new Node(i));
		}
		x.next = header;
		System.out.println("被清除出去的顺序为：");
		while(x != x.next) {
			// 至少还有两人，仍然继续报数，到M就shoot
			for(int i = 1; i < M; i++) {
				x = x.next;
			}
			System.out.println(x.next.val + "被干掉了。");
			x.next = x.next.next;
		}
		System.out.println("最后这个幸运儿是： " + x.val);
	}
	public static void main(String[] args) {
		Q062_Josephus q062Josephus = new Q062_Josephus();
		q062Josephus.killNode();

	}

}
