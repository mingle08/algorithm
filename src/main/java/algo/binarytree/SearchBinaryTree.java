package algo.binarytree;


/**
 * 查找二叉树
 *
 * @author huxm
 */
public class SearchBinaryTree {

    private TreeNode root;

    public SearchBinaryTree() {

    }

    /**
     * 创建查找二叉树
     *
     * @author huxm
     */
    public TreeNode put(int data) {
        TreeNode node = null;
        TreeNode parent = null;
        // 如果树是空的,则把此数字构建成一个节点，作为根
        if (root == null) {
            node = new TreeNode(0, data);
            root = node;
            return root;
        }
        // 将根节点赋值给node，从根开始判断
        node = root;
        while (node != null) {
            // 父节点
            parent = node;
            if (data > node.data) {
                node = node.rightChild;
            } else if (data < node.data) {
                node = node.leftChild;
            } else {
                return node;
            }
        }
        // 表示将此结点添加到相应的位置
        node = new TreeNode(0, data);
        if (data < parent.data) {
            parent.leftChild = node;
        } else {
            parent.rightChild = node;
        }
        node.parent = parent;
        return node;
    }

    /**
     * 删除节点
     */
    public void deleteNode(int key) throws Exception {
        TreeNode node = searchNode(key);
        if (node == null) {
            throw new Exception("该结点无法找到！");
        } else {
            // 删除该结点
            delete(node);
        }
    }

    /**
     * 查找节点
     */
    private TreeNode searchNode(int key) {
        TreeNode node = root;
        if (node == null) {
            return null;
        } else {
            while (node != null && key != node.data) {
                if (key < node.data) {
                    node = node.leftChild;
                } else {
                    node = node.rightChild;
                }
            }
        }
        // 能直到这一步，说明找到了，或者没找到（没找到就为空，即node值为空）
        return node;
    }

    private void delete(TreeNode node) throws Exception {
        if (node == null) {
            throw new Exception("该结点无法找到！");
        }
        TreeNode parent = node.parent;
        // 被删除的节点是叶子节点：无左也无右孩子
        if (node.leftChild == null && node.rightChild == null) {
            if (parent.leftChild == node) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
            return;
        }

        // 被删除的节点只有左孩子，无右
        if (node.leftChild != null && node.rightChild == null) {
            if (parent.leftChild == node) {
                parent.leftChild = node.leftChild;
            } else {
                parent.rightChild = node.leftChild;
            }
            return;
        }

        // 被删除的节点只有右孩子，无左
        if (node.leftChild == null && node.rightChild != null) {
            if (parent.leftChild == node) {
                parent.leftChild = node.rightChild;
            } else {
                parent.rightChild = node.rightChild;
            }
            return;
        }

        /**
         * 被删除的节点，既有左，又有右孩子：找到后继结点
         * 这个后继结点，一定是叶子节点
         */
        TreeNode nextNode = getNextNode(node);
        delete(nextNode);

    }

    private TreeNode getNextNode(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.rightChild != null) {
            // 找某人上结点最小关键字结点
            return getMinTreeNode(node.rightChild);
        } else {
            TreeNode parent = node.parent;
            while (parent != null && node == parent.rightChild) {
                node = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }

    private TreeNode getMinTreeNode(TreeNode node) {
        if (node == null) {
            return null;
        }
        while (node.leftChild != null) { // 如果左孩子为空，就跳出此循环
            node = node.leftChild;
        }
        return node;
    }

    /**
     * 前序遍历
     */
    public void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        preOrder(node.leftChild);
        preOrder(node.rightChild);
    }

    /**
     * 中序遍历
     */
    public void midOrder(TreeNode node) {
        if (node == null) {
            return;
        } else {
            midOrder(node.leftChild);
            System.out.println(node.data);
            midOrder(node.rightChild);
        }
    }

    /**
     * 内部类：TreeNode
     *
     * @author huxm
     */
    class TreeNode {

        private int key;
        private int data;
        private TreeNode leftChild;
        private TreeNode rightChild;
        private TreeNode parent;

        // 构造函数
        public TreeNode(int key, int data) {
            super();
            this.key = key;
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
            this.parent = null;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public TreeNode getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(TreeNode leftChild) {
            this.leftChild = leftChild;
        }

        public TreeNode getRightChild() {
            return rightChild;
        }

        public void setRightChild(TreeNode rightChild) {
            this.rightChild = rightChild;
        }

        public TreeNode getParent() {
            return parent;
        }

        public void setParent(TreeNode parent) {
            this.parent = parent;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        SearchBinaryTree bt = new SearchBinaryTree();
        int[] intArr = new int[]{50, 30, 20, 44, 88, 33, 87, 16, 7, 77};
        for (int i : intArr) {
            bt.put(i);
        }
        bt.midOrder(bt.root);
        System.out.println("============");
//		bt.preOrder(bt.root);
        // 删除一个节点
        try {
            bt.deleteNode(44);
            bt.midOrder(bt.root);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
