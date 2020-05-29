package l_0156_上下翻转二叉树;
/*Binary Tree Upside Down (Top-down迭代法)
Krahets
发布于 9 个月前
1.5k
根据题目描述，树中任何节点的右子节点若存在一定有左子节点，因此思路是向左遍历树进行转化；
规律是：左子节点变父节点；父节点变右子节点；右子节点变父节点。
对于某节点root，修改root.left，root.right之前，需要将三者都存下来：
root.left是下一轮递归的主节点；
root是下一轮递归root的root.right；
root.right是下一轮递归root的root.left。
返回parent。*/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
	public TreeNode upsideDownBinaryTree(TreeNode root) {
		TreeNode parent = null, parent_right = null;
		while (root != null) {
			TreeNode root_left = root.left;
			root.left = parent_right;
			parent_right = root.right;
			root.right = parent;
			parent = root;
			root = root_left;
		}
		return parent;
	}
/*	执行用时 :
		0 ms
		, 在所有 Java 提交中击败了
		100.00%
		的用户
		内存消耗 :
		37.2 MB
		, 在所有 Java 提交中击败了
		6.45%
		的用户*/
}
