package t003_从尾到头打印链表;

import java.util.ArrayList;

/*
二、递归
1. 分析
既然非递归都实现了，那么我们也可以利用递归，借助系统的"栈"帮忙打印


3. 复杂度
时间复杂度：O(n)
空间复杂度：O(n)

*/

public class Solution2 {

	ArrayList<Integer> list = new ArrayList<Integer>();

	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		if (listNode != null) {
			printListFromTailToHead(listNode.next);
			list.add(listNode.val);
		}
		return list;
	}
}
