package t041_和为S的连续正数序列;

import java.util.ArrayList;
import java.util.List;

//滑动窗口法【见图3.png】
public class Solution3 {
	public int[][] findContinuousSequence(int target) {
		int i = 1; // 滑动窗口的左边界
		int j = 1; // 滑动窗口的右边界
		int sum = 0; // 滑动窗口中数字的和
		List<int[]> res = new ArrayList<>();

		while (i <= target / 2) {
			if (sum < target) {
				// 右边界向右移动
				sum += j;
				j++;
			} else if (sum > target) {
				// 左边界向右移动
				sum -= i;
				i++;
			} else {
				// 记录结果
				int[] arr = new int[j - i];
				for (int k = i; k < j; k++) {
					arr[k - i] = k;
				}
				res.add(arr);
				// 左边界向右移动
				sum -= i;
				i++;
			}
		}
		return res.toArray(new int[res.size()][]);
	}
/*	执行用时 :
		4 ms
		, 在所有 Java 提交中击败了
		73.62%
		的用户
		内存消耗 :
		38 MB
		, 在所有 Java 提交中击败了
		100.00%
		的用户*/
}
