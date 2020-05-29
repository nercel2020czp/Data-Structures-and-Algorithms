package l_0084_柱状图中最大的矩形_largest_rectangle_in_histogram;
/*
     方法 1：暴力
首先，我们可以想到，两个柱子间矩形的高由它们之间最矮的柱子决定。如下图所示：
见图1:
因此，我们可以考虑所有两两柱子之间形成的矩形面积，该矩形的高为它们之间最矮
柱子的高度，宽为它们之间的距离，这样可以找到所要求的最大面积的矩形。

 */
public class Solution1 {
   public int largestRectangleArea(int[] heights) {
       int maxarea = 0;
       for (int i = 0; i < heights.length; i++) {
           for (int j = i; j < heights.length; j++) {
               int minheight = Integer.MAX_VALUE;
               for (int k = i; k <= j; k++)
                   minheight = Math.min(minheight, heights[k]);
               maxarea = Math.max(maxarea, minheight * (j - i + 1));
           }
       }
       return maxarea;
   }
   
/*   复杂度分析

   时间复杂度：O(n^3)。我们需要使用 O(n) 的时间找到 O(n^2) 枚举出来的所有柱子对之间的最矮柱子

   空间复杂度：O(1)。 只需要常数空间的额外变量

   作者：LeetCode
   链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/zhu-zhuang-tu-zhong-zui-da-de-ju-xing-by-leetcode/
   来源：力扣（LeetCode）
   著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
   
}
