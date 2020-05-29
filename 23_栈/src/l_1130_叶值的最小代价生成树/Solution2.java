package l_1130_叶值的最小代价生成树;

import java.util.Stack;

/*单调栈：
单调栈的方法有点讨巧。
以下是我的个人理解
我们维护一个单调递减栈，单调递减栈有一个特性。
如果我们遇到一个比栈顶元素大元素，于是乎就有了两种情况。
我们就看前面3个。
第一种情况：大 小 中，这样只会将小出栈。
我们来算一下：
大小放一块：大 * 小 + 大 * 中
小中放一块：小 * 中 + 大 * 中
所以把小和中放在一起得到的值更小。
第二种情况： 中 小 大， 小 中 都会出栈
中小放在一块：中 * 小 + 中 * 大
小大放在一块：小 * 大 + 中 * 大
因此把中小放在一起得到的值更小。
由此得出结论如果遇到出栈情况，我们将小的那个(也就是栈顶元素)和它左边或右边较小的那个放在一起得到的答案是最优。
同时，小的那个元素就不再需要了，我们只看大的那个元素可能还会和别的值相乘。
最后将值放入栈后，栈内元素单调递减，于是就有了大 中 小,这个可以自己去证。会发现还是把中小放在一起最优。

作者：ripple-zjw
链接：https://leetcode-cn.com/problems/minimum-cost-tree-from-leaf-values/solution/xiang-xi-jie-shi-dong-tai-gui-hua-dan-diao-zhan-ji/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
public class Solution2 {
	class Solution {
	    public int mctFromLeafValues(int[] arr) {
	        Stack<Integer> stack = new Stack<>();
	        stack.push(Integer.MAX_VALUE);
	        int ans = 0;
	        for (int n : arr) {
	            while (stack.peek() < n) ans += stack.pop() * Math.min(stack.peek(), n);
	            stack.push(n);
	        }
	        while (stack.size() > 2) ans += stack.pop() * stack.peek();
	        return ans;
	    }
	}
	
/*	执行用时 :
		1 ms
		, 在所有 Java 提交中击败了
		97.80%
		的用户
		内存消耗 :
		37.6 MB
		, 在所有 Java 提交中击败了
		100.00%
		的用户*/

/*	作者：ripple-zjw
	链接：https://leetcode-cn.com/problems/minimum-cost-tree-from-leaf-values/solution/xiang-xi-jie-shi-dong-tai-gui-hua-dan-diao-zhan-ji/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
