package t054_字符流中第一个不重复的字符;
//这题其实并不难，里面需要唯一注意的点就是我们需要返回的字符是 第一次只出现一次的字符，
//所以当我们用map存储的时候，因为map是乱序的，所以我们需要额外判断我们返回的字符在字符流中的序号是不是最小。
/*
这题分三步：
	1.新建一个string input用来存储我们接收到的所有字符，
	     同时也能给我们后续判断字符出现的顺序做参照，再新建一个hashmap，
	     用来存储每个字符我们接收过的次数。
    2.insert function 填写：
    	 我们首先判断hashmap的keyset里有没有当前收到字符，
    	 	如果没有：
    	 		我们需要把keyset更新，
	 	         如果有：
 	         	我们需要把对应的value更新，同时我们将收到的字符串放进前面我们
 	         	新建的string input里
	3.FirstAppearingOnce function 填写： 
		我们需要先新建一个int index，来储存我们现在找到的最小的只出现一次的字符的index，
		然后我们新建一个char result，因为题目里提到，如果没有找到符合的字符，
		我们需要返回“#”，所以我们将char result设为默认值“#”。
		接下来我们遍历整个hashmap，如果有只出现一次的字符，我们记录下他的index，
		如果小于我们创建的int index，我们更新int index，同时更新我们对应的result。
		最后，我们return result即可。
*/

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
	//新建一个string input用来存储我们接收到的所有字符，
    //同时也能给我们后续判断字符出现的顺序做参照
	String input = "";//
	//再新建一个hashmap，用来存储每个字符我们接收过的次数。
	Map<Character, Integer> map = new HashMap<>();

	//Insert one char from stringstream
	public void Insert(char ch) {
		if (!map.keySet().contains(ch)) {
			map.put(ch, 1);
		} else {
			map.put(ch, map.get(ch) + 1);
		}
		input += ch;
	}

	// return the first appearence once char in current stringstream
	public char FirstAppearingOnce() {
		int index = Integer.MAX_VALUE;
		char result = '#';
		for (Character c : map.keySet()) {
			if (map.get(c) == 1) {
				if (input.indexOf(c) < index) {
					index = input.indexOf(c);
					result = input.charAt(index);
				}
			}
		}
		return result;
	}
}
