package l_0221_最大正方形_maximal_square;
/*方法三：动态规划优化
在前面的动态规划解法中，计算 i^{th} 行（row）的 dp 方法中，我们只使用了上一个元素和第 (i-1)^{th} 
行，因此我们不需要二维 dp 矩阵，因为一维 dp 足以满足此要求。

我们扫描一行原始矩阵元素时，我们根据公式：dp[j]=min(dp[j-1],dp[j],prev)
更新数组 dp，其中 prev 指的是 dp[j-1]，对于每一行，我们重复相同过程并在 dp 矩阵中更新元素。
【见图3.png】

作者：LeetCode
链接：https://leetcode-cn.com/problems/maximal-square/solution/zui-da-zheng-fang-xing-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
public class Solution3 {
    public int maximalSquare(char[][] matrix) {
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
