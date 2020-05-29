package l_0094_二叉树的中序遍历_binary_tree_inorder_traversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution1 {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> resList = new LinkedList<>();
		Stack<TreeNode> stack = new Stack<>();
		if (root == null) 
			return resList;
		TreeNode cur = root;
		while(!stack.empty() || cur != null) {
			//一直遍历到左子树最下边，边遍历边保存根节点到栈中
			while(cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			// 当p为空时，说明已经到达左子树最下边，这时需要出栈了
			cur = stack.pop();
			resList.add(cur.val);
			// 进入右子树，开始新的一轮左子树遍历(这是递归的自我实现)
			cur = cur.right;
		}
		return resList;
	}
/*	
	执行用时 :
		1 ms
		, 在所有 Java 提交中击败了
		65.67%
		的用户
		内存消耗 :
		37.6 MB
		, 在所有 Java 提交中击败了
		5.13%
		的用户
	
	*/
}
