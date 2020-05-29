package l_0160_相交链表;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution1 {
/*	可以理解成两个人速度一致， 走过的路程一致。那么肯定会同一个时间点到达终点。
	如果到达终点的最后一段路两人都走的话，那么这段路上俩人肯定是肩并肩手牵手的。 nb*/
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	    if (headA == null || headB == null) return null;
	    ListNode pA = headA, pB = headB;
	    while (pA != pB) {
	        pA = pA == null ? headB : pA.next;
	        pB = pB == null ? headA : pB.next;
	    }
	    return pA;
	}
/*	执行用时 :
		1 ms
		, 在所有 Java 提交中击败了
		99.97%
		的用户
		内存消耗 :
		42.9 MB
		, 在所有 Java 提交中击败了
		54.76%
		的用户*/
/*	作者：reals
	链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/solution/tu-jie-xiang-jiao-lian-biao-by-user7208t/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
