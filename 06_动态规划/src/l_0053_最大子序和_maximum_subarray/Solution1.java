package l_0053_最大子序和_maximum_subarray;

/*
思路
	这道题用动态规划的思路并不难解决，比较难的是后文提出的用分治法求解，但由于其不是最优解法，所以先不列出来
	动态规划的是首先对数组进行遍历，当前最大连续子序列和为 sum，结果为 ans
	如果 sum > 0，则说明 sum 对结果有增益效果，则 sum 保留并加上当前遍历数字
	如果 sum <= 0，则说明 sum 对结果无增益效果，需要舍弃，则 sum 直接更新为当前遍历数字
	每次比较 sum 和 ans的大小，将最大值置为ans，遍历结束返回结果
	时间复杂度：O(n)

作者：guanpengchn
链接：https://leetcode-cn.com/problems/maximum-subarray/solution/hua-jie-suan-fa-53-zui-da-zi-xu-he-by-guanpengchn/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
public class Solution1 {

    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for(int num: nums) {
            if(sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
    
	public int maxSubArray1(int[] nums) {
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			dp[i] = Math.max(dp[i- 1] + nums[i], nums[i]);	
			if (max < dp[i]) {
				max = dp[i];
			}
		}
		return max;
	}
    
/*    
    执行结果：
    通过
    显示详情
    执行用时 :
    0 ms
    , 在所有 Java 提交中击败了
    100.00%
    的用户
    内存消耗 :
    41.3 MB
    , 在所有 Java 提交中击败了
    8.95%
    的用户
    
   */ 
    
}
