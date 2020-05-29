package l_0025_K个一组翻转链表;

import java.util.ArrayDeque;
import java.util.Deque;

/*思路一：
用栈，我们把 k 个数压入栈中，然后弹出来的顺序就是翻转的！

这里要注意几个问题：

第一，剩下的链表个数够不够 k 个（因为不够 k 个不用翻转）；

第二，已经翻转的部分要与剩下链表连接起来。

作者：powcai
链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group/solution/kge-yi-zu-fan-zhuan-lian-biao-by-powcai/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution1 {
/*	执行用时 :
		3 ms
		, 在所有 Java 提交中击败了
		12.17%
		的用户
		内存消耗 :
		39.9 MB
		, 在所有 Java 提交中击败了
		7.32%
		的用户*/
	class Solution {
	    public ListNode reverseKGroup(ListNode head, int k) {
	        Deque<ListNode> stack = new ArrayDeque<ListNode>();
	        ListNode dummy = new ListNode(0);
	        ListNode p = dummy;
	        while (true) {
	            int count = 0;
	            ListNode tmp = head;
	            while (tmp != null && count < k) {
	                stack.add(tmp);
	                tmp = tmp.next;
	                count++;
	            }
	            if (count != k) {
	                p.next = head;
	                break;
	            }
	            while (!stack.isEmpty()){
	                p.next = stack.pollLast();
	                p = p.next;
	            }
	            p.next = tmp;
	            head = tmp;
	        }
	        return dummy.next;
	    }
	}

/*	作者：powcai
	链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group/solution/kge-yi-zu-fan-zhuan-lian-biao-by-powcai/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
