package c01_第一章_动态规划系列.c01_最长递增子序列;

/*
首先，给你一排扑克牌，我们像遍历数组那样从左到右一张一张处理这些扑克牌，最终要把这些牌分成若干堆。

处理这些扑克牌要遵循以下规则：
	1.只能把点数小的牌压到点数比它大的牌上。
	2.如果当前牌点数较大没有可以放置的堆，则新建一个堆，把这张牌放进去。
	3.如果当前牌有多个堆可供选择，则选择最左边的堆放置。

为什么遇到多个可选择堆的时候要放到最左边的堆上呢？因为这样可以保证牌堆顶的牌有序.

按照上述规则执行，可以算出最长递增子序列，牌的堆数就是最长递增子序列的长度，证明略。

 */
public class Solution2 {
	public int lengthOfLIS(int[] nums) {
		int length = nums.length;
		int[] top = new int[length];
		// 牌堆数初始化为 0
		int piles = 0;
		for (int i = 0; i < length; i++) {
			// 要处理的扑克牌
			int poker = nums[i];
			/***** 搜索左侧边界的二分查找 *****/
			int left = 0, right = piles;
			while (left < right) {
				int mid = (left + right) / 2;
				if (top[mid] > poker) {
					right = mid;
				} else if (top[mid] < poker) {
					left = mid + 1;
				} else {
					right = mid;
				}
			}
			/*********************************/
			// 没找到合适的牌堆， 新建⼀堆
			if (left == piles)
				piles++;
			// 把这张牌放到牌堆顶
			top[left] = poker;
		}
		// 牌堆数就是 LIS ⻓度
		return piles;
	}
}
