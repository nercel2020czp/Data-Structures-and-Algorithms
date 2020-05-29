package t018_二叉树的镜像;

import java.util.Stack;

//手动压栈【该解法目前有问题】
public class Solution2 {
	public void Mirror(TreeNode root) {
		// 空树
		if (root == null) {
			return;
		}
		// 左右均为空
		if (root.left == null && root.right == null) {
			return;
		}

		// 用来遍历的栈
		Stack<TreeNode> stack = new Stack<TreeNode>();

		stack.push(root);

		TreeNode curNode;
		TreeNode tempNode;

		// 深度优先
		while (!stack.isEmpty()) {
			curNode = stack.pop();
			if (curNode == null) {
				continue;
			}
			if (curNode.left == null && curNode.right == null) {
				continue;
			}
			// 交换
			tempNode = curNode.left;
			curNode.left = curNode.right;
			curNode.right = tempNode;
			stack.push(curNode.left);
			stack.push(curNode.right);
		}
	}
}
