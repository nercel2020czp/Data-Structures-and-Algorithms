/**

 */
/**
@author 15753
 *
 */
package c13_LeetCode.l_0099_恢复二叉搜索树;
/*
99. 恢复二叉搜索树【困难】
https://leetcode-cn.com/problems/recover-binary-search-tree/

99. 恢复二叉搜索树
二叉搜索树中的两个节点被错误地交换。

请在不改变其结构的情况下，恢复这棵树。

示例 1:

输入: [1,3,null,null,2]

   1
  /
 3
  \
   2

输出: [3,1,null,null,2]

   3
  /
 1
  \
   2
示例 2:

输入: [3,1,4,null,null,2]

  3
 / \
1   4
   /
  2

输出: [2,1,4,null,null,3]

  2
 / \
1   4
   /
  3
进阶:

使用 O(n) 空间复杂度的解法很容易实现。
你能想出一个只使用常数空间的解决方案吗？

===================【】======================
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    public void recoverTree(TreeNode root) {
        
    }
}

========================【题目分析】==============================
思路:
这道题难点,是找到那两个交换节点,把它交换过来就行了.

这里我们二叉树搜索树的中序遍历(中序遍历遍历元素是递增的)

如下图所示, 中序遍历顺序是 4,2,3,1,我们只要找到节点4和节点1交换顺序即可!

这里我们有个规律发现这两个节点:

第一个节点,是第一个按照中序遍历时候前一个节点大于后一个节点,我们选取前一个节点,这里指节点4;

第二个节点,是在第一个节点找到之后, 后面出现前一个节点大于后一个节点,我们选择后一个节点,这里指节点1;

图1.png

对于中序遍历,我们有两种方法.

方法一: 迭代

方法二: 递归

详细链接 关于树遍历.
*/