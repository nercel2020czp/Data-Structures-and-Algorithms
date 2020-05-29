package t017_树的子结构;
/*
题目:
	输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）

思路:
	正确理解题意：子结构到底是啥意思？很容易弄混淆的是子树和子结构，这里分别讨论一下，
	多亏楼下两个老哥指正，也在这重新总结修改一下！

子树:
	一棵大树 A，一棵小树 B，若 B 是 A 的子树，则：
		1.B 和 A 的结点值完全相同，它们俩的左子树、右子树所有结点的值也完全相同
		2.或者 B 的左孩子和 A 的结点值完全相同，它们俩的左子树、右子树所有结点的值也完全相同
		3.或者 B 的右孩子和 A 的结点值完全相同，它们俩的左子树、右子树所有结点的值也完全相同
		
		
举个形象的例子：【见图1.png】

这棵大树的子树有：

	4 和 5 对应的两棵子树
	3 本身自己完整的一棵树
	而里面的小框圈出来的不是 3 这棵大树的子树！

理解后可以写代码了，如果子树先达到 null ，那么一定是其子树

那么，判断 root2 是否是 root1 的子树如下：

*/


class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}


public class Solution1 {

	public class IsSubTree {
		public boolean HasSubtree(TreeNode root1, TreeNode root2) {
			if (root1 == null || root2 == null) {
				return false;
			}
			return judgeSubTree(root1, root2) || judgeSubTree(root1.left, root2)
					|| judgeSubTree(root1.right, root2);
		}

		private boolean judgeSubTree(TreeNode root1, TreeNode root2) {
			if (root2 == null) {
				return true;
			}
			if (root1 == null) {
				return false;
			}
			if (root1.val != root2.val) {
				return false;
			}
			return judgeSubTree(root1.left, root2.left) 
					&& judgeSubTree(root1.right, root2.right);
		}
	}
}
