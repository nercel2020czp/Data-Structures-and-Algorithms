package c06_Binary_Search_Tree.c13_LeetCode.l_0230_二叉搜索树中第K小的元素;

import java.util.ArrayList;

/*
方法一：递归
算法：
通过构造 BST 的中序遍历序列，则第 k-1 个元素就是第 k 小的元素。

执行用时 :
1 ms
, 在所有 Java 提交中击败了
66.37%
的用户
内存消耗 :
40.1 MB
, 在所有 Java 提交中击败了
8.70%
的用户
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution1 {
	class Solution {
		public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
			if (root == null)
				return arr;
			inorder(root.left, arr);
			arr.add(root.val);
			inorder(root.right, arr);
			return arr;
		}

		public int kthSmallest(TreeNode root, int k) {
			ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>());
			return nums.get(k - 1);
		}
	}
/*	复杂度分析
	时间复杂度：O(N)O(N)O(N)，遍历了整个树。
	空间复杂度：O(N)O(N)O(N)，用了一个数组存储中序序列。*/
}
