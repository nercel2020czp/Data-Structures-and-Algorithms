package l_0234_回文链表;

import java.util.ArrayList;
import java.util.List;

/*
方法一：将值复制到数组中后用双指针法
如果你还不太熟悉链表，下面有列表的概要。

有两种常用的列表实现，一种是数组列表和链表。如果我们想在列表中存储值，那么它们是如何保存的呢？

	数组列表底层是使用数组存储值，我们可以通过索引在 O(1)O(1) 的时间访问列表任何位置的值，这是由于内存寻址的方式。
	
	链表存储的是称为节点的对象，每个节点保存一个值和指向下一个节点的指针。访问某个特定索引的节点需要 O(n)O(n) 的时间，
	因为要通过指针获取到下一个位置的节点。
	
确定数组列表是否为回文很简单，我们可以使用双指针法来比较两端的元素，并向中间移动。
一个指针从起点向中间移动，另一个指针从终点向中间移动。这需要 O(n)O(n) 的时间，
因为访问每个元素的时间是 O(1)O(1)，而有 nn 个元素要访问。

然后，直接在链表上操作并不简单，因为不论是正向访问还是反向访问都不是 O(1)O(1)。
而将链表的值复制到数组列表中是 O(n)O(n)，因此最简单的方法就是将链表的值复制到数组列表中，再使用双指针法判断。

算法：

我们可以分为两个步骤：

	复制链表值到数组列表中。
	使用双指针法判断是否为回文。
	

作者：LeetCode
链接：https://leetcode-cn.com/problems/palindrome-linked-list/solution/hui-wen-lian-biao-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution1 {
/*	执行用时 :
		4 ms
		, 在所有 Java 提交中击败了
		32.74%
		的用户
		内存消耗 :
		43.7 MB
		, 在所有 Java 提交中击败了
		5.41%
		的用户*/
	class Solution {
	    public boolean isPalindrome(ListNode head) {
	        List<Integer> vals = new ArrayList<>();

	        // Convert LinkedList into ArrayList.
	        ListNode currentNode = head;
	        while (currentNode != null) {
	            vals.add(currentNode.val);
	            currentNode = currentNode.next;
	        }

	        // Use two-pointer technique to check for palindrome.
	        int front = 0;
	        int back = vals.size() - 1;
	        while (front < back) {
	            // Note that we must use ! .equals instead of !=
	            // because we are comparing Integer, not int.
	            if (!vals.get(front).equals(vals.get(back))) {
	                return false;
	            }
	            front++;
	            back--;
	        }
	        return true;
	    }
	}

/*	作者：LeetCode
	链接：https://leetcode-cn.com/problems/palindrome-linked-list/solution/hui-wen-lian-biao-by-leetcode/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
