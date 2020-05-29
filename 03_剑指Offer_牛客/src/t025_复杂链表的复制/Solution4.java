package t025_复杂链表的复制;



/*编织链表 超越双100%
 * /剑指offer_力扣/src/面试题35_复杂链表的复制/Solution4.java
解题思路
利用原链表的next指针指向拷贝节点

	链表编织 再拆分
	每一个节点next都跟着复制自己的节点
	先拆random连接 复制节点 的random指向其指向的原节点的next（即复制节点）
	再拆next，每一个节点next都指向其原来指向的下一跳

作者：sarafina
链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/solution/bian-zhi-lian-biao-chao-yue-shuang-100-by-sarafina/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
public class Solution4 {


	public RandomListNode Clone(RandomListNode pHead) {
		if (pHead == null) {
			return null;
		}
		copy(pHead);
		randomDirect(pHead);
		return reList(pHead);
	}

	// 拷贝链表
	private void copy(RandomListNode pHead) {
		while (pHead != null) {
			RandomListNode cloneNode = new RandomListNode(pHead.label);
			RandomListNode nextNode = pHead.next;
			pHead.next = cloneNode;
			cloneNode.next = nextNode;
			pHead = cloneNode.next;
		}
	}

	// 指定随机指针
	private void randomDirect(RandomListNode pHead) {
		while (pHead != null) {
			RandomListNode cloneNode = pHead.next;
			if (pHead.random != null) {
				RandomListNode direct = pHead.random;
				cloneNode.random = direct.next;
			}
			pHead = cloneNode.next;
		}
	}

	// 重新连接 链表
	private RandomListNode reList(RandomListNode pHead) {
		RandomListNode cloneNode = pHead.next;
		RandomListNode cloneHead = cloneNode;
		pHead.next = cloneNode.next;
		pHead = pHead.next;
		while (pHead != null) {
			cloneNode.next = pHead.next;
			pHead.next = pHead.next.next;
			pHead = pHead.next;
			cloneNode = cloneNode.next;
		}
		return cloneHead;
	}
}
