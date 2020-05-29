package l_0215_数组中的第K个最大元素;

import java.util.PriorityQueue;

/*
方法一：堆
思路是创建一个大顶堆，将所有数组中的元素加入堆中，并保持堆的大小小于等于 k。这样，堆中就保留了前 k 个最大的元素。这样，堆顶的元素就是正确答案。

像大小为 k 的堆中添加元素的时间复杂度为 {O}(\log k)O(logk)，我们将重复该操作 N 次，故总时间复杂度为 {O}(N \log k)O(Nlogk)。

在 Python 的 heapq 库中有一个 nlargest 方法，具有同样的时间复杂度，能将代码简化到只有一行。

本方法优化了时间复杂度，但需要 {O}(k)O(k) 的空间复杂度。



作者：LeetCode
链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/shu-zu-zhong-de-di-kge-zui-da-yuan-su-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

public class Solution1 {
	class Solution {
		public int findKthLargest(int[] nums, int k) {
//			作者自己代码里面就是用的小顶堆，解释里面却说大顶堆；他那个lambda表达式删了也能出结果，默认是小顶堆啊
			// init heap 'the smallest element first'//初始化小顶堆
			PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);
			//PriorityQueue<Integer> heap = new PriorityQueue<Integer>();

			// keep k largest elements in the heap
			for (int n : nums) {
				heap.add(n);
				if (heap.size() > k)
					heap.poll();
			}

			// output
			return heap.poll();
		}
	}
	
/*	执行用时 :
		7 ms
		, 在所有 Java 提交中击败了
		51.85%
		的用户
		内存消耗 :
		39.7 MB
		, 在所有 Java 提交中击败了
		6.12%
		的用户*/
	

/*	复杂度分析

	时间复杂度 : {O}(N \log k)O(Nlogk)。
	空间复杂度 : {O}(k)O(k)，用于存储堆元素。*/

	
/*	作者：LeetCode
	链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/shu-zu-zhong-de-di-kge-zui-da-yuan-su-by-leetcode/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
