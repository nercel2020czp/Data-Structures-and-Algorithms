package l_0042_接雨水;

import java.util.Stack;

/*
 * https://mp.weixin.qq.com/s/f9ebzbwymR8jQeUDxjeCDA
4、单调栈  时间O(N) 空间O(N) 
单调栈是本文想要重点说明的一个方法～
因为本题是一道典型的单调栈的应用题。
简单来说就是当前柱子如果小于等于栈顶元素，说明形不成凹槽，则将当前柱子入栈；
反之若当前柱子大于栈顶元素，说明形成了凹槽，于是将栈中小于当前柱子的元素pop出来，
将凹槽的大小累加到结果中。

关于凹槽的理解，我们可以先看一下gif图：

图1.gif

通过上图可以发现，遍历到某些柱子的时候，会由于和之前的某个柱子形成凹槽，接住雨水。

这道题目可以用单调栈来做。单调栈就是比普通的栈多一个性质，即维护栈内元素单调。
比如当前某个单调递减的栈的元素从栈底到栈顶分别是：[10, 9, 8, 3, 2]，如果要入栈元素5，
需要把栈顶元素pop出去，直到满足单调递减为止，即先变成[10, 9, 8]，再入栈5，就是[10, 9, 8, 5]。

演示：
我们为这道题演示一下[4, 3, 1, 0, 1, 2, 4]是怎么接雨水的，下图是最终的接雨水效果，蓝色部分是雨水。

图2.PNG

接下来我们开始演示，下面的图示中，最上方是每个柱子的高度。
左侧是单调栈的元素。图中有红色边框的柱子是存在于单调栈里的元素。

Step 1:  遍历到下图中箭头所指向的位置时，栈内元素是[4, 3, 1, 0]。
由于当前柱体的高度为1大于栈顶元素0，那就可以接住雨水。
接住雨水的量的高度 = 栈顶元素 和 左右两边形成的高度差的min。宽度是1。

图3.PNG

Step 2:  遍历到下图中箭头所指向的位置时，栈内元素是[4, 3, 1, 1]。
由于当前的柱体的高度为2大于栈顶元素1，那就可以接住雨水。
由于栈顶元素有相等的情况，所以可以把1全都pop出去，变成[4, 3]。
此时形成的新凹槽的高度 = 此时的栈顶元素3 和 当前高度为2的柱体的高度的min - 先前的栈顶元素1，
新凹槽的宽度 = 此时栈顶元素的位置和当前高度为2的柱体的位置的距离。
可以算出来此次接住的雨水是1 * 3。
 
图4.PNG

Step 3:  遍历到下图中箭头所指向的位置时，栈内元素是 [4, 3, 2]。
由于当前的柱体的高度为4大于栈顶元素2，把 2 pop出来，
栈顶元素3所在位置和当前高为4的柱体可以接住雨水，雨水量是 1 * 4。

图5.PNG

Step 4:  由于上步的栈顶元素3仍然小于当前的柱体高度4，因此pop出3。
新栈顶元素4所在位置和当前高为4的柱体可以接住雨水，雨水量是 1 * 5。

图6.PNG

这样每个部分的雨水量都可以算出来，加在一起就可以了。
由于每个柱体最多入栈出栈一次，所以时间复杂度 O(N)。

代码就很简单了，具体见注释～


 */

public class Solution4 {
	public int trap(int[] height) {
		Stack<Integer> stack = new Stack<>();
		int res = 0;
		// 遍历每个柱体
		for (int i = 0; i < height.length; i++) {
			while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
				int bottomIdx = stack.pop();
				// 如果栈顶元素一直相等，那么全都pop出去，只留第一个。
				while (!stack.isEmpty() && height[stack.peek()] == height[bottomIdx]) {
					stack.pop();
				}
				if (!stack.isEmpty()) {
					// stack.peek()是此次接住的雨水的左边界的位置，右边界是当前的柱体，即i。
					// Math.min(height[stack.peek()], height[i])
					// 是左右柱子高度的min，减去height[bottomIdx]就是雨水的高度。
					// i - stack.peek() - 1 是雨水的宽度。
					res += (Math.min(height[stack.peek()], height[i])
							- height[bottomIdx]) * (i - stack.peek() - 1);
				}
			}
			stack.push(i);
		}
		return res;
	}
}
