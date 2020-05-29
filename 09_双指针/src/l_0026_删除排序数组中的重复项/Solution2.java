package l_0026_删除排序数组中的重复项;

class ListNode{
	ListNode next;
	int val;
}
public class Solution2 {
	ListNode deleteDuplicates(ListNode head) {
	    if (head == null) return null;
	    ListNode slow = head, fast = head.next;
	    while (fast != null) {
	        if (fast.val != slow.val) {
	            // nums[slow] = nums[fast];
	            slow.next = fast;
	            // slow++;
	            slow = slow.next;
	        }
	        // fast++
	        fast = fast.next;
	    }
		return head;
	}
}
