package l_0084_柱状图中最大的矩形_largest_rectangle_in_histogram;
/*方法 2：优化的暴力
 算法

我们可以基于方法 1 进行一点点修改来优化算法。我们可以用前一对柱子之间的最低高度来求出当前柱子对间的最低高度。

用数学语言来表达，minheight=min(minheight,heights(j)) ，其中， heights(j) 是第 j 个柱子的高度。

作者：LeetCode
链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/zhu-zhuang-tu-zhong-zui-da-de-ju-xing-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

 */
public class Solution2 {
   public int largestRectangleArea(int[] heights) {
       int maxarea = 0;
       for (int i = 0; i < heights.length; i++) {
           int minheight = Integer.MAX_VALUE;
           for (int j = i; j < heights.length; j++) {
               minheight = Math.min(minheight, heights[j]);
               maxarea = Math.max(maxarea, minheight * (j - i + 1));
           }
       }
       return maxarea;
   }
   
/*   复杂度分析

   时间复杂度：O(n^2)。 需要枚举所有可能的柱子对。

   空间复杂度：O(1) 。不需要额外的空间。

*/
   
}
