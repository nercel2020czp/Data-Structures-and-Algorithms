package c01_单调栈.l_1130_叶值的最小代价生成树;
/*
分析：
这道题有两种解法，一种是动态规划，另一种是使用单调栈。
感谢刘岳大佬的题解。
代码：
动态规划：
我们发现数组中的数可以划分为两部分，一半是左子树，一半是右子树，根节点就是左边最大和右边最大的乘积。
而左右子树里面的值就是当数组中的数为左子树的叶子节点时的情况，右边一样。
直到数组中的数只有2个时，答案就是左边右边相乘。
因此我们可以这么看，如果2个数后面又加了一个数，那么我们可以以01为一个节点再和2划分,也可以0一个节点和12划分。
树的左右两边至少有1个叶子结点。
如果有四个数，有0 123, 01 23, 012 3,同时3个数又有之前的情况。
因此我可以这样找状态，i代表起始点,j代表结束位置。如果我想知道4个数的答案，我就把上面划分的情况算出来，每一个情况还要加上左边和右边的最大值的乘积，作为根节点。
于是乎我就是要穷举所有状态。

作者：ripple-zjw
链接：https://leetcode-cn.com/problems/minimum-cost-tree-from-leaf-values/solution/xiang-xi-jie-shi-dong-tai-gui-hua-dan-diao-zhan-ji/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

/*执行用时 :
4 ms
, 在所有 Java 提交中击败了
63.88%
的用户
内存消耗 :
38 MB
, 在所有 Java 提交中击败了
100.00%
的用户*/

public class Solution1 {
	class Solution {
	    public int mctFromLeafValues(int[] arr) {
	        int len = arr.length;
	        int[][] dp = new int[len][len];
	        int[][] maxVal = new int[len][len];
	        for (int i = 0; i < len; i++) {
	            for (int j = 0; j < len; j++) {
	                int max = 0;
	                for (int k = i; k <= j; k++) if (max < arr[k]) max = arr[k];
	                maxVal[i][j] = max;
	            }
	        }
	        for (int i = 0; i < len; i++) for (int j = 0; j < len; j++) dp[i][j] = Integer.MAX_VALUE;
	        for (int i = 0; i < len; i++) dp[i][i] = 0;
	        for (int i = 1; i < len; i++) { // 长度
	            for (int j = 0; j < len - i; j++) { // 起始点
	                for (int k = j; k < j + i; k++) { // 中间点
	                    dp[j][j+i] = Math.min(dp[j][j+i], dp[j][k] + dp[k+1][j+i] + maxVal[j][k] * maxVal[k+1][j+i]);
	                }
	            }
	        }
	        return dp[0][len-1];
	    }
	}

}
