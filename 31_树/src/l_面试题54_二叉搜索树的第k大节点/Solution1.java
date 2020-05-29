package l_面试题54_二叉搜索树的第k大节点;
/*然后引出我们的第一种解法，递归，其实就是上面那种遍历方式的变形，我们不需要遍历完这个二叉树，
 * 我们只需要遍历到第k大的就好，所以我们要定义一个全局变量count为k（如果要是递归中使用局部
 * 变量会随着方法的弹栈而变化，不好控制），每遍历到一个节点我们就减一，知道count等于1，这
 * 时遍历到的数字就是最大的，我们此时记录答案终止递归，return方法即可；这种方法罕见的在
 * leetcode上内存和时间都击败了100%的JAVA同学；

作者：yang_hang
链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/solution/javaji-bai-100de-xiang-xi-jie-da-di-gui-he-die-dai/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
import java.util.Objects;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
//递归【推荐】
public class Solution1 {
    int count;
    int result = -1;

    public int kthLargest(TreeNode root, int k) {
        count = k;
        kthLargest(root);
        return result;
    }

    public void kthLargest(TreeNode root) {
        if (Objects.nonNull(root)) {
            kthLargest(root.right);
            if (count == 1) {
                result = root.val;
                count--;
                return;
            }
            count--;
            kthLargest(root.left);
        }
    }
/*    执行用时 :
    	1 ms
    	, 在所有 Java 提交中击败了
    	67.48%
    	的用户
    	内存消耗 :
    	41.6 MB
    	, 在所有 Java 提交中击败了
    	100.00%
    	的用户*/
}

/*作者：yang_hang
链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/solution/javaji-bai-100de-xiang-xi-jie-da-di-gui-he-die-dai/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/