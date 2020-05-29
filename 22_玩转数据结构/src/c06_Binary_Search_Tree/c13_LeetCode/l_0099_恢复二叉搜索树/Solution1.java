package c06_Binary_Search_Tree.c13_LeetCode.l_0099_恢复二叉搜索树;

import java.util.Deque;
import java.util.LinkedList;

/*
方法一：对数组进行排序

我们直到 BST 的中序遍历是升序序列。下面展示了如何计算中序遍历。

public void inorder(TreeNode root, List<Integer> nums) {
  if (root == null) return;
  inorder(root.left, nums);
  nums.add(root.val);
  inorder(root.right, nums);
}
这里被交换了两个节点，因此中序遍历是一个几乎排好序的数组，其中有两个元素被交换。
识别排序数组中两个交换元素是可以在线性时间内解决的经典问题。

作者：LeetCode
链接：https://leetcode-cn.com/problems/recover-binary-search-tree/solution/hui-fu-er-cha-sou-suo-shu-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class Solution1 {
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
		public void recoverTree(TreeNode root) {
			Deque<TreeNode> stack = new LinkedList<>();
			TreeNode firstNode = null;
			TreeNode secondNode = null;
			TreeNode pre = new TreeNode(Integer.MIN_VALUE);
			TreeNode p = root;
			while (p != null || !stack.isEmpty()) {
				while (p != null) {
					stack.push(p);
					p = p.left;
				}
				p = stack.pop();
				if (firstNode == null && pre.val > p.val)
					firstNode = pre;
				if (firstNode != null && pre.val > p.val)
					secondNode = p;
				pre = p;
				p = p.right;
			}
			int tmp = firstNode.val;
			firstNode.val = secondNode.val;
			secondNode.val = tmp;
		}
	}
}
