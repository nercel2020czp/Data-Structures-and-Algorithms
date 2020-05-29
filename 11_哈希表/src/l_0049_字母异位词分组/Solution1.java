package l_0049_字母异位词分组;
/*
解法一:
	最通用的一种解法，对于每个字符串，比较它们的每个字符出现的个数是否相等，相等的话就把它们放在一个 list 中去，作为一个类别。
	最外层写一个 for 循环然后一一比较就可以，还可以用一个等大的布尔型数组来记录当前字符串是否已经加入的了 list 。
	比较两个字符串的字符出现的次数可以用一个 HashMap，具体看代码吧。

作者：windliang
链接：https://leetcode-cn.com/problems/group-anagrams/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--16/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution1 {
	public List<List<String>> groupAnagrams(String[] strs) {
	    List<List<String>> ans = new ArrayList<>();
	    boolean[] used = new boolean[strs.length];
	    for (int i = 0; i < strs.length; i++) {
	        List<String> temp = null;
	        if (!used[i]) {
	            temp = new ArrayList<String>();
	            temp.add(strs[i]);
	            //两两比较判断字符串是否符合
	            for (int j = i + 1; j < strs.length; j++) {
	                if (equals(strs[i], strs[j])) {
	                    used[j] = true;
	                    temp.add(strs[j]);
	                }
	            }
	        }
	        if (temp != null) {
	            ans.add(temp);

	        }
	    }
	    return ans;

	}

	private boolean equals(String string1, String string2) {
	    Map<Character, Integer> hash = new HashMap<>();
	    //记录第一个字符串每个字符出现的次数，进行累加
	    for (int i = 0; i < string1.length(); i++) {
	        if (hash.containsKey(string1.charAt(i))) {
	            hash.put(string1.charAt(i), hash.get(string1.charAt(i)) + 1);
	        } else {
	            hash.put(string1.charAt(i), 1);
	        }
	    }
	     //记录第一个字符串每个字符出现的次数，将之前的每次减 1
	    for (int i = 0; i < string2.length(); i++) {
	        if (hash.containsKey(string2.charAt(i))) {
	            hash.put(string2.charAt(i), hash.get(string2.charAt(i)) - 1);
	        } else {
	            return false;
	        }
	    }
	    //判断每个字符的次数是不是 0 ，不是的话直接返回 false
	    Set<Character> set = hash.keySet();
	    for (char c : set) {
	        if (hash.get(c) != 0) {
	            return false;
	        }
	    }
	    return true;
	}

}
