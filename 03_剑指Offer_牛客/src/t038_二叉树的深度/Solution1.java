package t038_二叉树的深度;

/*二叉树：二叉树是每个结点最多有两个子树的树结构。通常子树被称作“左子树”（left subtree）和“右子树”（right subtree）。
二叉树常被用于实现二叉查找树和二叉堆。
题目：求二叉树的深度，从根节点到字节点的最长路径。
递归求法：
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
	public int TreeDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = TreeDepth(root.left);
		int right = TreeDepth(root.right);
		return Math.max(left, right) + 1;
	}
}
