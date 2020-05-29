package l_0438_找到字符串中所有字母异位词_find_all_anagrams_in_a_string;

import java.util.HashMap;
import java.util.Vector;
//2:后来发现是这里window[d] == need[d]要将等号改为equals，就会全部通过了
public class Solution1 {
	
	static Vector<Integer> findAnagrams(String s, String t) {
	    HashMap<Character, Integer> need = new HashMap<>();
	    HashMap<Character, Integer> window = new HashMap<>();
	    for (char c : t.toCharArray()) 
	    	need.put(c, need.getOrDefault(c, 0) + 1);

	    int left = 0, right = 0;
	    int valid = 0;
	    Vector<Integer> res = new Vector<>(); // 记录结果
	    while (right < s.length()) {
	        char c = s.charAt(right);
	        right++;
	        // 进行窗口内数据的一系列更新
	        if (need.containsKey(c)) {
	            window.put(c, window.getOrDefault(c, 0) + 1);
	            if (window.get(c) == need.get(c)) 
	                valid++;
	        }
	        // 判断左侧窗口是否要收缩
	        while (right - left >= t.length()) {
	            // 当窗口符合条件时，把起始索引加入 res
	            if (valid == need.size())
	                res.add(left);
	            char d = s.charAt(left);
	            left++;
	            // 进行窗口内数据的一系列更新
	            if (need.containsKey(d)) {
	                if (window.get(d) == need.get(d))
	                    valid--;
	                window.put(d, window.get(d) - 1);
	            }
	        }
	    }
	    return res;
	}
	
	public static void main(String[] args) {
		//s: "abab" p: "ab"
//		String s = "cbaebabacd", p = "abc";
		String s = "abab", p = "ab";
		System.out.println(findAnagrams(s, p ));
	}

}
