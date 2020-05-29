package c06_Binary_Search_Tree.c13_LeetCode.l_0098_验证二叉搜索树;

import java.util.Stack;

/*
方法三：中序遍历
算法
我们使用
中序遍历
左子树 -> 结点 -> 右子树的顺序。

上面的结点按照访问的顺序标号，你可以按照 1-2-3-4-5 的顺序来比较不同的策略。
左子树 -> 结点 -> 右子树 意味着对于二叉搜索树而言，每个元素都应该比下一个元素小。
因此，具有 O(N){O}(N)O(N) 时间复杂度与 O(N){O}(N)O(N) 空间复杂度的算法十分简单:

计算中序遍历列表 inorder.
检查 inorder中的每个元素是否小于下一个。

我们需要保留整个inorder列表吗？

事实上不需要。每一步最后一个添加的元素就足以保证树是（或不是）二叉搜索树。
因此，我们可以将步骤整合并复用空间。


作者：LeetCode
链接：https://leetcode-cn.com/problems/validate-binary-search-tree/solution/yan-zheng-er-cha-sou-suo-shu-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
public class Solution3 {
	class Solution {
		public boolean isValidBST(TreeNode root) {
			Stack<TreeNode> stack = new Stack<>();
			double inorder = -Double.MAX_VALUE;

			while (!stack.isEmpty() || root != null) {
				while (root != null) {
					stack.push(root);
					root = root.left;
				}
				root = stack.pop();
				// If next element in inorder traversal
				// is smaller than the previous one
				// that's not BST.
				if (root.val <= inorder)
					return false;
				inorder = root.val;
				root = root.right;
			}
			return true;
		}
	}
	
/*	执行用时 :
		3 ms
		, 在所有 Java 提交中击败了
		20.63%
		的用户
		内存消耗 :
		39.2 MB
		, 在所有 Java 提交中击败了
		26.09%
		的用户*/
	
/*	复杂度分析


	时间复杂度 : 最坏情况下（树为二叉搜索树或破坏条件的元素是最右叶结点）为 O(N){O}(N)O(N)。


	空间复杂度 : O(N){O}(N)O(N) 用于存储 stack。

	作者：LeetCode
	链接：https://leetcode-cn.com/problems/validate-binary-search-tree/solution/yan-zheng-er-cha-sou-suo-shu-by-leetcode/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
