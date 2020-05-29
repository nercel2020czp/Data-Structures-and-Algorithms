package l_0236_二叉树的最近公共祖先;
/*算法
(递归) O(n)O(n)

当我们用递归去做这个题时不要被题目误导，应该要明确一点
这个函数的功能有三个：给定两个节点 p 和 q

如果 p 和 q 都存在，则返回它们的公共祖先；
如果只存在一个，则返回存在的一个；
如果 p 和 q 都不存在，则返回null
本题说给定的两个节点都存在，那自然还是能用上面的函数来解决

具体思路：
（1） 如果当前结点 root 等于null，则直接返回null
（2） 如果 root 等于 p 或者 q ，那这棵树一定返回 p 或者 q
（3） 然后递归左右子树，因为是递归，使用函数后可认为左右子树已经算出结果，用 left 和 right 表示
（4） 此时若left为空，那最终结果只要看 right；若 right 为空，那最终结果只要看 left
（5） 如果 left 和 right 都非空，因为只给了 p 和 q 两个结点，都非空，说明一边一个，因此 root 是他们的最近公共祖先
（6） 如果 left 和 right 都为空，则返回空（其实已经包含在前面的情况中了）

时间复杂度是O(n)O(n)：每个结点最多遍历一次或用主定理，空间复杂度是O(n)O(n)：需要系统栈空间

作者：Wilson79
链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/c-jing-dian-di-gui-si-lu-fei-chang-hao-li-jie-shi-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution1 {
/*	执行用时 :
		8 ms
		, 在所有 Java 提交中击败了
		86.36%
		的用户
		内存消耗 :
		42.2 MB
		, 在所有 Java 提交中击败了
		5.71%
		的用户*/
	
	
/*	具体思路：
	（1） 如果当前结点 root 等于null，则直接返回null
	（2） 如果 root 等于 p 或者 q ，那这棵树一定返回 p 或者 q
	（3） 然后递归左右子树，因为是递归，使用函数后可认为左右子树已经算出结果，用 left 和 right 表示
	（4） 此时若left为空，那最终结果只要看 right；若 right 为空，那最终结果只要看 left
	（5） 如果 left 和 right 都非空，因为只给了 p 和 q 两个结点，都非空，说明一边一个，因此 root 是他们的最近公共祖先
	（6） 如果 left 和 right 都为空，则返回空（其实已经包含在前面的情况中了）*/
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		//（1） 如果当前结点 root 等于null，则直接返回null
		if(root == null)
            return null;
        //（2） 如果 root 等于 p 或者 q ，那这棵树一定返回 p 或者 q
		if(root == p || root == q) 
            return root;
        //（3） 然后递归左右子树，因为是递归，使用函数后可认为左右子树已经算出结果，
		//用 left 和 right 表示 
        TreeNode left =  lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //（4） 此时若left为空，那最终结果只要看 right；若 right 为空，那最终结果只要看 left
        if(left == null)
            return right;
        if(right == null)
            return left;      
		//（5） 如果 left 和 right 都非空，因为只给了 p 和 q 两个结点，都非空，说明一边一个，
        //因此 root 是他们的最近公共祖先
        if (left != null && right != null) // p和q在两侧
			return root;
        //（6） 如果 left 和 right 都为空，则返回空（其实已经包含在前面的情况中了）
        return null; // 必须有返回值
	}
}
