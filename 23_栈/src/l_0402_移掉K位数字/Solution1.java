package l_0402_移掉K位数字;

import java.util.Stack;

/*
思路：单调栈
思路：单调栈
维护一个递增栈，但当前元素小于栈顶元素，则移掉栈顶元素。
*/
public class Solution1 {
	
/*	执行用时 :
		5 ms
		, 在所有 Java 提交中击败了
		92.45%
		的用户
		内存消耗 :
		39.6 MB
		, 在所有 Java 提交中击败了
		7.69%
		的用户*/
	
	class Solution {
		public String removeKdigits(String num, int k) {
			StringBuilder res = new StringBuilder();
			int n = num.length(), m = n - k;
			for (char c : num.toCharArray()) {
				while (k != 0 && res.length() != 0 && res.charAt(res.length() - 1) > c) {
//		                res.pop_back();
					res = res.deleteCharAt(res.length() - 1);
					--k;
				}
				res.append(c);
			}
			res = res.delete(m, res.length());
			// 去除前导0， 如10200，k = 1
			while (res.length() != 0 && res.charAt(0) == '0') {
				res = res.deleteCharAt(0);
			}
			return res.length() == 0 ? "0" : res.toString();
		}
	}

}
/*
		作者：guohaoding
		链接：https://leetcode-cn.com/problems/remove-k-digits/solution/402-yi-diao-kwei-shu-zi-dan-diao-zhan-by-guohaodin/
		来源：力扣（LeetCode）
		著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
