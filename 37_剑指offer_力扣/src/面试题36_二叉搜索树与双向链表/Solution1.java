package 面试题36_二叉搜索树与双向链表;


/*解题思路
先写一个转换为双向不循环链表，再写一个头尾对接，就变成双向循环链表，击败100%*/

/*
由于要求转换之后的链表是排好序的,我们可以中序遍历树中的每个节点,
这是因为中序遍历算法的特点是按照从小到大的顺序遍历二叉树的每个节点。
当遍历到根节点的时候,我们把树看成3部分:值为10的节点,根节点值为6的
左子树:根节点值为14的右子树。根据排序链表的定义,值为10的节点将和它
的左子树的最大一个节点(值为8的节点)链接起来,同时它还将和右子树最小的
节点(值为12的节点)链接起来,

如图3.png

按照中序遍历的顺序,当我们遍历转换到根节点(值为10的节点)时,它的左子树已
经转换成一个排序的链表了,并且处在链表中的最后一个节点是当前值最大的节点。
我们把值为8的节点和根节点链接起来,此时链表中的最后一个节点就是10了。
接着我们去遍历转换右子树,并把根节点和右子树中最小的节点链接起来。至于怎
么去转换它的左子树和右子树,由于遍历和转换过程是一样的,我们很自然地想到
可以用递归。

按照中序递归遍历中，当我们遍历转换到根结点时，它的左子树已经转换成了一个排序
的链表，并且此时链表尾部的值为左子树中值最大的结点的值（8）。我们将它（8）
和根结点（10）链接起来，此时根结点（10）变成了链表尾部，接着去遍历右子树，
我们知道中序遍历根结点（10）后的一个结点此时为右子树值最小的结点（12），
我们将它和根结点链接起来。左右子树再用这样的办法，即递归即可解决问题。

*/
//Definition for a Node.
class Node {
	public int val;
	public Node left;
	public Node right;

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, Node _left, Node _right) {
		val = _val;
		left = _left;
		right = _right;
	}
}

public class Solution1 {
	Node head = null, pre = null, tail = null;

	public Node treeToDoublyList(Node root) {
		if (root == null)
			return root;
		// 中序遍历访问节点并连接
		inorder(root);
		// 连接头尾节点
		head.left = tail;
		tail.right = head;
		return head;
	}

	private void inorder(Node root) {
		// 递归出口
		if (root == null)
			return;
		// 访问左子树
		inorder(root.left);
		// 将当前节点和上一个节点连接
		if (pre == null)
			head = root;
		else
			pre.right = root;
		root.left = pre;
		pre = root;
		tail = root;
		// 访问右子树
		inorder(root.right);
		return;
	}

/*	
	
	执行用时 :
		0 ms
		, 在所有 Java 提交中击败了
		100.00%
		的用户
		内存消耗 :
		38.2 MB
		, 在所有 Java 提交中击败了
		100.00%
		的用户
	
	*/
}
