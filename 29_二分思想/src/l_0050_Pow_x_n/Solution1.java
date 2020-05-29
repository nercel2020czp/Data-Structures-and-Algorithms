package l_0050_Pow_x_n;
/*方法一：快速幂 + 递归

「快速幂算法」的本质是分治算法。举个例子，如果我们要计算 x^{64}x 
64
 ，我们可以按照：
 方法一：快速幂 + 递归.png
 
 复杂度分析

时间复杂度：O(logn)，即为递归的层数。

空间复杂度：O(logn)，即为递归的层数。这是由于递归的函数调用会使用栈空间。

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/powx-n/solution/powx-n-by-leetcode-solution/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

2 分钟前	通过	1 ms	37.2 MB	Java

*/
public class Solution1 {
	class Solution {
	    public double quickMul(double x, long N) {
	        if (N == 0) {
	            return 1.0;
	        }
	        double y = quickMul(x, N / 2);
	        return N % 2 == 0 ? y * y : y * y * x;
	    }

	    public double myPow(double x, int n) {
	        long N = n;
	        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
	    }
	}
}
