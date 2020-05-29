package c06_Binary_Search_Tree.c13_LeetCode.l_0235_二叉搜索树的最近公共祖先;
/*方法二 （迭代）
算法
这个方法跟方法一很接近。唯一的不同是，我们用迭代的方式替代了递归来遍历整棵树。
由于我们不需要回溯来找到 LCA 节点，所以我们是完全可以不利用栈或者是递归的。
实际上这个问题本身就是可以迭代的，我们只需要找到分割点就可以了。
这个分割点就是能让节点 ppp 和节点 qqq 不能在同一颗子树上的那个节点，或者是节点 ppp 
和节点 qqq 中的一个，这种情况下其中一个节点是另一个节点的父亲节点。

作者：LeetCode
链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/solution/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian--2/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
public class Solution2 {
	class Solution {
	    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

	        // Value of p
	        int pVal = p.val;

	        // Value of q;
	        int qVal = q.val;

	        // Start from the root node of the tree
	        TreeNode node = root;

	        // Traverse the tree
	        while (node != null) {

	            // Value of ancestor/parent node.
	            int parentVal = node.val;

	            if (pVal > parentVal && qVal > parentVal) {
	                // If both p and q are greater than parent
	                node = node.right;
	            } else if (pVal < parentVal && qVal < parentVal) {
	                // If both p and q are lesser than parent
	                node = node.left;
	            } else {
	                // We have found the split point, i.e. the LCA node.
	                return node;
	            }
	        }
	        return null;
	    }
	}
/*	执行用时 :
		7 ms
		, 在所有 Java 提交中击败了
		57.33%
		的用户
		内存消耗 :
		40.6 MB
		, 在所有 Java 提交中击败了
		6.06%
		的用户*/
}
