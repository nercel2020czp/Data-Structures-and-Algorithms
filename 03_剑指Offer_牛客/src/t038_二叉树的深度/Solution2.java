package t038_二叉树的深度;
//非递归：利用队列，count是当前的节点，nextcount是当前深度总的节点。
//【总是要遍历到当前深度的最后一个节点，深度才加1】
import java.util.LinkedList;
import java.util.Queue;
public class Solution2 {
	public int TreeDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		int d = 0, count = 0, nextcount = q.size();
		while (q.size() != 0) {
			TreeNode t = q.poll();
			count++;
			if (t.left != null) {
				q.add(t.left);
			}
			if (t.right != null) {
				q.add(t.right);
			}
			if (count == nextcount) {
				d++;
				count = 0;
				nextcount = q.size();
			}
		}
		return d;
	}
}
