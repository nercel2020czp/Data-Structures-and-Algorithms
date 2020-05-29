package l_0560_和为K的子数组;
/*
方法一：暴力解法（超时）
枚举左右边界（超时）。
*/

public class Solution1 {
/*	复杂度分析：

	时间复杂度：O(N^3)O(N 
	3
	 )，这里 NN 是数组的长度；
	空间复杂度：O(1)O(1)。*/
	    public int subarraySum(int[] nums, int k) {
	        int len = nums.length;
	        int count = 0;
	        for (int left = 0; left < len; left++) {
	            for (int right = left; right < len; right++) {

	                int sum = 0;
	                for (int i = left; i <= right; i++) {
	                    sum += nums[i];
	                }
	                if (sum == k) {
	                    count++;
	                }
	            }
	        }
	        return count;
	    }

	    public static void main(String[] args) {
	        int[] nums = new int[]{1, 1, 1};
	        int k = 2;
	        Solution1 solution = new Solution1();
	        int res = solution.subarraySum(nums, k);
	        System.out.println(res);
	    }

/*	作者：liweiwei1419
	链接：https://leetcode-cn.com/problems/subarray-sum-equals-k/solution/bao-li-jie-fa-qian-zhui-he-qian-zhui-he-you-hua-ja/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
