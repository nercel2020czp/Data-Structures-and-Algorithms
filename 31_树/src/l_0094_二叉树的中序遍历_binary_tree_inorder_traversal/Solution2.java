package l_0094_二叉树的中序遍历_binary_tree_inorder_traversal;

import java.util.ArrayList;
import java.util.List;

/*方法三：莫里斯遍历
https://leetcode.wang/leetCode-94-Binary-Tree-Inorder-Traversal.html#%E8%A7%A3%E6%B3%95%E4%B8%89-morris-traversal

根据这个关系，写代码
记当前遍历的节点为 cur。

1、cur.left 为 null，保存 cur 的值，更新 cur = cur.right
2、cur.left 不为 null，找到 cur.left 这颗子树最右边的节点记做 last
	2.1 last.right 为 null，那么将 last.right = cur，更新 cur = cur.left
	2.2 last.right 不为 null，说明之前已经访问过，第二次来到这里，
		表明当前子树遍历完成，保存 cur 的值，更新 cur = cur.right


作者：LeetCode
链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/er-cha-shu-de-zhong-xu-bian-li-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

*/
public class Solution2 {
	public List<Integer> inorderTraversal(TreeNode root) {
	    List<Integer> ans = new ArrayList<>();
	    TreeNode cur = root;
	    while (cur != null) {
	        //情况 1:cur.left 为 null，保存 cur 的值，更新 cur = cur.right
	        if (cur.left == null) {
	            ans.add(cur.val);
	            cur = cur.right;
	        } else {
        	//情况 2：cur.left 不为 null，找到 cur.left 这颗子树最右边的节点记做 last
	            //找左子树最右边的节点
	            TreeNode pre = cur.left;
	            while (pre.right != null && pre.right != cur) {
	                pre = pre.right;
	            }
	            //情况 2.1：last.right 为 null，那么将 last.right = cur，更新 cur = cur.left
	            if (pre.right == null) {
	                pre.right = cur;
	                cur = cur.left;
	            }
	            //情况 2.2：last.right 不为 null，说明之前已经访问过，第二次来到这里，
	    		//表明当前子树遍历完成，保存 cur 的值，更新 cur = cur.right
	            if (pre.right == cur) {
	                pre.right = null; //这里可以恢复为 null
	                ans.add(cur.val);
	                cur = cur.right;
	            }
	        }
	    }
	    return ans;
	}
 
	
	/*
	 * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗 : 37.4 MB , 在所有 Java 提交中击败了
	 * 5.13% 的用户
	 */
	

/*	复杂度分析

	时间复杂度：O(n)。 想要证明时间复杂度是O(n)，最大的问题是找到每个节点的前驱节点的时间复杂度。
	乍一想，找到每个节点的前驱节点的时间复杂度应该是 O(nlogn)，因为找到一个节点的前驱节点和树的高度有关。
	但事实上，找到所有节点的前驱节点只需要O(n) 时间。一棵 n 个节点的二叉树只有 n−1 条边，每条边只可能使用2次，
	一次是定位节点，一次是找前驱节点。

	故复杂度为 O(n)。

	空间复杂度：O(n)。使用了长度为 n 的数组。

	作者：LeetCode
	链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/er-cha-shu-de-zhong-xu-bian-li-by-leetcode/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
