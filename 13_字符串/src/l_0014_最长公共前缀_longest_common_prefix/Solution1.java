package l_0014_最长公共前缀_longest_common_prefix;
/*思路
标签：链表
当字符串数组长度为 0 时则公共前缀为空，直接返回
令最长公共前缀 ans 的值为第一个字符串，进行初始化
遍历后面的字符串，依次将其与 ans 进行比较，两两找出公共前缀，最终结果即为最长公共前缀
如果查找过程中出现了 ans 为空的情况，则公共前缀不存在直接返回
时间复杂度：O(s)O(s)，s 为所有字符串的长度之和

作者：guanpengchn
链接：https://leetcode-cn.com/problems/longest-common-prefix/solution/hua-jie-suan-fa-14-zui-chang-gong-gong-qian-zhui-b/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


*/
class Solution {
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0)
			return "";
		String ans = strs[0];
		for (int i = 1; i < strs.length; i++) {
			int j = 0;
			for (; j < ans.length() && j < strs[i].length(); j++) {
				if (ans.charAt(j) != strs[i].charAt(j))
					break;
			}
			ans = ans.substring(0, j);
			if (ans.equals(""))
				return ans;
		}
		return ans;
	}
}

public class Solution1 {

}
