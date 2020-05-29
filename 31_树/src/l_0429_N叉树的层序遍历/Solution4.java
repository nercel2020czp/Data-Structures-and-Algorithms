package l_0429_N叉树的层序遍历;

import java.util.ArrayList;
import java.util.List;

/*
方法三：递归
算法：
我们可以使用递归来解决这个问题，通常我们不能使用递归进行广度优先搜索。
这是因为广度优先搜索基于队列，而递归运行时使用堆栈，适合深度优先搜索。
但是在本题中，我们可以以不同的顺序添加到最终列表中，
只要我们知道节点在哪一层并确保在那一层的列表顺序正确就可以了。

作者：LeetCode
链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/solution/ncha-shu-de-ceng-xu-bian-li-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
public class Solution4 {
	
/*	复杂度分析

	时间复杂度：O(n)O(n)。nn 指的是节点的数量
	空间复杂度：正常情况 O(\log n)O(logn)，最坏情况 O(n)O(n)。运行时在堆栈上的空间。

*/	
/*	执行用时 :
		1 ms
		, 在所有 Java 提交中击败了
		100.00%
		的用户
		内存消耗 :
		40.5 MB
		, 在所有 Java 提交中击败了
		100.00%
		的用户*/
	
	class Solution {

	    private List<List<Integer>> result = new ArrayList<>();

	    public List<List<Integer>> levelOrder(Node root) {
	        if (root != null) traverseNode(root, 0);
	        return result;
	    }

	    private void traverseNode(Node node, int level) {
	        if (result.size() <= level) {
	            result.add(new ArrayList<>());
	        }
	        result.get(level).add(node.val);
	        for (Node child : node.children) {
	            traverseNode(child, level + 1);
	        }
	    }
	}

/*	作者：LeetCode
	链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/solution/ncha-shu-de-ceng-xu-bian-li-by-leetcode/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
