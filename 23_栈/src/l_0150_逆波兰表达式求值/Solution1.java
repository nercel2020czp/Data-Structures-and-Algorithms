package l_0150_逆波兰表达式求值;
/*
Java纯数组和栈两种实现:简洁

其他Java相关优化操作：

数组最大长度为tokens.length / 2 + 1
switch代替if-else，效率优化
Integer.parseInt代替Integer.valueOf,减少自动拆箱装箱操作

附两种方法：
纯数组模拟栈实现(推荐)：

作者：hteason
链接：https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/solution/javachun-shu-zu-he-zhan-liang-chong-shi-xian-jian-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

*/
public class Solution1 {
	//纯数组模拟栈实现(推荐)：
	class Solution {
		//纯数组模拟栈实现(推荐)   3 ms	36 MB
		public int evalRPN(String[] tokens) {
			int[] numStack = new int[tokens.length / 2 + 1];
			int index = 0;
			for (String s : tokens) {
				switch (s) {
				case "+":
					numStack[index - 2] += numStack[--index];
					break;
				case "-":
					numStack[index - 2] -= numStack[--index];
					break;
				case "*":
					numStack[index - 2] *= numStack[--index];
					break;
				case "/":
					numStack[index - 2] /= numStack[--index];
					break;
				default:
					// numStack[index++] = Integer.valueOf(s);
					//valueOf改为parseInt，减少自动拆箱装箱操作
					numStack[index++] = Integer.parseInt(s);
					break;
				}
			}
			return numStack[0];
		}
	}

/*	执行用时 :
		3 ms
		, 在所有 Java 提交中击败了
		99.65%
		的用户
		内存消耗 :
		39.2 MB
		, 在所有 Java 提交中击败了
		7.14%
		的用户*/
	
/*	作者：hteason
	链接：https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/solution/javachun-shu-zu-he-zhan-liang-chong-shi-xian-jian-/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
