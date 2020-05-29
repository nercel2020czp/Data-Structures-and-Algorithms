package l_1209_删除字符串中的所有相邻重复项_II;

import java.util.Stack;

/*
方法五：双指针

该方法由lee215提出，使用双指针可以优化方法二和三中的字符串操作。
这里，使用快慢指针复制字符。每次需要删除 k 个元素时，只需要将慢指针回退 k 个位置。

1209_approach5.png

算法
	初始慢指针 j 等于 0。
	使用快指针 i 遍历字符串：
		令 s[i] = s[j]。
		如果 s[j] = s[j - 1]，则栈顶元素加 1。
			否则，栈中压入 1。
		如果计数器等于 k，j = j - k，并弹出栈顶元素。

	返回字符串的前 j 个字符。

作者：LeetCode
链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string-ii/solution/shan-chu-zi-fu-chuan-zhong-de-suo-you-xiang-lin--4/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
public class Solution5 {
/*	执行用时 :
		15 ms
		, 在所有 Java 提交中击败了
		66.00%
		的用户
		内存消耗 :
		40.9 MB
		, 在所有 Java 提交中击败了
		20.00%
		的用户*/
	public String removeDuplicates(String s, int k) {
	    Stack<Integer> counts = new Stack<>();
	    char[] sa = s.toCharArray();
	    int j = 0;
	    for (int i = 0; i < s.length(); ++i, ++j) {
	        sa[j] = sa[i];
	        if (j == 0 || sa[j] != sa[j - 1]) {
	            counts.push(1);
	        } else {
	            int incremented = counts.pop() + 1;
	            if (incremented == k) {
	                j = j - k;
	            } else {
	                counts.push(incremented);
	            }
	        }
	    }
	    return new String(sa, 0, j);
	}

/*	作者：LeetCode
	链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string-ii/solution/shan-chu-zi-fu-chuan-zhong-de-suo-you-xiang-lin--4/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
