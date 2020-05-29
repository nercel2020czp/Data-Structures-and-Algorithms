package l_0045_跳跃游戏_II;

/*
解法一 ：顺藤摸瓜
LeetCode 讨论里，大部分都是这个思路，贪婪算法，我们每次在可跳范围内选择可以使得跳的更远的位置。

如下图，开始的位置是 2，可跳的范围是橙色的。然后因为 3 可以跳的更远，所以跳到 3 的位置。

图1.PNG

如下图，然后现在的位置就是 3 了，能跳的范围是橙色的，然后因为 4 可以跳的更远，所以下次跳到 4 的位置。

图2.PNG

写代码的话，我们用 end 表示当前能跳的边界，对于上边第一个图的橙色 1，
第二个图中就是橙色的 4，遍历数组的时候，到了边界，我们就重新更新新的边界。

时间复杂度：O(n)O(n)。

空间复杂度：O(1)O(1)。

这里要注意一个细节，就是 for 循环中，i < nums.length - 1，少了末尾。因为开始的时候边界是第 00 个位置，steps 已经加 11 了。
如下图，如果最后一步刚好跳到了末尾，此时 steps 其实不用加 11 了。如果是 i < nums.length，i 遍历到最后的时候，会进入 if 语句中，
steps 会多加 11。

图3.PNG

作者：windliang
链接：https://leetcode-cn.com/problems/jump-game-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-10/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

作者：windliang
链接：https://leetcode-cn.com/problems/jump-game-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-10/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

 */

public class Solution2 {
	public int jump(int[] nums) {
	    int end = 0;
	    int maxPosition = 0; 
	    int steps = 0;
	    for(int i = 0; i < nums.length - 1; i++){
	        //找能跳的最远的
	        maxPosition = Math.max(maxPosition, nums[i] + i); 
	        if( i == end ){ //遇到边界，就更新边界，并且步数加一
	            end = maxPosition;
	            steps++;
	        }
	    }
	    return steps;
	}
	class Solution {
	    public int jump(int[] nums) {
	        /*

	        题目说明：假设你总是可以到达数组的最后一个位置。
	        即一定存在一条路线能够到达最后一个位置，而不是说中间没有 0 ，只是存在可以越过 0 的路线

	        贪心算法：找能跳的最远的
	        使用 k 记录目前能够跳到的最高位置
	        使用 end 记录这次跳跃的边界，到达边界就跳跃次数 + 1

	        过程解析：
	        最开始遍历 i = 0, end = 0,因此 step 会进行 step ++，我们可以认为，这是开始起跳，因为必定会落下，因此跳跃次数 + 1
	        而 nums[0] 这个数限制了你只能在落脚在某个范围内，假如 nums[0] = 4，那么你只能选择落脚在 [1, 4] 位置，而如果到了边界，那么肯定是一次新的起跳，因此次数需要再 + 1

	        从 0 位置开始起跳，你落脚的必定是 [1, 4] 位置中能够跳得更远的，因为根据贪心思想，这样做能够尽可能的减少跳跃次数，因为更加接近最后一个位置
	        而在这个过程遍历 [1, 4] 过程中一直记录着最远位置 k，而你落地在 [1, 4] 之间，落地的那个点也就是 [1, 4] 之间最能够跳得远的那个位置，因此当到达边界的时候，将 end 更新为 k

	        注意：[1, 4] 跳得最远的位置必定不会在 [1, 4] ，因为如果在 [1, 4] ，那么表示根本就出不去 [1, 4] 这个圈
	        当然不会是 [4,1,1,1,0,1,2] 这种的，因为如果是这种的，压根过不去这个 0，因此必定第一次起跳必定能够跳出 [1, 4] 这个范围，比如 [4,1,1,1,1,1,0]
	        */
	        int k = 0;
	        //记录跳跃的次数
	        int step = 0;
	        int end = 0;
	        //这里有个小细节，因为是起跳的时候就 + 1 了，如果最后一次跳跃刚好到达了最后一个位置，那么遍历到最后一个位置的时候就会再次起跳，这是不允许的，因此不能遍历最后一个位置
	        for(int i = 0; i < nums.length - 1; i++){
	            //一定跳得到，因此不存在 k < i

	            k = Math.max(k, i + nums[i]);
	         //第一次起跳 或 到达跳跃的边界
	            if(i == end){
	          //再次起跳
	                step++;
	          //更新边界
	                end = k;
	            }
	        }

	        return step;
	    }
	}

/*	作者：windliang
	链接：https://leetcode-cn.com/problems/jump-game-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-10/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
