package l_0103_二叉树的锯齿形层次遍历;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*思路:
上一题一样102. 二叉树的层次遍历

思路一:BFS

思路二:DFS*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution1 {
/*	执行用时 :
		1 ms
		, 在所有 Java 提交中击败了
		97.89%
		的用户
		内存消耗 :
		39.4 MB
		, 在所有 Java 提交中击败了
		7.41%
		的用户*/
	class Solution {
		public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
			List<List<Integer>> res = new ArrayList<>();
			if (root == null)
				return res;
			Deque<TreeNode> queue = new LinkedList<>();
			queue.add(root);
			int depth = 0;
			while (!queue.isEmpty()) {
				List<Integer> tmp = new LinkedList<>();
				int cnt = queue.size();
				for (int i = 0; i < cnt; i++) {
					TreeNode node = queue.poll();
					// System.out.println(node.val);
					if (depth % 2 == 0)
						tmp.add(node.val);
					else
						tmp.add(0, node.val);
					if (node.left != null)
						queue.add(node.left);
					if (node.right != null)
						queue.add(node.right);
				}
				res.add(tmp);
				depth++;
			}
			return res;
		}
	}

/*	作者：powcai
	链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/solution/die-dai-he-di-gui-by-powcai-3/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
