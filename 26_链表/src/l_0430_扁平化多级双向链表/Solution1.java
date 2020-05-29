package l_0430_扁平化多级双向链表;
/*


方法一：递归的深度优先搜素
我们可能会疑问什么情况下会使用这样的数据结构。其中一个场景就是 git 分支的简化版本。
通过扁平化多级列表，可以认为将所有 git 的分支合并在一起。

首先，为了清楚扁平化操作的效果，我们用下面的一个例子来说明。

图1.jpg

在上面的例子中，我们用不同的颜色区分不同级别的节点。扁平化的操作可以分为以下两个步骤：

图2.jpg

我们可以看到通过扁平化的操作，我们将 child 指针指向的列表合并到父列表。

这是解释扁平化操作的一种方式，看起来很直观，但可能会在实现过程中遇到挫折，是因为没有抓住问题的本质。

我们将列表顺时针转 90 °，那么就会看到一颗二叉树，则扁平化的操作也就是对二叉树进行先序遍历（深度优先搜索）

图3.jpg

如上图所示，我们可以将 child 指针当作二叉树中指向左子树的 left 指针。
同样，next 指针可以当作是二叉树中的 right 指针。
然后我们深度优先搜索树将得到答案。

算法：
	现在我们要做的就是模拟在二叉树进行深度优先搜索。

	我们知道实现深度优先搜索通常有两种方式：递归和迭代。我们先从递归开始。
	
	递归的深度优先搜索算法如下：

		1.首先，我们定义递归函数 flatten_dfs(prev, curr)，它接收两个指针作为函数参数并返回扁平化列表中的尾部指针。
		curr 指针指向我们要扁平化的子列表，prev 指针指向 curr 指向元素的前一个元素。
		
		2.在函数 flatten_dfs(prev, curr)，我们首先在 prev 和 curr 节点之间建立双向连接。
		
		3.然后在函数中调用 flatten_dfs(curr, curr.child) 对左子树（curr.child 即子列表）进行操作，
		它将返回扁平化子列表的尾部元素 tail，再调用 flatten_dfs(tail, curr.next) 对右子树进行操作。
		
		4.为了得到正确的结果，我们还需要注意两个重要的细节：
			4.1在调用 flatten_dfs(curr, curr.child) 之前我们应该复制 curr.next 指针，因为 curr.next 可能在函数中改变。
			4.2在扁平化 curr.child 指针所指向的列表以后，我们应该删除 child 指针，因为我们最终不再需要该指针。


作者：LeetCode
链接：https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list/solution/bian-ping-hua-duo-ji-shuang-xiang-lian-biao-by-lee/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

作者：LeetCode
链接：https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list/solution/bian-ping-hua-duo-ji-shuang-xiang-lian-biao-by-lee/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
    

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }

}
public class Solution1 {

	class Solution {
	  public Node flatten(Node head) {
	    if (head == null) return head;
	    // pseudo head to ensure the `prev` pointer is never none
	    Node pseudoHead = new Node(0, null, head, null);

	    flattenDFS(pseudoHead, head);

	    // detach the pseudo head from the real head
	    pseudoHead.next.prev = null;
	    return pseudoHead.next;
	  }
	  /* return the tail of the flatten list */
	  public Node flattenDFS(Node prev, Node curr) {
	    if (curr == null) return prev;
	    curr.prev = prev;
	    prev.next = curr;

	    // the curr.next would be tempered in the recursive function
	    Node tempNext = curr.next;

	    Node tail = flattenDFS(curr, curr.child);
	    curr.child = null;

	    return flattenDFS(tail, tempNext);
	  }
	}

}
