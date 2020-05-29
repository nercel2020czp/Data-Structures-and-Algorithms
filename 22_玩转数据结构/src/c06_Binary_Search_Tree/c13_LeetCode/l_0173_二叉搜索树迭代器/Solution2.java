package c06_Binary_Search_Tree.c13_LeetCode.l_0173_二叉搜索树迭代器;

import java.util.Stack;

/*
方法二：受控递归
我们前面使用的方法在空间上与二叉搜索树中的节点数呈线性关系。
然而，我们不得不使用这种方法的原因是我们可以在数组上迭代，且我们不能够暂停递归，然后在某个时候启动它。

但是，如果我们可以模拟中序遍历的受控递归，那么除了堆栈用于模拟递归的空间之外，实际上不需要使用任何其他空间。

因此，这种方法的本质上是使用自定义的栈来模拟中序遍历。
也就是说，我们将采用迭代的方式来模拟中序遍历，而不是采用递归的方法；
这样做的过程中，我们能够轻松的实现这两个函数的调用，而不是用其他额外的空间。

因此，这种方法的本质上是使用自定义的栈来模拟中序遍历。
也就是说，我们将采用迭代的方式来模拟中序遍历，而不是采用递归的方法；
这样做的过程中，我们能够轻松的实现这两个函数的调用，而不是用其他额外的空间。

然而，就这两个函数的复杂性而言，会有点复杂，我们需要花一些时间来理解这种方法是否符合问题所说的渐近复杂性的要求。
让我们更加具体的看一下这个算法。

算法：
	1.初始化一个空栈 S，用于模拟二叉搜索树的中序遍历。
		中序遍历我们采用与之前相同的方法，只是我们现在使用的是自己的栈而不是系统的堆栈。
		由于我们使用自定义的数据结构，因此可以随时暂停和恢复递归。
	2.我们还要实现一个帮助函数，在实现中将一次又一次的调用它。
	     这个函数叫 _inorder_left，它将给定节点中的所有左子节点添加到栈中，
	     直到节点没有左子节点为止。如下：
	     def inorder_left(root):
		   while (root):
		     S.append(root)
		     root = root.left
    3.第一次调用 next() 函数时，必须返回二叉搜索树的最小元素，
      	然后我们模拟递归必须向前移动一步，即移动到二叉搜索树的下一个最小元素上。
      	栈的顶部始终包含 next() 函数返回的元素。
      	hasNext() 很容易实现，因为我们只需要检查栈是否为空。
      	
  	4.首先，给定二叉搜索树的根节点，我们调用函数 _inorder_left，这确保了栈顶部始终包含了 next() 函数返回的元素。
  	
  	5.假设我们调用 next()，我们需要返回二叉搜索树中的下一个最小元素，即栈的顶部元素。有两种可能性： 
  		5.1:一个是栈顶部的节点是一个叶节点。
  			这是最好的情况，因为我们什么都不用做，只需将节点从栈中弹出并返回其值。
  			所以这是个常数时间的操作。
		5.2:另一个情况是栈顶部的节点拥有右节点。
			我们不需要检查左节点，因为左节点已经添加到栈中了。
			栈顶元素要么没有左节点，要么左节点已经被处理了。
			如果栈顶部拥有右节点，那么我们需要对右节点上调用帮助函数。
			该时间复杂度取决于树的结构。

	6.next() 函数调用中，获取下一个最小的元素不需要花太多时间，但是要保证栈顶元素是 next() 函数返回的元素方面花费了一些时间。

作者：LeetCode
链接：https://leetcode-cn.com/problems/binary-search-tree-iterator/solution/er-cha-sou-suo-shu-die-dai-qi-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/

/*执行用时 :
23 ms
, 在所有 Java 提交中击败了
93.61%
的用户
内存消耗 :
45.2 MB
, 在所有 Java 提交中击败了
100.00%
的用户*/

public class Solution2 {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 * int val;
	 * TreeNode left;
	 * TreeNode right;
	 * TreeNode(int x) { val = x; }
	 * }
	 */
	class BSTIterator {

	    Stack<TreeNode> stack;

	    public BSTIterator(TreeNode root) {
	        
	        // Stack for the recursion simulation
	        this.stack = new Stack<TreeNode>();
	        
	        // Remember that the algorithm starts with a call to the helper function
	        // with the root node as the input
	        this._leftmostInorder(root);
	    }

	    private void _leftmostInorder(TreeNode root) {
	      
	        // For a given node, add all the elements in the leftmost branch of the tree
	        // under it to the stack.
	        while (root != null) {
	            this.stack.push(root);
	            root = root.left;
	        }
	    }

	    /**
	     * @return the next smallest number
	     */
	    public int next() {
	        // Node at the top of the stack is the next smallest element
	        TreeNode topmostNode = this.stack.pop();

	        // Need to maintain the invariant. If the node has a right child, call the 
	        // helper function for the right child
	        if (topmostNode.right != null) {
	            this._leftmostInorder(topmostNode.right);
	        }

	        return topmostNode.val;
	    }

	    /**
	     * @return whether we have a next smallest number
	     */
	    public boolean hasNext() {
	        return this.stack.size() > 0;
	    }
	}

}


/*复杂度分析

时间复杂度：

hasNext()：若栈中还有元素，则返回 true，反之返回 false。所以这是一个 O(1)O(1)O(1) 的操作。
next()：包含了两个主要步骤。一个是从栈中弹出一个元素，它是下一个最小的元素。这是一个 O(1)O(1)O(1) 的操作。然而，随后我们要调用帮助函数 _inorder_left ，它需要递归的，将左节点添加到栈上，是线性时间的操作，最坏的情况下为 O(N)O(N)O(N)。但是我们只对含有右节点的节点进行调用，它也不会总是处理 N 个节点。只有当我们有一个倾斜的树，才会有 N 个节点。因此该操作的平均时间复杂度仍然是 O(1)O(1)O(1)，符合问题中所要求的。


空间复杂度：O(h)O(h)O(h)，使用了一个栈来模拟递归。

作者：LeetCode
链接：https://leetcode-cn.com/problems/binary-search-tree-iterator/solution/er-cha-sou-suo-shu-die-dai-qi-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/