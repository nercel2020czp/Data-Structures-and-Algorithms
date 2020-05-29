package l_0147_对链表进行插入排序;
/*
 * 思路:
这个道题就像排队,先找个排头dummy,然后依次从head节点放入dummy,只需要依次dummy现有节点比较,插入其中!
 */
public class Solution1 {
	class Solution {
		public ListNode insertionSortList(ListNode head) {
			ListNode dummy = new ListNode(0);
			ListNode pre = dummy;
			ListNode cur = head;
			while (cur != null) {
				ListNode tmp = cur.next;
				while (pre.next != null && pre.next.val < cur.val)
					pre = pre.next;
				cur.next = pre.next;
				pre.next = cur;
				pre = dummy;
				cur = tmp;
			}
			return dummy.next;
		}
		
/*		执行用时 :
			28 ms
			, 在所有 Java 提交中击败了
			31.81%
			的用户
			内存消耗 :
			39.3 MB
			, 在所有 Java 提交中击败了
			6.67%
			的用户*/
		
	}

	
/*
	作者：powcai
	链接：https://leetcode-cn.com/problems/insertion-sort-list/solution/jia-ge-tailsu-du-jiu-kuai-liao-by-powcai/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
