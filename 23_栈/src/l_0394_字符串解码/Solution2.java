package l_0394_字符串解码;
/*
解法二：递归法
总体思路与辅助栈法一致，不同点在于将 [ 和 ] 分别作为递归的开启与终止条件：
	1.当 s[i] == ']' 时，返回当前括号内记录的 res 字符串与 ] 的索引 i （更新上层递归指针位置）；
	2.当 s[i] == '[' 时，开启新一层递归，记录此 [...] 内字符串 tmp 和递归后的最新索引 i，并执行 res + multi * tmp 拼接字符串。
	3.遍历完毕后返回 res。
复杂度分析：
	1.时间复杂度 O(N)O(N)，递归会更新索引，因此实际上还是一次遍历 s；
	2.空间复杂度 O(N)O(N)，极端情况下递归深度将会达到线性级别。
 */


public class Solution2 {
	class Solution {
	    public String decodeString(String s) {
	        return dfs(s, 0)[0];
	    }
	    private String[] dfs(String s, int i) {
	        StringBuilder res = new StringBuilder();
	        int multi = 0;
	        while(i < s.length()) {
	            if(s.charAt(i) >= '0' && s.charAt(i) <= '9') 
	                multi = multi * 10 + Integer.parseInt(String.valueOf(s.charAt(i))); 
	            else if(s.charAt(i) == '[') {
	                String[] tmp = dfs(s, i + 1);
	                i = Integer.parseInt(tmp[0]);
	                while(multi > 0) {
	                    res.append(tmp[1]);
	                    multi--;
	                }
	            }
	            else if(s.charAt(i) == ']') 
	                return new String[] { String.valueOf(i), res.toString() };
	            else 
	                res.append(String.valueOf(s.charAt(i)));
	            i++;
	        }
	        return new String[] { res.toString() };
	    } 
	}
/*	执行用时 :
		0 ms
		, 在所有 Java 提交中击败了
		100.00%
		的用户
		内存消耗 :
		37.1 MB
		, 在所有 Java 提交中击败了
		7.69%
		的用户*/
	
/*
	作者：jyd
	链接：https://leetcode-cn.com/problems/decode-string/solution/decode-string-fu-zhu-zhan-fa-di-gui-fa-by-jyd/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
