package l_0064_最小路径和_minimum_path_sum;
/*思路：
首先想到可以使用动态规划来解决，对于每一个状态都是由于上面或者左边的值加上当前值。

过程：
1. 创建 一个dp数组，状态转移方程，dp[i][j] = Math.min(dp[i][j-1]+grid[i][j],dp[i-1][j]+grid[i][j])
2. 考虑边界状态
 2.1 由于状态转移必须来自上一个状态，因此第一个状态dp[0][0]初始化为grid[0][0]
 2.2 最上一行的格子的上一个状态只可能来自左边
 2.2 最左一列的格子的上一个状态只可能来自上面
3. 循环，需要注意的是当i为0时候j不能为0，避免数组越界

根据以上思路写代码：*/
public class Solution1 {
	 public int minPathSum(int[][] grid) {
        //思路：首先想到可以使用动态规划来解决，对于每一个状态都是由于上面或者左边的值加上当前值
        //过程：
        /* 1、创建 一个dp数组，状态转移方程，dp[i][j] = Math.min(dp[i][j-1],dp[i-1][j])+grid[i][j]
           2、考虑边界状态
                2.1 由于状态转移必须来自上一个状态，因此第一个状态dp[0][0]初始化为grid[0][0]
                2.2 最上一行的格子的上一个状态只可能来自左边
                2.2 最左一列的格子的上一个状态只可能来自上面
            3、循环，需要注意的是当i为0时候j不能为0，避免数组越界
        * */


        //只有1格,要自主测试一下返回0还是返回这个格子的值作为开销
        if (grid.length <= 1 && grid[0].length <= 1) {
            return grid[0][0];
        }

        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];

        for (int i = 0; i < grid.length; i++) {
            for (int j = i==0?1:0; j < grid[0].length; j++) {

                if (i==0){
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                }else if (j==0){
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                }else {
                    dp[i][j] = Math.min(dp[i][j - 1] + grid[i][j], dp[i - 1][j] + grid[i][j]);
                }
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }
/*	 执行结果：
	 通过
	 显示详情
	 执行用时 :
	 6 ms
	 , 在所有 Java 提交中击败了
	 9.15%
	 的用户
	 内存消耗 :
	 41.8 MB
	 , 在所有 Java 提交中击败了
	 26.84%
	 的用户*/
	 
}
