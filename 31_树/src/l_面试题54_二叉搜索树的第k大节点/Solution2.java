package l_面试题54_二叉搜索树的第k大节点;
/*第二种迭代的方式我是在leetcode上看到一位同学写的，效率实测没有上面的好，
 * 但是可以看出楼主对二叉搜索树的理解，我对楼主的原代码做了一定的优化，我也建议
 * 大家平时的时候多集思广益，不光会一种解法，更是对这种数据结构的理解层次上的提升；

这种迭代的方式使用了栈结构，主要的思想就是，一个节点的右节点一定比这个节点的左子树乃至父
节点都大，所以我们需要利用栈结构迭代找到最右边的节点，当右节点遍历完了之后，再看一下这个右节
点有没有左子节点（因为这个右节点的左子节点也比这个右子节点的父节点大），左右都遍历完了，再输
出这个当前节点，同理，输出完当前节点，再看看当前节点有没有左子节点，没有的话，再回到当前节点的
父节点，这样以此类推，就能按照从大到小输出，当然我们只要第k大，所以定义一个常量，当到了第k个直
接return即可；如下图为我手画的基于示例图的堆栈执行过程；

作者：yang_hang
链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/solution/javaji-bai-100de-xiang-xi-jie-da-di-gui-he-die-dai/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
import java.util.Objects;
import java.util.Stack;

class Solution {
	public int kthLargest(TreeNode root, int k) {
		int count = 1;
		Stack<TreeNode> stack = new Stack<>();
		while (Objects.nonNull(root) || !stack.empty()) {
			while (Objects.nonNull(root)) {
				stack.push(root);
				root = root.right;
			}
			TreeNode pop = stack.pop();
			if (count == k) {
				return pop.val;
			}
			count++;
			root = pop.left;
		}
		return 0;
	}
/*	执行用时 :
		1 ms
		, 在所有 Java 提交中击败了
		67.48%
		的用户
		内存消耗 :
		40.8 MB
		, 在所有 Java 提交中击败了
		100.00%
		的用户*/
}
