package l_0429_N叉树的层序遍历;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
方法二：简化的广度优先搜索



*/
public class Solution3 {
	// This code is a modified version of the code posted by
	// #zzzliu on the discussion forums.
	
/*	复杂度分析

	时间复杂度：O(n)O(n)。nn 指的是节点的数量。
	空间复杂度：O(n)O(n)，我们的列表包含所有节点。*/
	
/*	执行用时 :
		3 ms
		, 在所有 Java 提交中击败了
		80.02%
		的用户
		内存消耗 :
		40.4 MB
		, 在所有 Java 提交中击败了
		100.00%
		的用户*/
	
	class Solution {

	    public List<List<Integer>> levelOrder(Node root) {
	        List<List<Integer>> result = new ArrayList<>();
	        if (root == null) return result;

	        List<Node> previousLayer = Arrays.asList(root);

	        while (!previousLayer.isEmpty()) {
	            List<Node> currentLayer = new ArrayList<>();
	            List<Integer> previousVals = new ArrayList<>();
	            for (Node node : previousLayer) {
	                previousVals.add(node.val);
	                currentLayer.addAll(node.children);
	            }
	            result.add(previousVals);
	            previousLayer = currentLayer;
	        }

	        return result;
	    }
	}

/*	作者：LeetCode
	链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/solution/ncha-shu-de-ceng-xu-bian-li-by-leetcode/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
