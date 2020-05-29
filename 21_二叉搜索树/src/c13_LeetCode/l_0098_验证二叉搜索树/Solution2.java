package c13_LeetCode.l_0098_验证二叉搜索树;

import java.util.LinkedList;

/*
方法二: 迭代

通过使用栈，上面的递归法可以转化为迭代法。这里使用深度优先搜索，比广度优先搜索要快一些。

*/

/*		作者：LeetCode
		链接：https://leetcode-cn.com/problems/validate-binary-search-tree/solution/yan-zheng-er-cha-sou-suo-shu-by-leetcode/
		来源：力扣（LeetCode）
		著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
public class Solution2 {
	class Solution {
		LinkedList<TreeNode> stack = new LinkedList<>();
		LinkedList<Integer> uppers = new LinkedList<>(), lowers = new LinkedList<>();

		public void update(TreeNode root, Integer lower, Integer upper) {
			stack.add(root);
			lowers.add(lower);
			uppers.add(upper);
		}

		public boolean isValidBST(TreeNode root) {
			Integer lower = null, upper = null, val;
			update(root, lower, upper);

			while (!stack.isEmpty()) {
				root = stack.poll();
				lower = lowers.poll();
				upper = uppers.poll();

				if (root == null)
					continue;
				val = root.val;
				if (lower != null && val <= lower)
					return false;
				if (upper != null && val >= upper)
					return false;
				update(root.right, val, upper);
				update(root.left, lower, val);
			}
			return true;
		}
	}
/*	
	复杂度分析
	时间复杂度 : 
	O(N)O(N)
	O(N)。每个结点访问一次。
	空间复杂度 : 
	O(N)O(N)
	O(N)。我们跟进了整棵树。

	*/
/*	执行用时 :
		5 ms
		, 在所有 Java 提交中击败了
		8.12%
		的用户
		内存消耗 :
		39.2 MB
		, 在所有 Java 提交中击败了
		28.98%
		的用户*/
}
