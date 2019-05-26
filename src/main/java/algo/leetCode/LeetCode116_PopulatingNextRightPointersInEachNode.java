package algo.leetCode;

public class LeetCode116_PopulatingNextRightPointersInEachNode {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }

    // Time Complexity: O(n), 每个点访问不超过两遍. Space: O(logn).
    public void connect1(TreeLinkNode root) {
        if(root == null){
            return;
        }
        // 不同父节点的右子节点到左子节点
        if(root.right != null && root.next != null){
            root.right.next = root.next.left;
        }
        // 同一个父节点左右子节点
        if(root.left!=null){
            root.left.next = root.right;
        }
        connect1(root.right);
        connect1(root.left);
    }

    // Time Complexity: O(n). Space: O(1).

    public void connect2(TreeLinkNode root) {
        TreeLinkNode head = root;
        while(head != null){
            TreeLinkNode nextDummy = new TreeLinkNode(0);   //记录下一层的假头
            TreeLinkNode cur = nextDummy;

            while(head != null){
                if(head.left != null){
                    cur.next = head.left;
                    cur = cur.next;
                }

                if(head.right != null){
                    cur.next = head.right;
                    cur = cur.next;
                }

                head = head.next;
            }

            head = nextDummy.next;  //head 更新到下一层假头的next上面
            nextDummy.next = null;
        }
    }


    public static void main(String[] args){
        LeetCode116_PopulatingNextRightPointersInEachNode solution = new LeetCode116_PopulatingNextRightPointersInEachNode();

        // 注意使用内部类new对象的方式
        LeetCode116_PopulatingNextRightPointersInEachNode.TreeLinkNode head = solution.new TreeLinkNode(1);

    }


}
