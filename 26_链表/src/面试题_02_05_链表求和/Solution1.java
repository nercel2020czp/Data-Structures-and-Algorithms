package 面试题_02_05_链表求和;
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
/*执行用时 :
2 ms
, 在所有 Java 提交中击败了
100.00%
的用户
内存消耗 :
39.9 MB
, 在所有 Java 提交中击败了
100.00%
的用户*/
public class Solution1 {

	class Solution {
	    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        
	        ListNode p1 = l1, p2 = l2, result = new ListNode(0);
	        ListNode p = result;
	        int carr = 0;
	        
	        while(p1 != null || p2 != null || carr > 0)
	        {
	            int sum = carr;
	            sum += p1 == null ? 0 : p1.val;
	            sum += p2 == null ? 0 : p2.val;
	            
	            p.next = new ListNode(sum % 10);
	            p = p.next;
	            
	            carr = sum / 10;
	            
	            if(p1 != null)
	                p1 = p1.next;
	            if(p2 != null)
	                p2 = p2.next;
	        }
	        
	        return result.next;

	    }
	}

}
