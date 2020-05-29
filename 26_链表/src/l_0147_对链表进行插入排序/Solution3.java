package l_0147_对链表进行插入排序;

/*
利用前一个插入位置提速:
看了下题解，大部分人都提到了利用 Tail 指针进行提速，当这种情况只适用测试用例正好最大的在后面的情况，
概率上来说发生的可能性是很小的。其实完全可以利用前一个插入的位置进行提速，
即每次先把当前要插入的元素和前一个插入点比较，如果比它大，那么就从这里开始搜索，否则才需要从链表头开始搜索。

作者：gui-lin-chong-zi
链接：https://leetcode-cn.com/problems/insertion-sort-list/solution/li-yong-qian-yi-ge-cha-ru-wei-zhi-ti-su-by-gui-lin/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution3 {
	public ListNode insertionSortList(ListNode head) {
		ListNode dummy = new ListNode(0);
		ListNode pre = dummy;

		for (ListNode node = head; node != null;) {
			ListNode cur = node;
			node = node.next;

			// 与前一个插入点比较决定从哪里开始搜索
			if (cur.val < pre.val)
				pre = dummy;

			while (pre.next != null && cur.val > pre.next.val)
				pre = pre.next;

			cur.next = pre.next;
			pre.next = cur;
		}

		return dummy.next;
	}
	
/*	执行用时 :
		3 ms
		, 在所有 Java 提交中击败了
		98.58%
		的用户
		内存消耗 :
		39.3 MB
		, 在所有 Java 提交中击败了
		6.67%
		的用户*/
	
/*
	作者：gui-lin-chong-zi
	链接：https://leetcode-cn.com/problems/insertion-sort-list/solution/li-yong-qian-yi-ge-cha-ru-wei-zhi-ti-su-by-gui-lin/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
