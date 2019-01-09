package structure;

import util.BTreeNode;

public class BinaryTree {
	public BTreeNode root;

	public BinaryTree() {
		
	}
	
	public BTreeNode constructFromPreorder(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null 
				|| preorder.length == 0 || inorder.length == 0)
			return null;
		
		root = new BTreeNode();
		root.val = preorder[0];
		
		int index = getIndex(inorder, root.val);
		root.left = constructFromPreorderCore(preorder, 1, index, inorder, 0, index);
		root.right = constructFromPreorderCore(preorder, index + 1, preorder.length, 
									inorder, index + 1, inorder.length);
		
		return root;
	}
	
	
	
	private BTreeNode constructFromPreorderCore(int[] preorder, int pre_start, int pre_end,
			int[] inorder, int in_start, int in_end) {
		
		if (pre_start >= preorder.length || pre_start > pre_end || in_start > in_end)
			return null;
		
		BTreeNode root = new BTreeNode();
		root.val = preorder[pre_start];
		if (pre_start == pre_end && in_start == in_end) {
			root.left = null;
			root.right = null;
			return root;	
		} 
		
		int index = getIndex(inorder, root.val);
		
		
		if (index >= in_start) {
			int length = index - in_start;
			root.left = constructFromPreorderCore(preorder, pre_start + 1, pre_start + length, 
					inorder, in_start, index - 1);
			root.right = constructFromPreorderCore(preorder, pre_start + length + 1, pre_end, 
					inorder, index + 1, in_end);
		}
		
		return root;
	}
	
	public BTreeNode constructFromPostorder(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null 
				|| inorder.length == 0 || postorder.length == 0)
			return null;
		
		BTreeNode root = new BTreeNode();
		root.val = postorder[postorder.length - 1];
		
		int index = getIndex(inorder, root.val);
		
		root.left = constructFromPostorderCore(inorder, 0, index - 1, postorder, 0, index - 1);
		root.right = constructFromPostorderCore(inorder, index + 1, inorder.length - 1, postorder, index, postorder.length - 2);
		
		return root;
	}
	
	private BTreeNode constructFromPostorderCore(int[] inorder, int in_start, int in_end, 
			int[] postorder, int post_start, int post_end) {
		
		if (post_end < 0 || in_start > in_end || post_start > post_end)
			return null;
		
		BTreeNode root = new BTreeNode();
		root.val = postorder[post_end];
		
		if (in_start == in_end && post_start == post_end) {
			root.left = null;
			root.right = null;
			return root;
		}
		
		int index = getIndex(inorder, root.val);
		
		if (index >= in_start) {
			int length = index - in_start;
			root.left = constructFromPostorderCore(inorder, in_start, index - 1, postorder, post_start, post_start + length - 1);
			root.right = constructFromPostorderCore(inorder, index + 1, in_end, postorder, post_start + length, post_end - 1);
		}
		
		return root;
	}
	
	private int getIndex(int[] array, int key) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == key)
				return i;
		}
		return -1;
	}
	
	public static void testPreorder() {
		int preorder[] = { 1, 2, 4, 7, 3, 5, 6, 8 };
		int inorder[] = { 4, 7, 2, 1, 5, 3, 8, 6 };
		
		BinaryTree tree = new BinaryTree();
		tree.root = tree.constructFromPreorder(preorder, inorder);
	}
	
	public static void testPostorder() {
		int inorder[] = {9, 3, 15, 20, 7};
		int postorder[] = {9, 15, 7, 20, 3};
		
		BinaryTree tree = new BinaryTree();
		tree.root = tree.constructFromPostorder(inorder, postorder);
		System.out.println(tree.root.val);
	}
	
	public static void main(String[] args) {
		testPostorder();
	}
}