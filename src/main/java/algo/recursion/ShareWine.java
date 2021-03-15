package algo.recursion;

public class ShareWine {
	private static int bottle1 = 12;
	private static int bottle2 = 8;
	private static int bottle3 = 5;
	private static int target = 6;
	//假设一开始12,0,0
	private static void backBottle(int bb1, int bb2, int bb3) {
		System.out.println("bb1: " + bb1 + "   bb2: " + bb2 + " bb3: " + bb3);
		if(bb1 == target || bb2 == target || bb3 == target) {
			System.out.println("find the bottle");
			return;
		}
		/**
		 * 1. 瓶子2 非空，且瓶子3不满
		 * 2. 瓶子2非空，且瓶子3已满
		 * 3. 瓶子2已空
		 */
		if(bb2 != 0 && bb3 != bottle3) { // 1. 瓶子2 非空，且瓶子3不满
			if(bb2 + bb3 <= bottle3) {
				// 倒不满
				backBottle(bb1, 0, bb2 + bb3);
			}else {
				backBottle(bb1, bb2 - (bottle3 - bb3), bottle3);
			}
		}else if(bb2 != 0 && bb3 == bottle3){ // 2. 瓶子2非空，且瓶子3已满
			// 瓶子3满了，往瓶子1倒
			if(bb3 + bb1 <= bottle1) {// 说明倒完后瓶子1没满
				backBottle(bb1 + bb3, bb2, 0);
			}else {
				backBottle(bottle1, bb2, bb3 - (bottle1 - bb1));
			}
		}else if(bb2 == 0) { // 瓶子2已空
			// 从瓶子1往瓶子2倒酒
			if(bb1 >= bottle2) {
				backBottle(bb1 - bottle2, bottle2, bb3);
			}else {
				backBottle(0, bb1, bb3);
			}
		}
	}

	public static void main(String[] args) {
		
		backBottle(12, 0, 0);
	}
}
