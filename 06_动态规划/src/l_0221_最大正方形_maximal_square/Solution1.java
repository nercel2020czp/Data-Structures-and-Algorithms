package l_0221_最大正方形_maximal_square;

/*
方法二：动态规划
我们用一个例子来解释这个方法：
0 1 1 1 0
1 1 1 1 1
0 1 1 1 1
0 1 1 1 1
0 0 1 1 1
1.我们用 0 初始化另一个矩阵 dp，维数和原始矩阵维数相同；
2.dp(i,j) 表示的是由 1 组成的最大正方形的边长；
  【注意：】应该是以dp(i,j)【=1】为右下角坐标时的最大正方形的边长
3.从 (0,0) 开始，对原始矩阵中的每一个 1，我们将当前元素的值更新为:
	dp(i, j)=min(dp(i−1, j), dp(i−1, j−1), dp(i, j−1))+1
4.我们还用一个变量记录当前出现的最大边长，这样遍历一次，找到最大的正方形边长 
  maxsqlenmaxsqlen，那么结果就是 maxsqlen^2。
  
  可以通过下面的图来理解该工作原理：【见图1.png】
  
(1,3) 处的 2 表示到该索引为止有个边长为 2 的正方形。同样的，(1,2) 和 (2,2)
 处的 2 也表示到该索引为止有边长为 2 的正方形。到了 (3,3)，原始矩阵中 (3,3)中的 1，
 形成了边长为 3 的正方形，所以在 (3,3) 中应该为 3。
 
 现在考虑索引 (3,4) 的情况，到 (3,4) 所能形成的最大正方形为 2，所以 (3,4) 应为 2。
--------------------------------------------------------------------
方法三：动态规划优化
在前面的动态规划解法中，计算 i^{th} 行（row）的 dp 方法中，我们只使用了上一个元素和第 (i-1)^{th} 
行，因此我们不需要二维 dp 矩阵，因为一维 dp 足以满足此要求。

我们扫描一行原始矩阵元素时，我们根据公式：dp[j]=min(dp[j-1],dp[j],prev)
更新数组 dp，其中 prev 指的是 dp[j-1]，对于每一行，我们重复相同过程并在 dp 矩阵中更新元素。
【见图3.png】


作者：LeetCode
链接：https://leetcode-cn.com/problems/maximal-square/solution/zui-da-zheng-fang-xing-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

*/
public class Solution1 {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[][] dp = new int[rows + 1][cols + 1];
        //【注意：】应该是以dp(i,j)【=1】为右下角坐标时的最大正方形的边长
        int maxsqlen = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
                }
            }
        }
        return maxsqlen * maxsqlen;
    }
/*    
    复杂度分析
	    时间复杂度：O(mn)。
	    空间复杂度：O(mn)，用了一个大小相同的矩阵 dp。
*/
    
    public int maximalSquare1(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[] dp = new int[cols + 1];
        int maxsqlen = 0, prev = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        return maxsqlen * maxsqlen;
    }
/*    
    复杂度分析

    时间复杂度：O(mn)。
    空间复杂度：O(n)，使用了一个一维数组 dp。
    */
    
}

