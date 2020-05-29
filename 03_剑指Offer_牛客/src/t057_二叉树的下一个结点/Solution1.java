package t057_二叉树的下一个结点;

import java.util.ArrayList;

/*
1. 还原二叉树
	1. 分析
	既然给了二叉树的某个结点，且二叉树存储着指向父结点的指针（next），那我们可以先找到根节点，
	再对树进行中序遍历，最后根据中序遍历结果找到给定结点的下一结点

*/
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
public class Solution1 {

	static ArrayList<TreeLinkNode> list = new ArrayList<>();

	public TreeLinkNode GetNext(TreeLinkNode pNode) {
		//1.既然给了二叉树的某个结点，且二叉树存储着指向父结点的指针（next），那我们可以先找到根节点，
		TreeLinkNode par = pNode;
		while (par.next != null) {
			par = par.next;
		}
		//2.再对树进行中序遍历
		InOrder(par);
		//3.最后根据中序遍历结果找到给定结点的下一结点
		for (int i = 0; i < list.size(); i++) {
			if (pNode == list.get(i)) {
				return i == list.size() - 1 ? null : list.get(i + 1);
			}
		}
		return null;
	}

	void InOrder(TreeLinkNode pNode) {
		if (pNode != null) {
			InOrder(pNode.left);
			list.add(pNode);
			InOrder(pNode.right);
		}
	}
}
