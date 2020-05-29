package l_0025_K个一组翻转链表;
/*思路二：
尾插法。

直接举个例子：k = 3。

Python
pre
tail    head
dummy    1     2     3     4     5
# 我们用tail 移到要翻转的部分最后一个元素
pre     head       tail
dummy    1     2     3     4     5
	       cur
# 我们尾插法的意思就是,依次把cur移到tail后面
pre          tail  head
dummy    2     3    1     4     5
	       cur
# 依次类推
pre     tail      head
dummy    3     2    1     4     5
		cur
....

作者：powcai
链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group/solution/kge-yi-zu-fan-zhuan-lian-biao-by-powcai/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
public class Solution2 {
/*	执行用时 :
		1 ms
		, 在所有 Java 提交中击败了
		57.68%
		的用户
		内存消耗 :
		39.7 MB
		, 在所有 Java 提交中击败了
		7.32%
		的用户*/
	class Solution {
	    public ListNode reverseKGroup(ListNode head, int k) {
	        ListNode dummy = new ListNode(0);
	        dummy.next = head;
	        ListNode pre = dummy;
	        ListNode tail = dummy;
	        while (true) {
	            int count = 0;
	            while (tail != null && count != k) {
	                count++;
	                tail = tail.next;
	            }
	            if (tail == null) break;
	            ListNode head1 = pre.next;
	            while (pre.next != tail) {
	                ListNode cur = pre.next;
	                pre.next = cur.next;
	                cur.next = tail.next;
	                tail.next = cur;
	            }
	            pre = head1;
	            tail = head1;
	        }
	        return dummy.next;
	    }
	}
/*
	作者：powcai
	链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group/solution/kge-yi-zu-fan-zhuan-lian-biao-by-powcai/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
