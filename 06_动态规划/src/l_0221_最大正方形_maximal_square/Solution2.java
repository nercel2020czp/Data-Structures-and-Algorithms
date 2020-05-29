package l_0221_最大正方形_maximal_square;
/*理解 min(上, 左, 左上) + 1:
	如题，动态规划方法的题解中，都会涉及到下列形式的代码：
	if (grid(i, j) == 1) {
	    dp(i, j) = min(dp(i-1, j), dp(i, j-1), dp(i-1, j-1)) + 1;
	}
翻译成中文:
	若某格子值为 1 ，则以此为右下角的正方形的、最大边长为：上面的正方形、左面
	的正方形或左上的正方形中，最小的那个，再加上此格。
先来阐述简单共识:
	1.若形成正方形（非单 1），以当前为右下角的视角看，则需要：当前格、上、左、左上都是 1
	2.可以换个角度：当前格、上、左、左上都不能受 0 的限制，才能成为正方形
	见图2.png
	
	就像 木桶的短板理论 那样——附近的最小边长，才与 ? 的最长边长有关。
			此时已可得到递推公式
			if (grid[i][j] == 1) 
				f[i][j] = min(f[i-1][j-1], f[i-1][j], f[i][j-1]) + 1;

作者：lzhlyle
链接：https://leetcode-cn.com/problems/maximal-square/solution/li-jie-san-zhe-qu-zui-xiao-1-by-lzhlyle/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。	

*/
public class Solution2 {
	public int maximalSquare(char[][] matrix) {
	    // base condition
	    if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return 0;

	    int height = matrix.length;
	    int width = matrix[0].length;
	    int maxSide = 0;

	    // 相当于已经预处理新增第一行、第一列均为0
	    int[][] dp = new int[height + 1][width + 1];

	    for (int row = 0; row < height; row++) {
	        for (int col = 0; col < width; col++) {
	            if (matrix[row][col] == '1') {
	                dp[row + 1][col + 1] = Math.min(Math.min(dp[row + 1][col], dp[row][col + 1]), dp[row][col]) + 1;
	                maxSide = Math.max(maxSide, dp[row + 1][col + 1]);
	            }
	        }
	    }
	    return maxSide * maxSide;
	}

}
