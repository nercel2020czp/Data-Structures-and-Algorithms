package l_0102_二叉树的层序遍历;
/*
BFS【模板解法】
https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/tao-mo-ban-bfs-he-dfs-du-ke-yi-jie-jue-by-fuxuemin/
BFS使用队列，把每个还没有搜索到的点依次放入队列，
然后再弹出队列的头部元素当做当前遍历点。
BFS总共有两个模板：
	1.如果不需要确定当前遍历到了哪一层，BFS模板如下。
	while queue 不空：
    cur = queue.pop()
    for 节点 in cur的所有相邻节点：
        if 该节点有效且未访问过：
            queue.push(该节点)
            
    2.如果要确定当前遍历到了哪一层，BFS模板如下。
		这里增加了level表示当前遍历到二叉树中的哪一层了，也可以理解为在一个图中，
		现在已经走了多少步了。size表示在当前遍历层有多少个元素，也就是队列中的元素数，
		我们把这些元素一次性遍历完，即把当前层的所有元素都向外走了一步。

		level = 0
		while queue 不空：
	    size = queue.size()
	    while (size --) {
	        cur = queue.pop()
	        for 节点 in cur的所有相邻节点：
	            if 该节点有效且未被访问过：
	                queue.push(该节点)
	    }
	    level ++;

上面两个是通用模板，在任何题目中都可以用，是要记住的！

本题要求二叉树的层次遍历，所以同一层的节点应该放在一起，故使用模板二。

使用队列保存每层的所有节点，每次把队列里的原先所有节点进行出队列操作，
再把每个元素的非空左右子节点进入队列。因此即可得到每层的遍历。

----------------------------------------------------
解题思路
本题要求层次遍历每层结点并放入一个二维数组中

首先就创建一个二维数组用来接收最后的结果，同时做判空操作

接下来就是层次遍历用到的典型的队列，队列中每次只存放一层的结点，
然后创建一个一维数组用来接收队列中每次存放的元素

然后如果有左右孩子就将他们也入队再放入数组中，然后一维数组再放入二维数组中

等到遍历完所有的结点，返回 ans 即可。

作者：jasion_han-r
链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/20200404102medianbfsceng-ci-bian-li-by-jasion_han-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution1 {
//理解了之后记忆，核心是一个队列，技巧是遍历每层之前记录元素个数，结果是分层记录节点的值。
	class Solution {
	    public List<List<Integer>> levelOrder(TreeNode root) {
	        // 创建二维数组接收每层的结点
	        List<List<Integer>> ans = new ArrayList<>();
	        if (root == null) {
	            return ans;
	        }
	        // 创建队列依次存放每层的结点
	        Queue<TreeNode> q = new LinkedList<>();
	        q.add(root);
	        while (!q.isEmpty()) {
	            // 创建数组来接收出队的结点，存放的是每层的结点
	            List<Integer> tmp = new ArrayList<>();
	            int len = q.size();
	            for (int i = 0; i < len; i++) {
	                // 定义 node 接收出队结点，然后加入数组 tmp 中
	                TreeNode node = q.poll();
	                tmp.add(node.val);
	                // 如果有左右孩子，就依次入队、出队、进数组
	                if (node.left != null) {
	                    q.add(node.left);
	                }
	                if (node.right != null) {
	                    q.add(node.right);
	                }
/*		            if 该节点有效且未被访问过：
	                queue.push(该节点)*/
	            }
	            // 数组每次都是放的一层的结点，然后一层一层的放入二维数组中
	            ans.add(tmp);
	        }
	        return ans;
	    }
	}


/*	执行用时 :
		1 ms
		, 在所有 Java 提交中击败了
		91.36%
		的用户
		内存消耗 :
		39.9 MB
		, 在所有 Java 提交中击败了
		5.71%
		的用户*/
	
/*	作者：jasion_han-r
	链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/20200404102medianbfsceng-ci-bian-li-by-jasion_han-/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
