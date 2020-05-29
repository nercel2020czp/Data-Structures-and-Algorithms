package l_0064_最小路径和_minimum_path_sum;
//https://leetcode-cn.com/problems/minimum-path-sum/solution/zui-xiao-lu-jing-he-dong-tai-gui-hua-gui-fan-liu-c/
/*
	解题思路：
此题是典型的动态规划题目。

状态定义：
      设 dp 为大小 m×n 矩阵，其中 dp[i][j] 的值代表直到走到 (i,j) 的最小路径和。

转移方程：      
      题目要求，只能向右或向下走，换句话说，当前单元格 (i,j) 只能从左方单元格 (i-1,j)
      或上方单元格 (i,j-1) 走到，因此只需要考虑矩阵左边界和上边界。

      走到当前单元格 (i,j) 的最小路径和 = “从左方单元格 (i-1,j) 与 从上方单元格 (i,j-1)
      走来的 两个最小路径和中较小的 ” + 当前单元格值 grid[i][j]。具体分为以下 4 种情况：
      1)当左边和上边都不是矩阵边界时： 即当i ≠ 0, j ≠ 0时，
        dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]；
      2)当只有左边是矩阵边界时： 只能从上面来，即当i = 0, j ≠ 0时，
        dp[i][j] = dp[i][j - 1] + grid[i][j];
      3)当只有上边是矩阵边界时： 只能从左面来，即当i ≠ 0, j = 0时， 
        dp[i][j] = dp[i - 1][j] + grid[i][j]；
      4)当左边和上边都是矩阵边界时： 即当i = 0, j = 0时，其实就是起点， 
        dp[i][j] = grid[i][j]；

初始状态：
   dp 初始化即可，不需要修改初始 0 值。

返回值：
      返回 dp 矩阵右下角值，即走到终点的最小路径和。
      
其实我们完全不需要建立 dp 矩阵浪费额外空间，直接遍历 grid[i][j] 修改即可。这是因为：
grid[i][j] = min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j]；
原 grid 矩阵元素中被覆盖为 dp 元素后（都处于当前遍历点的左上方），不会再被使用到。

复杂度分析：
时间复杂度 O(M×N) ： 遍历整个 grid 矩阵元素。
空间复杂度 O(1) ： 直接修改原矩阵，不使用额外空间。


*/
public class Solution2 {
    public int minPathSum(int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(i == 0 && j == 0) continue;
                else if(i == 0)  grid[i][j] = grid[i][j - 1] + grid[i][j];
                else if(j == 0)  grid[i][j] = grid[i - 1][j] + grid[i][j];
                else grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
    
/*    执行结果：
    通过
    显示详情
    执行用时 :
    3 ms
    , 在所有 Java 提交中击败了
    84.57%
    的用户
    内存消耗 :
    42.3 MB
    , 在所有 Java 提交中击败了
    16.76%
    的用户*/
    
}
