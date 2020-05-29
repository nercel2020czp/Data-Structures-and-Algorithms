package l_0017_电话号码的字母组合_letter_combinations_of_a_phone_number;

import java.util.LinkedList;
import java.util.List;

public class Solution3 {
	public List<String> letterCombinations(String digits) {
/*		确实巧妙啊，利用队列先进先出，将之前的字符串出队，拼接新的字符，新生成的字符串入队。
		操作简单清楚，而且使用LinkedList，申请新空间方便，不会像ArrayList那样频繁扩容导致的性能低下。*/
		LinkedList<String> ans = new LinkedList<String>();
		if(digits.isEmpty()) return ans;
		String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		ans.add("");
		for(int i =0; i<digits.length();i++){
			int x = Character.getNumericValue(digits.charAt(i));
			while(ans.peek().length()==i){
				String t = ans.remove();
				for(char s : mapping[x].toCharArray())
					ans.add(t+s);
			}
		}
		return ans;
	}
/*	执行用时 :
		7 ms
		, 在所有 Java 提交中击败了
		18.95%
		的用户
		内存消耗 :
		38.4 MB
		, 在所有 Java 提交中击败了
		5.16%
		的用户*/
}
