package l_0725_分隔链表;
/*
方法二：拆分链表
	算法：
		在方法 1 中，我们知道每个部分的大小。
		我们将不创建新列表，而是直接拆分原链表，并根据需要返回指向原始链表中节点的指针列表。
 */
public class Solution2 {
	class Solution {
	    public ListNode[] splitListToParts(ListNode root, int k) {
	        ListNode cur = root;
	        int N = 0;
	        while (cur != null) {
	            cur = cur.next;
	            N++;
	        }

	        int width = N / k, rem = N % k;

	        ListNode[] ans = new ListNode[k];
	        cur = root;
	        for (int i = 0; i < k; ++i) {
	            ListNode head = cur;
	            for (int j = 0; j < width + (i < rem ? 1 : 0) - 1; ++j) {
	                if (cur != null) cur = cur.next;
	            }
	            if (cur != null) {
	                ListNode prev = cur;
	                cur = cur.next;
	                prev.next = null;
	            }
	            ans[i] = head;
	        }
	        return ans;
	    }
	}
/*	执行用时 :
		0 ms
		, 在所有 Java 提交中击败了
		100.00%
		的用户
		内存消耗 :
		40.1 MB
		, 在所有 Java 提交中击败了
		6.67%
		的用户*/
}
/*复杂度分析

时间复杂度：O(N + k)O(N+k)。NN 指的是所给链表的结点数，若 kk 很大，则还需要添加许多空列表。
空间复杂度：O(k)O(k)，存储答案时所需的额外空格。

作者：LeetCode
链接：https://leetcode-cn.com/problems/split-linked-list-in-parts/solution/fen-ge-lian-biao-by-leetcode-2/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/