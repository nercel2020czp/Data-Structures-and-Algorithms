package l_1209_删除字符串中的所有相邻重复项_II;
/*方法二：记忆计数
从方法一中可以看出，如果为每个字符设置计数器，就不必每次删除完字符后从头开始。
这种方法具有线性复杂度，但需要额外空间存储字符的计数器。

算法
	1.初始长度为 n 的数组 counts。
	2.遍历字符串：
		2.1如果当前字符与上一个字符相等，令 counts[i] = counts[i - 1] + 1。
			否则，令 counts[i] = 1。
		2.2如果 counts[i] = k，删除这 k 个字符，令 i = i - k。

作者：LeetCode
链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string-ii/solution/shan-chu-zi-fu-chuan-zhong-de-suo-you-xiang-lin--4/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。




*/
public class Solution2 {
/*	执行用时 :
		8 ms
		, 在所有 Java 提交中击败了
		89.61%
		的用户
		内存消耗 :
		40 MB
		, 在所有 Java 提交中击败了
		20.00%
		的用户*/
	public String removeDuplicates(String s, int k) {
	    StringBuilder sb = new StringBuilder(s);
	    int count[] = new int[sb.length()];
	    for (int i = 0; i < sb.length(); ++i) {
	        if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
	            count[i] = 1;
	        } else {
	            count[i] = count[i - 1] + 1;
	            if (count[i] == k) {
	                sb.delete(i - k + 1, i + 1);
	                i = i - k;
	            }
	        }
	    }
	    return sb.toString();
	}

/*	复杂度分析

	时间复杂度：\mathcal{O}(n)O(n)，其中 nn 是字符串长度。每个字符仅被处理一次。

	空间复杂度：\mathcal{O}(n)O(n)，存储每个字符的计数器。

	作者：LeetCode
	链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string-ii/solution/shan-chu-zi-fu-chuan-zhong-de-suo-you-xiang-lin--4/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
	
/*	作者：LeetCode
	链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string-ii/solution/shan-chu-zi-fu-chuan-zhong-de-suo-you-xiang-lin--4/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
