package l_0636_函数的独占时间;

import java.util.List;
import java.util.Stack;

/*
方法一：栈
	我们可以使用栈来模拟函数的调用，即在遇到一条包含 start 的日志时，我们将对应的函数 id 入栈；
	在遇到一条包含 end 的日志时，我们将对应的函数 id 出栈。
	在每一个时刻，栈中的所有函数均为被调用的函数，而栈顶的函数为正在执行的函数。
	
在每条日志的时间戳后，栈顶的函数会独占执行，直到下一条日志的时间戳，
因此我们可以根据相邻两条日志的时间戳差值，来计算函数的独占时间。

我们依次遍历所有的日志，对于第 i 条日志，
	如果它包含 start，那么栈顶函数从其时间戳 time[i] 开始运行，即 prev = time[i]；
	如果它包含 end，那么栈顶函数从其时间戳 time[i] 的下一个时间开始运行，即 prev = time[i] + 1。
	
对于第 i + 1 条日志，如果它包含 start，那么在时间戳 time[i + 1] 时，有新的函数被调用，
因此原来的栈顶函数的独占时间为time[i + 1] - prev；
如果它包含 end，那么在时间戳 time[i + 1] 时，原来的栈顶函数执行结束，独占时间为 time[i+1] - prev + 1。
在这之后，我们更新 prev 并遍历第 i + 2 条日志。
在遍历结束后，我们就可以得到所有函数的独占时间。


作者：LeetCode
链接：https://leetcode-cn.com/problems/exclusive-time-of-functions/solution/han-shu-de-du-zhan-shi-jian-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

public class Solution1 {
/*	执行用时 :
		19 ms
		, 在所有 Java 提交中击败了
		65.23%
		的用户
		内存消耗 :
		40.5 MB
		, 在所有 Java 提交中击败了
		100.00%
		的用户*/
	class Solution {
		public int[] exclusiveTime(int n, List<String> logs) {
			//我们可以使用栈来模拟函数的调用，即在遇到一条包含 start 的日志时，我们将对应的函数 id 入栈；
			//在遇到一条包含 end 的日志时，我们将对应的函数 id 出栈。
			//在每一个时刻，栈中的所有函数均为被调用的函数，而栈顶的函数为正在执行的函数。
			Stack<Integer> stack = new Stack<>();
			int[] res = new int[n];
			String[] s = logs.get(0).split(":");
			stack.push(Integer.parseInt(s[0]));
			int i = 1, prev = Integer.parseInt(s[2]);
			while (i < logs.size()) {
				//s[0]:是进程id, s[1]:是start或者end, s[2]:是时间戳
				s = logs.get(i).split(":");
				if (s[1].equals("start")) {
					if (!stack.isEmpty())
						res[stack.peek()] += (Integer.parseInt(s[2]) - prev);
					stack.push(Integer.parseInt(s[0]));
					prev = Integer.parseInt(s[2]);
				} else {
					res[stack.peek()] += (Integer.parseInt(s[2]) - prev + 1);
					stack.pop();
					prev = Integer.parseInt(s[2]) + 1;
				}
				i++;
			}
			return res;
		}
	}

/*	作者：LeetCode
	链接：https://leetcode-cn.com/problems/exclusive-time-of-functions/solution/han-shu-de-du-zhan-shi-jian-by-leetcode/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
