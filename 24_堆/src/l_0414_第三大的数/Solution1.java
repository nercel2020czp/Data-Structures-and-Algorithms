package l_0414_第三大的数;

import java.util.TreeSet;

/*
思路一： 借用TreeSet（红黑树） O(n)

比较好想的思路

维护一个只有3个元素的TreeSet，如果大于三个元素就就把Set中的最小最小值remove掉。
最后如果Set中元素小于3就返回Set最大值，否则返回最小值。

作者：happy_yuxuan
链接：https://leetcode-cn.com/problems/third-maximum-number/solution/414-kong-jian-o1-shi-jian-onliang-chong-fang-fa-he/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

时间复杂度： O(n * log3) == O(n)
*/
public class Solution1 {
	class Solution {
		public int thirdMax(int[] nums) {
			if (nums == null || nums.length == 0)
				throw new RuntimeException("error");

			TreeSet<Integer> set = new TreeSet<>();
			for (Integer elem : nums) {
				set.add(elem);
				if (set.size() > 3)
					set.remove(set.first());
			}

			return set.size() < 3 ? set.last() : set.first(); // set.last() 里面最大的元素
		}
	}
	
/*	执行结果：
	通过
	显示详情
	执行用时 :
	5 ms
	, 在所有 Java 提交中击败了
	45.98%
	的用户
	内存消耗 :
	38.8 MB
	, 在所有 Java 提交中击败了
	11.11%
	的用户*/
	
/*
	作者：happy_yuxuan
	链接：https://leetcode-cn.com/problems/third-maximum-number/solution/414-kong-jian-o1-shi-jian-onliang-chong-fang-fa-he/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
