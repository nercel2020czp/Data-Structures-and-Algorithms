package l_0300_最长上升子序列_lengthOfLIS;

/*
解法一：动态规划
解题思路：
	状态定义：
		dp[i] 的值代表 nums 前 i 个数字的最长子序列长度。
		
	转移方程： 
		设 j∈[0,i)考虑每轮计算新 dp[i] 时，遍历 [0,i)列表区间，做以下判断：
		1)当 nums[i] > nums[j] 时： nums[i] 可以接在 nums[j] 之后（此题要求严格递增），
			此情况下最长上升子序列长度为 dp[j] + 1；
		2)当 nums[i] <= nums[j] 时： nums[i] 无法接在 nums[j] 之后，此情况上升子序列
			不成立，跳过。
		上述所有 1)情况 下计算出的 dp[j] + 1 的最大值，为直到的最长上升子序列长度（即 dp[i]）。
		实现方式为遍历 j 时，每轮执行 dp[i] = max(dp[i], dp[j] + 1)。
		所以转移方程为： 
			dp[i] = max(dp[i], dp[j] + 1) for j in [0, i)。
			
	初始状态：
		dp[i] 所有元素置 11，含义是每个元素都至少可以单独成为子序列，此时长度都为 11。
		
	返回值：
		返回 dp 列表最大值，即可得到全局最长上升子序列长度。
		
	复杂度分析：
		时间复杂度 O(N^2) ： 遍历计算 dp 列表需 O(N)，计算每个 dp[i] 需 O(N)。
		空间复杂度 O(N) ： dp 列表占用线性大小额外空间。

作者：jyd
链接：https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-2/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/

import java.util.Arrays;

public class Solution1 {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) 
                	dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
