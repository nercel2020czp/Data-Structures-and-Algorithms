package l_0338_比特位计数_counting_bits;
/*方法三：动态规划 + 最低有效位 【通过】
直觉

只要x' 小于 x，且它们的 pop count 之间存在函数关系，就可以写出其他的状态转移函数。
算法
遵循上一方法的相同原则，我们还可以通过最低有效位来获得状态转移函数。

观察x 和 x' = x / 2 的关系：
	x  = (1001011101)_2= (605)_{10}
​	x' = (100101110)_2 = (302)_{10}

可以发现 x' 与 x 只有一位不同，这是因为x',可以看做 x 移除最低有效位的结果。

这样，我们就有了下面的状态转移函数：
		P(x)=P(x/2)+(xmod2)
*/



public class Solution4 {
	public int[] countBits(int num) {
		int[] ans = new int[num + 1];
		for (int i = 1; i <= num; ++i)
		{
/*			观察x 和 x' = x / 2 的关系：
			x  = (1001011101)_2= (605)_{10}
		​	x' = (100101110)_2 = (302)_{10}

		可以发现 x' 与 x 只有一位不同，这是因为x',可以看做 x 移除最低有效位的结果。

		这样，我们就有了下面的状态转移函数：
				P(x)=P(x/2)+(xmod2)*/
			ans[i] = ans[i >> 1] + (i & 1); // x / 2 is x >> 1 and x % 2 is x & 1
		}
		return ans;
	}
	
/*	复杂度分析

	时间复杂度：O(n)。对每个整数 x，我们只需要常数时间。
	空间复杂度：O(n)。与方法二相同。*/
	
	
	
}
/*
	作者：LeetCode
	链接：https://leetcode-cn.com/problems/counting-bits/solution/bi-te-wei-ji-shu-by-leetcode/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
