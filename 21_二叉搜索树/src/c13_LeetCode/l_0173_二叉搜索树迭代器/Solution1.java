package c13_LeetCode.l_0173_二叉搜索树迭代器;

import java.util.ArrayList;

/*
方法一：扁平化二叉搜索树

在计算机程序设计中，迭代器是使程序员能够遍历容器的对象。这是维基百科对迭代器的定义。
当前，实现迭代器的最简单的方法是在类似数组的容器接口上。
如果我们有一个数组，则我们只需要一个指针或者索引，就可以轻松的实现函数 next() 和 hasNext()。

因此，我们要研究的第一种方法就是基于这种思想。我们将使用额外的数组，并将二叉搜索树展开存放到里面。
我们想要数组的元素按升序排序，则我们应该对二叉搜索树进行中序遍历，然后我们在数组中构建迭代器函数。

算法：
	1.初始化一个空数组用来存放二叉搜索树的中序序列。
	2.我们按中序遍历二叉搜索树，按照左中右的顺序处理节点。
	3.一旦所有节点都在数组中，则我们只需要一个指针或索引来实现 next() 和 hasNext 这两个函数。
		每当调用 hasNext() 时，我们只需要检查索引是否达到数组末尾。
		每当调用 next() 时，我们只需要返回索引指向的元素，并向前移动一步，以模拟迭代器的进度。


作者：LeetCode
链接：https://leetcode-cn.com/problems/binary-search-tree-iterator/solution/er-cha-sou-suo-shu-die-dai-qi-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution1 {
	
/*	执行用时 :
		21 ms
		, 在所有 Java 提交中击败了
		99.54%
		的用户
		内存消耗 :
		44.8 MB
		, 在所有 Java 提交中击败了
		100.00%
		的用户*/
	
	class BSTIterator {

	    ArrayList<Integer> nodesSorted;
	    int index;

	    public BSTIterator(TreeNode root) {

	        // Array containing all the nodes in the sorted order
	        this.nodesSorted = new ArrayList<Integer>();
	        
	        // Pointer to the next smallest element in the BST
	        this.index = -1;
	        
	        // Call to flatten the input binary search tree
	        this._inorder(root);
	    }

	    private void _inorder(TreeNode root) {

	        if (root == null) {
	            return;
	        }

	        this._inorder(root.left);
	        this.nodesSorted.add(root.val);
	        this._inorder(root.right);
	    }

	    /**
	     * @return the next smallest number
	     */
	    public int next() {
	        return this.nodesSorted.get(++this.index);
	    }

	    /**
	     * @return whether we have a next smallest number
	     */
	    public boolean hasNext() {
	        return this.index + 1 < this.nodesSorted.size();
	    }
	}
/*	
	复杂度分析:
	时间复杂度：构造迭代器花费的时间为 O(N)O(N)，问题陈述只要求我们分析两个函数的复杂性，
	但是在实现类时，还要注意初始化类对象所需的时间；
	在这种情况下，时间复杂度与二叉搜索树中的节点数成线性关系。
	next()：O(1)O(1)
	hasNext()：O(1)O(1)
	
	空间复杂度：O(N)O(N)，由于我们创建了一个数组来包含二叉搜索树中的所有节点值，这不符合问题陈述中的要求，任一函数的最大空间复杂度应为 O(h)O(h)，其中 hh 指的是树的高度，对于平衡的二叉搜索树，高度通常为 logNlogN。


	作者：LeetCode
	链接：https://leetcode-cn.com/problems/binary-search-tree-iterator/solution/er-cha-sou-suo-shu-die-dai-qi-by-leetcode/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
	*/
}
