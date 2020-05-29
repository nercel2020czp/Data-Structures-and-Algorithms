package l_0086_分隔链表;

/*
思路:
用两个链表,一个链表放小于x的节点,一个链表放大于等于x的节点

最后,拼接这两个链表.
 */

public class Solution1 {
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
	class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}
	class Solution {
	    public ListNode partition(ListNode head, int x) {
	        ListNode dummy1 = new ListNode(-1);
	        ListNode dummy2 = new ListNode(-1);
	        ListNode p1 = dummy1;
	        ListNode p2 = dummy2;
	        while (head != null) {
	            if (head.val < x) {
	                p1.next = head;
	                p1 = p1.next;
	            } else {
	                p2.next = head;
	                p2 = p2.next;
	            }
	            head = head.next;
	        }
	        p1.next = dummy2.next;
	        p2.next = null;
	        return dummy1.next; 
	    }
	}
/*	执行用时 :
		0 ms
		, 在所有 Java 提交中击败了
		100.00%
		的用户
		内存消耗 :
		39.5 MB
		, 在所有 Java 提交中击败了
		5.55%
		的用户*/
}
