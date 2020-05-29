package t044_翻转单词顺序列;

public class Solution3 {
	public String reverseWords(String s) {
        if (null == s || s.length() == 0)
            return "";
        final char[] c = s.toCharArray();
        final int len = c.length;
        int i = len - 1;
        
        while (i >= 0 && c[i] == ' ') i--;

        int left = i + 1;
        int right = i + 1;
        StringBuffer sb = new StringBuffer(i + 1);
        
        
        for (; i >= 0; i--) {
            if (c[i] == ' ') {
                if (right != left) sb.append(c, left, right - left).append(" ");
                left = i;
                right = i;
                continue;
            }
            left = i;
        }
        if (right != left)
            return sb.append(c, left, right - left).toString();
        return sb.length() > 0 ? sb.substring(0, sb.length() - 1) : "";
    }
/*	执行用时 :
		2 ms
		, 在所有 Java 提交中击败了
		98.90%
		的用户
		内存消耗 :
		39.6 MB
		, 在所有 Java 提交中击败了
		5.06%
		的用户*/

}
