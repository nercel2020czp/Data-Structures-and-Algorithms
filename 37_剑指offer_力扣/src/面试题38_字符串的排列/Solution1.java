package 面试题38_字符串的排列;

import java.util.HashMap;
/*
我们求整个字符串的排列，可以看成两步：
	第一步：求出所有可能出现在第一个位置的字符，即把第一个字符和后面所有的字符交换。
	第二步：固定第一个字符，求后面所有字符的排列。
		这个时候我们仍把后面的所有字符分成两部分：后面字符的第一个字符，以及这个字符之后
	     的所有字符。然后把第一个字符逐一和它后面的字符交换。
*/
class Solution {
    //为了便于获取map的key，从而生成字符串数组，所以没有采用无法获取key的set
    public HashMap<String, Integer> map = new HashMap<>();
    public String[] permutation(String s) {
        help(new StringBuilder().append(s), 0);
        String[] res = new String[map.size()];
        int index = 0;
        for (String key:map.keySet()){
            res[index] = key;
            index++;
        }
        return res;
    }

	public void help(StringBuilder s, int k) {
		// 递归返回条件，当k刚好等于字符串长度，说明所有元素都遍历完毕
		if (k == s.length()) {
			map.put(s.toString(), 1);
		}
		for (int i = k; i < s.length(); i++) {
			// 先固定某一个元素
			swap(s, i, k);
			// 再去递归后面的元素
			help(s, k + 1);
			// 回溯，需把之前换过的元素换回原来的位置
			swap(s, i, k);
		}
	}

	// 交换StringBuilder类型的字符串中任意位置的两个字符
	public void swap(StringBuilder s, int i, int j) {
		String cur = String.valueOf(s.charAt(i));
		s.replace(i, i + 1, String.valueOf(s.charAt(j)));
		s.replace(j, j + 1, cur);
	}
}
/*
作者：olivaaaa
链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/solution/jian-zhi-offerde-si-lu-by-olivaaaa/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/

/*执行用时:108 ms,

在所有 Java 提交中击败了 10.81%
的用户
内存消耗:46.9 MB,
在所有 Java 提交中击败了 100.00%的用户*/

