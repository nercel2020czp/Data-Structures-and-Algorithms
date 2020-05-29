package t003_从尾到头打印链表;

import java.util.ArrayList;

/*

一、非递归
链接：https://www.nowcoder.com/questionTerminal/d0267f7f55b3412ba93bd35cfa8e8035?answerType=1&f=discussion
来源：牛客网

1. 分析
listNode 是链表，只能从头遍历到尾，但是输出却要求从尾到头，这是典型的"先进后出"，我们可以想到栈！
ArrayList 中有个方法是 add(index,value)，可以指定 index 位置插入 value 值,所以我们在遍历
listNode 的同时将每个遇到的值插入到 list 的 0 位置，最后输出 listNode 即可得到逆序链表

*/

class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}

public class Solution1 {
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> list = new ArrayList<>();
		ListNode tmp = listNode;
		while (tmp != null) {
/*			ArrayList 中有个方法是 add(index,value)，可以指定 index 位置插入 value 值,所以我们在遍历
			listNode 的同时将每个遇到的值插入到 list 的 0 位置，最后输出 listNode 即可得到逆序链表*/
			list.add(0, tmp.val);
			tmp = tmp.next;
		}
		return list;
	}
}
