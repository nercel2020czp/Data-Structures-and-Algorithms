package c09_Segment_Tree. c05_Segment_Tree_Problems_in_Leetcode.l_0303_区域和检索_数组不可变;

//一维前缀和，不多解释了，快上车！
class NumArray {
	private int[] sum;

	public NumArray(int[] nums) {
	    sum = new int[nums.length + 1];
	    for (int i = 0; i < nums.length; i++) {
	        sum[i + 1] = sum[i] + nums[i];
	    }
	}

	public int sumRange(int i, int j) {
	    return sum[j + 1] - sum[i];
	}
}
//复杂度分析

/*时间复杂度：每次查询的时间 O(1)O(1)，O(N)O(N) 预计算时间。由于累积和被缓存，每个sumrange查询都可以用 O(1)O(1) 时间计算。
空间复杂度：O(n)O(n).

作者：LeetCode
链接：https://leetcode-cn.com/problems/range-sum-query-immutable/solution/qu-yu-he-jian-suo-shu-zu-bu-ke-bian-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
public class Solution1 {

}
