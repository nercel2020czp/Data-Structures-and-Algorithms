package c13_LeetCode.l_0230_二叉搜索树中第K小的元素;

import java.util.LinkedList;

/*方法二：迭代
算法：
在栈的帮助下，可以将方法一的递归转换为迭代，这样可以加快速度，因为这样可以不用遍历整个树，可以在找到答案后停止。


圖3.jpg

*/
public class Solution2 {
	class Solution {
		//二叉搜索树的中序遍历  非递归
		public int kthSmallest(TreeNode root, int k) {
			LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

			while (true) {
				while (root != null) {
					stack.add(root);
					root = root.left;
				}
				root = stack.removeLast();
				if (--k == 0)
					return root.val;
				root = root.right;
			}
		}
	}
/*	执行用时 :
		0 ms
		, 在所有 Java 提交中击败了
		100.00%
		的用户
		内存消耗 :
		39.6 MB
		, 在所有 Java 提交中击败了
		8.70%
		的用户*/
}
