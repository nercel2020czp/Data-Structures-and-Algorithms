package l_0316_去除重复字母;

import java.util.Stack;

/*解题思想:
若栈中已经有当前元素，则直接去除当前元素
若当前的栈顶元素比当前的元素字典序大，且当前元素的位置后面还有栈顶元素,
将栈顶元素出栈, 将当前元素入栈, 这样来找到最优的排列

作者：5jiong-jie
链接：https://leetcode-cn.com/problems/remove-duplicate-letters/solution/java-zhan-shi-xian-by-5jiong-jie/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
public class Solution1 {
/*	执行用时 :
		5 ms
		, 在所有 Java 提交中击败了
		81.67%
		的用户
		内存消耗 :
		38 MB
		, 在所有 Java 提交中击败了
		16.67%
		的用户*/
	public String removeDuplicateLetters(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			// 1若栈中已经有当前元素，则直接去除当前元素
			if (stack.contains(c))
				continue;
			// 2若当前的栈顶元素比当前的元素字典序大，且当前元素的位置后面还有栈顶元素,
			while (!stack.isEmpty() && stack.peek() > c && s.indexOf(stack.peek(), i) != -1)
				stack.pop();
			stack.push(c);
		}
		char[] res = new char[stack.size()];
		for (int i = 0; i < stack.size(); i++)
			res[i] = stack.get(i);

		return new String(res);
	}

	public static void main(String[] args) {
		String s = "cbacdcbc";
		System.out.println(new Solution1().removeDuplicateLetters(s));
	}
	
/*	作者：5jiong-jie
	链接：https://leetcode-cn.com/problems/remove-duplicate-letters/solution/java-zhan-shi-xian-by-5jiong-jie/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
