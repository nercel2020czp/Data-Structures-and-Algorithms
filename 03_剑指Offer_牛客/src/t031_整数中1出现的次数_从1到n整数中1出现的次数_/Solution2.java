package t031_整数中1出现的次数_从1到n整数中1出现的次数_;
/*

在方法一中，我们手动计算了每个数中 ’1’ 的个数，但这种计算是非常慢。因此，我们需要找到 ’1’ 在这些数中出现的规律。
然后我们就能利用这个规律来形成数学公式解决问题了。考虑 ’1’ 在 个位，十位，百位，... 出现的情况，我们可以做出以下的分析：
【见图1.png】


作者：LeetCode
链接：https://leetcode-cn.com/problems/number-of-digit-one/solution/shu-zi-1-de-ge-shu-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



 */
public class Solution2 {
	public int NumberOf1Between1AndN_Solution(int n) {
	    int countr = 0;
	    for (long i = 1; i <= n; i *= 10) {
	        long divider = i * 10;
	        countr += (n / divider) * i + Math.min(Math.max(n % divider - i + 1, 0L), i);
	    }
	    return countr;
	}

}
