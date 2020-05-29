package l_0373_查找和最小的K对数字;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
方法二：优先级队列（堆）
思路:
我们可以利用堆，在不枚举出全部数对的情况下解决该问题，从而提高效率。
由于nums1和nums2均是已经排好序的升序数组，我们可以固定选择nums1中的一个数字nums[k],
让其依次和nums2中的每个数对进行组合从而形成一个以升序排列的数对队列。
例：nums1 = [1,7,11], nums2 = [2,4,6]
pic1.png

这样，我们将原问题转换成在n1个升序队列中，查找最小的前K对数字。
为了解决该问题，我们可以参考leetcode 23 合并K个有序链表的方法。
我们统计n1个升序队列的队首元素中的最小值，将其加入结果队列，
并将指向该队首的指针向后移，直到我们找齐前K对数字。

算法:
维护一个堆，存放n1个升序队列的队首元素，每个元素为一个长度为2数组，
里面存放的是nums1和nums2中某个数字的下标。
堆中的元素按照数对和由小到大顺序排列，每次我们取出堆中数对和最小的数对，加入结果数组。
同时将该数对所在的队列中下一个元素(若存在的话)加入堆中，如此反复直至我们找齐全部K对数字或堆的大小为空。

复杂度分析
时间复杂度：O(KlogN1)O(KlogN1) 其中N1是数组nums1nums1的长度。
空间复杂度：O(K)O(K)


作者：KLEA
链接：https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums/solution/cha-zhao-he-zui-xiao-de-kdui-shu-zi-by-lenn123/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
public class Solution2 {
	
/*	执行用时 :
		5 ms
		, 在所有 Java 提交中击败了
		98.86%
		的用户
		内存消耗 :
		40.3 MB
		, 在所有 Java 提交中击败了
		75.00%
		的用户*/
	
	class Solution {
	    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
	        int n1 = nums1.length, n2 = nums2.length;
//	        维护一个堆，存放n1个升序队列的队首元素，每个元素为一个长度为2数组，
//	        里面存放的是nums1和nums2中某个数字的下标。
	        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (nums1[o1[0]]+nums2[o1[1]]) - (nums1[o2[0]]+nums2[o2[1]]));
	        List<List<Integer>> result = new ArrayList<>();
	        
			if (n1 == 0 || n2 == 0 || k == 0)
				return result;
			for (int i = 0; i < n1; i++)
				pq.offer(new int[] { i, 0 });

			while (pq.size() > 0 && k > 0) {
//				堆中的元素按照数对和由小到大顺序排列，每次我们取出堆中数对和最小的数对，加入结果数组。
//				同时将该数对所在的队列中下一个元素(若存在的话)加入堆中，如此反复直至我们找齐全部K对数字或堆的大小为空。
				int[] pair = pq.poll();
				if (pair[1] + 1 < n2)
					pq.offer(new int[] { pair[0], pair[1] + 1 });
				List<Integer> temp = new ArrayList<>();
				temp.add(nums1[pair[0]]);
				temp.add(nums2[pair[1]]);
				result.add(temp);
				k--;
			}

	        return result;
	    }
	}

}
