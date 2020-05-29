package l_0234_回文链表;

public class Solution2 {
	class Solution {
		// 题解：快慢指针法，快指针走两步，慢指针走一步，找到链表的中点。然后，翻转后半部分。最后从头、中点开始判断是否相同。
		@SuppressWarnings("null")
		public boolean isPalindrome(ListNode head) {
			if (head != null || head.next != null)
				return true;
			ListNode fast = head, slow = head, pre = null;
			// 1、找到链表的中点，链表长度奇偶不影响
			while (fast != null && fast.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			}
			// 2、将slow之后链表进行断开且反转，最后翻转完成之后pre指向反转链表的头节点
			while (slow != null) {
				ListNode p = slow.next;
				slow.next = pre;
				pre = slow;
				slow = p;
			}
			// 3、前后链表进行比较，注意若为奇数链表，后半部分回比前部分多1一个节点，然而我们只比较相同长度的节点值，巧妙地避开这点判断
			while (head != null && pre != null) {
				if (head.val != pre.val)
					return false;
				head = head.next;
				pre = pre.next;
			}
			return true;
		}
	}
}
