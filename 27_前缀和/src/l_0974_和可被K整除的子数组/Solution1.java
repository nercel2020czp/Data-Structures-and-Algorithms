package l_0974_和可被K整除的子数组;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
/*	执行用时 :
		22 ms
		, 在所有 Java 提交中击败了
		38.90%
		的用户
		内存消耗 :
		45.3 MB
		, 在所有 Java 提交中击败了
		100.00%
		的用户*/
	
	class Solution {
	    public int subarraysDivByK(int[] A, int K) {
	        Map<Integer, Integer> record = new HashMap<>();
	        record.put(0, 1);
	        int sum = 0;
	        for (int elem: A) {
	            sum += elem;
	            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
	            int modulus = (sum % K + K) % K;
	            record.put(modulus, record.getOrDefault(modulus, 0) + 1);
	        }

	        int ans = 0;
	        for (Map.Entry<Integer, Integer> entry: record.entrySet()) {
			    ans += entry.getValue() * (entry.getValue() - 1) / 2;
			}
	        return ans;
	    }
	}

/*	作者：LeetCode-Solution
	链接：https://leetcode-cn.com/problems/subarray-sums-divisible-by-k/solution/he-ke-bei-k-zheng-chu-de-zi-shu-zu-by-leetcode-sol/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
