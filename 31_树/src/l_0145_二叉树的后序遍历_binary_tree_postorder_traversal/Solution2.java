package l_0145_二叉树的后序遍历_binary_tree_postorder_traversal;

import java.util.LinkedList;
import java.util.List;

/*

从根节点开始依次迭代，弹出栈顶元素输出到输出列表中，然后依次压入它的所有孩子节点，
按照从上到下、从左至右的顺序依次压入栈中。

因为深度优先搜索后序遍历的顺序是从下到上、从左至右，所以需要将输出列表逆序输出。

作者：LeetCode
链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal/solution/er-cha-shu-de-hou-xu-bian-li-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/





class Solution2 {
	public List<Integer> postorderTraversal(TreeNode root) {
		LinkedList<TreeNode> stack = new LinkedList<>();
		LinkedList<Integer> output = new LinkedList<>();
		if (root == null) {
			return output;
		}
/*		从根节点开始依次迭代，弹出栈顶元素输出到输出列表中，然后依次压入它的所有孩子节点，
		按照从上到下、从左至右的顺序依次压入栈中。

		因为深度优先搜索后序遍历的顺序是从下到上、从左至右，所以需要将输出列表逆序输出。*/
		
/*		先序遍历：root->left->right 后序遍历：left->right-root，两者反过来当然不相等了，
		但是如果把先序遍历改成root->right-left，再逆序一下就相等*/
		stack.add(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pollLast();
			output.addFirst(node.val);
			if (node.left != null) {
				stack.add(node.left);
			}
			if (node.right != null) {
				stack.add(node.right);
			}
		}
		return output;
	}
/*	执行用时 :
		0 ms
		, 在所有 Java 提交中击败了
		100.00%
		的用户
		内存消耗 :
		37.9 MB
		, 在所有 Java 提交中击败了
		5.13%
		的用户*/
}

