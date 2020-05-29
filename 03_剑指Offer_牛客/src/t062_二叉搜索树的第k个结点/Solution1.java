package t062_二叉搜索树的第k个结点;

import java.util.ArrayList;
// {8,6,10,5,7,9,11},8
// null,5
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Solution1 {
    ArrayList<TreeNode> list = new ArrayList<>(); // (1)
 
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        addNode(pRoot);
 
        if(k>=1 && list.size()>=k) {
            return list.get(k-1);
        }
 
        return null;
 
    }
 
    // 中序遍历
    void addNode(TreeNode cur) {   // (2)
        if(cur != null) {
            addNode(cur.left);
            list.add(cur);
            addNode(cur.right);
        }
    }
}
