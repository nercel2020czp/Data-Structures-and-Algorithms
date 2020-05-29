package l_0313_超级丑数;
/*只使用动态规划思想解决这道题的话，其实这道题和264题丑数II的思想是一致的。
dp保存按序排列的丑数，每个指针分别乘对应位置的素数找出下一个丑数。*/
public class Solution1 {
/*	执行用时 :
		19 ms
		, 在所有 Java 提交中击败了
		75.25%
		的用户
		内存消耗 :
		38 MB
		, 在所有 Java 提交中击败了
		33.33%
		的用户*/
	public int nthSuperUglyNumber(int n, int[] primes) {

	    int[] dp = new int[n];
	    dp[0] = 1;

	    int k = primes.length;
	    int[] index = new int[k];

	    for (int i = 1; i < n; i++) {
	        int min = Integer.MAX_VALUE;
	        for (int j = 0; j < k; j++) {
	            if (min > dp[index[j]] * primes[j]) {
	                min = dp[index[j]] * primes[j];
	            }
	            dp[i] = min;
	        }
	        for (int j = 0; j < k; j++) {
	            if (min == dp[index[j]] * primes[j]) {
	                index[j]++;
	            }
	        }
	    }
	    return dp[n - 1];
	}

/*	作者：Thpffcj
	链接：https://leetcode-cn.com/problems/super-ugly-number/solution/dong-tai-gui-hua-java-by-thpffcj/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
