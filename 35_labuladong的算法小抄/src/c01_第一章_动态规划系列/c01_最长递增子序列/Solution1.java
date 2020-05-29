package c01_第一章_动态规划系列.c01_最长递增子序列;

import java.util.Arrays;

import sun.security.util.Length;
/*输入: [10,9,2,5,3,7,101,18]
输出: 4 
解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
说明:

可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
你算法的时间复杂度应该为 O(n2) 。
进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?*/
public class Solution1 {
	public static void main(String[] args) {
		int[] arr = {10,9,2,5,3,7,101,18};
		System.out.println(lengthOfLIS(arr));
	}
	public static int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
		// dp 数组全都初始化为 1
		Arrays.fill(dp, 1);
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j])
					dp[i] = Math.max(dp[i], dp[j] + 1);
			}
		}
		int res = 0;
		for (int i = 0; i < dp.length; i++) 
			res = Math.max(res, dp[i]);
		return res;
	}
}
