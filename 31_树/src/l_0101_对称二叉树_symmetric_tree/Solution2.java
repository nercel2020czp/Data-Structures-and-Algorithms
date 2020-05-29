package l_0101_对称二叉树_symmetric_tree;

import java.util.LinkedList;
import java.util.Queue;

/*
方法二：迭代

除了递归的方法外，我们也可以利用队列进行迭代。
队列中每两个连续的结点应该是相等的，而且它们的子树互为镜像。
	1.最初，队列中包含的是 root 以及 root。
	2.该算法的工作原理类似于 BFS，但存在一些关键差异。
	3.每次提取两个结点并比较它们的值。
	4.然后，将两个结点的左右子结点按相反的顺序插入队列中。
	5.当队列为空时，或者我们检测到树不对称（即从队列中取出两个不相等的连续结点）时，该算法结束
*/
public class Solution2 {
	public boolean isSymmetric(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		//1.最初，队列中包含的是 root 以及 root。
		q.add(root);
		q.add(root);
		while (!q.isEmpty()) {
			//3.每次提取两个结点并比较它们的值。
			TreeNode t1 = q.poll();
			TreeNode t2 = q.poll();
			if (t1 == null && t2 == null)
				continue;
			if (t1 == null || t2 == null)
				return false;
			
			if (t1.val != t2.val)
				return false;
			//4.然后，将两个结点的左右子结点按相反的顺序插入队列中。
			q.add(t1.left);
			q.add(t2.right);
			q.add(t1.right);
			q.add(t2.left);
		}
		//5.当队列为空时，或者我们检测到树不对称（即从队列中取出两个不相等的连续结点）时，该算法结束
		return true;
	}
}
