package t054_字符流中第一个不重复的字符;
/*链接：https://www.nowcoder.com/questionTerminal/00de97733b8e4f97a3fb5c680ee10720?answerType=1&f=discussion
来源：牛客网

看到很多讨论代码中FirstAppearingOnce()方法中都是这样写的：
for(char ch : str) | for(int i=0;i<size;++i)
真的是... emmm...

【澄清】offer书上代码中occurrence[i]数组有两个作用，很是巧妙：
	1.记录字符出现的次数；
	2.记录字符出现的次数。
特此，我分别用两个数组来表示，如下：*/

public class Solution2 {
 
    int[] count = new int[256]; // 字符出现的次数
    int[] index = new int[256]; // 字符出现的次数
    int number = 0;
 
    public void Insert(char ch) {
        count[ch]++;
        index[ch] = number++;
    }
 
    public char FirstAppearingOnce() {
        int minIndex = number;
        char ch = '#';
        for (int i = 0; i < 256; i++) {  // !!!
            if (count[i] == 1 && index[i] < minIndex) {
                ch = (char) i;
                minIndex = index[i];
            }
        }
        return ch;
    }
    
/*    public char firstUniqChar(String s) {
        int[] count = new int[26];
        for(char c : s.toCharArray()){
            count[c - 'a']++;
        }
        for(char c : s.toCharArray()){
            if(count[c - 'a'] == 1) return c;
        }
        return ' ';
    }*/
/*    执行用时 :
    	6 ms
    	, 在所有 Java 提交中击败了
    	92.14%
    	的用户
    	内存消耗 :
    	41.7 MB
    	, 在所有 Java 提交中击败了
    	100.00%
    	的用户*/
    
}
