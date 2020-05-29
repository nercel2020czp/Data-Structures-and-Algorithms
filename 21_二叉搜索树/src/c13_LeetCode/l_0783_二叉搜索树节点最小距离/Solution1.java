package c13_LeetCode.l_0783_二叉搜索树节点最小距离;
/*	作者：LeetCode
链接：https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/solution/er-cha-sou-suo-shu-jie-dian-zui-xiao-ju-chi-by-lee/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/

/*复杂度分析

时间复杂度：O(N)O(N)，其中 NN 为树中节点的个数。

空间复杂度：O(H)O(H)，其中 HH 为树的高度，其为递归调用 dfs 产生函数栈的大小。

作者：LeetCode
链接：https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/solution/er-cha-sou-suo-shu-jie-dian-zui-xiao-ju-chi-by-lee/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution1 {
	class Solution {
	    Integer prev, ans;
	    public int minDiffInBST(TreeNode root) {
	        prev = null;
	        ans = Integer.MAX_VALUE;
	        dfs(root);
	        return ans;
	    }

	    public void dfs(TreeNode node) {
	        if (node == null) return;
	        dfs(node.left);
	        if (prev != null)
	            ans = Math.min(ans, node.val - prev);
	        prev = node.val;
	        dfs(node.right);
	    }
	}
/*	执行用时 :
		0 ms
		, 在所有 Java 提交中击败了
		100.00%
		的用户
		内存消耗 :
		37.6 MB
		, 在所有 Java 提交中击败了
		50.00%
		的用户*/
}
