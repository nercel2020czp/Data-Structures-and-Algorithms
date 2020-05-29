package l_1290_二进制链表转整数;
/*
双100%我觉得很短粗暴啊
graph-2.png
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution1 {
	class Solution {
	    public int getDecimalValue(ListNode head) {
	        int sum = 0;
	        while(head!=null){
	            sum = sum*2 + head.val;
	            head = head.next;
	        }
	        return sum;
	    }
	}
/*
	执行用时 :
		0 ms
		, 在所有 Java 提交中击败了
		100.00%
		的用户
		内存消耗 :
		37.1 MB
		, 在所有 Java 提交中击败了
		5.00%
		的用户*/
	
/*	作者：gu-xiong-007
	链接：https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer/solution/shuang-bai-wo-jue-de-hen-cu-bao-a-by-gu-xiong-007/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
