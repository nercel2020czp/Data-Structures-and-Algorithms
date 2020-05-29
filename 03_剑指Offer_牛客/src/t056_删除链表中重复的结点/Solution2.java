package t056_删除链表中重复的结点;
/*链接：https://www.nowcoder.com/questionTerminal/fc533c45b73a41b0b44ccba763f866ef?answerType=1&f=discussion
来源：牛客网

2. 遍历的同时删除
1. 分析
借助辅助头结点，可避免单独讨论头结点的情况。设置两个结点 pre 和 cur，当 cur 和 cur.next 值相等，
cur 一直向前走，直到不等退出循环，这时候 cur 指的值还是重复值，调整 cur 和 pre 的指针再次判断*/

public class Solution2 {
    public ListNode deleteDuplication(ListNode pHead){
        if(pHead == null || pHead.next == null){
            return pHead;
        }
        // 自己构建辅助头结点
        ListNode head = new ListNode(Integer.MIN_VALUE);
        head.next = pHead;
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur!=null){
            if(cur.next != null && cur.next.val == cur.val){
                // 相同结点一直前进
                while(cur.next != null && cur.next.val == cur.val){
                    cur = cur.next;
                }
                // 退出循环时，cur 指向重复值，也需要删除，而 cur.next 指向第一个不重复的值
                // cur 继续前进
                cur = cur.next;
                // pre 连接新结点
                pre.next = cur;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        return head.next;
    }
    
/*    3. 复杂度
    时间复杂度：O(n)
    空间复杂度：O(1)*/
    
}
