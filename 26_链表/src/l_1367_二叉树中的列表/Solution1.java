package l_1367_二叉树中的列表;
/*
先序遍历+递归
解题思路
路径匹配的递归，有两种情况需要考虑
	1.1.root.val != head.val 这个时候，head不变，root进入左右子树，判断左右子树是否和head匹配
	2.2.root.val == head.val 这个时候递归进入左右子树，head变为head.next。
		如果左右子树匹配过程中，出现了匹配不上的情况，这个时候，需要回到root和head的情况，
		重新进入到root.val != head.val这种不匹配的情况。
		
	相等匹配的情况，如果head为空，表示匹配完成，treeNode为空以及head.val != treeNode.val表示匹配失败
	
耗时1ms

作者：burning-summer
链接：https://leetcode-cn.com/problems/linked-list-in-binary-tree/solution/xian-xu-bian-li-di-gui-by-shi-huo-de-xia-tian/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution1 {
/*	执行用时 :
		2 ms
		, 在所有 Java 提交中击败了
		52.80%
		的用户
		内存消耗 :
		40.5 MB
		, 在所有 Java 提交中击败了
		100.00%
		的用户*/
	class Solution {
	    public boolean isSubPath(ListNode head, TreeNode root) {
	        if (root == null){
	            return false;
	        }
	        // 相等的匹配
	        if (root.val == head.val){
	            boolean isSub = matchSubPath(head.next,root.left) || matchSubPath(head.next,root.right);
	            if (isSub){
	                // 匹配上了，返回true
	                return true;
	            }
	            // 不匹配，要进入不等的匹配
	        }
	        // 匹配不上，ListNode不变，进入左右子树
	        return isSubPath(head,root.left) || isSubPath(head,root.right);
	    }

	    /**
	     * root.val == head.val的匹配,考虑剪枝
	     * @param head
	     * @param node
	     * @return
	     */
	    private boolean matchSubPath(ListNode head, TreeNode node){
	        // 链表匹配结束，匹配上
	        if (head == null){
	            return true;
	        }
	        // 树节点空了，无法匹配
	        if (node == null){
	            return false;
	        }
	        // 不相等的，无法匹配
	        if (head.val != node.val){
	            return false;
	        }
	        // 相等继续进入左右子树，和链表的next节点匹配
	        return matchSubPath(head.next,node.left) || matchSubPath(head.next,node.right);
	    }
	}

}
