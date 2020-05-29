package l_0020_有效的括号;

import java.util.HashMap;
import java.util.Stack;

/*
思路

想象一下，你正在为你的大学课设编写一个小型编译器，编译器的任务之一（或称子任务）将检测括号是否匹配。

我们本文中看到的算法可用于处理编译器正在编译的程序中的所有括号，并检查是否所有括号都已配对。这将检查给定的括号字符串是否有效，是一个重要的编程问题。

我们这个问题中将要处理的表达式可以包含以下三种不同类型的括号：

作者：LeetCode
链接：https://leetcode-cn.com/problems/valid-parentheses/solution/you-xiao-de-gua-hao-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

()，
{} 以及
[]

在查看如何检查由这些括号组成的给定表达式是否有效之前，
让我们看一下该问题的简化版本，在简化后的问题中，只含一种类型的括号。
这么一来，我们将会遇到的表达式是

(((((()))))) -- VALID

()()()()     -- VALID

(((((((()    -- INVALID

((()(())))   -- VALID

作者：LeetCode
链接：https://leetcode-cn.com/problems/valid-parentheses/solution/you-xiao-de-gua-hao-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


算法
	1.初始化栈 S。
	2.一次处理表达式的每个括号。
	3.如果遇到开括号，我们只需将其推到栈上即可。
	     这意味着我们将稍后处理它，让我们简单地转到前面的 子表达式。
	4.如果我们遇到一个闭括号，那么我们检查栈顶的元素。
	     如果栈顶的元素是一个 相同类型的 左括号，那么我们将它从栈中弹出并继续处理。
	     否则，这意味着表达式无效。
	5.如果到最后我们剩下的栈中仍然有元素，那么这意味着表达式无效。

作者：LeetCode
链接：https://leetcode-cn.com/problems/valid-parentheses/solution/you-xiao-de-gua-hao-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Solution1 {
	
/*	算法
	1.初始化栈 S。
	2.一次处理表达式的每个括号。
	3.如果遇到开括号，我们只需将其推到栈上即可。
	     这意味着我们将稍后处理它，让我们简单地转到前面的 子表达式。
	4.如果我们遇到一个闭括号，那么我们检查栈顶的元素。
	     如果栈顶的元素是一个 相同类型的 左括号，那么我们将它从栈中弹出并继续处理。
	     否则，这意味着表达式无效。
	5.如果到最后我们剩下的栈中仍然有元素，那么这意味着表达式无效。*/
	
	class Solution {

		// Hash table that takes care of the mappings.
		private HashMap<Character, Character> mappings;

		// Initialize hash map with mappings. This simply makes the code easier to read.
		public Solution() {
			this.mappings = new HashMap<Character, Character>();
			this.mappings.put(')', '(');
			this.mappings.put('}', '{');
			this.mappings.put(']', '[');
		}

		public boolean isValid(String s) {
/*			1.初始化栈 S。
			2.一次处理表达式的每个括号。
			3.如果遇到开括号，我们只需将其推到栈上即可。
			     这意味着我们将稍后处理它，让我们简单地转到前面的 子表达式。
			4.如果我们遇到一个闭括号，那么我们检查栈顶的元素。
			     如果栈顶的元素是一个 相同类型的 左括号，那么我们将它从栈中弹出并继续处理。
			     否则，这意味着表达式无效。
			5.如果到最后我们剩下的栈中仍然有元素，那么这意味着表达式无效。*/
			// Initialize a stack to be used in the algorithm.
			Stack<Character> stack = new Stack<Character>();

			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);

				// If the current character is a closing bracket.
				if (this.mappings.containsKey(c)) {

					// Get the top element of the stack. If the stack is empty, set a dummy value of
					// '#'
					char topElement = stack.empty() ? '#' : stack.pop();

					// If the mapping for this bracket doesn't match the stack's top element, return
					// false.
					if (topElement != this.mappings.get(c)) {
						return false;
					}
				} else {
					// If it was an opening bracket, push to the stack.
					stack.push(c);
				}
			}

			// If the stack still contains elements, then it is an invalid expression.
			return stack.isEmpty();
		}
	}
/*	
	复杂度分析

	时间复杂度：O(n)O(n)，因为我们一次只遍历给定的字符串中的一个字符并在栈上进行 O(1)O(1) 的推入和弹出操作。
	空间复杂度：O(n)O(n)，当我们将所有的开括号都推到栈上时以及在最糟糕的情况下，我们最终要把所有括号推到栈上。例如 ((((((((((。

	作者：LeetCode
	链接：https://leetcode-cn.com/problems/valid-parentheses/solution/you-xiao-de-gua-hao-by-leetcode/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
	
}
