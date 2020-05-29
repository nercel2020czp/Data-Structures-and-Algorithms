package l_0460_LFU缓存_lfu_cache;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/*三、O(N) 解法
最傻fufuの O(N) —— 只用1条双向链表
使 freq 小的 Node 在链表的左边，freq 大的 Node 在链表的右边，freq 相等的话最久使用的 Node 在左边、最近使用的 Node 在右边，因此满了之后删除 head.post，该 Node 即 freq 最小且最久访问的。
每次 node 的 freq++ 后，从当前位置向后遍历链表，直到 nextNode.freq > node.freq || nextNode == tail，在 nextNode 之前插入该 node。

作者：sweetiee
链接：https://leetcode-cn.com/problems/lfu-cache/solution/java-13ms-shuang-100-shuang-xiang-lian-biao-duo-ji/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/

/*执行用时 :
90 ms
, 在所有 Java 提交中击败了
22.10%
的用户
内存消耗 :
48.3 MB
, 在所有 Java 提交中击败了
100.00%
的用户*/


class LFUCache {

    HashMap<Integer, Node> cache;
    Node head;
    Node tail;
    int capacity;
    int size;

    public LFUCache(int capacity) {
        cache = new HashMap<Integer, Node>(capacity);
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.post = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        node.freq++;
        moveToNewPosition(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            node.freq++;
            moveToNewPosition(node);
        } else {
            if (size == capacity) {
                cache.remove(head.post.key);
                removeNode(head.post);
                size--;
            }
            Node newNode = new Node(key, value);
            addNode(newNode);
            cache.put(key, newNode);
            size++;
        }
    }

    private void moveToNewPosition(Node node) {
        Node nextNode = node.post;
        removeNode(node);
        while (nextNode.freq <= node.freq && nextNode != tail) {
            nextNode = nextNode.post;
        }
        nextNode.pre.post = node;
        node.pre = nextNode.pre;
        node.post = nextNode;
        nextNode.pre = node;
    }

    private void addNode(Node node) {
        node.post = head.post;
        node.pre = head;
        head.post.pre = node;
        head.post = node;
        moveToNewPosition(node);
    }

    private void removeNode(Node node) {
        node.pre.post = node.post;
        node.post.pre = node.pre;
    }
}

class Node {
    int key;
    int value;
    int freq = 1;
    Node pre;
    Node post;

    public Node() {}
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

//作者：sweetiee
//链接：https://leetcode-cn.com/problems/lfu-cache/solution/java-13ms-shuang-100-shuang-xiang-lian-biao-duo-ji/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

public class Solution1 {

}
