package l_0142_环形链表_II;
/*
---------------------------题目解析----------------------------
1. 这题我们可以采用双指针解法，一快一慢指针。快指针每次跑两个element，慢指针每次跑一个。
       如果存在一个圈，总有一天，快指针是能追上慢指针的。
       
2. 如图1.png所示，我们先找到快慢指针相遇的点，p。我们再假设，环的入口在点q，从头节点到点q距离
       为A，q p两点间距离为B，p q两点间距离为C。       
       
3. 因为快指针是慢指针的两倍速，且他们在p点相遇，则我们可以得到等式 2(A+B) = A+B+C+B.

4. 由3的等式，我们可得，C = A。

5. 这时，因为我们的slow指针已经在p，我们可以新建一个另外的指针，slow2，让他从头节点开始走，
       每次只走下一个，原slow指针继续保持原来的走法，和slow2同样，每次只走下一个。      
       
6. 我们期待着slow2和原slow指针的相遇，因为我们知道A=C，所以当他们相遇的点，一定是q了。

7. 我们返回slow2或者slow任意一个节点即可，因为此刻他们指向的是同一个节点，即环的起始点，q。  */   


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Solution1 {

	public class Solution {
	    public ListNode detectCycle(ListNode head) {
	        ListNode fast = head, slow = head;
	        while (true) {
	            if (fast == null || fast.next == null) return null;
	            fast = fast.next.next;
	            slow = slow.next;
	            if (fast == slow) break;
	        }
	        fast = head;
	        while (slow != fast) {
	            slow = slow.next;
	            fast = fast.next;
	        }
	        return fast;
	    }
	}
	
/*	执行用时 :
		0 ms
		, 在所有 Java 提交中击败了
		100.00%
		的用户
		内存消耗 :
		40.2 MB
		, 在所有 Java 提交中击败了
		7.14%
		的用户*/
	
}
