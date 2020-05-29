package l_1209_删除字符串中的所有相邻重复项_II;

import java.util.Stack;

/*
方法三：栈

当前字符与前一个不同时，往栈中压入 1。否则栈顶元素加 1。
1209_approach3.png

算法
	1.迭代字符串：
		1.1如果当前字符与前一个相同，栈顶元素加 1。
			否则，往栈中压入 1。
		1.2如果栈顶元素等于 k，则从字符串中删除这 k 个字符，并将 k 从栈顶移除。

		注意：因为在 Java 中 Integer 是不可变的，需要先弹出栈顶元素，然后加 1，再压入栈顶。

作者：LeetCode
链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string-ii/solution/shan-chu-zi-fu-chuan-zhong-de-suo-you-xiang-lin--4/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
public class Solution3 {
/*	执行用时 :
		25 ms
		, 在所有 Java 提交中击败了
		44.39%
		的用户
		内存消耗 :
		39.9 MB
		, 在所有 Java 提交中击败了
		20.00%
		的用户*/
	public String removeDuplicates(String s, int k) {
	    StringBuilder sb = new StringBuilder(s);
	    Stack<Integer> counts = new Stack<>();
	    for (int i = 0; i < sb.length(); ++i) {
	        if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
	            counts.push(1);
	        } else {
	            int incremented = counts.pop() + 1;
	            if (incremented == k) {
	                sb.delete(i - k + 1, i + 1);
	                i = i - k;
	            } else {
	                counts.push(incremented);
	            }
	        }
	    }
	    return sb.toString();
	}
	
/*	复杂度分析

	时间复杂度：\mathcal{O}(n)O(n)，其中 nn 是字符串长度。每个字符只处理一次。

	空间复杂度：\mathcal{O}(n)O(n)，栈空间

	作者：LeetCode
	链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string-ii/solution/shan-chu-zi-fu-chuan-zhong-de-suo-you-xiang-lin--4/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
/*
	作者：LeetCode
	链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string-ii/solution/shan-chu-zi-fu-chuan-zhong-de-suo-you-xiang-lin--4/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
