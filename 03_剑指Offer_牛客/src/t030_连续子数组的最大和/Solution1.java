package t030_连续子数组的最大和;
/*
 * 参考/动态规划/src/t0053_最大子序和_maximum_subarray/Solution2.java
 * 这题目应该是最基础的动态规划的题目：最大子数组的和一定是由当前元素和之前最大连续子数组的和叠加在一起形成的，
因此需要遍历n个元素，看看当前元素和其之前的最大连续子数组的和能够创造新的最大值。*/
public class Solution1 {

	public int FindGreatestSumOfSubArray(int[] array) {
		int len = array.length;
		int[] dp = new int[len];
		int max = array[0];
		dp[0] = array[0];
		for (int i = 1; i < len; i++) {
			int newMax = dp[i - 1] + array[i];
			if (newMax > array[i])
				dp[i] = newMax;
			else
				dp[i] = array[i];
			if (dp[i] > max)
				max = dp[i];
		}
		return max;

	}
}
