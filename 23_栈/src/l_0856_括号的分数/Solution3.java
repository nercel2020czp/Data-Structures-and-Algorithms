package l_0856_括号的分数;
/*
方法三：统计核心的数目

事实上，我们可以发现，只有 () 会对字符串 S 贡献实质的分数，其它的括号只会将分数乘二或者将分数累加。
因此，我们可以找到每一个 () 对应的深度 x，那么答案就是 2^x 的累加和。




作者：LeetCode
链接：https://leetcode-cn.com/problems/score-of-parentheses/solution/gua-hao-de-fen-shu-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
public class Solution3 {
/*	执行用时 :
		0 ms
		, 在所有 Java 提交中击败了
		100.00%
		的用户
		内存消耗 :
		37 MB
		, 在所有 Java 提交中击败了
		25.00%
		的用户*/
/*	复杂度分析

	时间复杂度：O(N)O(N)，其中 NN 是字符串 S 的长度。

	空间复杂度：O(1)O(1)。*/
	class Solution {

	    public int scoreOfParentheses(String S) {
	        int ans = 0, bal = 0;
	        for (int i = 0; i < S.length(); ++i) {
	            if (S.charAt(i) == '(') {
	                bal++;
	            } else {
	                bal--;
	                if (S.charAt(i-1) == '(')
	                    ans += 1 << bal;
	            }
	        }

	        return ans;
	    }
	}

/*	作者：LeetCode
	链接：https://leetcode-cn.com/problems/score-of-parentheses/solution/gua-hao-de-fen-shu-by-leetcode/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
