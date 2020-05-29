package l_0817_链表组件;

import java.util.HashSet;
import java.util.Set;

/*
线性扫描：
我们对链表进行一次扫描，一个组件在链表中对应一段极长的连续节点，因此如果当前的节点在列表 G 中，
并且下一个节点不在列表 G 中，我们就找到了一个组件的尾节点，可以将答案加 1。

例如，当链表为 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7，G 为 [0, 2, 3, 5, 7] 时，
我们扫描之后可以发现 0, 3, 5, 7 四个节点是组件的尾节点，那么答案就为 4。

JavaPython


作者：LeetCode
链接：https://leetcode-cn.com/problems/linked-list-components/solution/lian-biao-zu-jian-by-leetcode/
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
		public int numComponents(ListNode head, int[] G) {
			Set<Integer> Gset = new HashSet<>();
			for (int x : G)
				Gset.add(x);

			ListNode cur = head;
			int ans = 0;

			while (cur != null) {
				if (Gset.contains(cur.val) && (cur.next == null || !Gset.contains(cur.next.val)))
					ans++;
				cur = cur.next;
			}

			return ans;
		}
	}
/*
	执行用时 :
		8 ms
		, 在所有 Java 提交中击败了
		79.76%
		的用户
		内存消耗 :
		40.2 MB
		, 在所有 Java 提交中击败了
		25.00%
		的用户*/
	
/*	作者：LeetCode
	链接：https://leetcode-cn.com/problems/linked-list-components/solution/lian-biao-zu-jian-by-leetcode/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
