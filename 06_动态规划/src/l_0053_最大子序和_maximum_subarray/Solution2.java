package l_0053_最大子序和_maximum_subarray;

/*
方法二：动态规划
第 1 步：定义状态
既然一个连续子数组一定要以一个数作为结尾，那么我们就将状态定义成如下。
dp[i]：表示以 nums[i] 结尾的连续子数组的最大和。
  【1】那么为什么这么定义呢？这是因为这样定义状态转移方程容易得到。
  【2】怎么想到这么定义的呢？凭经验，以前做过类似问题，例如「力扣」第 300 题：“最长上升子序列”，
           或者说是凭感觉。这两道题都是动态规划的经典问题，当做例题来学习未尝不可，我学习动态规划的
           时候，就是直接看别人的博客和题解的。
           
第 2 步：思考状态转移方程【状态方程见图1.png】
    根据状态的定义，由于 nums[i] 一定会被选取，并且 dp[i] 所表示的连续子序列与 dp[i-1]
    所表示的连续子序列（有可能）就差一个 nums[i] 。
    
    假设数组 nums 全是正数，那么一定有 dp[i] = dp[i-1] + nums[i]。   

	      在一般情况下 dp[i-1] 有可能是负数，例如前几个数都是负数，突然来了一个正数。
	      于是分类讨论：   
 	   如果 dp[i-1] >= 0，那么可以把 nums[i] 直接接在 dp[i-1] 表示的那个数组的后面。
          如果 dp[i-1] < 0，那么加上前面的数反而越来越小了，于是“另起炉灶”，单独的一个 nums[i]，
          就是 dp[i]。

第 3 步：思考初始值
dp[0] 根据定义，一定以 nums[0] 结尾，因此 dp[0] = nums[0]。

第 4 步：思考输出  
  这里状态的定义不是题目中的问题的定义，不能直接将最后一个状态返回回去。
  
  输出应该是把所有的 dp[0]、dp[1]、……、dp[n - 1] 都看一遍，取最大值。 
  同样的情况也适用于「力扣」第 300 题：“最长上升子序列”。我经常在这一步“摔跟头”，
  请各位也留意。

作者：liweiwei1419
链接：https://leetcode-cn.com/problems/maximum-subarray/solution/dong-tai-gui-hua-fen-zhi-fa-python-dai-ma-java-dai/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
public class Solution2 {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        //dp[i]：表示以 nums[i] 结尾的连续子数组的最大和。
        int[] dp = new int[len];
        dp[0] = nums[0];

        for (int i = 1; i < len; i++) {
            if (dp[i-1] >= 0) {
                dp[i] = dp[i-1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }

        // 最后不要忘记全部看一遍求最大值
        int res = dp[0];
        for (int i = 1; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

/*作者：liweiwei1419
链接：https://leetcode-cn.com/problems/maximum-subarray/solution/dong-tai-gui-hua-fen-zhi-fa-python-dai-ma-java-dai/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
