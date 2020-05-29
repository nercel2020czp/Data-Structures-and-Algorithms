package l_0148_排序链表;
/*
解答一：归并排序（递归法）
	题目要求时间空间复杂度分别为O(nlogn)O(nlogn)和O(1)O(1)，根据时间复杂度我们自然想到二分法，从而联想到归并排序；
	
	对数组做归并排序的空间复杂度为 O(n)O(n)，分别由新开辟数组O(n)O(n)和递归函数调用O(logn)O(logn)组成，而根据链表特性：
		数组额外空间：链表可以通过修改引用来更改节点顺序，无需像数组一样开辟额外空间；
		递归额外空间：递归调用函数将带来O(logn)O(logn)的空间复杂度，因此若希望达到O(1)O(1)空间复杂度，则不能使用递归。
		
	通过递归实现链表归并排序，有以下两个环节：
		1 分割 cut 环节： 找到当前链表中点，并从中点将链表断开（以便在下次递归 cut 时，链表片段拥有正确边界）；
			1.1:我们使用 fast,slow 快慢双指针法，奇数个节点找到中点，偶数个节点找到中心左边的节点。
			1.2:找到中点 slow 后，执行 slow.next = None 将链表切断。
			1.3:递归分割时，输入当前链表左端点 head 和中心节点 slow 的下一个节点 tmp(因为链表是从 slow 切断的)。
			1.4:cut 递归终止条件： 当head.next == None时，说明只有一个节点了，直接返回此节点。
			
		2.合并 merge 环节： 将两个排序链表合并，转化为一个排序链表。
			2.1:双指针法合并，建立辅助ListNode h 作为头部。
			2.2:设置两指针 left, right 分别指向两链表头部，比较两指针处节点值大小，
				由小到大加入合并链表头部，指针交替前进，直至添加完两个链表。
			2.3:返回辅助ListNode h 作为头部的下个节点 h.next。
			2.4:时间复杂度 O(l + r)，l, r 分别代表两个链表长度。
			
		3.当题目输入的 head == None 时，直接返回None。
		
		图1.png

作者：jyd
链接：https://leetcode-cn.com/problems/sort-list/solution/sort-list-gui-bing-pai-xu-lian-biao-by-jyd/
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
		/*	通过递归实现链表归并排序，有以下两个环节：
		1 分割 cut 环节： 找到当前链表中点，并从中点将链表断开（以便在下次递归 cut 时，链表片段拥有正确边界）；
			1.1:我们使用 fast,slow 快慢双指针法，奇数个节点找到中点，偶数个节点找到中心左边的节点。
			1.2:找到中点 slow 后，执行 slow.next = None 将链表切断。
			1.3:递归分割时，输入当前链表左端点 head 和中心节点 slow 的下一个节点 tmp(因为链表是从 slow 切断的)。
			1.4:cut 递归终止条件： 当head.next == None时，说明只有一个节点了，直接返回此节点。
			
		2.合并 merge 环节： 将两个排序链表合并，转化为一个排序链表。
			2.1:双指针法合并，建立辅助ListNode h 作为头部。
			2.2:设置两指针 left, right 分别指向两链表头部，比较两指针处节点值大小，
				由小到大加入合并链表头部，指针交替前进，直至添加完两个链表。
			2.3:返回辅助ListNode h 作为头部的下个节点 h.next。
			2.4:时间复杂度 O(l + r)，l, r 分别代表两个链表长度。
			
		3.当题目输入的 head == None 时，直接返回None。*/
		public ListNode sortList(ListNode head) {
			//1.4:cut 递归终止条件： 当head.next == None时，说明只有一个节点了，直接返回此节点。
			if (head == null || head.next == null)
				return head;
			ListNode fast = head.next, slow = head;
			while (fast != null && fast.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			}
			ListNode tmp = slow.next;
			slow.next = null;
			ListNode left = sortList(head);
			ListNode right = sortList(tmp);
			
			//合并操作
			ListNode h = new ListNode(0);
			ListNode res = h;
			while (left != null && right != null) {
				if (left.val < right.val) {
					h.next = left;
					left = left.next;
				} else {
					h.next = right;
					right = right.next;
				}
				h = h.next;
			}
			h.next = left != null ? left : right;
			return res.next;
		}
	}
	
/*	执行用时 :
		3 ms
		, 在所有 Java 提交中击败了
		99.25%
		的用户
		内存消耗 :
		41.9 MB
		, 在所有 Java 提交中击败了
		5.88%
		的用户*/
	
	

/*	作者：jyd
	链接：https://leetcode-cn.com/problems/sort-list/solution/sort-list-gui-bing-pai-xu-lian-biao-by-jyd/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
