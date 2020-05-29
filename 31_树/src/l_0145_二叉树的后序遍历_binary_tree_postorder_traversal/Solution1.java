package l_0145_二叉树的后序遍历_binary_tree_postorder_traversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
/* Definition for a binary tree node. */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
public class Solution1 {
	public List<Integer> postorderTraversal(TreeNode root) {
	    List<Integer> list = new LinkedList<>();
	    Stack<TreeNode> stack = new Stack<>();
	    TreeNode cur = root;
	    TreeNode last = null;
	    while (cur != null || !stack.isEmpty()) {
	        while (cur != null) {
	            stack.push(cur);
	            cur = cur.left;
	        } 
	        if(!stack.empty()) {
	            TreeNode temp = stack.peek();
	            //是否变到右子树
	            if (temp.right != null && temp.right != last) {
	                cur = temp.right;
	            } else {
	                list.add(temp.val);
	                last = temp;
	                stack.pop();
	            }
	        }
	    }
	    return list;
	}
	
/*	执行用时 :
		1 ms
		, 在所有 Java 提交中击败了
		59.36%
		的用户
		内存消耗 :
		37.5 MB
		, 在所有 Java 提交中击败了
		5.13%
		的用户*/
}
