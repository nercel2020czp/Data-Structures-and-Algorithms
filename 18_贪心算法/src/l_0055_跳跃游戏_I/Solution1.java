package l_0055_跳跃游戏_I;
/*
解题思路：
	如果某一个作为 起跳点 的格子可以跳跃的距离是 3，那么表示后面 3 个格子都可以作为 起跳点。
	可以对每一个能作为 起跳点 的格子都尝试跳一次，把 能跳到最远的距离 不断更新。
	如果可以一直跳到最后，就成功了。

作者：ikaruga
链接：https://leetcode-cn.com/problems/jump-game/solution/55-by-ikaruga/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Solution1 {
	class Solution {
		public boolean canJump(int[] nums) {
			int k = 0;
			for (int i = 0; i < nums.length; i++) {
				//这里面好像有点动态规划的思想
				if (i > k)//已经跳了i步
					return false;
				//更新能够达到的最远距离
				k = Math.max(k, i + nums[i]);
			}
			return true;

		}
/*		
		执行用时 :
			2 ms
			, 在所有 Java 提交中击败了
			71.32%
			的用户
			内存消耗 :
			42.2 MB
			, 在所有 Java 提交中击败了
			12.50%
			的用户*/
	}
/*	
    作者：ikaruga
    链接：https://leetcode-cn.com/problems/jump-game/solution/55-by-ikaruga/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
	
}
