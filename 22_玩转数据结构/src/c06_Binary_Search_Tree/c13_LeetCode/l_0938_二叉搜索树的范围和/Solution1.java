package c06_Binary_Search_Tree.c13_LeetCode.l_0938_二叉搜索树的范围和;
//看到二叉排序树就中序遍历。【有待优化】
public class Solution1 {
/*	class Solution {
		public:
		    int rangeSumBST(TreeNode* root, int L, int R) {
		        int sum = 0;
		        int last = -1;
		        DFS(root, sum, L, R);
		        return sum;       
		    }
		    void DFS(TreeNode* root, int& sum,const int L, const int R){
		        if(root==nullptr) return;
		        //左子树
		        if(root->left) DFS(root->left,sum,L,R);
		        //如果当前结点的值在L-R之间，就相加
		        if(root->val>=L && root->val<=R)sum += root->val;
		        //右子树
		        if(root->right) DFS(root->right,sum,L,R);      
		    }
		};*/
	class Solution {
	    int ans;
	    public int rangeSumBST(TreeNode root, int L, int R) {
	        ans = 0;
	        dfs(root, L, R);
	        return ans;
	    }

	    public void dfs(TreeNode node, int L, int R) {
	        if (node != null) {
	            if (node.left != null)
	                dfs(node.left, L, R);
	            if (L <= node.val && node.val <= R)
	            	ans += node.val;
	            if (node.right != null)
	                dfs(node.right, L, R);
	        }
	    }
	}
/*	执行用时 :
		1 ms
		, 在所有 Java 提交中击败了
		49.97%
		的用户
		内存消耗 :
		47.3 MB
		, 在所有 Java 提交中击败了
		6.67%
		的用户*/
}
