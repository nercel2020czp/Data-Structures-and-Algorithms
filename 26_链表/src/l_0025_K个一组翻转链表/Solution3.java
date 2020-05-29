package l_0025_K个一组翻转链表;

/*思路三：
递归*/

public class Solution3 {
/*	执行用时 :
		0 ms
		, 在所有 Java 提交中击败了
		100.00%
		的用户
		内存消耗 :
		39.4 MB
		, 在所有 Java 提交中击败了
		7.32%
		的用户*/
	
	class Solution {
	    public ListNode reverseKGroup(ListNode head, int k) {
	        ListNode cur = head;
	        int count = 0;
	        while (cur != null && count != k) {
	            cur = cur.next;
	            count++;
	        }
	        if (count == k) {
	            cur = reverseKGroup(cur, k);
	            while (count != 0) {
	                count--;
	                ListNode tmp = head.next;
	                head.next = cur;
	                cur = head;
	                head = tmp;
	            }
	            head = cur;
	        }
	        return head;
	    }

	}
/*	作者：powcai
	链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group/solution/kge-yi-zu-fan-zhuan-lian-biao-by-powcai/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
