package l_0101_对称二叉树_symmetric_tree;
/*
方法：递归
如果一个树的左子树与右子树镜像对称，那么这个树是对称的。
		如   图1.png


因此，该问题可以转化为：两个树在什么情况下互为镜像？
如果同时满足下面的条件，两个树互为镜像：
	1.它们的两个根结点具有相同的值。
	2.每个树的右子树都与另一个树的左子树镜像对称。
	
就像人站在镜子前审视自己那样。镜中的反射与现实中的人具有相同的头部，
但反射的右臂对应于人的左臂，反之亦然。	


复杂度分析
	1.时间复杂度：O(n)，因为我们遍历整个输入树一次，所以总的运行时间为 O(n)，其中 nn 是树中结点的总数。
	2.空间复杂度：递归调用的次数受树的高度限制。在最糟糕情况下，树是线性的，其高度为 O(n)。
		因此，在最糟糕的情况下，由栈上的递归调用造成的空间复杂度为 O(n)。

作者：LeetCode
链接：https://leetcode-cn.com/problems/symmetric-tree/solution/dui-cheng-er-cha-shu-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

上面的解释可以很自然地转换为一个递归函数，如下所示：
*/
/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution1 {
	public boolean isSymmetric(TreeNode root) {
		return isMirror(root, root);
	}

	public boolean isMirror(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null)
			return true;
		if (t1 == null || t2 == null)
			return false;
		return (t1.val == t2.val) 
				&& isMirror(t1.right, t2.left) 
				&& isMirror(t1.left, t2.right);
	}
/*	执行用时 :
		0 ms
		, 在所有 Java 提交中击败了
		100.00%
		的用户
		内存消耗 :
		37.5 MB
		, 在所有 Java 提交中击败了
		33.41%
		的用户*/
}
