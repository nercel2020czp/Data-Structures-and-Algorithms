package l_0155_最小栈;

import java.util.Stack;

/*
解法二
解法一中用了两个栈去实现，那么我们能不能用一个栈去实现呢？

参考了 这里。https://leetcode.com/problems/min-stack/discuss/49014/Java-accepted-solution-using-one-stack


解法一中单独用了一个栈去保存所有最小值，那么我们能不能只用一个变量去保存最小值呢？

再看一下上边的例子。

入栈 3 
|   |   min = 3
|   |     
|_3_|    
stack   

入栈 5 
|   |   min = 3
| 5 |     
|_3_|    
stack  

入栈 2 
| 2 |   min = 2?
| 5 |     
|_3_|    
stack  

如果只用一个变量就会遇到一个问题，如果把 min 更新为 2，那么之前的最小值 3 就丢失了。

怎么把 3 保存起来呢？把它在 2 之前压入栈中即可。

入栈 2 ，同时将之前的 min 值 3 入栈，再把 2 入栈，同时更新 min = 2
| 2 |   min = 2
| 3 |  
| 5 |     
|_3_|    
stack  

入栈 6 
| 6 |  min = 2
| 2 |   
| 3 |  
| 5 |     
|_3_|    
stack  

出栈 6     
| 2 |   min = 2
| 3 |  
| 5 |     
|_3_|    
stack  

出栈 2     
| 2 |   min = 2
| 3 |  
| 5 |     
|_3_|    
stack  

上边的最后一个状态，当出栈元素是最小元素我们该如何处理呢？

我们只需要把 2 出栈，然后再出栈一次，把 3 赋值给 min 即可。

出栈 2     
|   |  min = 3   
| 5 |   
|_3_|    
stack  

通过上边的方式，我们就只需要一个栈了。
当有更小的值来的时候，我们只需要把之前的最小值入栈，当前更小的值再入栈即可。
当这个最小值要出栈的时候，下一个值便是之前的最小值了。


作者：windliang
链接：https://leetcode-cn.com/problems/min-stack/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-38/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
public class Solution2 {
/*	执行用时 :
		6 ms
		, 在所有 Java 提交中击败了
		98.07%
		的用户
		内存消耗 :
		41.2 MB
		, 在所有 Java 提交中击败了
		15.66%
		的用户*/
	
	class MinStack {
	    int min = Integer.MAX_VALUE;
	    Stack<Integer> stack = new Stack<Integer>();
	    public void push(int x) {
	        //当前值更小
	        if(x <= min){   
	            //将之前的最小值保存
	            stack.push(min);
	            //更新最小值
	            min=x;
	        }
	        stack.push(x);
	    }

	    public void pop() {
	        //如果弹出的值是最小值，那么将下一个元素更新为最小值
	        if(stack.pop() == min) {
	            min=stack.pop();
	        }
	    }

	    public int top() {
	        return stack.peek();
	    }

	    public int getMin() {
	        return min;
	    }
	}

/*	作者：windliang
	链接：https://leetcode-cn.com/problems/min-stack/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-38/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
