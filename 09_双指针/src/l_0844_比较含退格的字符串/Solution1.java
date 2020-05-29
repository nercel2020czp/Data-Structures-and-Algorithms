package l_0844_比较含退格的字符串;

import java.util.Stack;

/*
 * 方法一：重构字符串【通过】
 * 思想

使用 build(S) 和 build(T) 构造去除了退格符和被删除字符后的字符串，然后比较它们是否相等。

算法

在 build(S) 中，使用栈存储每次输入的字符。

作者：LeetCode
链接：https://leetcode-cn.com/problems/backspace-string-compare/solution/bi-jiao-han-tui-ge-de-zi-fu-chuan-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

public class Solution1 {
	class Solution {
	    public boolean backspaceCompare(String S, String T) {
	        return build(S).equals(build(T));
	    }

	    public String build(String S) {
	        Stack<Character> ans = new Stack<>();
	        for (char c: S.toCharArray()) {
	            if (c != '#')
	                ans.push(c);
	            else if (!ans.empty())
	                ans.pop();
	        }
	        return String.valueOf(ans);
	    }
	}

/*	复杂度分析

	时间复杂度：O(M + N)O(M+N)，其中 M, NM,N 是字符串 S 和 T 的长度。

	空间复杂度：O(M + N)O(M+N)。*/
	
}
