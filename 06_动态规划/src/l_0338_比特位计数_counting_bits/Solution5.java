package l_0338_比特位计数_counting_bits;
/*
方法四：动态规划 + 最后设置位【通过】 
 */
public class Solution5 {
/*	算法

	与上述方法思路相同，我们可以利用最后设置位。

	最后设置位是从右到左第一个为1的位。使用 x &= x - 1 将该位设置为0，就可以得到以下状态转移函数：

	P(x)=P(x&(x−1))+1;

	作者：LeetCode
	链接：https://leetcode-cn.com/problems/counting-bits/solution/bi-te-wei-ji-shu-by-leetcode/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
	
	复杂度分析

时间复杂度：O(n)。 与方法三相同。
空间复杂度：O(n)。与方法三相同。
	*/
	public int[] countBits(int num) {
		int[] ans = new int[num + 1];
		for (int i = 1; i <= num; ++i)
			ans[i] = ans[i & (i - 1)] + 1;
		return ans;
	}

/*		作者：LeetCode
		链接：https://leetcode-cn.com/problems/counting-bits/solution/bi-te-wei-ji-shu-by-leetcode/
		来源：力扣（LeetCode）
		著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
