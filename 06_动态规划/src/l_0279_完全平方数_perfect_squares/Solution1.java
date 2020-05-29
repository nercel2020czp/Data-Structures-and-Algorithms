package l_0279_完全平方数_perfect_squares;
//https://leetcode-cn.com/problems/perfect-squares/solution/hua-jie-suan-fa-279-wan-quan-ping-fang-shu-by-guan/

/*
解题方案
思路：
标签：动态规划
	1.首先初始化长度为n+1的数组dp，每个位置都为0
	2.如果n为0，则结果为0
	3.对数组进行遍历，下标为i，每次都将当前数字先更新为最大的结果，
	    即dp[i]=i，比如i=4，最坏结果为4=1+1+1+1即为4个数字
	4.动态转移方程为：dp[i] = MIN(dp[i], dp[i - j * j] + 1)，
	  i表示当前数字，j*j表示平方数
	5.时间复杂度：O(n*sqrt(n))，sqrt为平方根
*/

public class Solution1 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1]; // 默认初始化值都为0
        for (int i = 1; i <= n; i++) {
            dp[i] = i; // 最坏的情况就是每次+1
            for (int j = 1; i - j * j >= 0; j++) { 
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1); // 动态转移方程
            }
        }
        return dp[n];
    }
/*    
    执行用时 :
    	63 ms
    	, 在所有 Java 提交中击败了
    	23.49%
    	的用户
    	内存消耗 :
    	38.5 MB
    	, 在所有 Java 提交中击败了
    	10.54%
    	的用户
    
    */
    
    
    
}
