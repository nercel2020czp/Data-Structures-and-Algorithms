package l_0050_Pow_x_n;

public class Solution2 {
/*	执行用时 :
		1 ms
		, 在所有 Java 提交中击败了
		94.50%
		的用户
		内存消耗 :
		37.1 MB
		, 在所有 Java 提交中击败了
		5.88%
		的用户*/
	
	class Solution {
	    double quickMul(double x, long N) {
	        double ans = 1.0;
	        // 贡献的初始值为 x
	        double x_contribute = x;
	        // 在对 N 进行二进制拆分的同时计算答案
	        while (N > 0) {
	            if (N % 2 == 1) {
	                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
	                ans *= x_contribute;
	            }
	            // 将贡献不断地平方
	            x_contribute *= x_contribute;
	            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
	            N /= 2;
	        }
	        return ans;
	    }

	    public double myPow(double x, int n) {
	        long N = n;
	        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
	    }
	}
/*
	作者：LeetCode-Solution
	链接：https://leetcode-cn.com/problems/powx-n/solution/powx-n-by-leetcode-solution/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
