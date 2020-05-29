package l_0387_字符串中的第一个唯一字符;

import java.util.HashMap;

/*方法一： 线性时间复杂度解法
这道题最优的解法就是线性复杂度了，为了保证每个元素是唯一的，至少得把每个字符都遍历一遍。

算法的思路就是遍历一遍字符串，然后把字符串中每个字符出现的次数保存在一个散列表中。
这个过程的时间复杂度为 O(N)O(N)，其中 NN 为字符串的长度。

接下来需要再遍历一次字符串，这一次利用散列表来检查遍历的每个字符是不是唯一的。
如果当前字符唯一，直接返回当前下标就可以了。第二次遍历的时间复杂度也是 O(N)O(N)。

作者：LeetCode
链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string/solution/zi-fu-chuan-zhong-de-di-yi-ge-wei-yi-zi-fu-by-leet/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
public class Solution3 {
	class Solution {
	    public int firstUniqChar(String s) {
	        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
	        int n = s.length();
	        // build hash map : character and how often it appears
	        for (int i = 0; i < n; i++) {
	            char c = s.charAt(i);
	            count.put(c, count.getOrDefault(c, 0) + 1);
	        }
	        
	        // find the index
	        for (int i = 0; i < n; i++) {
	            if (count.get(s.charAt(i)) == 1) 
	                return i;
	        }
	        return -1;
	    }
	}
	
/*
	作者：LeetCode
	链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string/solution/zi-fu-chuan-zhong-de-di-yi-ge-wei-yi-zi-fu-by-leet/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
