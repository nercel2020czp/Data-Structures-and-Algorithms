package 面试题34_二叉树中和为某一值的路径;

import java.util.ArrayList;
import java.util.Stack;

/*
思路
回溯法的最佳实践！

注意题的要义是根结点到叶子结点值为和才是路径，所以在这次的题目中不断对树的每一个
孩子进行一个新的状态的递归求和，当回溯的时候，就需要进行状态重置，而状态重置在本
题中需要进行两次！
	一次是左子树完事，回溯，状态重置
	一次是右子树完事，回溯，状态重置

而且分外注意！对于叶子结点要额外处理，叶子结点的左右孩子都为 null，
对于一条正确的路径：不能让它回溯两次，因为：
	第一次状态，到底 null，得到正确答案
	回溯
	第二次状态，再次到底 null，又得到正确答案
	回溯

可以看到回得到两次答案，重复了，所以要判断一下叶子结点的情况，其他非叶子结点就回溯两次


*/
public class Solution2 {

	private ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
	private Stack<Integer> path = new Stack<Integer>();

	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
		if (root == null) {
			return new ArrayList<>();
		}
		find(root, target, 0);
		return paths;
	}

	private void find(TreeNode root, int target, int cur) {
		if (cur == target && root == null) {
			paths.add(new ArrayList<Integer>(path));

			return;
		}
		if (root == null) {
			return;
		}

		path.push(root.val);
		find(root.left, target, cur + root.val);
		path.pop();

		if (root.left == null && root.right == null) {
			return;
		}

		path.push(root.val);
		find(root.right, target, cur + root.val);
		path.pop();
	}
}
