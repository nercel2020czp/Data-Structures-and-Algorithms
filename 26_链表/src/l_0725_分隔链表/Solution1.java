package l_0725_分隔链表;
/*
方法一：创建新列表
	算法：
		1.如果链表有 NN 个结点，则分隔的链表中每个部分中都有 n/kn/k 个结点，且前 N\%kN%k 部分有一个额外的结点。
			我们可以用一个简单的循环来计算 NN。
		2.现在对于每个部分，我们已经计算出该部分有多少个节点：
			width + (i < remainder ? 1 : 0)。
			我们创建一个新列表并将该部分写入该列表。
复杂度分析

时间复杂度：O(N + k)O(N+k)。NN 指的是链表的结点数，若 kk 很大，则还需要添加许多空列表。
空间复杂度：O(max(N, k))O(max(N,k))，存放答案所需的空间。

作者：LeetCode
链接：https://leetcode-cn.com/problems/split-linked-list-in-parts/solution/fen-ge-lian-biao-by-leetcode-2/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution1 {
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
				ListNode head = new ListNode(0), write = head;
				for (int j = 0; j < width + (i < rem ? 1 : 0); ++j) {
					write = write.next = new ListNode(cur.val);
					if (cur != null)
						cur = cur.next;
				}
				ans[i] = head.next;
			}
			return ans;
		}
	}

}
