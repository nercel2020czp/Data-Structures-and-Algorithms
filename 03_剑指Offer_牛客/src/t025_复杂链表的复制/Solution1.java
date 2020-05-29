package t025_复杂链表的复制;
/*
算法(迭代)

利用哈希表，秒杀100%java
解题思路
利用哈希表
【参考】/剑指offer_力扣/src/面试题35_复杂链表的复制/Solution1.java
*/

import java.util.HashMap;
import java.util.Map;

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
public class Solution1 {
	public RandomListNode Clone(RandomListNode pHead) {
		// 使用哈希
		// 哈希表中<原表节点，新表节点>
		//
		Map<RandomListNode, RandomListNode> map = new HashMap<>();
		RandomListNode p = pHead;
		while (p != null) {
			map.put(p, new RandomListNode(p.label));
			p = p.next;
		}
		p = pHead;
		while (p != null) {
			map.get(p).next = map.get(p.next);
			map.get(p).random = map.get(p.random);
			p = p.next;
		}
		return map.get(pHead);
	}
}
