package l_0155_最小栈;

import java.util.Stack;

/*解法三【瞭解即可，不要求掌握】
参考 这里，再分享利用一个栈的另一种思路。

通过解法二的分析，我们关键要解决的问题就是当有新的更小值的时候，之前的最小值该怎么办？

解法二中通过把之前的最小值入栈解决问题。

这里的话，用了另一种思路。同样是用一个 min 变量保存最小值。
只不过栈里边我们不去保存原来的值，而是去存储入栈的值和最小值的差值。
然后得到之前的最小值的话，我们就可以通过 min 值和栈顶元素得到，举个例子。

入栈 3，存入 3 - 3 = 0
|   |   min = 3
|   |     
|_0_|    
stack   

入栈 5，存入 5 - 3 = 2
|   |   min = 3
| 2 |     
|_0_|    
stack  

入栈 2，因为出现了更小的数，所以我们会存入一个负数，这里很关键
也就是存入  2 - 3 = -1, 并且更新 min = 2 
对于之前的 min 值 3, 我们只需要用更新后的 min - 栈顶元素 -1 就可以得到    
| -1|   min = 2
| 5 |     
|_3_|    
stack  

入栈 6，存入  6 - 2 = 4
| 4 |   min = 2
| -1| 
| 5 |     
|_3_|    
stack  

出栈，返回的值就是栈顶元素 4 加上 min，就是 6
|   |   min = 2
| -1| 
| 5 |     
|_3_|    
stack  

出栈，此时栈顶元素是负数，说明之前对 min 值进行了更新。
入栈元素 - min = 栈顶元素，入栈元素其实就是当前的 min 值 2
所以更新前的 min 就等于入栈元素 2 - 栈顶元素(-1) = 3
|   | min = 3
| 5 |     
|_3_|    
stack     

再理一下上边的思路，我们每次存入的是 原来值 - 当前最小值。

当原来值大于等于当前最小值的时候，我们存入的肯定就是非负数，
所以出栈的时候就是 栈中的值 + 当前最小值 。

当原来值小于当前最小值的时候，我们存入的肯定就是负值，此时的值我们不入栈，
用 min 保存起来，同时将差值入栈。

当后续如果出栈元素是负数的时候，那么要出栈的元素其实就是 min。
此外之前的 min 值，我们可以通过栈顶的值和当前 min 值进行还原，
就是用 min 减去栈顶元素即可。



上边的解法的一个缺点就是由于我们保存的是差值，所以可能造成溢出，所以我们用了数据范围更大的 long 类型。

此外相对于解法二，最小值需要更新的时候，我们并没有将之前的最小值存起来，
我们每次都是通过当前最小值和栈顶元素推出了之前的最小值，所以会省一些空间。



作者：windliang
链接：https://leetcode-cn.com/problems/min-stack/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-38/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
public class Solution3 {
/*	再理一下上边的思路，我们每次存入的是 原来值 - 当前最小值。

	当原来值大于等于当前最小值的时候，我们存入的肯定就是非负数，
	所以出栈的时候就是 栈中的值 + 当前最小值 。

	当原来值小于当前最小值的时候，我们存入的肯定就是负值，此时的值我们不入栈，
	用 min 保存起来，同时将差值入栈。

	当后续如果出栈元素是负数的时候，那么要出栈的元素其实就是 min。
	此外之前的 min 值，我们可以通过栈顶的值和当前 min 值进行还原，
	就是用 min 减去栈顶元素即可。*/
	
/*	执行用时 :
		8 ms
		, 在所有 Java 提交中击败了
		57.74%
		的用户
		内存消耗 :
		41.6 MB
		, 在所有 Java 提交中击败了
		14.46%
		的用户*/
	
	public class MinStack {
	    long min;
		Stack<Long> stack;

		public MinStack(){
	        stack=new Stack<>();
	    }

		public void push(int x) {
//			我们每次存入的是 原来值 - 当前最小值。
			if (stack.isEmpty()) {
				min = x;
				stack.push(x - min);
			} else {
				stack.push(x - min);
				if (x < min){
//					当原来值小于当前最小值的时候，我们存入的肯定就是负值，此时的值我们不入栈，
//					用 min 保存起来，同时将差值入栈。
					min = x; // 更新最小值
				}
					
			}
		}

		public void pop() {
			if (stack.isEmpty())
				return;

			long pop = stack.pop();
			
			//弹出的是负值，要更新 min
			if (pop < 0) {
				min = min - pop;
			}

		}

		public int top() {
			long top = stack.peek();
			//负数的话，出栈的值保存在 min 中
			if (top < 0) {
				return (int) (min);
	        //出栈元素加上最小值即可
			} else {
				return (int) (top + min);
			}
		}

		public int getMin() {
			return (int) min;
		}
	}

/*	作者：windliang
	链接：https://leetcode-cn.com/problems/min-stack/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-38/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
