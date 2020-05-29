package l_0338_比特位计数_counting_bits;
/*
方法一：Pop count 【通过】

直觉
对一个数字解决问题，并应用到全部。

算法

本问题可以看做 位 1 的个数 的后续。它计数一个无符号整数的位。
结果称为 pop count，或 汉明权重。可以参看 位 1 的个数 的题
解以获得更详细介绍。
	1.汉明重量是一串符号中非零符号的个数。因此它等同于同样长度的
	     全零符号串的汉明距离。在最为常见的数据位符号串中，它是1的个数。
    2. 位 1:https://leetcode-cn.com/problems/number-of-1-bits/
	
现在，我们先默认这个概念。假设我们有函数int popcount(int x) ，
可以返回一个给定非负整数的位计数。我们只需要在 [0, num] 范围内循环
并将结果存到一个列表中。

作者：LeetCode
链接：https://leetcode-cn.com/problems/counting-bits/solution/bi-te-wei-ji-shu-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

*/
public class Solution2 {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 0; i <= num; ++i)
            ans[i] = popcount(i);
        return ans;
    }
    private int popcount(int x) {
        int count;
        for (count = 0; x != 0; ++count)
          x &= x - 1; //zeroing out the least significant nonzero bit
        return count;
    }
    
    
/*    复杂度分析

    时间复杂度：O(nk)。对于每个整数 x，我们需要 O(k) 次操作，其中 k 是 x 的位数。
    空间复杂度：O(n)。 我们需要 O(n) 的空间来存储计数结果。如果排除这一点，就只需要常数空间。

    作者：LeetCode
    链接：https://leetcode-cn.com/problems/counting-bits/solution/bi-te-wei-ji-shu-by-leetcode/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
