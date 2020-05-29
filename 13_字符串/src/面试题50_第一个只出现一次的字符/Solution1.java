package 面试题50_第一个只出现一次的字符;
/*对字符进行计数

遍历字符串字符，检查对应字符的出现次数

之所以是遍历字符串，是因为题目要求第一个只出现一次，要按字符串的字符顺序*/
class Solution1 {
    public char firstUniqChar(String s) {
        int[] count = new int[26];
        for(char c : s.toCharArray()){
            count[c - 'a']++;
        }
        for(char c : s.toCharArray()){
            if(count[c - 'a'] == 1) return c;
        }
        return ' ';
    }
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

/*作者：caixiaoxin
链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/solution/yi-ge-jian-dan-gao-xiao-de-tong-ji-fang-fa-by-caix/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
