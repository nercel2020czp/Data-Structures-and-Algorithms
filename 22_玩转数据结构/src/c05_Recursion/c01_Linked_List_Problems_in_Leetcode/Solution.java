package c05_Recursion.c01_Linked_List_Problems_in_Leetcode;


/// Leetcode 203. Remove Linked List Elements
/// https://leetcode.com/problems/remove-linked-list-elements/description/

class Solution {

    public ListNode removeElements(ListNode head, int val) {

        while(head != null && head.val == val){
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }

        if(head == null)
            return head;

        ListNode prev = head;
        while(prev.next != null){
            if(prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            }
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
    	40.9 MB
    	, 在所有 Java 提交中击败了
    	6.25%
    	的用户*/
}