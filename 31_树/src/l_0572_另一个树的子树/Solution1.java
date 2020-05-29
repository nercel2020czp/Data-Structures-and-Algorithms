package l_0572_另一个树的子树;
/*解题思路
看到题目描述，首先判断一个树是否是另一棵树的子树，很明显想到可以用递归，但是两棵树完全相同也可以看做一棵树是另一棵树的子树。
所以自然而然想到用一个判断两棵树是否相同的递归函数。
然后就上代码吧~~

作者：kelly2018
链接：https://leetcode-cn.com/problems/subtree-of-another-tree/solution/java-di-gui-ban-by-kelly2018/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution1 {
/*	执行用时 :
		4 ms
		, 在所有 Java 提交中击败了
		98.36%
		的用户
		内存消耗 :
		40.1 MB
		, 在所有 Java 提交中击败了
		60.00%
		的用户*/
	class Solution {
		public boolean isSubtree(TreeNode s, TreeNode t) {
			if (t == null)
				return true; // t 为 null 一定都是 true
			if (s == null)
				return false; // 这里 t 一定不为 null, 只要 s 为 null，肯定是 false
			return isSubtree(s.left, t) || isSubtree(s.right, t) || isSameTree(s, t);
		}

	    /**
	     * 判断两棵树是否相同
	     */
		public boolean isSameTree(TreeNode s, TreeNode t) {
			if (s == null && t == null)
				return true;
			if (s == null || t == null)
				return false;
			if (s.val != t.val)
				return false;
			return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
		}
	}

}
