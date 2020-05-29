package l_0152_乘积最大子序列_maximum_product_subarray;
/*
 解题方案
	思路
标签：动态规划
	1.遍历数组时计算当前最大值，不断更新
	2.令imax为当前最大值，则当前最大值为 imax = max(imax * nums[i], nums[i])
	3.由于存在负数，那么会导致最大的变最小的，最小的变最大的。因此还需要维护当前最小值imin，
	  imin = min(imin * nums[i], nums[i])
	4.当负数出现时则imax与imin进行交换再进行下一步计算
	5.时间复杂度：O(n)
	

 */
public class Solution1 {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] < 0){ 
              int tmp = imax;
              imax = imin;
              imin = tmp;
            }
            imax = Math.max(imax*nums[i], nums[i]);
            imin = Math.min(imin*nums[i], nums[i]);
            
            max = Math.max(max, imax);
        }
        return max;
    }
}
