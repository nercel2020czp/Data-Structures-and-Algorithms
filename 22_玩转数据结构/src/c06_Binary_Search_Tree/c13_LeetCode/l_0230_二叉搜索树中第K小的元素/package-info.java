/**

 */
/**
@author 15753
 *
 */
package c06_Binary_Search_Tree.c13_LeetCode.l_0230_二叉搜索树中第K小的元素;
/*
https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/

230. 二叉搜索树中第K小的元素
给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。

说明：
你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。

示例 1:

输入: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
输出: 1
示例 2:

输入: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
输出: 3
进阶：
如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    public int kthSmallest(TreeNode root, int k) {

    }
}

===================【题目解析】====================
概述：
怎么遍历树：
深度优先搜索（DFS）
在这个策略中，我们从根延伸到某一片叶子，然后再返回另一个分支。
根据根节点，左节点，右节点的相对顺序，DFS 还可以分为前序，中序，后序。

广度优先搜索（BFS）
在这个策略中，我们逐层，从上到下扫描整个树。

图1.jpg

为了解决这个问题，可以使用 BST 的特性：BST 的中序遍历是升序序列。


作者：LeetCode
链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/solution/er-cha-sou-suo-shu-zhong-di-kxiao-de-yuan-su-by-le/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/