package l_0003_无重复字符的最长子串;

import java.util.HashMap;

/*
 * 示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
2:后来发现是这里window[d] == need[d]要将等号改为equals，就会全部通过了
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

这个题终于有了点新意，不是一套框架就出答案，不过反而更简单了，稍微改一改框架就行了：
 */

public class Solution1 {
	
	static int lengthOfLongestSubstring(String s) {
	    HashMap<Character, Integer> window = new HashMap<Character, Integer>();

	    int left = 0, right = 0;
	    int res = 0; // 记录结果
	    while (right < s.length()) {
	        char c = s.charAt(right);
	        right++;
	        // 进行窗口内数据的一系列更新
	        window.put(c, window.getOrDefault(c, 0) + 1);
	        // 判断左侧窗口是否要收缩
	        while (window.get(c) > 1) {
	            char d = s.charAt(left);
	            left++;
	            // 进行窗口内数据的一系列更新
	            window.put(d, window.get(d) - 1);
	        }
	        // 在这里更新答案
	        res = Math.max(res, right - left);
	    }
	    return res;
	}
	
	public static void main(String[] args) {
//		String str = "abcabcbb";
//		String str = "bbbbb";
		String str = "pwwkew";
		System.out.println(lengthOfLongestSubstring(str));
	}
	
}
