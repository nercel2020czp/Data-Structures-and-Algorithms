/**

 */
/**
@author 15753
 *
 */
package l_0103_二叉树的锯齿形层次遍历;
/*https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
103. 二叉树的锯齿形层次遍历
给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回锯齿形层次遍历如下：

[
  [3],
  [20,9],
  [15,7]
]

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

    }
}
思路:
上一题一样102. 二叉树的层次遍历

思路一:BFS

思路二:DFS
 */