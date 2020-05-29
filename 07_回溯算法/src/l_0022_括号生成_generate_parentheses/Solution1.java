package l_0022_括号生成_generate_parentheses;

import java.util.ArrayList;
import java.util.List;

/*
方法一：深度优先遍历【回溯算法】
我们以 n = 2 为例，画树形结构图。方法是 “做减法”。
【见图2.png】

思路和算法

只有在我们知道序列仍然保持有效时才添加 '(' or ')'，而不是像 方法一 那样每次添加。
我们可以通过跟踪到目前为止放置的左括号和右括号的数目来做到这一点，

如果我们还剩一个位置，我们可以开始放一个左括号。 如果它不超过左括号的数量，我们可以放一个右括号。

*/
public class Solution1 {
	public List<String> generateParenthesis(int n) {
		List<String> ans = new ArrayList<String>();
		backtrack(ans, "", 0, 0, n);
		return ans;
	}

	public void backtrack(List<String> ans, String cur, int open, int close, int max) {
		if (cur.length() == max * 2) {
			ans.add(cur);
			return;
		}

		if (open < max)
			backtrack(ans, cur + "(", open + 1, close, max);
		if (close < open)
			backtrack(ans, cur + ")", open, close + 1, max);
	}
/*	执行用时 :
		1 ms
		, 在所有 Java 提交中击败了
		98.72%
		的用户
		内存消耗 :
		39.2 MB
		, 在所有 Java 提交中击败了
		5.01%
		的用户*/
}
