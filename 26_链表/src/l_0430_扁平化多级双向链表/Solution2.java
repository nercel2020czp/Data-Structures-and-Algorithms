package l_0430_扁平化多级双向链表;
/*
思路：
多级链表结构的扁平化类似二叉树的先序遍历
child就相当于left tree，next相当于right tree
需要维护一个prev指针用于访问当前节点的上一个节点
prev指针非空时，建立prev与当前节点的双向连接
处理完一个child后记得把它设为null

作者：pusheen
链接：https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list/solution/dfs-er-cha-shu-xian-xu-bian-li-java-0ms-by-pusheen/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Solution2 {
	class Solution {
		private Node prev = null;

		public Node flatten(Node head) {
			dfs(head);
			return head;
		}

		private void dfs(Node head) {
			if (head == null)
				return;
			Node next = head.next;
			if (prev != null) {
				prev.next = head;
				head.prev = prev;
			}
			prev = head;
			dfs(head.child);
			head.child = null;
			dfs(next);
		}
	}
	
/*	执行用时 :
		0 ms
		, 在所有 Java 提交中击败了
		100.00%
		的用户
		内存消耗 :
		38.3 MB
		, 在所有 Java 提交中击败了
		50.00%
		的用户*/

}
