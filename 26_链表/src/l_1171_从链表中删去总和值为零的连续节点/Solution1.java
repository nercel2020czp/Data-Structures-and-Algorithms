package l_1171_从链表中删去总和值为零的连续节点;

import java.util.HashMap;
import java.util.Map;
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution1 {
	class Solution {
	    public ListNode removeZeroSumSublists(ListNode head) {
	        ListNode dummy = new ListNode(0);
	        dummy.next = head;

	        Map<Integer, ListNode> map = new HashMap<>();

	        // 首次遍历建立 节点处链表和<->节点 哈希表
	        // 若同一和出现多次会覆盖，即记录该sum出现的最后一次节点
	        int sum = 0;
	        for (ListNode d = dummy; d != null; d = d.next) {
	            sum += d.val;
	            map.put(sum, d);
	        }

	        // 第二遍遍历 若当前节点处sum在下一处出现了则表明两结点之间所有节点和为0 直接删除区间所有节点
	        sum = 0;
	        for (ListNode d = dummy; d != null; d = d.next) {
	            sum += d.val;
	            d.next = map.get(sum).next;
	        }

	        return dummy.next;
	    }
	}
	
/*	执行用时 :
		3 ms
		, 在所有 Java 提交中击败了
		85.19%
		的用户
		内存消耗 :
		39.6 MB
		, 在所有 Java 提交中击败了
		12.50%
		的用户*/
	

/*	作者：shane-34
	链接：https://leetcode-cn.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/solution/java-hashmap-liang-ci-bian-li-ji-ke-by-shane-34/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
