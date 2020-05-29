package c06_Binary_Search_Tree.c13_LeetCode.l_0099_恢复二叉搜索树;

public class Solution2 {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	class Solution {
	    TreeNode firstNode = null;
	    TreeNode secondNode = null;
	    TreeNode preNode = new TreeNode(Integer.MIN_VALUE);

	    public void recoverTree(TreeNode root) {

	        in_order(root);
	        int tmp = firstNode.val;
	        firstNode.val = secondNode.val;
	        secondNode.val = tmp;
	    }

		private void in_order(TreeNode root) {
			if (root == null)
				return;
			in_order(root.left);
			if (firstNode == null && preNode.val > root.val)
				firstNode = preNode;
			if (firstNode != null && preNode.val > root.val)
				secondNode = root;
			preNode = root;
			in_order(root.right);
		}
	}

}
