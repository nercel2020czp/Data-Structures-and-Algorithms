package 面试题18_删除链表的节点;
//详解 时间复杂度从 O(N) 到 O(1)

/*
题目说明
这道题与《剑指offer》有一些不同：
	1.本题中，输入的类型为：head: ListNode, val: int，即 val 的类型是整形；
	2.在《剑指offer》中，默认输入为 head: ListNode, val: ListNode，即 val 的类型是链表。

1. val: int 解法
	
class Solution:
    def deleteNode(self, head: ListNode, val: int) -> ListNode:
        dummy = ListNode(0)  # 设置伪结点//dummy假的
        dummy.next = head
        if head.val == val: return head.next # 头结点是要删除的点，直接返回
        while head and head.next:
            if head.next.val == val:   # 找到了要删除的结点，删除
                head.next = head.next.next
            head = head.next
        return dummy.next

复杂度分析:
	时间复杂度：O(N)。N 为链表的长度，最坏情况下，要删除的结点位于链表末尾，这时我们需要遍历整个链表。
	空间复杂度：O(1)。仅使用了额外的 dummy。//dummy假的

作者：z1m
链接：https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/solution/cong-on-dao-o1-by-ml-zimingmeng/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
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
public class Solution1 {
    public ListNode deleteNode(ListNode head, int val) {
		ListNode dummy = new ListNode(0); // # 设置伪结点
        dummy.next = head;//假的;
        if(head.val == val)
        	return head.next;//头结点是要删除的点，直接返回
        while(head != null && head.next != null) {
        	if(head.next.val == val) 
        		head.next = head.next.next;
        	head = head.next;
        }
        return dummy.next;
    }
/*    执行用时 :
    	0 ms
    	, 在所有 Java 提交中击败了
    	100.00%
    	的用户
    	内存消耗 :
    	38.6 MB
    	, 在所有 Java 提交中击败了
    	100.00%
    	的用户*/
}
