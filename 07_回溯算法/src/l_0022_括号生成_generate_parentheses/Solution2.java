package l_0022_括号生成_generate_parentheses;

import java.util.ArrayList;
import java.util.List;

/*方法三：闭合数
思路

为了枚举某些内容，我们通常希望将其表示为更容易计算的不相交子集的总和。

考虑有效括号序列 S 的 闭包数：至少存在 index >= 0，使得 S[0], S[1], ..., S[2*index+1]是有效的。 显然，每个括号序列都有一个唯一的闭包号。 我们可以尝试单独列举它们。

算法

对于每个闭合数 c，我们知道起始和结束括号必定位于索引 0 和 2*c + 1。然后两者间的 2*c 个元素一定是有效序列，其余元素一定是有效序列。


方法三的理解： 对于任何一个括号组合（1对以上），可以表达为这么一种组合 ( left ) right 的形式。其中，若left 和 right 两部分的括号总数为 n-1对，那么新的组合 ( left ) right 则有n对，这样将n对括号求解，转化为n-1对的求解，以此类推直到零对括号可以直接给出空字符串的解。以3对为例，可拆解为 “( left=0对）right=2对”“( left=1对）right=1对”“( left=2对）right=0对”。对于上述题解给出的方案，如果缓存中间组合，可以减少搜索次数。


*/
public class Solution2 {
	public List<String> generateParenthesis(int n) {
		List<String> ans = new ArrayList<String>();
		if (n == 0) {
			ans.add("");
		} else {
			for (int c = 0; c < n; ++c)
				for (String left : generateParenthesis(c))
					for (String right : generateParenthesis(n - 1 - c))
						ans.add("(" + left + ")" + right);
		}
		return ans;
	}
	
/*	执行用时 :
		11 ms
		, 在所有 Java 提交中击败了
		9.66%
		的用户
		内存消耗 :
		41.3 MB
		, 在所有 Java 提交中击败了
		5.01%
		的用户*/
	
}
