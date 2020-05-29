package c13_LeetCode.l_0098_验证二叉搜索树;
/*
方法一: 递归
上述思路可以用递归法实现。首先将结点的值与上界和下界（如果有）比较。然后，对左子树和右子树递归进行该过程。


作者：LeetCode
链接：https://leetcode-cn.com/problems/validate-binary-search-tree/solution/yan-zheng-er-cha-sou-suo-shu-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

*/

//Definition for a binary tree node.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution1 {
	class Solution {
		public boolean helper(TreeNode node, Integer lower, Integer upper) {
			if (node == null)
				return true;

			int val = node.val;
			if (lower != null && val <= lower)
				return false;
			if (upper != null && val >= upper)
				return false;

			if (!helper(node.right, val, upper))
				return false;
			if (!helper(node.left, lower, val))
				return false;
			return true;
		}

		public boolean isValidBST(TreeNode root) {
			return helper(root, null, null);
		}
	}
/*	执行用时 :
		0 ms
		, 在所有 Java 提交中击败了
		100.00%
		的用户
		内存消耗 :
		39.4 MB
		, 在所有 Java 提交中击败了
		15.94%
		的用户*/
}
