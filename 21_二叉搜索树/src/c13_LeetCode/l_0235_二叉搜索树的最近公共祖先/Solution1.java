package c13_LeetCode.l_0235_二叉搜索树的最近公共祖先;
/*
方法一 （递归）
思路:
	
	节点 ppp，qqq 的最近公共祖先（LCA）是距离这两个节点最近的公共祖先节点。
	在这里 最近 考虑的是节点的深度。下面这张图能帮助你更好的理解 最近 这个词的含义。
	
	图1.png
	
	笔记：ppp 和 qqq 其中的一个在 LCA 节点的左子树上，另一个在 LCA 节点的右子树上。
	
	也有可能是下面这种情况：

	图2.png
	
算法:
	1.从根节点开始遍历树
	2.如果节点 ppp 和节点 qqq 都在右子树上，那么以右孩子为根节点继续 1 的操作
	3.如果节点 ppp 和节点 qqq 都在左子树上，那么以左孩子为根节点继续 1 的操作
	4.如果条件 2 和条件 3 都不成立，这就意味着我们已经找到节 ppp 和节点 qqq 的 LCA 了

作者：LeetCode
链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/solution/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian--2/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

作者：LeetCode
链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/solution/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian--2/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
/*执行用时 :
6 ms
, 在所有 Java 提交中击败了
99.88%
的用户
内存消耗 :
39.8 MB
, 在所有 Java 提交中击败了
6.06%
的用户*/
public class Solution1 {
	class Solution {
		public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

			// Value of current node or parent node.
			int parentVal = root.val;

			// Value of p
			int pVal = p.val;

			// Value of q;
			int qVal = q.val;

			if (pVal > parentVal && qVal > parentVal) {
				// If both p and q are greater than parent
				return lowestCommonAncestor(root.right, p, q);
			} else if (pVal < parentVal && qVal < parentVal) {
				// If both p and q are lesser than parent
				return lowestCommonAncestor(root.left, p, q);
			} else {
				// We have found the split point, i.e. the LCA node.
				return root;
			}
		}
	}
/*	复杂度分析


	时间复杂度：O(N)O(N)O(N)
	其中 NNN 为 BST 中节点的个数，在最坏的情况下我们可能需要访问 BST 中所有的节点。


	空间复杂度：O(N)O(N)O(N)
	所需开辟的额外空间主要是递归栈产生的，之所以是 NNN 是因为 BST 的高度为 NNN。

	作者：LeetCode
	链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/solution/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian--2/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
/*	作者：LeetCode
	链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/solution/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian--2/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
