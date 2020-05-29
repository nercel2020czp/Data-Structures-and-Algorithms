package t056_删除链表中重复的结点;

import java.util.HashSet;

/*1. 分析
多次遍历，第一次遍历把重复的结点值存入 set 容器，第二次遍历，当结点值存储在 set 容器中，就删除该结点*/
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Solution1 {

	public ListNode deleteDuplication(ListNode pHead) {
		if (pHead == null) {
			return null;
		}
		// 先找出相同结点，存入 set
		HashSet<Integer> set = new HashSet<>();
		ListNode pre = pHead;
		ListNode cur = pHead.next;
		while (cur != null) {
			if (cur.val == pre.val) {
				set.add(cur.val);
			}
			pre = cur;
			cur = cur.next;
		}
		// 再根据相同节点删除
		// 先删头部
		while (pHead != null && set.contains(pHead.val)) {
			pHead = pHead.next;
		}
		if (pHead == null) {
			return null;
		}
		// 再删中间结点
		pre = pHead;
		cur = pHead.next;
		while (cur != null) {
			if (set.contains(cur.val)) {
				pre.next = cur.next;
				cur = cur.next;
			} else {
				pre = cur;
				cur = cur.next;
			}
		}
		return pHead;
	}
	
/*	3. 复杂度
	时间复杂度：HashSet 是基于哈希表实现的，查找效率为 O(1)，所以总的效率是 O(n)
	空间复杂度：最坏的情况是存一半结点 O(n/2)，最好的情况是一个也不存，O(1)*/
}
