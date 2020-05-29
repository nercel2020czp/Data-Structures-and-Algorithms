package t027_字符串的排列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/*链接：https://www.nowcoder.com/questionTerminal/fe6b651b66ae47d7acce78ffdd9a96c7?answerType=1&f=discussion
来源：牛客网

先学习回溯的基本套路，这里使用回溯法解，那么思考回溯的那些玩意有啥：

path 是啥 ？StringBuilder
paths 是啥 ？TreeSet
状态重置哪一些东西？重置使用状态 visited[] 以及 StringBuilder 的最后一个字符
具体是这样的：

排列组合中用过的字符不能再用，所以要用 boolean visited[] 来标记哪一个用过，用过了就不能再组合
题目说可能有重复字母，TreeSet 刚好存的值不能重复，所以用 TreeSet，假如用 List 存会存在：
S = "aa"
List = ["aa", "aa"]
第一个是第一个 a 开头的，第二个是第二个 a 开头的
最后，将 TreeSet 的值放入 ArrayList 返回即可，这是题目要求的
*/
public class Solution2 {

	private ArrayList<String> res = new ArrayList<>();
	private TreeSet<String> paths = new TreeSet<>();
	private StringBuilder path = new StringBuilder();
	private boolean[] visited;

	public ArrayList<String> Permutation(String str) {
		if (str == null || str.equals("")) {
			return res;
		}
		char[] strs = str.toCharArray();
		Arrays.sort(strs);
		visited = new boolean[strs.length];
		combination(strs, 0);
		res.addAll(paths);
		return res;
	}

	private void combination(char[] strs, int len) {
		if (len == strs.length) {
			paths.add(path.toString());
			return;
		}
		for (int i = 0; i < strs.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				path.append(strs[i]);
				combination(strs, len + 1);
				// Duang ~ 回溯 - 状态重置
				visited[i] = false;
				path.deleteCharAt(path.length() - 1);
			}
		}
	}
/*	链接：https://www.nowcoder.com/questionTerminal/fe6b651b66ae47d7acce78ffdd9a96c7?answerType=1&f=discussion
		来源：牛客网

		总结
		这道题是常规回溯基本应用，最好是学习了回溯后拿来练手，这次总共碰到了两个坑：

		重复问题，一开始用 ArrayList 存，有重复结果，用 TreeSet 解决
		StringBuilder 删除越界，因为每次删除，我们相当于要删除路径的最后一个字符，而一开始我删除的是第 i 个，那么可能前面的删除了，导致 i 大于当前字符串的最大长度，就越界了
		PS：回溯法是真的神奇，Duang 的一下，就回溯 = =，同时排列组合问题，一般是回溯法解*/
}
