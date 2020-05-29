package l_0045_跳跃游戏_II;

/*
思路【这种思路最好理解】
如果某一个作为 起跳点 的格子可以跳跃的距离是 3，那么表示后面 3 个格子都可以作为 起跳点。
11. 可以对每一个能作为 起跳点 的格子都尝试跳一次，把 能跳到最远的距离 不断更新。

如果从这个 起跳点 起跳叫做第 1 次 跳跃，那么从后面 3 个格子起跳 都 可以叫做第 2 次 跳跃。

所以，当一次 跳跃 结束时，从下一个格子开始，到现在 能跳到最远的距离，都 是下一次 跳跃 的 起跳点。
31. 对每一次 跳跃 用 for 循环来模拟。
32. 跳完一次之后，更新下一次 起跳点 的范围。
33. 在新的范围内跳，更新 能跳到最远的距离。

记录 跳跃 次数，如果跳到了终点，就得到了结果。
图解

图4.png


作者：ikaruga
链接：https://leetcode-cn.com/problems/jump-game-ii/solution/45-by-ikaruga/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

public class Solution0 {
	public int jump(int[] nums) {
		int ans = 0;
		int start = 0;
		int end = 1;
		while (end < nums.length) {
			int maxPos = 0;
			for (int i = start; i < end; i++) {
				// 能跳到最远的距离
				maxPos = Math.max(maxPos, i + nums[i]);
			}
			start = end; // 下一次起跳点范围开始的格子
			end = maxPos + 1; // 下一次起跳点范围结束的格子
			ans++; // 跳跃次数
		}
		return ans;
	}
/*
	执行用时 :
		2 ms
		, 在所有 Java 提交中击败了
		94.90%
		的用户
		内存消耗 :
		41.8 MB
		, 在所有 Java 提交中击败了
		5.00%
		的用户*/
	
/*	作者：ikaruga
	链接：https://leetcode-cn.com/problems/jump-game-ii/solution/45-by-ikaruga/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
