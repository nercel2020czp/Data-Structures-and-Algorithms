package c06_Binary_Search_Tree.c13_LeetCode.l_0099_恢复二叉搜索树;
/*
解法三 Morris Traversal
	解法一和解法二本质上是一致的，都需要 O（h）的空间来保存上一层的信息。
	而我们注意到中序遍历，就是遍历完左子树，然后遍历根节点。
	如果我们把当前根节点存起来，然后遍历左子树，左子树遍历完以后回到当前根节点就可以了，怎么做到呢？
Morris 版中序遍历
因为之前这个方法中用了 pre 变量，为了方便，这里也需要 pre 变量，我们用 pre_new 代替。
具体 Morris 遍历算法参见 94 题 。利用 Morris 的话，我们的空间复杂度终于达到了 O（1）。


根据这个关系，写代码
记当前遍历的节点为 cur。

1、cur.left 为 null，保存 cur 的值，更新 cur = cur.right
2、cur.left 不为 null，找到 cur.left 这颗子树最右边的节点记做 last
	2.1 last.right 为 null，那么将 last.right = cur，更新 cur = cur.left
	2.2 last.right 不为 null，说明之前已经访问过，第二次来到这里，
		表明当前子树遍历完成，保存 cur 的值，更新 cur = cur.right
作者：windliang
链接：https://leetcode-cn.com/problems/recover-binary-search-tree/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-21/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
/*
执行用时 :
2 ms
, 在所有 Java 提交中击败了
100.00%
的用户
内存消耗 :
40.4 MB
, 在所有 Java 提交中击败了
12.50%
的用户
*/
public class Solution3 {
	public void recoverTree(TreeNode root) {
	    TreeNode first = null;
	    TreeNode second = null;
	    TreeNode cur = root;
	    TreeNode pre_new = null;
	    while (cur != null) {
	        // 情况 1
	        if (cur.left == null) {
	            /*******************************************************/
	            if (pre_new != null && cur.val < pre_new.val) {
	                if (first == null) {
	                    first = pre_new;
	                    second = cur;
	                } else {
	                    second = cur;
	                }
	            }
	            pre_new = cur;
	            /*******************************************************/
	            cur = cur.right;
	        } else {
	            // 找左子树最右边的节点
	            TreeNode pre = cur.left;
	            while (pre.right != null && pre.right != cur) {
	                pre = pre.right;
	            }
	            // 情况 2.1
	            if (pre.right == null) {
	                pre.right = cur;
	                cur = cur.left;
	            }
	            // 情况 2.2
	            if (pre.right == cur) {
	                pre.right = null; // 这里可以恢复为 null
	                /*******************************************************/
	                if (pre_new != null && cur.val < pre_new.val) {
	                    if (first == null) {
	                        first = pre_new;
	                        second = cur;
	                    } else {
	                        second = cur;
	                    }
	                }
	                pre_new = cur;
	                /*******************************************************/
	                cur = cur.right;
	            }
	        }
	    }
	    
	    int temp = first.val;
	    first.val = second.val;
	    second.val = temp;
	}

/*	作者：windliang
	链接：https://leetcode-cn.com/problems/recover-binary-search-tree/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-21/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
