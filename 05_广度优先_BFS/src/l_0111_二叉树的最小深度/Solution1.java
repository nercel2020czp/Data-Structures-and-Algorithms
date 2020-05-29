package l_0111_二叉树的最小深度;

import java.util.LinkedList;
import java.util.Queue;

/*
怎么套到 BFS 的框架里呢？
首先明确一下起点start和终点target是什么，怎么判断到达了终点？
显然起点就是root根节点，终点就是最靠近根节点的那个「叶子节点」嘛，
叶子节点就是两个子节点都是null的节点：

*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution1 {
	int minDepth(TreeNode root) {
	    if (root == null) return 0;
	    Queue<TreeNode> q = new LinkedList<>();
	    q.offer(root);
	    // root 本身就是一层，depth 初始化为 1
	    int depth = 1;

	    while (!q.isEmpty()) {
	        int sz = q.size();
	        /* 将当前队列中的所有节点向四周扩散 */
	        for (int i = 0; i < sz; i++) {
	            TreeNode cur = q.poll();
	            /* 判断是否到达终点 */
	            if (cur.left == null && cur.right == null) 
	                return depth;
	            /* 将 cur 的相邻节点加入队列 */
	            if (cur.left != null)
	                q.offer(cur.left);
	            if (cur.right != null) 
	                q.offer(cur.right);
	        }
	        /* 这里增加步数 */
	        depth++;
	    }
	    return depth;
	}
}
/*

二叉树是很简单的数据结构，我想上述代码你应该可以理解的吧，
其实其他复杂问题都是这个框架的变形，在探讨复杂问题之前，我们解答两个问题：
 
1、为什么 BFS 可以找到最短距离，DFS 不行吗？
 首先，你看 BFS 的逻辑，depth每增加一次，队列中的所有节点都向前迈一步，
 这保证了第一次到达终点的时候，走的步数是最少的。
 
 DFS 不能找最短路径吗？其实也是可以的，但是时间复杂度相对高很多。
 
 你想啊，DFS 实际上是靠递归的堆栈记录走过的路径，你要找到最短路径，
 肯定得把二叉树中所有树杈都探索完才能对比出最短的路径有多长对不对？
 
 而 BFS 借助队列做到一次一步「齐头并进」，
 是可以在不遍历完整棵树的条件下找到最短距离的。
 
 形象点说，DFS 是线，BFS 是面；DFS 是单打独斗，BFS 是集体行动。这个应该比较容易理解吧。
 
 2、既然 BFS 那么好，为啥 DFS 还要存在？

BFS 可以找到最短距离，但是空间复杂度高，而 DFS 的空间复杂度较低。

还是拿刚才我们处理二叉树问题的例子，假设给你的这个二叉树是满二叉树，
节点总数为N，对于 DFS 算法来说，空间复杂度无非就是递归堆栈，最坏情
况下顶多就是树的高度，也就是O(logN)。

但是你想想 BFS 算法，队列中每次都会储存着二叉树一层的节点，
这样的话最坏情况下空间复杂度应该是树的最底层节点的数量，也就
是N/2，用 Big O 表示的话也就是O(N)。

由此观之，BFS 还是有代价的，一般来说在找最短路径的时候使用 BFS，
其他时候还是 DFS 使用得多一些（主要是递归代码好写）。

好了，现在你对 BFS 了解得足够多了，下面来一道难一点的题目，深化一下框架的理解吧。

三、解开密码锁的最少次数
 
 
 
 */
