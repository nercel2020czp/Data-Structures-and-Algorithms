/**
 * 
 */
/**
 * @author 15753
 *
 */
package c06_Binary_Search_Tree.c13_LeetCode.l_0173_二叉搜索树迭代器;
/*
https://leetcode-cn.com/problems/binary-search-tree-iterator/
173. 二叉搜索树迭代器
实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。

调用 next() 将返回二叉搜索树中的下一个最小的数。



示例：

 bst-tree.png
 
 BSTIterator iterator = new BSTIterator(root);
iterator.next();    // 返回 3
iterator.next();    // 返回 7
iterator.hasNext(); // 返回 true
iterator.next();    // 返回 9
iterator.hasNext(); // 返回 true
iterator.next();    // 返回 15
iterator.hasNext(); // 返回 true
iterator.next();    // 返回 20
iterator.hasNext(); // 返回 false

提示：

next() 和 hasNext() 操作的时间复杂度是 O(1)，并使用 O(h) 内存，其中 h 是树的高度。
你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 中至少存在一个下一个最小的数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-search-tree-iterator
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

class BSTIterator {

    public BSTIterator(TreeNode root) {

    }
    
    // @return the next smallest number 
    public int next() {

    }
    
    // @return whether we have a next smallest number
    public boolean hasNext() {

    }
}
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * -----------------------
 *  * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
=====================【题目描述】==========================
在研究这个问题的解决方案之前，让我们来总结以下问题的陈述中要求我们实现什么。
我们有一个迭代器类，它有两个函数，即 next() 和 hasNext()。
hasNext() 函数的作用是：返回一个布尔值，表示二叉搜索树中是否还有元素。
next() 函数返回二叉搜索树中下一个最小元素。
因此，我们第一次调用 next() 函数时，应返回二叉搜索树中的最小元素；
同理，当我们最后一次调用 next() 时，应返回二叉搜索树中的最大元素。

你可能想知道迭代器的作用是什么。
本质上，迭代器可以用于迭代任何容器的对象。
就本题而言，容器是一个二叉搜索树。
如果定义了这样的一个迭代器，那么遍历的逻辑就可以被抽象出来，我们可以使用迭代器按一定顺序处理元素。

	1. new_iterator = BSTIterator(root);
	2. while (new_iterator.hasNext())
	3.     process(new_iterator.next());

现在我们知道了为数据结构设计一个迭代器类背后的原因，通常，迭代器只是逐个遍历容器的每个元素。
对于二叉搜索树，我们希望迭代器以升序返回元素。

二叉搜索树的一个重要的特性是是二叉搜索树的中序序列是升序序列；因此，中序遍历是该解决方案的核心。

作者：LeetCode
链接：https://leetcode-cn.com/problems/binary-search-tree-iterator/solution/er-cha-sou-suo-shu-die-dai-qi-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
