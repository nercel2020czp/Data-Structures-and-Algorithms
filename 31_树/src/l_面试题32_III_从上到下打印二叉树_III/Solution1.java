package l_面试题32_III_从上到下打印二叉树_III;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*解题思路
相比于面试题31题，只需要加一个num表示当前是第几行，如果是偶数行则对list进行反转，否则直接添加到resList中*/
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x;
	}
}

public class Solution1 {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> resList = new ArrayList<>();
		if (root == null)
			return resList;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int num = 0;
		while (!queue.isEmpty()) {
			num++;
			int size = queue.size();
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < size; i++) {
				TreeNode curNode = queue.poll();
				list.add(curNode.val);
				if (curNode.left != null)
					queue.add(curNode.left);
				if (curNode.right != null)
					queue.add(curNode.right);
			}
			//把%换成&操作效率高一点，或者使用boolean变量也可以
			if (num % 2 == 0)
				Collections.reverse(list);
			//列表反转那一步可以优化掉，list.add() 改成 LinkedList addFirst() 和 add() 搭配使用
			resList.add(list);
		}
		return resList;
	}
}
/*
优化：
if (num % 2 == 0)
	Collections.reverse(list);
//列表反转那一步可以优化掉，list.add() 改成 LinkedList addFirst() 和 add() 搭配使用
*/