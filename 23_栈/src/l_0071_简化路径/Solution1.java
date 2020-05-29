package l_0071_简化路径;

import java.util.Deque;
import java.util.LinkedList;

/*思路:
一句话解释: 栈解决,把当前目录压入栈中,遇到..弹出栈顶,最后返回栈中元素.*/
public class Solution1 {
	class Solution {
		public String simplifyPath(String path) {
			Deque<String> stack = new LinkedList<>();
			for (String item : path.split("/")) {
				if (item.equals("..")) {
					if (!stack.isEmpty())
						stack.pop();
				} else if (!item.isEmpty() && !item.equals("."))
					stack.push(item);
			}
			String res = "";
			for (String d : stack)
				res = "/" + d + res;
			return res.isEmpty() ? "/" : res;
		}
	}
	
/*	执行用时 :
		10 ms
		, 在所有 Java 提交中击败了
		34.82%
		的用户
		内存消耗 :
		40.2 MB
		, 在所有 Java 提交中击败了
		9.52%
		的用户*/
	

/*	作者：powcai
	链接：https://leetcode-cn.com/problems/simplify-path/solution/zhan-by-powcai/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
