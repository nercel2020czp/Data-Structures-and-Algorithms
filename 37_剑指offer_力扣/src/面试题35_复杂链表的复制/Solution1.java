package 面试题35_复杂链表的复制;

import java.util.HashMap;
import java.util.Map;

/*
题目描述
请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
还有一个 random 指针指向链表中的任意节点或者 null。【见图5.png】

*/
//算法(迭代)

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Solution1 {
	public Node copyRandomList(Node head) {
		// 使用哈希
		// 哈希表中<原表节点，新表节点>
		//
		Map<Node, Node> map = new HashMap<>();
		Node p = head;
		while (p != null) {
			map.put(p, new Node(p.val));
			p = p.next;
		}
		p = head;
		while (p != null) {
			map.get(p).next = map.get(p.next);
			map.get(p).random = map.get(p.random);
			p = p.next;
		}
		return map.get(head);
	}
	
/*	
	执行用时 :
		0 ms
		, 在所有 Java 提交中击败了
		100.00%
		的用户
		内存消耗 :
		40.7 MB
		, 在所有 Java 提交中击败了
		100.00%
		的用户
	*/
	
}
/*class Solution {
public:
    Node* copyRandomList(Node* head) {
        if (!head) return nullptr;
        
        unordered_map<Node*, Node*> mp;
        for (Node *it = head; it; it = it->next) {
            mp[it] = new Node(it->val);
        }
        for (Node *it = head; it; it = it->next) {
            if (it->next) mp[it]->next = mp[it->next];
            if (it->random) mp[it]->random = mp[it->random];
        }
        return mp[head];
    }
};

作者：happy_yuxuan
链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/solution/mian-shi-ti-35-fu-za-lian-biao-de-fu-zhi-san-chong/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/