package algo.swordToOffer;

import algo.util.TreeNode;

/**
 * 将搜索二叉树转换成有序的双向链表
 *
 * 以下解释摘自古灵阁的博文：https://www.cnblogs.com/keedor/p/4467040.html
 * 代码中有两个参数，一个是根节点，一个是已经转换好的链表的最后一个节点，因为二叉搜索树中序遍历的特性，
 * 当遍历到根节点的时候，左子树已经排好序了，所以会有一个左子树已经转换好的链表，而这个链表的最后一个节点
 * 即是我们需要和根节点左连的节点
 *
 * 最开始的时候lastNode为null
 *
 * current为当前子树的根节点
 *
 * 如果左子树存在，那么转换左子树，递归下去，递归返回之后，说明找到了链表的第一个节点，也就是4那个节点，
 * 将4的前面节点置为null，此时current为4那个节点，这个时候由于6的4这个左子树已遍历完了，所以需要往上层返回，
 * 返回之前需要将current赋值给lastNode，说明4这个左子树的最后一个节点就是4
 *
 * 由于往上返回了一层，此时的current已经是6了，将6的左节点赋值为之前返回的4，判断之前返回的lastNode是否为null，
 * 不为空说明需要把根节点和lastNode连起来，其实lastNode为null的情况就只有第一个节点会出现，其他的时候都不会出现。
 * 现在已排好序的包括6的左子树以及6本身了，所以此时的lastNode为6
 *
 * 6和4的双向连接就完成了，由于6的右子树存在，又会递归到右边子树去，由于8不存在左右子树，递归下去一层之后current
 * 就是8这个节点，但它的左孩子为空，所以不会左边递归下去，将8的左连接与之前的lastNode连接起来，建立双向连接的一条
 * 连接，然后由于lastNode不为空，所以又把lastNode的右连接与8连接起来，至此双向连接建立，此时lastNode为8
 *
 * 所以468都已排好序，此时lastNode为8，返回到上一层，也就是根节点10了，在这一层current为10，将current的左连接与
 * lastNode连接起来，如果lastNode存在，将lastNode的右连接与10连接一起，以此建立双向连接。至此就将根节点和左子树
 * 都连接起来了，然后就是去转换右子树，现在的lastNode为10，current为14，14有左孩子，所以需要递归到下一层，下一层
 * 的current为12，12没有左孩子，所以不用在坐递归，所以12是12这棵子树转换成双向链表的最左边的节点，将lastNode与12
 * 连接，也就是10与12连接，此时的lastNode就变成了12，再将12的右子树递归，由于没有右子树，所以直接返回到上一层，
 * 上一层的current是14,14与已排好序的lastNode连接，也就是12与14连接，然后lastNode变为14，递归到14的右子树，也就
 * current变为16，16再递归左子树，无左子树，将16与14连接，此时的lastNode变为16，递归右子树，无右子树，所以整个递归
 * 工作完成
 */
public class Q036_ConvertBSTreeToDoubleNodeList {

    public TreeNode convert(TreeNode root){
        TreeNode lastNode = null;
        lastNode = convertNode(root, lastNode);
        TreeNode head = lastNode;
        while (head != null && head.left != null){
            head = head.left;
        }
        return head;
    }

    private TreeNode convertNode(TreeNode root, TreeNode lastNode){
        if (root == null)
            return lastNode;

        TreeNode cur = root;
        if (cur.left != null)
            lastNode = convertNode(cur.left, lastNode);
        cur.left = lastNode;    // 双向链接第1步

        // 把根节点连接到链表中
        if (lastNode != null)
            lastNode.right = cur;   // 双向链接第2步，至此，完成双向链接

        // 根节点成为新的最后节点，再与右子树相连
        lastNode = cur;
        if (cur.right != null)
            lastNode = convertNode(cur.right, lastNode);

        return lastNode;

    }
}
