package l_0045_跳跃游戏_II;

/*优化
从上面代码观察发现，其实被 while 包含的 for 循环中，i 是从头跑到尾的。

只需要在一次 跳跃 完成时，更新下一次 能跳到最远的距离。

并以此刻作为时机来更新 跳跃 次数。

就可以在一次 for 循环中处理。

作者：ikaruga
链接：https://leetcode-cn.com/problems/jump-game-ii/solution/45-by-ikaruga/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/

public class Solution1 {
	public int jump(int[] nums) {
		int ans = 0;
		int end = 0;
		int maxPos = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			maxPos = Math.max(nums[i] + i, maxPos);
			if (i == end) {
				end = maxPos;
				ans++;
			}
		}
		return ans;
	}
/*	执行用时 :
		2 ms
		, 在所有 Java 提交中击败了
		94.90%
		的用户
		内存消耗 :
		41.9 MB
		, 在所有 Java 提交中击败了
		5.00%
		的用户*/
}
