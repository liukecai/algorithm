package structure;

public class BinaryTreeGetNextMiddle {

	class TreeNode {
		int val;
		public TreeNode parent;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int x) {
			val = x;
		}
		
		public String toString() {
			return Integer.toHexString(hashCode())+ "@" + Integer.toString(this.val);
		}
	}
	
	/**
	 * Construct binary tree with parent node
	 * 
	 * @param root
	 * @param left
	 * @param right
	 */
	public static void connectTreeNode(TreeNode root, TreeNode left, TreeNode right) {
		if (root == null)
			return;
		
		root.left = left;
		root.right = right;
		if (left != null)
			left.parent = root;
		if (right != null)
			right.parent = root;
	}
	
	public TreeNode getNext(TreeNode root) {
		if (root == null)
			return null;
	
		if (root.right != null) {
			TreeNode p = root.right;
			while (p.left != null)
				p = p.left;
			return p;
		}
		
		if (root.left != null) { 
			return root.parent;
		}
		
		if (root.left == null && root.right == null) {
			if (root.parent != null) {
				
				TreeNode p = root.parent;
				TreeNode q = root;
				while (p.parent != null) {
					if (p.left == q)
						return p;
					q = p;
					p = p.parent;
				}
				if (p.left == q)
					return p;
				else
					return null;
				
			}
		}
		
		return null;
	}
	
	public void test(TreeNode root, TreeNode except) {
		TreeNode next = getNext(root);
		if (next == except)
			System.out.println("Pass");
		else
			System.out.println("Root:\t" + root + "\nNext:\t" + next + "\nExcept:\t" + except +  "\nFialed\n");
	}
	
	
	
	//          1
	//         / \
	//        2   3
	//       / \ / \
	//      4  5 6  7
	//        / \
	//       8   9
	//
	// middle:  4 2 8 5 9 1 6 3 7
	public void test1() {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		TreeNode node9 = new TreeNode(9);
		
		connectTreeNode(node1, node2, node3);
		connectTreeNode(node2, node4, node5);
		connectTreeNode(node3, node6, node7);
		connectTreeNode(node5, node8, node9);
		
		printBinaryTree(node1);
		System.out.println();
		
		test(node1, node6);
		test(node2, node8);
		test(node3, node7);
		test(node4, node2);
		test(node5, node9);
		test(node6, node3);
		test(node7, null);
		test(node8, node5);
		test(node9, node1);
	}
	
	//  	8
	//	6      10
	// 5 7    9  11
	//
	// middle 5 6 7 8 9 10 11 
	public void test2() {
		TreeNode node8 = new TreeNode(8);
		TreeNode node6 = new TreeNode(6);
		TreeNode node10 = new TreeNode(10);
		TreeNode node5 = new TreeNode(5);
		TreeNode node7 = new TreeNode(7);
		TreeNode node9 = new TreeNode(9);
		TreeNode node11 = new TreeNode(11);
		
		connectTreeNode(node8, node6, node10);
		connectTreeNode(node6, node5, node7);
		connectTreeNode(node10, node9, node11);
		
		printBinaryTree(node8);
		System.out.println();
		
	    test(node8, node9);
	    test(node6, node7);
	    test(node10, node11);
	    test(node5, node6);
	    test(node7, node8);
	    test(node9, node10);
	    test(node11, null);
	}
	
	//  	5
	//	  4
	//	3
	//2
	public void test3() {
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		
		connectTreeNode(node5, node4, null);
		connectTreeNode(node4, node3, null);
		connectTreeNode(node3, node2, null);
		
		printBinaryTree(node5);
		System.out.println();
		
	    test(node5, null);
	    test(node4, node5);
	    test(node3, node4);
	    test(node2, node3);
	}
	
	//    2
	//	    3
	//	      4
	//          5
	public void test4() {
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		
		connectTreeNode(node2, null, node3);
		connectTreeNode(node3, null, node4);
		connectTreeNode(node4, null, node5);
		
		printBinaryTree(node2);
		System.out.println();
		
	    test(node5, null);
	    test(node4, node5);
	    test(node3, node4);
	    test(node2, node3);
	}
	
	// 1
	public void test5() {
		TreeNode node1 = new TreeNode(1);
		
		connectTreeNode(node1, null, null);
		
		printBinaryTree(node1);
		System.out.println();
		
		test(node1, null);
	}
	
	public static void printBinaryTree(TreeNode root) {
		if (root == null)
			return;
		
		printBinaryTree(root.left);
		System.out.printf("%d ", root.val);
		printBinaryTree(root.right);
	}
	
	public static void main(String[] args) {
		BinaryTreeGetNextMiddle tree = new BinaryTreeGetNextMiddle();
		tree.test1();
		tree.test2();
		tree.test3();
		tree.test4();
		tree.test5();
	}
}
