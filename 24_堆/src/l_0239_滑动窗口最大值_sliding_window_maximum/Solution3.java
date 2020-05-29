package l_0239_滑动窗口最大值_sliding_window_maximum;

import java.util.ArrayDeque;

/*
方法二：双向队列

直觉

如何优化时间复杂度呢？首先想到的是使用堆，因为在最大堆中 heap[0] 永远是最大的元素。
在大小为 k 的堆中插入一个元素消耗 log(k) 时间，因此算法的时间复杂度为 O(Nlog(k))。

能否得到只要 O(N) 的算法？

我们可以使用双向队列，该数据结构可以从两端以常数时间压入/弹出元素。
存储双向队列的索引比存储元素更方便，因为两者都能在数组解析中使用。

算法非常直截了当：
	1.处理前 k 个元素，初始化双向队列。
	2.遍历整个数组。在每一步 :
	3.清理双向队列 :
		- 只保留当前滑动窗口中有的元素的索引。
		- 移除比当前元素小的所有元素，它们不可能是最大的。
	4.将当前元素添加到双向队列中。
	5.将 deque[0] 添加到输出中。
	6.返回输出数组。

复杂度分析：
	时间复杂度：O(N)，每个元素被处理两次- 其索引被添加到双向队列中和被双向队列删除。
	空间复杂度：O(N)，输出数组使用了 O(N−k+1) 空间，双向队列使用了 O(k)。

作者：LeetCode
链接：https://leetcode-cn.com/problems/sliding-window-maximum/solution/hua-dong-chuang-kou-zui-da-zhi-by-leetcode-3/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

*/
public class Solution3 {
	ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
	int[] nums;

	public void clean_deque(int i, int k) {
		// remove indexes of elements not from sliding window
		if (!deq.isEmpty() && deq.getFirst() == i - k)
			deq.removeFirst();

		// remove from deq indexes of all elements
		// which are smaller than current element nums[i]
		while (!deq.isEmpty() && nums[i] > nums[deq.getLast()])
			deq.removeLast();
	}

	public int[] maxSlidingWindow(int[] nums, int k) {
		int n = nums.length;
		if (n * k == 0)
			return new int[0];
		if (k == 1)
			return nums;

		// init deque and output
		this.nums = nums;
		int max_idx = 0;
		for (int i = 0; i < k; i++) {
			clean_deque(i, k);
			deq.addLast(i);
			// compute max in nums[:k]
			if (nums[i] > nums[max_idx])
				max_idx = i;
		}
		int[] output = new int[n - k + 1];
		output[0] = nums[max_idx];

		// build output
		for (int i = k; i < n; i++) {
			clean_deque(i, k);
			deq.addLast(i);
			output[i - k + 1] = nums[deq.getFirst()];
		}
		return output;
	}
/*	执行用时 :
		9 ms
		, 在所有 Java 提交中击败了
		81.25%
		的用户
		内存消耗 :
		49.2 MB
		, 在所有 Java 提交中击败了
		5.10%
		的用户*/
}
/*作者：LeetCode
链接：https://leetcode-cn.com/problems/sliding-window-maximum/solution/hua-dong-chuang-kou-zui-da-zhi-by-leetcode-3/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
