package t044_翻转单词顺序列;
/*解法一
题目很直观，做法也会很直观，哈哈。遍历原字符串，遇到字母就加到一个 temp 变量中，遇到空格，
如果 temp 变量不为空，就把 temp 组成的单词加到一个栈中，然后清空 temp 继续遍历。

最后，将栈中的每个单词依次拿出来拼接即可。
有一个技巧可以用，就是最后一个单词后边可能没有空格，为了统一，我们可以人为的在字符串后边加入一个空格。

作者：windliang
链接：https://leetcode-cn.com/problems/reverse-words-in-a-string/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-36/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。





public String reverseWords(String s) {
    Stack<String> stack = new Stack<>();
    StringBuilder temp = new StringBuilder();
    s += " ";
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == ' ') {
            if (temp.length() != 0) {
                stack.push(temp.toString());
                temp = new StringBuilder();
            }
        } else {
            temp.append(s.charAt(i));
        }
    }
    if (stack.isEmpty()) {
        return "";
    }
    StringBuilder res = new StringBuilder();
    res.append(stack.pop());
    while (!stack.isEmpty()) {
        res.append(" ");
        res.append(stack.pop());
    }
    return res.toString();
}
执行用时 :
9 ms
, 在所有 Java 提交中击败了
29.18%
的用户
内存消耗 :
41.9 MB
, 在所有 Java 提交中击败了
5.06%
的用户

*/

import java.lang.StringBuffer;
public class Solution1 {
	public String ReverseSentence(String str) {
		// 健壮性
		if (str.length() <= 0) {
			return "";
		}
		// 反转整个句子
		StringBuffer st1 = new StringBuffer(str);
		st1.reverse();
		// 存放结果
		StringBuffer result = new StringBuffer();
		int j = 0;
		// 标记空格数
		int blankNum = 0;
		for (int i = 0; i < st1.length(); i++) {
			// 1、当有空格，且没有到达最后一个单词时
			if (st1.charAt(i) == ' ' && (i != st1.length() - 1)) {
				blankNum++;
				StringBuffer st2 = new StringBuffer(st1.substring(j, i));
				result.append(st2.reverse().toString()).append(" ");
				j = i + 1;
			}
			// 2、当有空格，且到达最后一个单词时
			if (blankNum != 0 && i == (st1.length() - 1)) {
				StringBuffer st3 = new StringBuffer(st1.substring(j, i + 1));
				result.append(st3.reverse());
			}
		}
		// 空格数为0时，直接返回原字符串
		if (blankNum == 0) {
			return str;
		}
		return result.toString();
	}
}
