package l_0567_字符串的排列_permutation_in_string;

import java.util.HashMap;
//2:后来发现是这里window[d] == need[d]要将等号改为equals，就会全部通过了
public class Solution1 {
	// 判断 s 中是否存在 t 的排列
	static boolean checkInclusion(String s1, String s2) {
	    HashMap<Character, Integer> need = new HashMap<>();
	    HashMap<Character, Integer> window = new HashMap<>();
	    
	    for (char c : s1.toCharArray()) 
	    	need.put(c, need.getOrDefault(c, 0) + 1);

	    int left = 0, right = 0;
	    int valid = 0;
	    while (right < s2.length()) {
	        char c = s2.charAt(right);
	        right++;
	        // 进行窗口内数据的一系列更新
	        if (need.containsKey(c)) {
	            window.put(c, window.getOrDefault(c, 0) + 1);
	            if (window.get(c) == need.get(c))
	                valid++;
	        }

	        // 判断左侧窗口是否要收缩
	        while (right - left >= s1.length()) {
	            // 在这里判断是否找到了合法的子串
	            if (valid == need.size())
	                return true;
	            char d = s2.charAt(left);
	            left++;
	            // 进行窗口内数据的一系列更新
	            if (need.containsKey(d)) {
	                if (window.get(d) == need.get(d))
	                    valid--;
	                window.put(d, window.get(d) - 1);
	            }
	        }
	    }
	    // 未找到符合条件的子串
	    return false;
	}
	
	public static void main(String[] args) {
		String s1 = "ab", s2 = "eidbaooo";
		System.out.println(checkInclusion(s1, s2));
	}
}
