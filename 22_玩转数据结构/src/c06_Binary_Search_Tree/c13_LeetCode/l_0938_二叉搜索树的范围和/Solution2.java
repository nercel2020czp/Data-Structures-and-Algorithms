package c06_Binary_Search_Tree.c13_LeetCode.l_0938_二叉搜索树的范围和;
/*
解题方案
思路

标签：深度优先遍历
题意：这个题字面含义很难理解，本意就是求出所有 X >= L 且 X <= R 的值的和
递归终止条件：

当前节点为 null 时返回 0
当前节点 X < L 时则返回右子树之和
当前节点 X > R 时则返回左子树之和
当前节点 X >= L 且 X <= R 时则返回：当前节点值 + 左子树之和 + 右子树之和


注意点：通过判断X的大小能够避免遍历全部树的节点，比如下方的动图中，3 这个值就没有必要遍历

作者：guanpengchn
链接：https://leetcode-cn.com/problems/range-sum-of-bst/solution/hua-jie-suan-fa-938-er-cha-sou-suo-shu-de-fan-wei-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution2 {
/*	执行用时 :
		0 ms
		, 在所有 Java 提交中击败了
		100.00%
		的用户
		内存消耗 :
		47.5 MB
		, 在所有 Java 提交中击败了
		6.67%
		的用户*/
	class Solution {
	    int ans;
	    public int rangeSumBST(TreeNode root, int L, int R) {
	        ans = 0;
	        dfs(root, L, R);
	        return ans;
	    }

	    public void dfs(TreeNode node, int L, int R) {
	        if (node != null) {
	            if (L <= node.val && node.val <= R)
	                ans += node.val;
	            if (L < node.val)
	                dfs(node.left, L, R);
	            if (node.val < R)
	                dfs(node.right, L, R);
	        }
	    }
	}
/*
	作者：LeetCode
	链接：https://leetcode-cn.com/problems/range-sum-of-bst/solution/er-cha-sou-suo-shu-de-fan-wei-he-by-leetcode/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
