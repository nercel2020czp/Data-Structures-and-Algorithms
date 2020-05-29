package t014_链表中倒数第k个结点;
/*链接：https://www.nowcoder.com/questionTerminal/529d3ae5a407492994ad2a246518148a?answerType=1&f=discussion
来源：牛客网

准备两个指针：left（慢）和 right（快）。整体过程如下：

right 先向右移动 k 位，此时 index(right) - index(left) = k
left 和 right 一起向右移动，直到 right 抵达边界
由于index(right) - index(left) = k，所以index(left) = index(right) - k = length - k。也就是 left 指针移动到了倒数第 k 个位置
时间复杂度是 O(N)，但仅需要遍历一次。空间复杂度是 O（1）*/
public class Solution2 {

	public ListNode FindKthToTail(ListNode head, int k) {
		if (head == null || k == 0) {
			return null;
		}

		ListNode slow = head;
		ListNode fast = head;
		for (int i = 0; i < k; i++) {
			if (fast == null) {
				return null;
			}
			fast = fast.next;

		}
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}

		return slow;

	}
}
