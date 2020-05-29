package l_0445_两数相加_II;

import java.util.Stack;

/*
🙋‍♀️就喜欢这种短短的打卡题，短短的打个卡，短短的发个题解，哎又是美妙的夜晚！

update：统一回复下头插法的评论，不熟悉的可以用迭代法去做做 206. 反转链表，需要链表逆序的时候就用头插法。

用 stack 保存链表，再从 stack 中取出来，就是数字从低位到高位访问了。

作者：sweetiee
链接：https://leetcode-cn.com/problems/add-two-numbers-ii/solution/javakai-fa-by-sweetiee/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution1 {
/*	执行用时 :
		5 ms
		, 在所有 Java 提交中击败了
		64.45%
		的用户
		内存消耗 :
		40.3 MB
		, 在所有 Java 提交中击败了
		95.83%
		的用户*/
	
	class Solution {
	    public ListNode addTwoNumbers(ListNode l1, ListNode l2) { 
	        Stack<Integer> stack1 = new Stack<>();
	        Stack<Integer> stack2 = new Stack<>();
	        while (l1 != null) {
	            stack1.push(l1.val);
	            l1 = l1.next;
	        }
	        while (l2 != null) {
	            stack2.push(l2.val);
	            l2 = l2.next;
	        }
	        
	        int carry = 0;
	        ListNode head = null;
	        while (!stack1.isEmpty() || !stack2.isEmpty() || carry > 0) {
	            int sum = carry;
	            sum += stack1.isEmpty()? 0: stack1.pop();
	            sum += stack2.isEmpty()? 0: stack2.pop();
	            ListNode node = new ListNode(sum % 10);
	            node.next = head;
	            head = node;
	            carry = sum / 10;
	        }
	        return head;
	    }
	}

}
