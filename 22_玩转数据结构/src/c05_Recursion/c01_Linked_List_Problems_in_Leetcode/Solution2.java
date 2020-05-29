package c05_Recursion.c01_Linked_List_Problems_in_Leetcode;


/// Leetcode 203. Remove Linked List Elements
/// https://leetcode.com/problems/remove-linked-list-elements/description/

class Solution2 {

    public ListNode removeElements(ListNode head, int val) {

        while(head != null && head.val == val)
            head = head.next;

        if(head == null)
            return head;

        ListNode prev = head;
        while(prev.next != null){
            if(prev.next.val == val)
                prev.next = prev.next.next;
            else
                prev = prev.next;
        }

        return head;
    }
/*    执行用时 :
    	1 ms
    	, 在所有 Java 提交中击败了
    	99.89%
    	的用户
    	内存消耗 :
    	40.8 MB
    	, 在所有 Java 提交中击败了
    	6.25%
    	的用户*/
}