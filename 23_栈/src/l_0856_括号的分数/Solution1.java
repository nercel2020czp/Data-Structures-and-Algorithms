package l_0856_括号的分数;
/*方法一：分治
对于一个字符串 S，我们将左括号 ( 记为 1，右括号记为 -1，如果 S 的某一个非空前缀对应的和为 0，
那么这个前缀就是一个平衡括号字符串。我们遍历字符串 S，得到若干个前缀和为 0 的位置，
就可以将字符串拆分为 S = P_1 + P_2 + ... + P_n，其中每一个 P_i 都是一个平衡括号字符串。
这样我们就可以分别计算每一个 P_i 的分数再相加，即 score(S) = score(P_1) + score(P_2) + ... + score(P_n)。

对于一个不可拆分的平衡括号字符串，如果它为 ()，那么就得 1 分，否则它的最外层一定有一对左右括号，
可以将这对括号去除后继续进行拆分，再将得到的分数乘 2。

作者：LeetCode
链接：https://leetcode-cn.com/problems/score-of-parentheses/solution/gua-hao-de-fen-shu-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
public class Solution1 {
/*	复杂度分析

	时间复杂度：O(N^2)O(N2)，其中 NN 是字符串 S 的长度，在最坏的情况下，
	字符串 S 为 (((((((....)))))))，它需要拆分 O(N)O(N) 次，
	每次遍历字符串的时间复杂度也为 O(N)O(N)。

	空间复杂度：O(N)O(N)。

	作者：LeetCode
	链接：https://leetcode-cn.com/problems/score-of-parentheses/solution/gua-hao-de-fen-shu-by-leetcode/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
	
/*	执行用时 :
		0 ms
		, 在所有 Java 提交中击败了
		100.00%
		的用户
		内存消耗 :
		37.4 MB
		, 在所有 Java 提交中击败了
		25.00%
		的用户*/
	
	class Solution {

	    public int scoreOfParentheses(String S) {
	        return F(S, 0, S.length());
	    }

	    public int F(String S, int i, int j) {
	        //Score of balanced string S[i:j]
	        int ans = 0, bal = 0;

	        // Split string into primitives
	        for (int k = i; k < j; ++k) {
	            bal += S.charAt(k) == '(' ? 1 : -1;
	            if (bal == 0) {
	                if (k - i == 1) ans++;
	                else ans += 2 * F(S, i+1, k);
	                i = k+1;
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
