package l_0147_对链表进行插入排序;
/*
一看执行时间2000ms,排名靠后,不应该哎!看了别人代码,原来是因为我们每次都要从头比较,但是测试集很多都是顺序排列的,没必要从头开始,
我们直接比较最后一个tail,放在后面!

作者：powcai
链接：https://leetcode-cn.com/problems/insertion-sort-list/solution/jia-ge-tailsu-du-jiu-kuai-liao-by-powcai/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Solution2 {
	class Solution {
		public ListNode insertionSortList(ListNode head) {
			ListNode dummy = new ListNode(Integer.MIN_VALUE);
			ListNode pre = dummy;
			ListNode tail = dummy;
			ListNode cur = head;
			while (cur != null) {
				if (tail.val < cur.val) {
					tail.next = cur;
					tail = cur;
					cur = cur.next;
				} else {
					ListNode tmp = cur.next;
					tail.next = tmp;
					while (pre.next != null && pre.next.val < cur.val)
						pre = pre.next;
					cur.next = pre.next;
					pre.next = cur;
					pre = dummy;
					cur = tmp;
				}
			}
			return dummy.next;
		}
	}
/*	执行用时 :
		4 ms
		, 在所有 Java 提交中击败了
		73.04%
		的用户
		内存消耗 :
		39.6 MB
		, 在所有 Java 提交中击败了
		6.67%
		的用户*/
}
