package c06_Binary_Search_Tree.c13_LeetCode.l_0108_将有序数组转换为二叉搜索树;

import java.util.Random;

/*
方法三：中序遍历：选择任意一个中间位置元素作为根节点

不做预定义选择，每次随机选择中间位置左边或者右边元素作为根节点。每次运行的结果都不同，但都是正确的。

random.png

算法

方法 helper(left, right) 使用数组 numsnums 中索引从 left 到 right 的元素创建 BST：

	如果 left > right，子树中不存在元素，返回空。
	
	找出中间位置右边元素：
	
		p = (left + right) // 2。
		
		如果 left + right 是偶数，随机选择 p + 0 或者 p + 1。
	
	创建根节点：root = TreeNode(nums[p])。
	
	递归创建左子树 root.left = helper(left, p - 1) 和右子树 root.right = helper(p + 1, right)。

返回 helper(0, len(nums) - 1)。

作者：LeetCode
链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/solution/jiang-you-xu-shu-zu-zhuan-huan-wei-er-cha-sou-s-15/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

 */
/*执行用时 :
1 ms
, 在所有 Java 提交中击败了
17.18%
的用户
内存消耗 :
39.8 MB
, 在所有 Java 提交中击败了
8.70%
的用户*/
public class Solution3 {
	class Solution {
		int[] nums;
		Random rand = new Random();

		public TreeNode helper(int left, int right) {
			if (left > right)
				return null;

			// choose random middle node as a root
			int p = (left + right) / 2;
			if ((left + right) % 2 == 1)
				p += rand.nextInt(2);

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
	
/*	复杂度分析

	时间复杂度：\mathcal{O}(N)O(N)，每个元素只访问一次。

	空间复杂度：\mathcal{O}(N)O(N)，二叉搜索树空间 \mathcal{O}(N)O(N)，递归栈深度 \mathcal{O}(\log N)O(logN)。

	作者：LeetCode
	链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/solution/jiang-you-xu-shu-zu-zhuan-huan-wei-er-cha-sou-s-15/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
