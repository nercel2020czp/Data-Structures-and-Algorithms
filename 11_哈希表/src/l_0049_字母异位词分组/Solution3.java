package l_0049_字母异位词分组;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
解法三:
	算术基本定理，又称为正整数的唯一分解定理，即：每个大于1的自然数，要么本身就是质数，
	要么可以写为2个以上的质数的积，而且这些质因子按大小排列之后，写法仅有一种方式。
	
利用这个，我们把每个字符串都映射到一个正数上。

用一个数组存储质数 prime = 
{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103}。

然后每个字符串的字符减去 ' a ' ，然后取到 prime 中对应的质数。把它们累乘。

例如 abc ，就对应 'a' - 'a'， 'b' - 'a'， 'c' - 'a'，即 0, 1, 2，也就是对应素数 2 3 5，
然后相乘 2 * 3 * 5 = 30，就把 "abc" 映射到了 30。


图1.png

作者：windliang
链接：https://leetcode-cn.com/problems/group-anagrams/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--16/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

public class Solution3 {
	public List<List<String>> groupAnagrams(String[] strs) {
	    HashMap<Integer, List<String>> hash = new HashMap<>();
	    //每个字母对应一个质数
	    int[] prime = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103 };
	    for (int i = 0; i < strs.length; i++) {
	        int key = 1;
	        //累乘得到 key
	        for (int j = 0; j < strs[i].length(); j++) {
	            key *= prime[strs[i].charAt(j) - 'a'];
	        } 
	        if (hash.containsKey(key)) {
	            hash.get(key).add(strs[i]);
	        } else {
	            List<String> temp = new ArrayList<String>();
	            temp.add(strs[i]);
	            hash.put(key, temp);
	        }

	    }
	    //这一步！！！
	    return new ArrayList<List<String>>(hash.values());
	}

/*	执行用时 :
		8 ms
		, 在所有 Java 提交中击败了
		98.56%
		的用户
		内存消耗 :
		42.7 MB
		, 在所有 Java 提交中击败了
		32.35%
		的用户*/
	
}
