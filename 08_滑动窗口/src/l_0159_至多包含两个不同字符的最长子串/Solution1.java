package l_0159_至多包含两个不同字符的最长子串;

import java.util.Collections;
import java.util.HashMap;

/*方法 1：滑动窗口
想法
为了遍历一遍就得到答案，我们使用一个左指针和一个右指针表示滑动窗口的边界。
一开始，让两个指针都指向 0 ，当窗口包含的字符不超过 2 个不同的字符时，就不断将右指针往右边移动。
如果在某一个位置有 3 个不同的字符，就开始移动左指针，直到窗口内包含不超过 2 个不同字符。

算法

现在我们可以写出如下算法：

如果 N 的长度小于 3 ，返回 N 。
将左右指针都初始化成字符串的左端点 left = 0 和 right = 0 ，且初始化最大子字符串为 max_len = 2
当右指针小于 N 时：
如果 hashmap 包含小于 3 个不同字符，那么将当前字符 s[right] 放到 hashmap 中并将右指针往右移动一次。
如果 hashmap 包含 3 个不同字符，将最左边的字符从 哈希表中删去，并移动左指针，以便滑动窗口只包含 2 个不同的字符。
更新 max_len
*/
//2:后来发现是这里window[d] == need[d]要将等号改为equals，就会全部通过了
public class Solution1 {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		int n = s.length();
		if (n < 3)
			return n;

		// sliding window left and right pointers
		int left = 0;
		int right = 0;
		// hashmap character -> its rightmost position
		// in the sliding window
		HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();

		int max_len = 2;

		while (right < n) {
			// slidewindow contains less than 3 characters
			if (hashmap.size() < 3)
				hashmap.put(s.charAt(right), right++);

			// slidewindow contains 3 characters
			if (hashmap.size() == 3) {
				// delete the leftmost character
				int del_idx = Collections.min(hashmap.values());
				hashmap.remove(s.charAt(del_idx));
				// move left pointer of the slidewindow
				left = del_idx + 1;
			}

			max_len = Math.max(max_len, right - left);
		}
		return max_len;
	}
	
/*	执行用时 :
		23 ms
		, 在所有 Java 提交中击败了
		13.97%
		的用户
		内存消耗 :
		41.6 MB
		, 在所有 Java 提交中击败了
		6.25%
		的用户*/
	
}
