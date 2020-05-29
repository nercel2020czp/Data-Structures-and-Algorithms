package t067_剪绳子;
/*
3. 动态规划
其实，方法2已经满足的题目的要求。但是我们还能这样进一步考虑，将递归转化为递推，
将自顶向下的思路转换为自底向上，这也是记忆化搜索和DP之间的区别所在。
代码如下：

作者：97wgl
链接：https://leetcode-cn.com/problems/integer-break/solution/bao-li-sou-suo-ji-yi-hua-sou-suo-dong-tai-gui-hua-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
public class Solution3 {
	// 动态规划
	public int cutRope(int n) {
		int[] dp = new int[n + 1];
	    dp[2] = 1;
	    for (int i = 3; i <= n; i++) {
	        for ( int j = 1; j <= i - 1; j++) {
	            dp[i] = Math.max(dp[i], 
	            		Math.max(j * dp[i - j], j * (i - j)));
	        }
	    }
	    return dp[n];
	}
/*	运行时间：16ms

	占用内存：9688k*/
}
