package l_0144_二叉树的前序遍历_binary_tree_preorder_traversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution1 {
    public List<Integer> preorderTraversal(TreeNode root) {
    	List<Integer> resList = new LinkedList<>();
    	Stack<TreeNode> stack = new Stack<>();
    	if (root == null) 
    		return resList;
		TreeNode cur = root;
		while(!stack.empty() || cur != null) {
			/*首先，我们遍历左子树，边遍历边打印，并把根节点存入栈中，以后需借助这些节点进入右子树开启新一轮的循环。*/
			//边遍历边打印，并存入栈中，以后需要借助这些根节点(不要怀疑这种说法哦)进入右子树
			while(cur != null) {
				// 访问cur节点
				resList.add(cur.val);
				// 并把cur节点存入栈中
				stack.push(cur);
				// 向左走
				cur = cur.left;
			}
			//当p为空时，说明根和左子树都遍历完了，该进入右子树了
			if(!stack.empty()) {
				cur = stack.pop();
				cur = cur.right;
			}
		}
    	return resList;
    }
/*    执行用时 :
    	1 ms
    	, 在所有 Java 提交中击败了
    	59.98%
    	的用户
    	内存消耗 :
    	37.6 MB
    	, 在所有 Java 提交中击败了
    	5.17%
    	的用户*/
}
