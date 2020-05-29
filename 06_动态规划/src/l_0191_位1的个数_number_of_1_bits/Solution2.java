package l_0191_位1的个数_number_of_1_bits;
/*方法 2：位操作的小技巧
我们可以把前面的算法进行优化。我们不再检查数字的每一个位，而是不断把数字最后一个 1 反转，并把答案加一。
当数字变成 0 的时候偶，我们就知道它没有 1 的位了，此时返回答案。

这里关键的想法是对于任意数字 n ，将 n 和n−1 做与运算，会把最后一个 1 的位变成 0 。
为什么？考虑 n 和 n−1 的二进制表示。
【见图1.png】图1.png 将 n 和 n−1 做与运算会将最低位的 1 变成 0

在二进制表示中，数字 n 中最低位的 1 总是对应 n−1 中的 0 。
因此，将 n 和 n−1 与运算总是能把 n 中最低位的 1 变成 0 ，
并保持其他位不变。

使用这个小技巧，代码变得非常简单。

作者：LeetCode
链接：https://leetcode-cn.com/problems/number-of-1-bits/solution/wei-1de-ge-shu-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
public class Solution2 {
	public int hammingWeight(int n) {
	    int sum = 0;
	    while (n != 0) {
	        sum++;
	        n &= (n - 1);
	    }
	    return sum;
	}
/*	
	复杂度分析

	时间复杂度：O(1) 。运行时间与 n 中位为 1 的有关。在最坏情况下， n 中所有位都是 1 。对于 32 位整数，运行时间是 O(1) 的。

	空间复杂度：O(1) 。没有使用额外空间。

	作者：LeetCode
	链接：https://leetcode-cn.com/problems/number-of-1-bits/solution/wei-1de-ge-shu-by-leetcode/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
	*/
}
