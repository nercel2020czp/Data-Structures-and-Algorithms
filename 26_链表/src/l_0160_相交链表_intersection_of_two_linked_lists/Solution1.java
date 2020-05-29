package l_0160_相交链表_intersection_of_two_linked_lists;
/*
一图胜千言，看图你就明白了
空间复杂度 O(1) 时间复杂度为 O(n)

这里使用图解的方式，解释比较巧妙的一种实现。

根据题目意思
如果两个链表相交，那么相交点之后的长度是相同的

我们需要做的事情是，让两个链表从同距离末尾同等距离的位置开始遍历。这个位置只能是较短链表的头结点位置。
为此，我们必须消除两个链表的长度差

	1.指针 pA 指向 A 链表，指针 pB 指向 B 链表，依次往后遍历
	2.如果 pA 到了末尾，则 pA = headB 继续遍历
	3.如果 pB 到了末尾，则 pB = headA 继续遍历
	4.比较长的链表指针指向较短链表head时，长度差就消除了
	5.如此，只需要将最短链表遍历两次即可找到位置

听着可能有点绕，看图最直观，链表的题目最适合看图了
【见图1.png】



 */

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Solution1 {
	// 可以理解成两个人速度一致， 走过的路程一致。那么肯定会同一个时间点到达终点。
	// 如果到达终点的最后一段路两人都走的话，那么这段路上俩人肯定是肩并肩手牵手的。 nb
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;
		ListNode pA = headA, pB = headB;
		while (pA != pB) {
			pA = pA == null ? headB : pA.next;
			pB = pB == null ? headA : pB.next;
		}
		return pA;
	}
}
