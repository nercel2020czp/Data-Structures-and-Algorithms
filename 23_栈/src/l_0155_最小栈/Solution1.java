package l_0155_最小栈;

import java.util.Stack;

/*解法一

要实现一个 stack，那么我们还能用 java 自带的 stack 吗？
也不用纠结，这道题的关键其实是实现「得到最小值这个功能」，所以为了代码简洁些，
我们就直接使用系统自带的 stack 了。

这道题最直接的解法就是我们可以用两个栈：
	一个栈去保存正常的入栈出栈的值，
	另一个栈去存最小值，也就是用栈顶保存当前所有元素的最小值。
存最小值的栈的具体操作流程如下：
	1.将第一个元素入栈。
	2.新加入的元素如果大于栈顶元素，那么新加入的元素就不处理。
	3.新加入的元素如果小于等于栈顶元素，那么就将新元素入栈。
	4.出栈元素不等于栈顶元素，不操作。
	5.出栈元素等于栈顶元素，那么就将栈顶元素出栈。
	
举个例子。
入栈 3 
|   |    |   |
|   |    |   |
|_3_|    |_3_|
stack  minStack

入栈 5 ， 5 大于 minStack 栈顶，不处理
|   |    |   |
| 5 |    |   |
|_3_|    |_3_|
stack  minStack

入栈 2 ，此时右边的 minStack 栈顶就保存了当前最小值 2 
| 2 |    |   |
| 5 |    | 2 |
|_3_|    |_3_|
stack  minStack

出栈 2，此时右边的 minStack 栈顶就保存了当前最小值 3
|   |    |   |
| 5 |    |   |
|_3_|    |_3_|
stack  minStack

出栈 5，右边 minStack 不处理
|   |    |   |
|   |    |   |
|_3_|    |_3_|
stack  minStack

出栈 3
|   |    |   |
|   |    |   |
|_ _|    |_ _|
stack  minStack



作者：windliang
链接：https://leetcode-cn.com/problems/min-stack/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-38/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



*/
public class Solution1 {
/*	执行用时 :
		8 ms
		, 在所有 Java 提交中击败了
		57.74%
		的用户
		内存消耗 :
		41.3 MB
		, 在所有 Java 提交中击败了
		15.66%
		的用户*/
	class MinStack {
	    /** initialize your data structure here. */
	    private Stack<Integer> stack;
	    private Stack<Integer> minStack;

	    public MinStack() {
	        stack = new Stack<>();
	        minStack = new Stack<>();
	    }

	    public void push(int x) {
	        stack.push(x);
	        if (!minStack.isEmpty()) {
	            int top = minStack.peek();
	            //小于的时候才入栈
	            if (x <= top) {
	                minStack.push(x);
	            }
	        }else{
	            minStack.push(x);
	        }
	    }

	    public void pop() {
	        int pop = stack.pop();

	        int top = minStack.peek();
	        //等于的时候再出栈
	        if (pop == top) {
	            minStack.pop();
	        }

	    }

	    public int top() {
	        return stack.peek();
	    }

	    public int getMin() {
	        return minStack.peek();
	    }
	}
/*
	作者：windliang
	链接：https://leetcode-cn.com/problems/min-stack/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-38/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/

}
