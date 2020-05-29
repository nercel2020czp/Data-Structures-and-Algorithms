package l_0414_第三大的数;
/*
思路二：
用三个变量来存放第一大，第二大，第三大的元素的变量，分别为one, two, three；
遍历数组，若该元素比one大则往后顺移一个元素，比two大则往往后顺移一个元素，比three大则赋值个three；
最后得到第三大的元素，若没有则返回第一大的元素。
java


作者：happy_yuxuan
链接：https://leetcode-cn.com/problems/third-maximum-number/solution/414-kong-jian-o1-shi-jian-onliang-chong-fang-fa-he/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


 */
public class Solution2 {
	class Solution {
		//相当于自己维护了一个简单的堆功能的
		private long MIN = Long.MIN_VALUE; // MIN代表没有在值

		public int thirdMax(int[] nums) {
			if (nums == null || nums.length == 0)
				throw new RuntimeException("nums is null or length of 0");
			int n = nums.length;

			int one = nums[0];
			long two = MIN;
			long three = MIN;

			for (int i = 1; i < n; i++) {
				int now = nums[i];
				if (now == one || now == two || now == three)
					continue; // 如果存在过就跳过不看
				if (now > one) {
					three = two;
					two = one;
					one = now;
				} else if (now > two) {
					three = two;
					two = now;
				} else if (now > three) {
					three = now;
				}
			}

			if (three == MIN)
				return one; // 没有第三大的元素，就返回最大值
			return (int) three;
		}
	}
/*	执行用时 :
		1 ms
		, 在所有 Java 提交中击败了
		96.80%
		的用户
		内存消耗 :
		39.6 MB
		, 在所有 Java 提交中击败了
		11.11%
		的用户*/
}
