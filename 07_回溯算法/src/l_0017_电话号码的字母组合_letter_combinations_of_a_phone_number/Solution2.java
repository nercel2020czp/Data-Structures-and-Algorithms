package l_0017_电话号码的字母组合_letter_combinations_of_a_phone_number;

import java.util.ArrayList;
import java.util.List;

/*利用队列求解
我们可以利用队列的先进先出特点，再配合循环完成题目要求。
我们先将2对应的字符"a","b","c"依次放入队列中*/
class Solution2 {
	public List<String> letterCombinations(String digits) {
		if (digits == null || digits.length() == 0) {
			return new ArrayList<String>();
		}
		// 一个映射表，第二个位置是"abc“,第三个位置是"def"。。。
		// 这里也可以用map，用数组可以更节省点内存
		String[] letter_map = { " ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		
/*		确实巧妙啊，利用队列先进先出，将之前的字符串出队，拼接新的字符，新生成的字符串入队。
		操作简单清楚，而且使用LinkedList，申请新空间方便，不会像ArrayList那样频繁扩容导致的性能低下。*/
		List<String> res = new ArrayList<>();
		// 先往队列中加入一个空字符
		res.add("");
		for (int i = 0; i < digits.length(); i++) {
			// 由当前遍历到的字符，取字典表中查找对应的字符串
			String letters = letter_map[digits.charAt(i) - '0'];
			int size = res.size();
			// 计算出队列长度后，将队列中的每个元素挨个拿出来
			for (int j = 0; j < size; j++) {
				// 每次都从队列中拿出第一个元素
				String tmp = res.remove(0);
				// 然后跟"def"这样的字符串拼接，并再次放到队列中
				for (int k = 0; k < letters.length(); k++) {
					res.add(tmp + letters.charAt(k));
				}
			}
		}
		return res;
	}
/*	执行用时 :
		7 ms
		, 在所有 Java 提交中击败了
		18.95%
		的用户
		内存消耗 :
		38.2 MB
		, 在所有 Java 提交中击败了
		5.16%
		的用户*/
}
