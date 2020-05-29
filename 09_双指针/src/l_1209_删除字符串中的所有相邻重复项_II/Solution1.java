package l_1209_删除字符串中的所有相邻重复项_II;
/*
方法一：暴力解法

按照问题要求操作：对重复的相邻字母计数，当计数达到 k 时将其删除。重复此操作，直到没有删除的字符为止。

1209_approach1.png

算法

1.记录字符串的长度。
2.遍历字符串：
	2.1如果当前字符与前一个相同，计数器加 1。
		否则，重置计数器为 1。
	2.2如果计数器等于 k，删除这 k 个字符。

3.如果字符串的长度被改变，从头开始重新遍历字符串。

复杂度分析

时间复杂度：\mathcal{O}(n^2 / k)O(n 
2/k)，其中 nn 是字符串的长度。字符串扫描不超过 n / kn/k 次。

空间复杂度：\mathcal{O}(1)O(1)。某些语言会创建字符串的副本，但算法只在字符串本身上操作。


作者：LeetCode
链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string-ii/solution/shan-chu-zi-fu-chuan-zhong-de-suo-you-xiang-lin--4/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
public class Solution1 {
	
/*	执行用时 :
		9 ms
		, 在所有 Java 提交中击败了
		83.92%
		的用户
		内存消耗 :
		39.4 MB
		, 在所有 Java 提交中击败了
		20.00%
		的用户*/
	
	public String removeDuplicates(String s, int k) {
	    StringBuilder sb = new StringBuilder(s);
	    int length = -1;
	    while (length != sb.length()) {
	        length = sb.length();
	        for (int i = 0, count = 1; i < sb.length(); ++i) {
	            if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
	                count = 1;
	            } else if (++count == k) {
	                sb.delete(i - k + 1, i + 1);
	                break;
	            }
	        }
	    }
	    return sb.toString();
	}

/*	作者：LeetCode
	链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string-ii/solution/shan-chu-zi-fu-chuan-zhong-de-suo-you-xiang-lin--4/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
