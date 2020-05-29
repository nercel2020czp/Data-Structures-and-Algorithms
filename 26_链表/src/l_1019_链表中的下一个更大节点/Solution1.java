package l_1019_链表中的下一个更大节点;

import java.util.ArrayList;
import java.util.Stack;

/*java, 单调栈
anyfeel
发布于 3 个月前
629
单调栈的思路
栈中保存链表的节点编号（即下标），还需要一个 data 数组保存下标对应的链表值（避免再次遍历链表）
按单调递减栈的入栈顺序，如果出现当前遍历到的节点比栈顶值大，说明需要将栈中元素出栈，并更新 res 值*/
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution1 {
	class Solution {
	    public int[] nextLargerNodes(ListNode head) {
/*	    	单调栈的思路
	    	栈中保存链表的节点编号（即下标），还需要一个 data 数组保存下标对应的链表值（避免再次遍历链表）
	    	按单调递减栈的入栈顺序，如果出现当前遍历到的节点比栈顶值大，说明需要将栈中元素出栈，并更新 res 值*/
	        Stack<Integer> stack = new Stack<>();
	        ArrayList<Integer> data = new ArrayList<>();
	        ArrayList<Integer> res = new ArrayList<>();

	        int index = 0;
	        while(head != null) {
	            res.add(0);
	            data.add(head.val);

	            while (!stack.empty() && head.val > data.get(stack.peek())) {
	                res.set(stack.pop(), head.val);
	            }

	            stack.push(index);
	            index++;
	            head = head.next;
	        }

	        int[] ans = new int[res.size()];

	        for (int i = 0; i < res.size(); i++) {
	            ans[i] = res.get(i);
	        }

	        return ans;
	    }
	}
	
/*	执行用时 :
		26 ms
		, 在所有 Java 提交中击败了
		63.25%
		的用户
		内存消耗 :
		46.4 MB
		, 在所有 Java 提交中击败了
		12.50%
		的用户*/
	

/*	作者：anyfeel
	链接：https://leetcode-cn.com/problems/next-greater-node-in-linked-list/solution/java-dan-diao-zhan-by-anyfeel/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
