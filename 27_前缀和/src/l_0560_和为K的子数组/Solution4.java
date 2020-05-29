package l_0560_和为K的子数组;
/*方法四：前缀和 + 哈希表优化
使用哈希表加速运算；
由于保存了之前相同前缀和的个数，计算区间总数的时候不是一个一个地加，时间复杂度降到了 O(N)O(N)。
这个思路不是很容易想到，需要多做一些类似的问题慢慢培养感觉。

作者：liweiwei1419
链接：https://leetcode-cn.com/problems/subarray-sum-equals-k/solution/bao-li-jie-fa-qian-zhui-he-qian-zhui-he-you-hua-ja/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

同类问题有：
「力扣」第 1 题：两数之和；
「力扣」第 1248 题： 统计「优美子数组」；
「力扣」第 454 题：四数相加 II。


*/
import java.util.HashMap;
import java.util.Map;
public class Solution4 {
/*	复杂度分析：

	时间复杂度：O(N)O(N)，这里 NN 是数组的长度；
	空间复杂度：O(N)O(N)。*/
	public class Solution {
//		由于保存了之前相同前缀和的个数，计算区间总数的时候不是一个一个地加，时间复杂度降到了 O(N)O(N)。
//		这个思路不是很容易想到，需要多做一些类似的问题慢慢培养感觉。
	    public int subarraySum(int[] nums, int k) {
	        // key：前缀和，value：key 对应的前缀和的个数
	        Map<Integer, Integer> preSumFreq = new HashMap<>();
	        // 对于下标为 0 的元素，前缀和为 0，个数为 1
	        preSumFreq.put(0, 1);

	        int preSum = 0;
	        int count = 0;
	        for (int num : nums) {
	            preSum += num;

	            // 先获得前缀和为 preSum - k 的个数，加到计数变量里
	            if (preSumFreq.containsKey(preSum - k)) {
	                count += preSumFreq.get(preSum - k);
	            }

	            // 然后维护 preSumFreq 的定义
	            preSumFreq.put(preSum, preSumFreq.getOrDefault(preSum, 0) + 1);
	        }
	        return count;
	    }
	}

/*	作者：liweiwei1419
	链接：https://leetcode-cn.com/problems/subarray-sum-equals-k/solution/bao-li-jie-fa-qian-zhui-he-qian-zhui-he-you-hua-ja/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
