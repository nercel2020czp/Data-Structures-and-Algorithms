package l_1209_删除字符串中的所有相邻重复项_II;

import java.util.Stack;

/*
方法四：栈重建

如果将计数器和字符都存储在栈中，则不需要修改字符串，只需要根据栈中结果重建字符串即可。

算法
	迭代字符串：
		如果当前字符与栈顶元素相同，则栈顶元素计数器加 1。
			否则，计数器设为 1，当前字符压入栈。
		如果栈顶元素计数器等于 k，则弹出栈顶元素。
	使用栈中元素和计数器构建结果字符串。

复杂度分析

与方法三相同。

作者：LeetCode
链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string-ii/solution/shan-chu-zi-fu-chuan-zhong-de-suo-you-xiang-lin--4/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
public class Solution4 {
/*	执行用时 :
		15 ms
		, 在所有 Java 提交中击败了
		66.00%
		的用户
		内存消耗 :
		39.8 MB
		, 在所有 Java 提交中击败了
		20.00%
		的用户*/
	class Pair {
	    int cnt;
	    char ch;
	    public Pair(int cnt, char ch) {
	        this.ch = ch;
	        this.cnt = cnt;
	    }
	}
	public String removeDuplicates(String s, int k) {
	    Stack<Pair> counts = new Stack<>();
	    for (int i = 0; i < s.length(); ++i) {
	        if (counts.empty() || s.charAt(i) != counts.peek().ch) {
	            counts.push(new Pair(1, s.charAt(i)));
	        } else {
	            if (++counts.peek().cnt == k) {
	                counts.pop();
	            }
	        }
	    }
	    StringBuilder b = new StringBuilder();
	    while (!counts.empty()) {
	        Pair p = counts.pop();
	        for (int i = 0; i < p.cnt; i++) {
	            b.append(p.ch);
	        }
	    }
	    return b.reverse().toString();
	}

/*	作者：LeetCode
	链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string-ii/solution/shan-chu-zi-fu-chuan-zhong-de-suo-you-xiang-lin--4/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
