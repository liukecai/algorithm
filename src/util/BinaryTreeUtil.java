package util;

public class BinaryTreeUtil {

	public static void printBinaryTree(BTreeNode root) {
		if (root == null)
			return;
		
		printBinaryTree(root.left);
		System.out.printf("%d ", root.val);
		printBinaryTree(root.right);
	}
}
