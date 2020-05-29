package l_0107_二叉树的层次遍历_II;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*2020.04.04（107，easy）BFS层次遍历
晴天
发布于 1 个月前
3.6k
解题思路
本题和 102 题基本一致，区别就是每层的结点在二维数组中存放的先后顺序不同

前面所有代码都和 102 题一样，只需将最后存放位置每次都从 0 开始放就可以了

具体区别步骤写在代码注释处。*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution1 {
	
/*	执行用时 :
		1 ms
		, 在所有 Java 提交中击败了
		99.38%
		的用户
		内存消耗 :
		39.9 MB
		, 在所有 Java 提交中击败了
		7.41%
		的用户*/
	
	class Solution {
	    public List<List<Integer>> levelOrderBottom(TreeNode root) {
//	        List<List<Integer>> ans = new ArrayList<>();//最好不要用ArrayList
	        List<List<Integer>> ans = new LinkedList<>();
	        if (root == null) {
	            return ans;
	        }
	        Queue<TreeNode> q = new LinkedList<>();
	        q.add(root);
	        while (!q.isEmpty()) {
	            List<Integer> tmp = new ArrayList<>();
	            int len = q.size();
	            for (int i = 0; i < len; i++) {
	                TreeNode node = q.poll();
	                tmp.add(node.val);
	                if (node.left != null) {
	                    q.add(node.left);
	                }
	                if (node.right != null) {
	                    q.add(node.right);
	                }
	            }
	            // 在索引 0 的位置加入一维数组 tmp
	            // 每次新的数组进来都会被放在开始的位置
	            ans.add(0, tmp);
	        }
	        return ans;
	    }
	}

/*	作者：jasion_han-r
	链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/solution/20200404107easybfsceng-ci-bian-li-by-jasion_han-r/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
