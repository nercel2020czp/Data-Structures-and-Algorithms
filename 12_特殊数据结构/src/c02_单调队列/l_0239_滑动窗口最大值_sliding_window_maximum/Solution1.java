package c02_单调队列.l_0239_滑动窗口最大值_sliding_window_maximum;

import java.util.LinkedList;

/*
此方法是看了左程云算法课讲解的思路，我只是知识的搬运工。
当时听了之后，自己来做了一遍，并发表了评论。没想到现在成了热评，
而且现在LeetCode可以自己写题解，官方既然发话了，我就再重新整理一下。

思路:
	1.遍历数组，将数存放在双向队列中，并用L,R来标记窗口的左边界和右边界。
	2.队列中保存的并不是真的数，而是该数值对应的数组下标位置，并且数组中的
	    数要从大到小排序。
    3.如果当前遍历的数比队尾的值大，则需要弹出队尾值，直到队列重新满足从大到小的要求。
	4.刚开始遍历时，L和R都为0，有一个形成窗口的过程，此过程没有最大值，L不动，R向右移。
	5.当窗口大小形成时，L和R一起向右移，
	6.每次移动时:
		判断队首的值的数组下标是否在[L,R]中，如果不在则需要弹出队首的值，当前窗口的最大值即为队首的数。

示例:
输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
输出: [3,3,5,5,6,7]

解释过程中队列中都是具体的值，方便理解，具体见代码。
	初始状态：L=R=0,队列:{}
	i=0,nums[0]=1。队列为空,直接加入。队列：{1}
	i=1,nums[1]=3。队尾值为1，3>1，弹出队尾值，加入3。队列：{3}
	i=2,nums[2]=-1。队尾值为3，-1<3，直接加入。队列：{3,-1}。此时窗口已经形成，L=0,R=2，result=[3]
	i=3,nums[3]=-3。队尾值为-1，-3<-1，直接加入。队列：{3,-1,-3}。队首3对应的下标为1，L=1,R=3，有效。result=[3,3]
	i=4,nums[4]=5。队尾值为-3，5>-3，依次弹出后加入。队列：{5}。此时L=2,R=4，有效。result=[3,3,5]
	i=5,nums[5]=3。队尾值为5，3<5，直接加入。队列：{5,3}。此时L=3,R=5，有效。result=[3,3,5,5]
	i=6,nums[6]=6。队尾值为3，6>3，依次弹出后加入。队列：{6}。此时L=4,R=6，有效。result=[3,3,5,5,6]
	i=7,nums[7]=7。队尾值为6，7>6，弹出队尾值后加入。队列：{7}。此时L=5,R=7，有效。result=[3,3,5,5,6,7]
	
	1.通过示例发现R=i，L=k-R。由于队列中的值是从大到小排序的，所以每次窗口变动时，只需要判断队首的值是否还在窗口中就行了。
	2.解释一下为什么队列中要存放数组下标的值而不是直接存储数值，因为要判断队首的值是否在窗口范围内，由数组下标取值很方便，
	    而由值取数组下标不是很方便。

作者：hanyuhuang
链接：https://leetcode-cn.com/problems/sliding-window-maximum/solution/shuang-xiang-dui-lie-jie-jue-hua-dong-chuang-kou-2/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
class Solution {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length < 2)
			return nums;
		// 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
		LinkedList<Integer> queue = new LinkedList<Integer>();
		// 结果数组
		int[] result = new int[nums.length - k + 1];
		// 遍历nums数组
		for (int i = 0; i < nums.length; i++) {
			// 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
			while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
				queue.pollLast();//弹出队尾元素
			}
			// 添加当前值对应的数组下标
			queue.addLast(i);
			// 判断当前队列中队首的值是否有效
			if (queue.peek() <= i - k) {
				queue.poll();
			}
			// 当窗口长度为k时 保存当前窗口中最大值
			if (i + 1 >= k) {
				result[i + 1 - k] = nums[queue.peek()];
			}
		}
		return result;
	}
/*	执行用时 :
		12 ms
		, 在所有 Java 提交中击败了
		73.65%
		的用户
		内存消耗 :
		47.7 MB
		, 在所有 Java 提交中击败了
		5.10%
		的用户*/
}

/*作者：hanyuhuang
链接：https://leetcode-cn.com/problems/sliding-window-maximum/solution/shuang-xiang-dui-lie-jie-jue-hua-dong-chuang-kou-2/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
