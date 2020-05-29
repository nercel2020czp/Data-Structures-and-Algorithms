package t060_把二叉树打印成多行;
/*解题思路：
建议先做 面试题32 - I. 从上到下打印二叉树 再做此题，两题仅有微小区别，即本题需将 每一层打印到一行 。

I. 按层打印： 题目要求的二叉树的 从上至下 打印（即按层打印），又称为二叉树的 广度优先搜索（BFS）。
	BFS 通常借助 队列 的先入先出特性来实现。
II. 每层打印到一行： 若将二叉树从上至下分为多层，则通过访问 某层所有节点的 左右子节点 ，可统计出 下一层的所有节点 。
	根据此特性，可在打印本层全部节点时，将下一层全部节点加入队列，以此类推，即可分为多行打印。
	
算法流程：
	1.特例处理： 当树的根节点为空，则直接返回空列表 [] ；
	2.初始化： 打印结果列表 res = [] ，包含根节点的队列 queue = [root] ；
	3.BFS 循环： 当队列 queue 为空时跳出；
		3.1新建一个临时列表 tmp ，用于存储当前层打印结果；
		3.2当前层打印循环： 循环次数为队列 queue 长度（队列中元素为所有当前层节点）；
			3.2.1 出队： 队首元素出队，记为 node；
			3.2.2 打印： 将 node.val 添加至列表 tmp 尾部；
			3.2.3添加子节点： 若 node 的左（右）子节点不为空，则将左（右）子节点加入队列 queue ；
		3.3 将当前层结果 tmp 添加入 res 。
	4.返回值： 返回打印结果列表 res 即可。
	
复杂度分析：
	时间复杂度 O(N) ：
	 	N 为二叉树的节点数量，即 BFS 需循环 N 次。
	空间复杂度 O(N) ：
	 	最差情况下，即当树为平衡二叉树时，最多有 N/2 个树节点同时在 queue 中，使用 O(N) 大小的额外空间。*/
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;

	public TreeNode(int val) {
		this.val = val;
	}
}

public class Solution1 {
	ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if (pRoot == null) {
			return res;
		}
		ArrayList<Integer> list;
		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode cur;
		queue.offer(pRoot);
		while (!queue.isEmpty()) {
			list = new ArrayList<>();
			int size = queue.size();
			while (size > 0) { // 记录上一层的size
				cur = queue.poll();
				list.add(cur.val);
				if (cur.left != null)
					queue.offer(cur.left);
				if (cur.right != null)
					queue.offer(cur.right);
				size--;
			}
			res.add(list);
		}
		return res;
	}
}
