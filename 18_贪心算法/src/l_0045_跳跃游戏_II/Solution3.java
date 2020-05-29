package l_0045_跳跃游戏_II;

/*

解法二：顺瓜摸藤
我们知道最终要到达最后一个位置，然后我们找前一个位置，遍历数组，找到能到达它的位置，离它最远的就是要找的位置。
然后继续找上上个位置，最后到了第 0 个位置就结束了。

至于离它最远的位置，其实我们从左到右遍历数组，第一个满足的位置就是我们要找的。

时间复杂度：O(n²)O(n²)，因为最坏的情况比如 1 1 1 1 1 1111111，position 会从 55 更新到 00，并且每次更新都会经历一个 for 循环。

空间复杂度：O(1)O(1)。

这种想法看起来更简单了，为什么奏效呢？我们可以这样想。

作者：windliang
链接：https://leetcode-cn.com/problems/jump-game-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-10/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

作者：windliang
链接：https://leetcode-cn.com/problems/jump-game-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-10/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

 */

public class Solution3 {
	public int jump(int[] nums) {
	    int position = nums.length - 1; //要找的位置
	    int steps = 0;
	    while (position != 0) { //是否到了第 0 个位置
	        for (int i = 0; i < position; i++) {
	            if (nums[i] >= position - i) {
	                position = i; //更新要找的位置
	                steps++;
	                break;
	            }
	        }
	    }
	    return steps;
	}

}
