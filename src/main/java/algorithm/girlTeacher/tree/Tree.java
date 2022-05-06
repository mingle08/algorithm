package algorithm.girlTeacher.tree;

import java.util.Stack;

public class Tree {

	private Node root;
	public Tree() {
		root = null;
	}

	// insert a node
	public void insert(int id, double dd) {
		Node node = new Node();
		node.iData = id;
		node.dData = dd;
		if(root == null) { // tree is empty
			root = node;
		}else {
			Node current = root;
			Node parent;
			while(true) {
				parent = current;
				if(id < current.iData) {
					current = current.leftChild;
					if(current == null) {
						parent.leftChild = node;
						return;
					}
				}else {
					current = current.rightChild;
					if(current == null) {
						parent.rightChild = node;
						return;
					}
				}
			}
		}
	}

	// delete a node
	public boolean delete(int key) {
		Node current = root;
		Node parent = root;
		boolean isLeftChild = true;
		while(current.iData != key) { // skip the loop, means found the node
			parent = current;
			if(key < current.iData) {
				isLeftChild = true;   // the target node (current) is leftChild or not
				current = current.leftChild;
			}else {
				isLeftChild = false;
				current = current.rightChild;
			}
			if(current == null) {  // not found
				return false;
			}
		}

		if(current.leftChild == null && current.rightChild == null) {  // leaf node
			if(current == root) { // the target node (current)  is root, and has no child nodes
				root = null;
			}else if(isLeftChild) {
				parent.leftChild = null;
			}else {
				parent.rightChild = null;
			}
		}else if(current.rightChild == null) { // the target node (current) has leftChild, no rightChild
			if(current == root) {
				root = current.leftChild;
			}else if(isLeftChild) {
				parent.leftChild = current.leftChild;
			}else {
				parent.rightChild = current.leftChild;
			}
		}else if(current.leftChild == null) { // the target node (current) has rightChild, no leftChild
			if(current == root) {
				root = current.rightChild;
			}else if(isLeftChild) {
				parent.leftChild = current.rightChild;
			}else {
				parent.rightChild = current.rightChild;
			}
		}else {   // not only has leftChild, but also has rightChild
			Node successor = getSuccessor(current);
			if(current == root) {
				root = successor;
			}else if(isLeftChild) {
				parent.leftChild = successor;
			}else {
				parent.rightChild = successor;
			}
			successor.leftChild = current.leftChild;
		}
		return true;
	}

	/**
	 * 向右子节点找出继承者节点
	 */
	private Node getSuccessor(Node delNode) {
		Node successorParent = delNode;
		Node successor = delNode;
		Node current = delNode.rightChild;
		while(current != null) {
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		}
		if(successor != delNode.rightChild) {
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = delNode.rightChild;
		}

		return successor;
	}

	public Node find(int key) {
		Node current = root;
		while(current.iData != key) {
			if(key < current.iData) {
				current = current.leftChild;
			}else {
				current = current.rightChild;
			}
			if(current == null) {
				return null;
			}
		}
		return current;
	}

	/**
	 * 遍历
	 */
	public void traverse(int type) {
		switch(type) {
		case 1:  // 从上至下，从左至右
			System.out.println("Preorder traversal: ");
			preOrder(root);
			break;
		case 2:  // 从下至上，从左至右
			System.out.println("Inorder traversal: ");
			inOrder(root);
			break;
		case 3:  // 从下至上，从右至左
			System.out.println("Postorder traversal:");
			postOrder(root);
			break;
		}
		System.out.println();
	}



	/**
	 * 前序遍历
	 */
	private void preOrder(Node localRoot) {
		if(localRoot != null) {
			System.out.print(localRoot.iData + " ");
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
	}

	/**
	 * 中序遍历
	 */
	private void inOrder(Node localRoot) {
		if(localRoot != null) {
			inOrder(localRoot.leftChild);
			System.out.print(localRoot.iData + " ");
			inOrder(localRoot.rightChild);
		}
	}

	/**
	 * 后序遍历
	 */
	private void postOrder(Node localRoot) {
		if(localRoot != null) {
			postOrder(localRoot.leftChild);
			postOrder(localRoot.rightChild);
			System.out.print(localRoot.iData + " ");
		}
	}

	public void displayTree() {
		Stack globalStack = new Stack();
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out.println("===========================================");
		while(!isRowEmpty) {
			Stack localStack = new Stack();
			isRowEmpty = true;
			for(int j = 0; j < nBlanks; j++) {
				System.out.print(" ");
			}
			while(!globalStack.isEmpty()) {
				Node temp = (Node) globalStack.pop();
				if(temp != null) {
					System.out.print(temp.iData);
					localStack.push(temp.leftChild);
					localStack.push(temp.rightChild);
					if(temp.leftChild != null || temp.rightChild != null) {
						isRowEmpty = false;
					}
				}else {
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}

				for(int j = 0; j < 2 * nBlanks - 2; j++) {
					System.out.print(" ");
				}
			}// while end
			System.out.println();
			nBlanks /= 2;
			while(!localStack.isEmpty()) {
				globalStack.push(localStack.pop());
			}
		}
		System.out.println("===========================================");
	}
}
