package l_0328_奇偶链表;
/*
解法
想法

将奇节点放在一个链表里，偶链表放在另一个链表里。然后把偶链表接在奇链表的尾部。

算法

这个解法非常符合直觉思路也很简单。但是要写一个精确且没有 bug 的代码还是需要进行一番思索的。

一个 LinkedList 需要一个头指针和一个尾指针来支持双端操作。我们用变量 head 和 odd 保存奇链表的头和尾指针。
 evenHead 和 even 保存偶链表的头和尾指针。算法会遍历原链表一次并把奇节点放到奇链表里去、偶节点放到偶链表里去。
 遍历整个链表我们至少需要一个指针作为迭代器。这里 odd 指针和 even 指针不仅仅是尾指针，也可以扮演原链表迭代器的角色。
 
解决链表问题最好的办法是在脑中或者纸上把链表画出来。比方说：

图1.png

作者：LeetCode
链接：https://leetcode-cn.com/problems/odd-even-linked-list/solution/qi-ou-lian-biao-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution1 {
//	"解决链表问题最好的办法是在脑中或者纸上把链表画出来" 这句很赞
	class Solution {
	    public ListNode oddEvenList(ListNode head) {
	        if (head == null) return null;
	        ListNode odd = head, even = head.next, evenHead = even;
	        while (even != null && even.next != null) {
	            odd.next = even.next;
	            odd = odd.next;
	            even.next = odd.next;
	            even = even.next;
	        }
	        odd.next = evenHead;
	        return head;
	    }
	}
/*	执行用时 :
		0 ms
		, 在所有 Java 提交中击败了
		100.00%
		的用户
		内存消耗 :
		39.6 MB
		, 在所有 Java 提交中击败了
		8.70%
		的用户*/
/*	复杂度分析

	时间复杂度： O(n)O(n) 。总共有 nn 个节点，我们每个遍历一次。

	空间复杂度： O(1)O(1) 。我们只需要 4 个指针。*/

/*	作者：LeetCode
	链接：https://leetcode-cn.com/problems/odd-even-linked-list/solution/qi-ou-lian-biao-by-leetcode/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
