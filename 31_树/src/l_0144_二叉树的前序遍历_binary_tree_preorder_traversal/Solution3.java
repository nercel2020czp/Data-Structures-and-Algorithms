package l_0144_二叉树的前序遍历_binary_tree_preorder_traversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*迭代解法
本质上是在模拟递归，因为在递归的过程中使用了系统栈，所以在迭代的解法中常用Stack来模拟系统栈。

前序遍历
首先我们应该创建一个Stack用来存放节点，首先我们想要打印根节点的数据，此时Stack里面的内容为空，
所以我们优先将头结点加入Stack，然后打印。

之后我们应该先打印左子树，然后右子树。所以先加入Stack的就是右子树，然后左子树。
此时你能得到的流程如下:【见图1.png】


作者：gre-z
链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal/solution/leetcodesuan-fa-xiu-lian-dong-hua-yan-shi-xbian-2/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


*/


public class Solution3 {
    public List<Integer> preorderTraversal(TreeNode root) {
    	List<Integer> resList = new LinkedList<>();
    	Stack<TreeNode> stack = new Stack<>();
//    	LinkedList<TreeNode> stack = new LinkedList<>();
    	if (root == null) {
    		return resList;
    	}
    	stack.push(root);
    	while (!stack.isEmpty()) {
//    		TreeNode node = stack.pollLast();
    		TreeNode node = stack.pop();
    		resList.add(node.val);
    		//要注意的是先把右孩子压入栈
    		if (node.right != null) {
    			stack.push(node.right);
//    			stack.add(node.right);
    		}
    		//再把左孩子压入栈
    		if (node.left != null) {
    			stack.push(node.left);
//    			stack.add(node.left);
    		}
    	}
    	return resList;
    }
/*    
    执行用时 :
    	1 ms
    	, 在所有 Java 提交中击败了
    	59.98%
    	的用户
    	内存消耗 :
    	37.7 MB
    	, 在所有 Java 提交中击败了
    	5.17%
    	的用户*/
    
    
/*    算法复杂度

    时间复杂度：访问每个节点恰好一次，时间复杂度为 O(N) ，其中 NN 是节点的个数，也就是树的大小。
    空间复杂度：取决于树的结构，最坏情况存储整棵树，因此空间复杂度是 O(N)。
*/
	public List<Integer> preorderTraversal1(TreeNode root) {
		LinkedList<TreeNode> stack = new LinkedList<>();
		LinkedList<Integer> resList = new LinkedList<>();
		if (root == null) {
			return resList;
		}

		stack.add(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pollLast();
			resList.add(node.val);
			if (node.right != null) {
				stack.add(node.right);
			}
			if (node.left != null) {
				stack.add(node.left);
			}
		}
		return resList;
	}
/*	执行用时 :
		0 ms
		, 在所有 Java 提交中击败了
		100.00%
		的用户
		内存消耗 :
		37.7 MB
		, 在所有 Java 提交中击败了
		5.17%
		的用户*/
}