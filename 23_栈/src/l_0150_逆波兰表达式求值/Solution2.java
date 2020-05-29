package l_0150_逆波兰表达式求值;

import java.util.Stack;

/*栈实现：*/
public class Solution2 {
	class Solution {
		// 栈实现   8 ms	36.7 MB	
		public int evalRPN(String[] tokens) {
			Stack<Integer> numStack = new Stack<>();
			Integer op1, op2;
			for (String s : tokens) {
				switch (s) {
				case "+":
					op2 = numStack.pop();
					op1 = numStack.pop();
					numStack.push(op1 + op2);
					break;
				case "-":
					op2 = numStack.pop();
					op1 = numStack.pop();
					numStack.push(op1 - op2);
					break;
				case "*":
					op2 = numStack.pop();
					op1 = numStack.pop();
					numStack.push(op1 * op2);
					break;
				case "/":
					op2 = numStack.pop();
					op1 = numStack.pop();
					numStack.push(op1 / op2);
					break;
				default:
					numStack.push(Integer.valueOf(s));
					break;
				}
			}
			return numStack.pop();
		}
	}

/*	执行用时 :
		6 ms
		, 在所有 Java 提交中击败了
		91.71%
		的用户
		内存消耗 :
		39.1 MB
		, 在所有 Java 提交中击败了
		7.14%
		的用户*/
	
/*	作者：hteason
	链接：https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/solution/javachun-shu-zu-he-zhan-liang-chong-shi-xian-jian-/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
