package l_0844_比较含退格的字符串;
/*
 * 
 * 方法二：双指针【通过】

思路

一个字符是否属于最终字符串的一部分，取决于它后面有多少个退格符。

如果反向遍历字符串，就可以先知道有多少个退格符，然后知道退格符左边有多少个字符会被删除，对应的也就知道哪些字符会保留在最终的字符串中。

算法

反向遍历字符串，如果遍历到一个退格符，那么再往左第一个非退格字符将会被删除，剩余未被删除的字符就是最终的字符串。

作者：LeetCode
链接：https://leetcode-cn.com/problems/backspace-string-compare/solution/bi-jiao-han-tui-ge-de-zi-fu-chuan-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


 */
public class Solution2 {
	class Solution {
		public boolean backspaceCompare(String S, String T) {
			int i = S.length() - 1, j = T.length() - 1;
			int skipS = 0, skipT = 0;

			while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
				while (i >= 0) { // Find position of next possible char in build(S)
					if (S.charAt(i) == '#') {
						skipS++;
						i--;
					} else if (skipS > 0) {
						skipS--;
						i--;
					} else
						break;
				}
				while (j >= 0) { // Find position of next possible char in build(T)
					if (T.charAt(j) == '#') {
						skipT++;
						j--;
					} else if (skipT > 0) {
						skipT--;
						j--;
					} else
						break;
				}
				// If two actual characters are different
				if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
					return false;
				// If expecting to compare char vs nothing
				if ((i >= 0) != (j >= 0))
					return false;
				i--;
				j--;
			}
			return true;
		}
	}

/*	执行用时 :
		1 ms
		, 在所有 Java 提交中击败了
		96.91%
		的用户
		内存消耗 :
		38.2 MB
		, 在所有 Java 提交中击败了
		33.33%
		的用户*/
	
}
