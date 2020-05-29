package l_0560_和为K的子数组;
/*复杂度分析：

时间复杂度：O(N^3)O(N 
3
 )，这里 NN 是数组的长度；
空间复杂度：O(1)O(1)。*/
public class Solution3 {
/*	复杂度分析：

	时间复杂度：O(N^2)O(N 
	2
	 )，这里 NN 是数组的长度；
	空间复杂度：O(N)O(N)。*/
	public class Solution {

	    public int subarraySum(int[] nums, int k) {
	        int len = nums.length;
	        // 计算前缀和数组
	        int[] preSum = new int[len + 1];
	        preSum[0] = 0;
	        for (int i = 0; i < len; i++) {
	            preSum[i + 1] = preSum[i] + nums[i];
	        }

	        int count = 0;
	        for (int left = 0; left < len; left++) {
	            for (int right = left; right < len; right++) {
	                // 区间和 [left..right]，注意下标偏移
	                if (preSum[right + 1] - preSum[left] == k) {
	                    count++;
	                }
	            }
	        }
	        return count;
	    }
	}

/*	作者：liweiwei1419
	链接：https://leetcode-cn.com/problems/subarray-sum-equals-k/solution/bao-li-jie-fa-qian-zhui-he-qian-zhui-he-you-hua-ja/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
