package c13_LeetCode.l_0804_唯一摩尔斯密码词;

/*方法一：哈希集合
我们将数组 word 中的每个单词转换为摩尔斯码，并加入哈希集合（HashSet）中，最终的答案即为哈希集合中元素的个数。*/

import java.util.HashSet;
import java.util.Set;


public class Solution1 {
	class Solution {
		
		/*	执行用时 :
				2 ms
				, 在所有 Java 提交中击败了
				99.56%
				的用户
				内存消耗 :
				37.9 MB
				, 在所有 Java 提交中击败了
				12.50%
				的用户*/
			
		    public int uniqueMorseRepresentations(String[] words) {
		        String[] MORSE = new String[]{".-","-...","-.-.","-..",".","..-.","--.",
		                         "....","..",".---","-.-",".-..","--","-.",
		                         "---",".--.","--.-",".-.","...","-","..-",
		                         "...-",".--","-..-","-.--","--.."};

		        Set<String> seen = new HashSet<>();
		        for (String word: words) {
		            StringBuilder code = new StringBuilder();
		            for (char c: word.toCharArray())
		                code.append(MORSE[c - 'a']);
		            seen.add(code.toString());
		        }

		        return seen.size();
		    }
		}

		/*作者：LeetCode
		链接：https://leetcode-cn.com/problems/unique-morse-code-words/solution/wei-yi-mo-er-si-mi-ma-ci-by-leetcode/
		来源：力扣（LeetCode）
		著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
