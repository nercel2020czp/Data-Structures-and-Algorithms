package t022_从上往下打印二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
链接：https://www.nowcoder.com/questionTerminal/7fe2212963db4790b57431d9ed259701?answerType=1&f=discussion
来源：牛客网

这道题目本身思想不难，用一个队列来存储这些曾经访问过但是仍旧有用的节点。
应该难就难在在各个编程语言中队列的实现，尤其如果要用C++或者C来编程那就
更难了，所以这道题目在锻炼了解题思路的同时也让我对Java中对QUeue这个高
级数据结构的实现有了进一步的了解


在Java中Queue是和List、Map同等级别的接口，LinkedList中也实现了Queue接口，该接口中的主要函数有：

容量不够或队列为空时不会抛异常：offer（添加队尾元素）、peek（访问队头元素）、poll（访问队头元素并移除）
容量不够或队列为空时抛异常：add、element（访问队列元素）、remove（访问队头元素并移除）

树【二叉树】的程序遍历：
	1.将根节点入队
	2.循环执行以下操作，直到队列为空
		2.1 将队头节点A出队，进行访问
		2.2 将A的左子结点入队
		2.3 将A的右子结点入队


*/

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }

}
public class Solution1 {

	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root == null)
			return result;
/*		在Java中Queue是和List、Map同等级别的接口，LinkedList中也实现了Queue接口，该接口中的主要函数有：
		容量不够或队列为空时不会抛异常：offer（添加队尾元素）、peek（访问队头元素）、poll（访问队头元素并移除）
		容量不够或队列为空时抛异常：add、element（访问队列元素）、remove（访问队头元素并移除）*/
		
/*		树【二叉树】的程序遍历：
		1.将根节点入队
		2.循环执行以下操作，直到队列为空
			2.1 将队头节点A出队，进行访问
			2.2 将A的左子结点入队
			2.3 将A的右子结点入队*/
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			//poll（访问队头元素并移除）
			TreeNode temp = queue.poll();
			result.add(temp.val);
			//左右孩子入队
			if (temp.left != null)
				queue.offer(temp.left);//offer（添加队尾元素）
			if (temp.right != null)
				queue.offer(temp.right);//offer（添加队尾元素）
		}
		return result;
	}
}
