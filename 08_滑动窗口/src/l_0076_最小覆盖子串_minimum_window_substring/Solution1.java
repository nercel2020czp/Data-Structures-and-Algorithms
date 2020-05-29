package l_0076_最小覆盖子串_minimum_window_substring;

import java.util.HashMap;

/*
 * 看了您的文章受益匪浅，前三道题按照您C++代码用java都写了一遍，每道题在leetcode上不能全通过，而您C++的代码全通过，好气啊，逐步逐步画图盯着看了半天不知道哪有问题。
作者:盲猜原因是 cpp 的哈希表会自动填充不存在的键。另外，有 IDE 可以 debug，盯着看没效率。
发现一只可达鸭
 2:后来发现是这里window[d] == need[d]要将等号改为equals，就会全部通过了
作者
 1:哦对，这个好像是 Java 包装类的原因，不能用等号而要用 equals 方法，给你置顶
 */

public class Solution1 {
	
    public static String minWindow(String s, String t) {
    	HashMap<Character, Integer> need = new HashMap<>();
    	HashMap<Character, Integer> window = new HashMap<>();
    	
    	for(char c : t.toCharArray()) 
    		need.put(c, need.getOrDefault(c, 0) + 1);
    	
    	int left = 0, right = 0;
    	int valid = 0;
    	//记录最小覆盖子串的起始索引及长度
    	long start = 0, len = Long.MAX_VALUE;
    	while (right < s.length()) {
    		// c 是将移入窗口的字符
            char c = s.charAt(right);
            // 右移窗口
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c)))
                    valid++;
            }
            
            // 判断左侧窗口是否要收缩
            while (valid == need.size()) {
                // 在这里更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 左移窗口
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d)))
                        valid--;
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }                    
            }
    	}
    	// 返回最小覆盖子串
        return len == Long.MAX_VALUE ?
            "" : s.substring((int)start, (int) (start + len));
    }

    public static void main(String[] args) {
		String s = "ADOBECODEBANC", t = "ABC";
		System.out.println(minWindow(s, t));
	}
    
}
