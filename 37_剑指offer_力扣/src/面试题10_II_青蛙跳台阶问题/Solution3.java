package 面试题10_II_青蛙跳台阶问题;
//方法三：动态规划
/*
此题是 面试题10- I. fei斐波那契数列
的变形形式，强烈建议您先看上一题斐波那契数列的解题方法，再看这道题时边游刃有余了。

本题与上一题的不同点只有一个，即 f(0) = 1, f(1) = 1。


复杂度分析
时间复杂度：O(N)。我们计算了从 0 到 n 的值。
空间复杂度：O(N)。使用了数组 dp。


作者：z1m
链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/solution/dong-tai-gui-hua-by-ml-zimingmeng/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
public class Solution3 {
    public int numWays(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
