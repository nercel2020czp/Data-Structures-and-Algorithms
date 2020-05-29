package c13_LeetCode.l_0938_二叉搜索树的范围和;

import java.util.Stack;

/*
迭代实现深度优先搜索
 */
public class Solution3 {
	class Solution {
	    public int rangeSumBST(TreeNode root, int L, int R) {
	        int ans = 0;
	        Stack<TreeNode> stack = new Stack<>();
	        stack.push(root);
	        while (!stack.isEmpty()) {
	            TreeNode node = stack.pop();
	            if (node != null) {
	                if (L <= node.val && node.val <= R)
	                    ans += node.val;
	                if (L < node.val)
	                    stack.push(node.left);
	                if (node.val < R)
	                    stack.push(node.right);
	            }
	        }
	        return ans;
	    }
	}
/*	执行用时 :
		4 ms
		, 在所有 Java 提交中击败了
		15.82%
		的用户
		内存消耗 :
		47.7 MB
		, 在所有 Java 提交中击败了
		6.67%
		的用户*/
}
