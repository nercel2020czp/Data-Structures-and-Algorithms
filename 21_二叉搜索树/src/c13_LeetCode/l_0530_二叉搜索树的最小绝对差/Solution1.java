package c13_LeetCode.l_0530_二叉搜索树的最小绝对差;
/*
解题思路
利用二叉树的中序遍历为升序的特性，将问题转化为在升序排列的数中寻找相邻两数的差的最小值。
用一个变量记录上一个数，每次只要计算当前数和上一个数的差，然后和最小值比较，并在比较后更新上一个数即可。
中序遍历结束后便可得到二叉树的最小绝对差。

作者：tyanyonecancode
链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/solution/marveljian-dan-de-xue-xi-bi-ji-530-by-tyanyonecanc/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

*/
/*作者：tyanyonecancode
链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/solution/marveljian-dan-de-xue-xi-bi-ji-530-by-tyanyonecanc/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution1 {
	class Solution {
	    private int pre;
	    private int minDif;
	    public int getMinimumDifference(TreeNode root) {
	        pre = -1;
	        minDif = Integer.MAX_VALUE;
	        inOrder(root);
	        return minDif;
	    }
	    private void inOrder(TreeNode root) {
	        if(root == null)    return;
	        inOrder(root.left);
	        if(pre != -1)
	            minDif = Math.min(minDif, root.val - pre);
	        pre = root.val;
	        inOrder(root.right);
	    }
	}
/*
	执行用时 :
		1 ms
		, 在所有 Java 提交中击败了
		85.87%
		的用户
		内存消耗 :
		39.5 MB
		, 在所有 Java 提交中击败了
		25.00%
		的用户*/
}
