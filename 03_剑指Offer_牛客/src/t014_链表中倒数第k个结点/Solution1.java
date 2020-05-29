package t014_链表中倒数第k个结点;
//解法 1: 两次循环
/*链接：https://www.nowcoder.com/questionTerminal/529d3ae5a407492994ad2a246518148a?answerType=1&f=discussion
来源：牛客网

因为要求链表倒数第 k 个节点，也就是求正数第length - k个节点。整体过程如下：

链表又是个单链表，并且没有保存长度信息。所以需要循环一次计算length。
第二次循环找到第length - k个节点。
时间复杂度是 O(N)，需要 2 次循环。

代码如下：*/


class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}

public class Solution1 {
	public ListNode FindKthToTail(ListNode head, int k) {
		int totalNum = 0;
		if (head != null) {
			totalNum++;
		} else {
			return null;
		}
		// 计算总的节点数量
		ListNode currentNode = head.next;
		while (currentNode != null) {
			totalNum++;
			currentNode = currentNode.next;
		}

		if (totalNum < k) {
			// throw new RuntimeException("k的值超过了链表长度");
			return null;
		}
		// 倒数第k个为正数第totalNum-k+1个
		ListNode resultNode = head;
		for (int i = 1; i <= totalNum - k; i++) {
			resultNode = resultNode.next;
		}
		return resultNode;

	}
}
