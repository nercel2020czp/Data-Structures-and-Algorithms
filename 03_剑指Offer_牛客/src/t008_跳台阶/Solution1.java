package t008_跳台阶;
/*方法一：动态规划
算法

不难发现，这个问题可以被分解为一些包含最优子结构的子问题，
即它的最优解可以从其子问题的最优解来有效地构建，我们可以使
用动态规划来解决这一问题。

第 i 阶可以由以下两种方法得到：
	在第 (i-1) 阶后向上爬1阶。
	在第 (i-2) 阶后向上爬 2 阶。
	
所以到达第 i 阶的方法总数就是到第 (i-1)阶和第 (i-2)阶的方法数之和。

令 dp[i] 表示能到达第 i 阶的方法总数：dp[i]=dp[i-1]+dp[i-2]


作者：LeetCode
链接：https://leetcode-cn.com/problems/climbing-stairs/solution/pa-lou-ti-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
public class Solution1 {
    public int JumpFloor(int target) {

        if (target == 1) {
            return 1;
        }
        int[] dp = new int[target + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= target; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target];
    }
}
