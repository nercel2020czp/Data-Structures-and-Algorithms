package l_0338_比特位计数_counting_bits;
/*
https://leetcode-cn.com/problems/counting-bits/solution/bi-te-wei-ji-shu-by-leetcode/ 
 方法二：动态规划 + 最高有效位 【通过】
直觉
利用已有的计数结果来生成新的计数结果。

算法
假设有一个整数：
x = (1001011101)_2 = (605)_10

我们已经计算了从 0 到 x−1 的全部结果。​	
我们知道，x 与 我们计算过的一个数只有一位之差:
	x′=(1011101)_2=(93)_{10}
它们只在最高有效位上不同。
让我们以二进制形式检查 [0,3] 的范围：​	
		(0) = (0)_2
		(1) = (1)_2
		(2) = (10)_2
		(3) = (11)_2
​	
可以看出， 2 和 3 的二进制形式可以通过给 0 和 1 的二进制形式在前面加上 1 来得到。因此，它们的 pop count 只相差 1。
类似的，我们可以使用 [0,3] 作为蓝本来得到 [4,7]。
总之，对于pop count P(x)，我们有以下的状态转移函数：
P(x+b)=P(x)+1,b=2^m>x
有了状态转移函数，我们可以利用动态规划从 0 开始生成所有结果。
*/
public class Solution3 {
	public class Solution {
	    public int[] countBits(int num) {
	        int[] ans = new int[num + 1];
	        int i = 0, b = 1;
	        // [0, b) is calculated
	        while (b <= num) {
	            // generate [b, 2b) or [b, num) from [0, b)
	            while(i < b && i + b <= num){
	                ans[i + b] = ans[i] + 1;
	                ++i;
	            }
	            i = 0;   // reset i
	            b <<= 1; // b = 2b
	        }
	        return ans;
	    }
	}
/*	
	复杂度分析

	时间复杂度：O(n)。对每个整数 x，我们只需要常数时间。
	空间复杂度：O(n)。我们需要 O(n) 的空间来存储技术结果。如果排除这一点，就只需要常数空间。

	作者：LeetCode
	链接：https://leetcode-cn.com/problems/counting-bits/solution/bi-te-wei-ji-shu-by-leetcode/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
	*/
}
