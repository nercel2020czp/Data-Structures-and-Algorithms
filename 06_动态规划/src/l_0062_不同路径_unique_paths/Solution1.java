package l_0062_不同路径_unique_paths;

import java.util.Arrays;

/*
思路二：动态规划:
	我们令 dp[i][j] 是到达 i, j 最多路径
	状态转移方程：dp[i][j] = dp[i-1][j] + dp[i][j-1]
	注意，对于第一行 dp[0][j]，或者第一列 dp[i][0]，由于都是在边界，所以只能为 1
	时间复杂度：O(m*n)
	空间复杂度：O(m*n)
	优化：因为我们每次只需要 dp[i-1][j],dp[i][j-1]
	
*/			
public class Solution1 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) dp[0][i] = 1;
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];  
    }
    
//    优化1：空间复杂度 O(2n)
    public int uniquePaths1(int m, int n) {
        int[] pre = new int[n];
        int[] cur = new int[n];
        Arrays.fill(pre, 1);
        Arrays.fill(cur,1);
        for (int i = 1; i < m;i++){
            for (int j = 1; j < n; j++){
                cur[j] = cur[j-1] + pre[j];
            }
            pre = cur.clone();
        }
        return pre[n-1]; 
    }
    
//    优化2：空间复杂度 O(n)
    public int uniquePaths2(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur,1);
        for (int i = 1; i < m;i++){
            for (int j = 1; j < n; j++){
                cur[j] += cur[j-1] ;
            }
        }
        return cur[n-1];
    }
//    这是个杨辉三角形，每个位置的路径 = 该位置左边的路径 + 该位置上边的路径
    

/*作者：powcai
链接：https://leetcode-cn.com/problems/unique-paths/solution/dong-tai-gui-hua-by-powcai-2/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
