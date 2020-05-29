package t002_替换空格;

/*
基于/剑指Offer_牛客/src/t002_替换空格/Solution2.java
你这个代码还可以再优化，遇到空格追加，使用stringbuilder，
底层的实现是会执行多次resize操作。因此在数据量大的情况下，性能会降低下来。

链接：https://www.nowcoder.com/questionTerminal/4060ac7e3e404ad1a894ef3e17650423?answerType=1&f=discussion
来源：牛客网

思路：
	解法一：用Java自带的函数str.toString().replace(" ","%20")。
	解法二：在当前字符串上进行替换。
		先计算替换后的字符串需要多大的空间，并对原字符串空间进行扩容；
		从后往前替换字符串的话，每个字符串只需要移动一次；
		如果从前往后，每个字符串需要多次移动，效率较低。
	解法三：开辟一个新的字符串。

*/

public class Solution3 {

    public String replaceSpace(StringBuffer str) {
        int spacenum = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ' '){
                spacenum++;
            }
        }
        int oldLength = str.length();
        int oldIndex = oldLength - 1;
        int newLength = oldLength + spacenum*2;
        str.setLength(newLength);
        int newIndex = newLength - 1;
//    	在当前字符串上进行从后往前的替换：
        for(; oldIndex >= 0 && oldLength < newLength; oldIndex--){
            if(str.charAt(oldIndex) == ' '){
                str.setCharAt(newIndex--, '0');
                str.setCharAt(newIndex--, '2');
                str.setCharAt(newIndex--, '%');
            }else{
                str.setCharAt(newIndex--, str.charAt(oldIndex));
            }
        }
        return str.toString();
    }
    /*    
    执行用时 :
    	1 ms
    	, 在所有 Java 提交中击败了
    	35.85%
    	的用户
    	内存消耗 :
    	37 MB
    	, 在所有 Java 提交中击败了
    	100.00%
    	的用户
    
  */ 
    
    public String replaceSpace1(String s) {
    	StringBuilder str = new StringBuilder(s);
        int spacenum = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ' '){
                spacenum++;
            }
        }
        int oldLength = s.length();
        int oldIndex = oldLength - 1;
		int newLength = oldLength + spacenum * 2;
        str.setLength(newLength);
        int newIndex = newLength - 1;
//    	在当前字符串上进行从后往前的替换：
        for(; oldIndex >= 0 && oldLength < newLength; oldIndex--){
            if(str.charAt(oldIndex) == ' '){
                str.setCharAt(newIndex--, '0');
                str.setCharAt(newIndex--, '2');
                str.setCharAt(newIndex--, '%');
            }else{
                str.setCharAt(newIndex--, str.charAt(oldIndex));
            }
        }
        return str.toString();
    }
    
    /*    
    执行用时 :
    	1 ms
    	, 在所有 Java 提交中击败了
    	35.85%
    	的用户
    	内存消耗 :
    	37 MB
    	, 在所有 Java 提交中击败了
    	100.00%
    	的用户
    
  */ 
    
}
