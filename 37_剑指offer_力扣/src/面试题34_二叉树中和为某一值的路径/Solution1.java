package 面试题34_二叉树中和为某一值的路径;

/*
解题思路：
本问题是典型的二叉树方案搜索问题，使用回溯法解决，其包含 先序遍历 + 路径记录 两部分。

	先序遍历： 按照“根、左、右”的顺序，遍历树的所有节点。
	路径记录： 在先序遍历中，当 
		① 根节点到叶节点形成的路径 且 
		② 路径各节点值的和等于目标值 sum 时，记录此路径。
		【见图1.png】
		
算法流程：
	pathSum(root, sum) 函数：
		初始化： 结果列表 res ，路径列表 path 。
		返回值： 返回 res 即可。
	recur(root, target) 函数：
		递推参数： 当前节点 root ，当前目标值 target 。
		终止条件： 若节点 root 为空，则直接返回。
		递推工作：
			1.路径更新： 将当前节点值 root.val 加入路径 path ；
			2.目标值更新： target = target - root.val（即目标值 target 从 sum 减至 0 ）；
			3.路径记录： 当 
				① root 的左 / 右子节点都为空（即 root 为叶节点） 且
				② target 等于 00 （即路径和等于目标值），则将此路径 path 加入 res 。
			4.先序遍历： 递归左 / 右子节点。
			5.路径恢复： 向上回溯前，需要将当前节点从路径 path 中删除，即执行 path.pop() 。

复杂度分析：
	时间复杂度 O(N) ： N 为二叉树的节点数，先序遍历需要遍历所有节点。
	空间复杂度 O(N) ： 最差情况下，即树退化为链表时，path 存储所有树节点，使用 O(N) 额外空间。
	
代码：
	1.值得注意的是，记录路径时若直接执行 res.append(path) ，则是将 path 对象加入了 res ；
		后续 path 改变时， res 中的 path 对象也会随之改变。
	2.正确做法：res.append(list(path)) ，相当于复制了一个 path 并加入到 res 。



*/
import java.util.LinkedList;
import java.util.List;

//递归做法如下：【也是属于某种回溯法】

class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;

	public TreeNode(int val) {
		this.val = val;
	}
}
public class Solution1 {

	LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>(); 
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum);
        return res;
    }
    void recur(TreeNode root, int target) {
        if(root == null) return;
        path.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null)
            res.add(new LinkedList<Integer>(path));
        recur(root.left, target);
        recur(root.right, target);
        path.removeLast();
    }
/*    执行用时 :
    	1 ms
    	, 在所有 Java 提交中击败了
    	100.00%
    	的用户
    	内存消耗 :
    	41.3 MB
    	, 在所有 Java 提交中击败了
    	100.00%
    	的用户*/
}
