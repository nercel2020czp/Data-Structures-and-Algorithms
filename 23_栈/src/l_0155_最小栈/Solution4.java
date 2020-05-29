package l_0155_最小栈;

/*解法四
再分享一个有趣的解法，参考 这里 。

回到最初的疑虑，我们要不要用 java 提供的 stack 。
如果不用的话，可以怎么做的？

直接用一个链表即可实现栈的基本功能，那么最小值该怎么得到呢？
我们可以在 Node 节点中增加一个 min 字段，这样的话每次加入一个节点的时候，
我们同时只要确定它的 min 值即可。

代码很简洁，我直接把代码贴过来吧。

作者：windliang
链接：https://leetcode-cn.com/problems/min-stack/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-38/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/

public class Solution4 {
	
/*	执行用时 :
		5 ms
		, 在所有 Java 提交中击败了
		99.91%
		的用户
		内存消耗 :
		41.9 MB
		, 在所有 Java 提交中击败了
		13.25%
		的用户*/
	
	class MinStack {
	    class Node{
	        int value;
	        int min;
	        Node next;

	        Node(int x, int min){
	            this.value=x;
	            this.min=min;
	            next = null;
	        }
	    }
	    Node head;
	    //每次加入的节点放到头部
	    //头插法
	    public void push(int x) {
	        if(null==head){
	            head = new Node(x,x);
	        }else{
	            //当前值和之前头结点的最小值较小的做为当前的 min
	            Node n = new Node(x, Math.min(x,head.min));
	            n.next=head;
	            head=n;
	        }
	    }

	    public void pop() {
	        if(head!=null)
	            head =head.next;
	    }

	    public int top() {
	        if(head!=null)
	            return head.value;
	        return -1;
	    }

	    public int getMin() {
	        if(null!=head)
	            return head.min;
	        return -1;
	    }
	}

/*	作者：windliang
	链接：https://leetcode-cn.com/problems/min-stack/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-38/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
