package l_0560_和为K的子数组;
/*方法二：暴力解法的优化
固定了起点，即枚举左边界，时间复杂度降了一维。
参考代码 2：*/
public class Solution2 {
	public class Solution {

	    public int subarraySum(int[] nums, int k) {
	        int count = 0;
	        int len = nums.length;
	        for (int left = 0; left < len; left++) {
	            int sum = 0;
	            // 区间里可能会有一些互相抵销的元素
	            for (int right = left; right < len; right++) {
	                sum += nums[right];
	                if (sum == k) {
	                    count++;
	                }
	            }
	        }
	        return count;
	    }
	}
	
/*	复杂度分析：

	时间复杂度：O(N^2)O(N 
	2
	 )，这里 NN 是数组的长度；
	空间复杂度：O(1)O(1)。*/

/*	作者：liweiwei1419
	链接：https://leetcode-cn.com/problems/subarray-sum-equals-k/solution/bao-li-jie-fa-qian-zhui-he-qian-zhui-he-you-hua-ja/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
