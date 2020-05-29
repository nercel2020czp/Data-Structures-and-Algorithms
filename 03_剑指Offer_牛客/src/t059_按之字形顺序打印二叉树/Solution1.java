package t059_按之字形顺序打印二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;

	public TreeNode(int val) {
		this.val = val;
	}
}
public class Solution1 {
/*	链接：https://www.nowcoder.com/questionTerminal/91b69814117f4e8097390d107d2efbe0?answerType=1&f=discussion
		来源：牛客网*/

	// 解题思路：其实就是二叉树的层级遍历，不过是在遍历的时候，需要将偶数层的节点逆序。
	// 关键点：每次只处理上次在queue中剩余的节点，这是上一层的所有节点。
	// 处理完后刚好将下一层的所有节点（包含null）又全部放了进去。
	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		if (pRoot == null) {
			return result;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(pRoot);
		boolean reverse = false;
		while (!queue.isEmpty()) {
			int size = queue.size();
			ArrayList<Integer> list = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (node == null) {
					continue;
				}
				if (!reverse) {
					list.add(node.val);
				} else {
					list.add(0, node.val);// 每次加到0的位置，就自动逆序了
				}
				queue.offer(node.left);
				queue.offer(node.right);
			}
			if (list.size() > 0) {
				result.add(list);
			}
			reverse = !reverse;//
		}
		return result;
	}
}
