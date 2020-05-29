package t002_替换空格;
/*1. 分析：
当遇到 " "，就追加 "%20"，否则遇到什么追加什么*/
public class Solution2 {
    public String replaceSpace(StringBuffer str) {
		StringBuilder sb = new StringBuilder(str.length() * 2);
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == ' ') {
				sb.append("%20");
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
    }
    
/*    执行用时 :
    	0 ms
    	, 在所有 Java 提交中击败了
    	100.00%
    	的用户
    	内存消耗 :
    	37 MB
    	, 在所有 Java 提交中击败了
    	100.00%
    	的用户*/
    
    public String replaceSpace1(String s) {
		StringBuilder sb = new StringBuilder(s.length() * 2);
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == ' ') {
				sb.append("%20");
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
    }
}
