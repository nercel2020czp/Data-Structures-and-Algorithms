package l_0856_括号的分数;

import java.util.Stack;

/*
方法二：栈

字符串 S 中的每一个位置都有一个“深度”，即该位置外侧嵌套的括号数目。例如，字符串 (()(.())) 中的 . 
的深度为 2，因为它外侧嵌套了 2 层括号：(__(.__))。

我们用一个栈来维护当前所在的深度，以及每一层深度的得分。
当我们遇到一个左括号 ( 时，我们将深度加一，并且新的深度的得分置为 0。
当我们遇到一个右括号 ) 时，我们将当前深度的得分乘二并加到上一层的深度。
这里有一种例外情况，如果遇到的是 ()，那么只将得分加一。

下面给出了字符串 (()(())) 每次对应的栈的情况：

[0, 0] (
[0, 0, 0] ((
[0, 1] (()
[0, 1, 0] (()(
[0, 1, 0, 0] (()((
[0, 1, 1] (()(()
[0, 3] (()(())
[6] (()(()))

作者：LeetCode
链接：https://leetcode-cn.com/problems/score-of-parentheses/solution/gua-hao-de-fen-shu-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
public class Solution2 {
/*	复杂度分析

	时间复杂度：O(N)O(N)，其中 NN 是字符串 S 的长度。

	空间复杂度：O(N)O(N)，为栈的大小。*/
/*	执行用时 :
		1 ms
		, 在所有 Java 提交中击败了
		70.03%
		的用户
		内存消耗 :
		37.2 MB
		, 在所有 Java 提交中击败了
		25.00%
		的用户*/
	public int scoreOfParentheses(String S) {
	    Stack<Integer> stack = new Stack<>();
	    stack.push(0); // The score of the current frame

	    for (char c: S.toCharArray()) {
	        if (c == '(')
	            stack.push(0);
	        else {
	            int v = stack.pop();
	            int w = stack.pop();
	            stack.push(w + Math.max(2 * v, 1));
	        }
	    }

	    return stack.pop();
	}

/*	作者：LeetCode
	链接：https://leetcode-cn.com/problems/score-of-parentheses/solution/gua-hao-de-fen-shu-by-leetcode/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
