package t015_反转链表;
/*
以3个节点为例：
	用pre记录当前节点的前一个节点
	用next记录当前节点的后一个节点

链接：https://www.nowcoder.com/questionTerminal/75e878df47f24fdc9dc3e400ec6058ca?answerType=1&f=discussion
来源：牛客网

	1.当前节点a不为空，进入循环，先记录a的下一个节点位置next = b;再让a的指针指向pre
	
	2.移动pre和head的位置，正因为刚才记录了下一个节点的位置，所以该链表没有断，我们让head走向b的位置。
	
	3.当前节点为b不为空，先记录下一个节点的位置，让b指向pre的位置即a的位置，同时移动pre和head
	
	4.当前节点c不为空，记录下一个节点的位置，让c指向b，同时移动pre和head，此时head为空，跳出，返回pre。


【见图1.jpg】



链接：https://www.nowcoder.com/questionTerminal/75e878df47f24fdc9dc3e400ec6058ca?answerType=1&f=discussion
来源：牛客网

*/



class ListNode {
    int val;
    ListNode next = null;
 
    ListNode(int val) {
        this.val = val;
    }
}
public class Solution1 {
    public ListNode ReverseList(ListNode head) {
         // 判断链表为空或长度为1的情况
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = null; // 当前节点的前一个节点
        ListNode next = null; // 当前节点的下一个节点
        while( head != null){
            next = head.next; // 记录当前节点的下一个节点位置；
            head.next = pre; // 让当前节点指向前一个节点位置，完成反转
            pre = head; // pre 往右走
            head = next;// 当前节点往右继续走
        }
        return pre;
    }
}
