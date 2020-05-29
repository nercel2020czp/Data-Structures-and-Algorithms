package l_0429_N叉树的层序遍历;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*方法一：利用队列实现广度优先搜索
我们要构造一个 sub-lists 列表，其中每个 sub-list 是树中一行的值。
行应该按从上到下的顺序排列。

因为我们从根节点开始遍历树，然后向下搜索最接近根节点的节点，这是广度优先搜索。
我们使用队列来进行广度优先搜索，队列具有先进先出的特性。

在这里使用栈是错误的选择，栈应用于深度优先搜索。

让我们在树上使用基于队列的遍历算法，看看它的作用。
这是你应该记住的一个基本算法。

	List<Integer> values = new ArrayList<>();
	Queue<Node> queue = new LinkedList<>();
	queue.add(root);
	while (!queue.isEmpty()) {
	    Node nextNode = queue.remove();
	    values.add(nextNode.val);
	    for (Node child : nextNode.children) {
	        queue.add(child);
	    }
	}
	
算法：
上面的基本算法在一定程度上帮助了我们解决这道题目，但是我们还需要保存每一层的列表，并且在根节点为空时正常工作。

再构造下一层的列表时，我们需要创建新的子列表，然后将该层的所有节点的值插入到列表中。
一个很好的方法时在 while 循环体开始时记录队列的当前大小 size。
然后用另一个循环来处理 size 数量的节点。这样可以保证 while 循环在每一次迭代处理一层。

使用队列十分重要，如果使用 Vector，List，Array 的话，我们删除元素需要 O(n)O(n) 的时间复杂度。
而队列删除元素只需要 O(1)O(1) 的时间。

复杂度分析

时间复杂度：O(n)O(n)。nn 指的是节点的数量。
空间复杂度：O(n)O(n)。


作者：LeetCode
链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/solution/ncha-shu-de-ceng-xu-bian-li-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/

/*执行用时 :
3 ms
, 在所有 Java 提交中击败了
80.02%
的用户
内存消耗 :
40.8 MB
, 在所有 Java 提交中击败了
75.00%
的用户*/

public class Solution2 {
	// This code is a modified version of the code posted by
	// #zzzliu on the discussion forums.
	class Solution {

	    public List<List<Integer>> levelOrder(Node root) {      
	        List<List<Integer>> result = new ArrayList<>();
	        if (root == null) return result;
	        Queue<Node> queue = new LinkedList<>();
	        queue.add(root);
	        while (!queue.isEmpty()) {
	            List<Integer> level = new ArrayList<>();
	            int size = queue.size();
	            for (int i = 0; i < size; i++) {
	                Node node = queue.poll();
	                level.add(node.val);
	                queue.addAll(node.children);
	            }
	            result.add(level);
	        }
	        return result;
	    }
	}

/*	作者：LeetCode
	链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/solution/ncha-shu-de-ceng-xu-bian-li-by-leetcode/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
