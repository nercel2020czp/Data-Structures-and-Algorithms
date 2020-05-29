package c06_Binary_Search_Tree.c13_LeetCode.l_0098_验证二叉搜索树;
/*
方法一: 递归
思路和算法

要解决这道题首先我们要了解二叉搜索树有什么性质可以给我们利用，由题目给出的信息我们可以知道：
如果该二叉树的左子树不为空，则左子树上所有节点的值均小于它的根节点的值； 
若它的右子树不空，则右子树上所有节点的值均大于它的根节点的值；
它的左右子树也为二叉搜索树。

这启示我们设计一个递归函数 helper(root, lower, upper) 来递归判断，
函数表示考虑以 root 为根的子树，判断子树中所有节点的值是否都在 (l,r)(l,r) 的范围内（注意是开区间）。
如果 root 节点的值 val 不在 (l,r)(l,r) 的范围内说明不满足条件直接返回，
否则我们要继续递归调用检查它的左右子树是否满足，如果都满足才说明这是一棵二叉搜索树。

那么根据二叉搜索树的性质，在递归调用左子树时，我们需要把上界 upper 改为 root.val，
即调用 helper(root.left, lower, root.val)，因为左子树里所有节点的值均小于它的根节点的值。
同理递归调用右子树时，我们需要把下界 lower 改为 root.val，即调用 helper(root.right, root.val, upper)。

函数递归调用的入口为 helper(root, -inf, +inf)， inf 表示一个无穷大的值。




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
