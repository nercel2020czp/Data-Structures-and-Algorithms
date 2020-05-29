package l_0138_复制带随机指针的链表;


/*
方法 3：O(1)O(1) 空间的迭代:
算法
遍历原来的链表并拷贝每一个节点，将拷贝节点放在原来节点的旁边，创造出一个旧节点和新节点交错的链表。
e4.png
如你所见，我们只是用了原来节点的值拷贝出新的节点。原节点 next 指向的都是新创造出来的节点。

cloned_node.next = original_node.next

original_node.next = cloned_node

迭代这个新旧节点交错的链表，并用旧节点的 random 指针去更新对应新节点的 random 指针。
比方说， B 的 random 指针指向 A ，意味着 B' 的 random 指针指向 A' 。

e5.png

现在 random 指针已经被赋值给正确的节点， next 指针也需要被正确赋值，以便将新的节点正确链接同时将旧节点重新正确链接。

e6.png
作者：LeetCode
链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer/solution/fu-zhi-dai-sui-ji-zhi-zhen-de-lian-biao-by-leetcod/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
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
public class Solution3 {
	public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        copy(head);
        randomDirect(head);
        return reList(head);
    }
    //拷贝链表
    private void copy(Node head){
        while(head!=null){
            Node cloneNode = new Node(head.val);
            Node nextNode = head.next;
            head.next = cloneNode;
            cloneNode.next = nextNode;
            head = cloneNode.next;
        }
    }
    //指定随机指针
    private void randomDirect(Node head){
        while(head!=null){
            Node cloneNode = head.next;
            if(head.random!=null){
                Node direct = head.random;
                cloneNode.random = direct.next;
            }
            head = cloneNode.next;
        }
    }
    //重新连接 链表
    private Node reList(Node head){
        Node cloneNode = head.next;
        Node cloneHead = cloneNode;
        head.next = cloneNode.next;
        head = head.next;
        while(head!=null){
            cloneNode.next = head.next;
            head.next = head.next.next;
            head = head.next;
            cloneNode = cloneNode.next;
        }
        return cloneHead;
    }
/*    
    执行用时 :
    	0 ms
    	, 在所有 Java 提交中击败了
    	100.00%
    	的用户
    	内存消耗 :
    	40.5 MB
    	, 在所有 Java 提交中击败了
    	100.00%
    	的用户*/


}
