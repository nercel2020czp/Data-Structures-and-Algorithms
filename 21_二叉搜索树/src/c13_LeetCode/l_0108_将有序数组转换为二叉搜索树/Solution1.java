package c13_LeetCode.l_0108_将有序数组转换为二叉搜索树;
/*
方法一：中序遍历：始终选择中间位置左边元素作为根节点
算法

left.png

方法 helper(left, right) 使用数组 numsnums 中索引从 left 到 right 的元素创建 BST：

如果 left > right，子树中不存在元素，返回空。

找出中间元素：p = (left + right) // 2。

创建根节点：root = TreeNode(nums[p])。

递归创建左子树 root.left = helper(left, p - 1) 和右子树 root.right = helper(p + 1, right)。

返回 helper(0, len(nums) - 1)。

作者：LeetCode
链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/solution/jiang-you-xu-shu-zu-zhuan-huan-wei-er-cha-sou-s-15/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

*/
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
/*
执行用时 :
0 ms
, 在所有 Java 提交中击败了
100.00%
的用户
内存消耗 :
40.1 MB
, 在所有 Java 提交中击败了
8.70%
的用户*/

public class Solution1 {
	class Solution {
		int[] nums;

		public TreeNode helper(int left, int right) {
			if (left > right)
				return null;

			// always choose left middle node as a root
			int p = (left + right) / 2;

			// inorder traversal: left -> node -> right
			TreeNode root = new TreeNode(nums[p]);
			root.left = helper(left, p - 1);
			root.right = helper(p + 1, right);
			return root;
		}

		public TreeNode sortedArrayToBST(int[] nums) {
			this.nums = nums;
			return helper(0, nums.length - 1);
		}
	}
/*
	复杂度分析

	时间复杂度：\mathcal{O}(N)O(N)，每个元素只访问一次。

	空间复杂度：\mathcal{O}(N)O(N)，二叉搜索树空间 \mathcal{O}(N)O(N)，递归栈深度 \mathcal{O}(\log N)O(logN)。

	作者：LeetCode
	链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/solution/jiang-you-xu-shu-zu-zhuan-huan-wei-er-cha-sou-s-15/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

	*/
}
