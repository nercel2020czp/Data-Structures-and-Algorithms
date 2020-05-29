package t002_替换空格;
//1. 调用自带函数

public class Solution1 {
    public String replaceSpace(StringBuffer str) {
        return str.toString().replace(" ", "%20");
    }
/*    执行用时 :
    	0 ms
    	, 在所有 Java 提交中击败了
    	100.00%
    	的用户
    	内存消耗 :
    	37.3 MB
    	, 在所有 Java 提交中击败了
    	100.00%
    	的用户*/
}
