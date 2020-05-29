package t060_把二叉树打印成多行;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Solution2 {
	public List<List<Integer>> levelOrder(TreeNode root) {
		// 空间复杂度 O(N) ：
		// 最差情况下，即当树为平衡二叉树时，最多有 N/2 个树节点同时在 queue 中，使用 O(N) 大小的额外空间。
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root != null)
			queue.add(root);
		/*
		 * 时间复杂度 O(N) ： N 为二叉树的节点数量，即 BFS 需循环 N 次。
		 */
		while (!queue.isEmpty()) {
			List<Integer> tmp = new ArrayList<Integer>();
			//for：开始打印每一层的
			for (int i = queue.size(); i > 0; i--) {
				TreeNode node = queue.poll();
				tmp.add(node.val);
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
			res.add(tmp);
		}
		return res;
	}
	/*
	 * 执行用时 : 1 ms , 在所有 Java 提交中击败了 95.80% 的用户 内存消耗 : 38.7 MB , 在所有 Java 提交中击败了
	 * 100.00% 的用户
	 */
}
