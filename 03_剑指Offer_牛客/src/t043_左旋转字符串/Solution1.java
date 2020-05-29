package t043_左旋转字符串;

public class Solution1 {
    public String LeftRotateString(String str, int n) {
        if (str == null || n > str.length()) {
            return str;
        }
        return str.substring(n) + str.substring(0, n);
    }
}
