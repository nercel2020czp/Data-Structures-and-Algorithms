package t004_重建二叉树;
/*
链接：https://www.nowcoder.com/questionTerminal/8a19cbe657394eeaac2f6ea9b0f6fcf6?answerType=1&f=discussion
来源：牛客网

关键是：利用前序序列根节点在前找到根节点，用根节点去中序序列划分成两部分，左部分是左子树，右部分是右子树。
再利用子树长度去前序序列把前序序列中的左右子树找出来，同时可以找出根节点。递归进行此步骤，如果子树长度为0，
则不需要生成子问题。

*/

/**
 * 关键是：利用前序序列根节点在前找到根节点，用根节点去中序序列划分成两部分，左部分是左子树，右部分是右子树。再利用子树长度去前序序列把前序序列中的左右子树找出来，同时可以找出根节点。递归进行此步骤，如果子树长度为0，则不需要生成子问题。
 */
public class Solution2 {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = new TreeNode(pre[0]);
        build(root, pre, 0, pre.length, in, 0, in.length);
        return root;
    }
 
    /**
     * 递归和二分思想，将问题不断划分，直到问题容易解决。
     * 做法是：对于一个根节点，先去中序序列中找到根节点的值所在位置，利用这个位置分成2部分，左部分的中序序列长度即为前序序列中左部分的中序序列长度，右部分亦然。
     * 然后开始生成子问题，如果序列长度为0则不需要生成子问题。否则：利用前序序列第一个元素为根节点的性质生成根节点，然后构造子问题。
     * @param root 根节点
     * @param pre 前序序列 范围是[pleft,pright)
     * @param in 中序序列 范围是[ileft,iright)
     */
    public void build(TreeNode root, int[] pre, int pleft, int pright, int[] in, int ileft, int iright) {
        int i;
        for (i = ileft; i < iright; i++) {
            if (in[i] == root.val) {//从中序序列寻找根节点的位置
                break;
            }
        }
        int t = i - ileft;
        if (t > 0) {
        	//子树长度为0时不必生成子问题
            root.left = new TreeNode(pre[pleft + 1]);
            build(root.left, pre, pleft + 1, pleft + 1 + t, in, ileft, i);
        }
 
        if (pright - pleft - 1 - t > 0) {
            root.right = new TreeNode(pre[pleft + 1 + t]);
            build(root.right, pre, pleft + 1 + t, pright, in, i + 1, iright);
        }
    }
}