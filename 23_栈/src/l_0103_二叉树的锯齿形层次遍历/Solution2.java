package l_0103_二叉树的锯齿形层次遍历;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*思路二:*/
public class Solution2 {
/*	执行用时 :
		1 ms
		, 在所有 Java 提交中击败了
		97.89%
		的用户
		内存消耗 :
		38.8 MB
		, 在所有 Java 提交中击败了
		7.41%
		的用户*/
	class Solution {
		public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
			List<List<Integer>> res = new ArrayList<>();
			helper(res, root, 0);
			return res;

		}

		private void helper(List<List<Integer>> res, TreeNode root, int depth) {
			if (root == null)
				return;
			if (res.size() == depth)
				res.add(new LinkedList<>());
			if (depth % 2 == 0)
				res.get(depth).add(root.val);
			else
				res.get(depth).add(0, root.val);
			helper(res, root.left, depth + 1);
			helper(res, root.right, depth + 1);
		}
	}

/*	作者：powcai
	链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/solution/die-dai-he-di-gui-by-powcai-3/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
