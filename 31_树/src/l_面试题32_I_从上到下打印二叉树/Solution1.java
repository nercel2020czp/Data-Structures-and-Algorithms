package l_面试题32_I_从上到下打印二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
解题思路：
	题目要求的二叉树的 从上至下 打印（即按层打印），又称为二叉树的 广度优先搜索（BFS）。
	BFS 通常借助 队列 的先入先出特性来实现。

【见图1.png】

算法流程：
	1.特例处理： 当树的根节点为空，则直接返回空列表 [] ；
	2.初始化： 打印结果列表 res = [] ，包含根节点的队列 queue = [root] ；
	3.BFS 循环： 当队列 queue 为空时跳出；
		3.1 出队： 队首元素出队，记为 node；
		3.2 打印： 将 node.val 添加至列表 tmp 尾部；
		3.3 添加子节点： 若 node 的左（右）子节点不为空，则将左（右）子节点加入队列 queue ；
	4.返回值： 返回打印结果列表 res 即可。

复杂度分析：
	时间复杂度 O(N) ： NN 为二叉树的节点数量，即 BFS 需循环 N 次。
	空间复杂度 O(N) ： 最差情况下，即当树为平衡二叉树时，最多有 N/2 个树节点同
	时在 queue 中，使用 O(N) 大小的额外空间。

作者：jyd
链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/solution/mian-shi-ti-32-i-cong-shang-dao-xia-da-yin-er-ch-4/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

*/
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x;
	}
}

public class Solution1 {
/*	算法流程：
	1.特例处理： 当树的根节点为空，则直接返回空列表 [] ；
	2.初始化： 打印结果列表 res = [] ，包含根节点的队列 queue = [root] ；
	3.BFS 循环： 当队列 queue 为空时跳出；
		3.1 出队： 队首元素出队，记为 node；
		3.2 打印： 将 node.val 添加至列表 tmp 尾部；
		3.3 添加子节点： 若 node 的左（右）子节点不为空，则将左（右）子节点加入队列 queue ；
	4.返回值： 返回打印结果列表 res 即可。*/
	public int[] levelOrder(TreeNode root) {
		if (root == null)
			return new int[0];
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		ArrayList<Integer> ans = new ArrayList<>();
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			ans.add(node.val);
			if (node.left != null)
				queue.add(node.left);
			if (node.right != null)
				queue.add(node.right);
		}
		int[] res = new int[ans.size()];
		for (int i = 0; i < ans.size(); i++)
			res[i] = ans.get(i);
		return res;
	}
/*	执行用时 :
		1 ms
		, 在所有 Java 提交中击败了
		97.87%
		的用户
		内存消耗 :
		38.6 MB
		, 在所有 Java 提交中击败了
		100.00%
		的用户*/
}
