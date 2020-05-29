package l_0143_重排链表;
/*
解法三:
参考 这里，主要是利用到一头一尾取元素的特性。

主要是三步，举个例子。

1 -> 2 -> 3 -> 4 -> 5 -> 6
第一步，将链表平均分成两半
1 -> 2 -> 3
4 -> 5 -> 6
    
第二步，将第二个链表逆序
1 -> 2 -> 3
6 -> 5 -> 4
    
第三步，依次连接两个链表
1 -> 6 -> 2 -> 5 -> 3 -> 4

第一步找中点的话，可以应用 19 题 的方法，快慢指针。快指针一次走两步，慢指针一次走一步，当快指针走到终点的话，慢指针会刚好到中点。
如果节点个数是偶数的话，slow 走到的是左端点，利用这一点，我们可以把奇数和偶数的情况合并，不需要分开考虑。

第二步链表逆序的话，在 第 2 题 讨论过了，有迭代和递归的两种方式，迭代的话主要利用两个指针，依次逆转。

第三步的话就很简单了，两个指针分别向后移动就可以。

作者：windliang
链接：https://leetcode-cn.com/problems/reorder-list/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-34/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution3 {
	public void reorderList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) {
			return;
		}
		// 找中点，链表分成两个
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode newHead = slow.next;
		slow.next = null;

		// 第二个链表倒置
		newHead = reverseList(newHead);

		// 链表节点依次连接
		while (newHead != null) {
			ListNode temp = newHead.next;
			newHead.next = head.next;
			head.next = newHead;
			head = newHead.next;
			newHead = temp;
		}

	}

	private ListNode reverseList(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode tail = head;
		head = head.next;

		tail.next = null;

		while (head != null) {
			ListNode temp = head.next;
			head.next = tail;
			tail = head;
			head = temp;
		}

		return tail;
	}
/*	执行用时 :
		2 ms
		, 在所有 Java 提交中击败了
		82.14%
		的用户
		内存消耗 :
		43.1 MB
		, 在所有 Java 提交中击败了
		9.09%
		的用户*/
}
