package l_0049_字母异位词分组;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
解法四
首先初始化 key = "0#0#0#0#0#"，数字分别代表 abcde 出现的次数，# 用来分割。

这样的话，"abb" 就映射到了 "1#2#0#0#0"。

"cdc" 就映射到了 "0#0#2#1#0"。

"dcc" 就映射到了 "0#0#2#1#0"。

作者：windliang
链接：https://leetcode-cn.com/problems/group-anagrams/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--16/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

public class Solution4 {
	public List<List<String>> groupAnagrams(String[] strs) {
	    HashMap<String, List<String>> hash = new HashMap<>();
	    for (int i = 0; i < strs.length; i++) {
	        int[] num = new int[26];
	        //记录每个字符的次数
	        for (int j = 0; j < strs[i].length(); j++) {
	            num[strs[i].charAt(j) - 'a']++;
	        }
	        //转成 0#2#2# 类似的形式
	        String key = "";
	        for (int j = 0; j < num.length; j++) {
	            key = key + num[j] + '#';
	        }
	        if (hash.containsKey(key)) {
	            hash.get(key).add(strs[i]);
	        } else {
	            List<String> temp = new ArrayList<String>();
	            temp.add(strs[i]);
	            hash.put(key, temp);
	        }

	    }
	    return new ArrayList<List<String>>(hash.values());
	}
	
/*	执行用时 :
		54 ms
		, 在所有 Java 提交中击败了
		10.63%
		的用户
		内存消耗 :
		44.5 MB
		, 在所有 Java 提交中击败了
		14.71%
		的用户*/
/*	时间复杂度： O（nK）O（nK）。

	空间复杂度：O（NK）O（NK），用来存储结果。*/
}
