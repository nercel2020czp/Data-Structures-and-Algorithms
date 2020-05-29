package l_0091_解码方法_decode_ways;
/*
 * 具体分析见图1.png
 */
public class Solution1 {
	int numDecodings(String s) {
	    if (s.charAt(0) == '0') return 0;
	    int pre = 1, curr = 1;//dp[-1] = dp[0] = 1
	    for (int i = 1; i < s.length(); i++) {
	        int tmp = curr;
	        if (s.charAt(i) == '0')
	            if (s.charAt(i-1) == '1' || s.charAt(i-1) == '2') 
	            	curr = pre;
	            else 
	            	return 0;
	        else if (s.charAt(i-1) == '1' || (s.charAt(i-1) == '2' && s.charAt(i) >= '1' && s.charAt(i) <= '6'))
	            curr = curr + pre;
	        pre = tmp;
	    }
	    return curr;
	}
/*	
	执行用时 :
		1 ms
		, 在所有 Java 提交中击败了
		100.00%
		的用户
		内存消耗 :
		37.5 MB
		, 在所有 Java 提交中击败了
		5.08%
		的用户
*/
/*	作者：pris_bupt
	链接：https://leetcode-cn.com/problems/decode-ways/solution/c-wo-ren-wei-hen-jian-dan-zhi-guan-de-jie-fa-by-pr/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
