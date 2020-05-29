package t021_栈的压入_弹出序列;

import java.util.Stack;

//思路：新建一个栈，将数组pushA压入栈中，当栈顶元素等于数组popA时，就将其出栈，当循环结束时，判断栈是否为空，若为空则返回true.
public class Solution1 {

	public boolean IsPopOrder(int[] pushA, int[] popA) {
		if (pushA.length == 0 || popA.length == 0 
				|| popA.length != pushA.length)
			return false;
		Stack<Integer> stack = new Stack<Integer>();
		int j = 0;
		for (int i = 0; i < pushA.length; i++) {
			stack.push(pushA[i]);

			while (!stack.isEmpty() && stack.peek() == popA[j]) {
				stack.pop();
				j++;
			}
		}
		//判断栈是否为空，若为空则返回true
		return stack.isEmpty();
	}
}
