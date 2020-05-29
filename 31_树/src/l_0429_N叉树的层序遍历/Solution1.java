package l_0429_N叉树的层序遍历;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
解题思路：
和102.二叉树的层遍历很相似，把取二叉树的left和right改为遍历children的list即可，注意children需要判空。

*/
class Node {
	public int val;
	public List<Node> children;

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, List<Node> _children) {
		val = _val;
		children = _children;
	}
}

public class Solution1 {
	
/*	执行用时 :
		4 ms
		, 在所有 Java 提交中击败了
		60.43%
		的用户
		内存消耗 :
		40.7 MB
		, 在所有 Java 提交中击败了
		75.00%
		的用户*/
	
	class Solution {
		public List<List<Integer>> levelOrder(Node root) {
			List<List<Integer>> result = new ArrayList<>();
			if (root == null) {
				return result;
			}
			Queue<Node> queue = new LinkedList<>();
			queue.offer(root);

			while (!queue.isEmpty()) {
				int size = queue.size();
				List<Integer> level = new ArrayList<>();
				for (int i = 0; i < size; i++) {
					Node curr = queue.poll();
					level.add(curr.val);
					List<Node> children = curr.children;
					for (Node child : children) {
						if (child != null) {
							queue.add(child);
						}
					}
//		            for (int i = 0; i < size; i++) {
//		                Node node = queue.poll();
//		                level.add(node.val);
//		                queue.addAll(node.children);
//		            }
				}
				result.add(level);
			}

			return result;
		}
	}

/*	作者：alex-3b
	链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/solution/javayan-du-you-xian-bian-li-by-alex-3b/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
