package l_0084_柱状图中最大的矩形;

/*
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/zhu-zhuang-tu-zhong-zui-da-de-ju-xing-by-leetcode/
方法 3：分治
算法

通过观察，可以发现，最大面积矩形存在于以下几种情况：

确定了最矮柱子以后，矩形的宽尽可能往两边延伸。

在最矮柱子左边的最大面积矩形（子问题）。
在最矮柱子右边的最大面积矩形（子问题）。

举个例子：

[6, 4, 5, 2, 4, 3, 9]

这里最矮柱子高度为 2 。以 2 为高的最大子矩阵面积是 2x7=14 。
现在，我们考虑上面提到的第二种和第三种情况。
我们对高度为 2 柱子的左边和右边采用同样的过程。
在 2 的左边， 4 是最小的，形成区域为 4x3=12 。
将左边区域再继续分，矩形的面积分别为 6x1=6 和 5x1=5 。
同样的，我们可以求出右边区域的面积为 3x3=9, 4x1=4 和 9x1=9 。
因此，我们得到最大面积是 16 。具体过程可参考下图：

图4.png



作者：LeetCode
链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/zhu-zhuang-tu-zhong-zui-da-de-ju-xing-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Solution3 {
/*	确定了最矮柱子以后，矩形的宽尽可能往两边延伸。

	在最矮柱子左边的最大面积矩形（子问题）。
	在最矮柱子右边的最大面积矩形（子问题）。*/
	public int calculateArea(int[] heights, int start, int end) {
		if (start > end)
			return 0;
		int minindex = start;
		for (int i = start; i <= end; i++)
			if (heights[minindex] > heights[i])
				minindex = i;
		return Math.max(heights[minindex] * (end - start + 1),
				Math.max(calculateArea(heights, start, minindex - 1), 
						calculateArea(heights, minindex + 1, end)));
	}

	public int largestRectangleArea(int[] heights) {
		return calculateArea(heights, 0, heights.length - 1);
	}
    
/*    复杂度分析

    时间复杂度：

    平均开销：O\big(n \log n\big)O(nlogn)

    最坏情况：O(n^2)O(n 
    2
     )。如果数组中的数字是有序的，分治算法将没有任何优化效果。

    空间复杂度：O(n)O(n)。最坏情况下递归需要 O(n)O(n) 的空间。

    作者：LeetCode
    链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/zhu-zhuang-tu-zhong-zui-da-de-ju-xing-by-leetcode/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/

}
