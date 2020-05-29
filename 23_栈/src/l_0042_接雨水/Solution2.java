package l_0042_接雨水;
/*
2、动态规划   时间O(N) 空间O(N)
在上述的暴力法中，对于每个柱子，我们都需要从两头重新遍历一遍求出左右两侧的最大高度，
这里是有很多重复计算的，很明显最大高度是可以记忆化的，具体在这里可以用数组边递推边存储，
也就是常说的动态规划，DP。

具体做法：
	1.定义二维dp数组 int[][] dp = new int[n][2],
	   其中，dp[i][0] 表示下标i的柱子左边的最大值，
	 dp[i][1] 表示下标i的柱子右边的最大值。
	2.分别从两头遍历height数组，为 dp[i][0]和 dp[i][1] 赋值。
	3.同方法1，遍历每个柱子，累加每个柱子可以储水的高度。
 */
public class Solution2 {
	public int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }
        // 定义二维dp数组
        // dp[i][0] 表示下标i的柱子左边的最大值
        // dp[i][1] 表示下标i的柱子右边的最大值
        int[][] dp = new int[n][2];
        dp[0][0] = height[0];
        dp[n - 1][1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(height[i], dp[i - 1][0]);   
        }
        for (int i = n - 2; i >= 0; i--) {
            dp[i][1] = Math.max(height[i], dp[i + 1][1]);
        }
        // 遍历每个柱子，累加当前柱子顶部可以储水的高度，
        // 即 当前柱子左右两边最大高度的较小者 - 当前柱子的高度。
        int res = 0;
        for (int i = 1; i < n - 1; i++) {
            res += Math.min(dp[i][0], dp[i][1]) - height[i];
        } 
        return res;
    }
}
