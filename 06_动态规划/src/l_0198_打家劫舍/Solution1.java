package l_0198_打家劫舍;
/*思路
标签：动态规划
动态规划方程：dp[n] = MAX( dp[n-1], dp[n-2] + num )
由于不可以在相邻的房屋闯入，所以在当前位置 n 房屋可盗窃的最大值，要么就是 n-1 房屋可盗窃的最大值，要么就是 n-2 房屋可盗窃的最大值加上当前房屋的值，二者之间取最大值
举例来说：1 号房间可盗窃最大值为 33 即为 dp[1]=3，2 号房间可盗窃最大值为 44 即为 dp[2]=4，3 号房间自身的值为 22 即为 num=2，那么 dp[3] = MAX( dp[2], dp[1] + num ) = MAX(4, 3+2) = 5，3 号房间可盗窃最大值为 55
时间复杂度：O(n)O(n)，nn 为数组长度

作者：guanpengchn
链接：https://leetcode-cn.com/problems/house-robber/solution/hua-jie-suan-fa-198-da-jia-jie-she-by-guanpengchn/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
public class Solution1 {
	class Solution {
	    public int rob(int[] nums) {
	        int len = nums.length;
	        if(len == 0)
	            return 0;
	        int[] dp = new int[len + 1];
	        dp[0] = 0;
	        dp[1] = nums[0];
	        for(int i = 2; i <= len; i++) {
	            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
	        }
	        return dp[len];
	    }
	}
/*	执行用时 :
		0 ms
		, 在所有 Java 提交中击败了
		100.00%
		的用户
		内存消耗 :
		37.5 MB
		, 在所有 Java 提交中击败了
		6.52%
		的用户*/

/*	作者：guanpengchn
	链接：https://leetcode-cn.com/problems/house-robber/solution/hua-jie-suan-fa-198-da-jia-jie-she-by-guanpengchn/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
