package l_0011_盛最多水的容器;
/*算法

在这种情况下，我们将简单地考虑每对可能出现的线段组合并找出这些情况之下的最大面积。

*/
public class Solution1 {
    public int maxArea(int[] height) {
        int maxarea = 0;
        for (int i = 0; i < height.length; i++)
            for (int j = i + 1; j < height.length; j++)
                maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
        return maxarea;
    }
/*    执行用时 :
    	522 ms
    	, 在所有 Java 提交中击败了
    	9.34%
    	的用户
    	内存消耗 :
    	41.1 MB
    	, 在所有 Java 提交中击败了
    	5.06%
    	的用户*/
}
