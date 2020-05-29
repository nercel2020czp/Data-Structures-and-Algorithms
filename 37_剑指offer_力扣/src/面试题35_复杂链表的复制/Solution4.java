package 面试题35_复杂链表的复制;
//复杂链表的复制-简单易懂的三步解决问题【内存消耗和执行时间均打败100%】
/*
算法步骤：
	一、复制每一个节点，使得复制后的节点都在当前节点的下一个节点
	二、原生链表的节点的指向任意节点，使复制的节点也都指向某一任意节点
	三、重新连接节点，把原生节点重新连接起来，把克隆后的节点连接起来

图片展示总结：【见图6.png】

//	一、复制每一个节点，使得复制后的节点都在当前节点的下一个节点
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
    
//    二、原生链表的节点的指向任意节点，使复制的节点也都指向某一任意节点
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
//    三、重新连接节点，把原生节点重新连接起来，把克隆后的节点连接起来
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



 */
public class Solution4 {
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
