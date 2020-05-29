package l_0042_接雨水;

/*
1、暴力   时间O(N^2)  空间O(1)
很明显每个柱子顶部可以储水的高度为：该柱子的左右两侧最大高度的较小者减去此柱子的高度。
因此我们只需要遍历每个柱子，累加每个柱子可以储水的高度即可。
此方法非常好理解，直接看下述👇代码中的注释即可。
 */

public class Solution1 {
	public int trap(int[] height) {
		if(height == null) return 0;
		int length = height.length;
        int res = 0;
        // 遍历每个柱子
        for (int i = 1; i < length - 1; i++) {
            int leftMax = 0, rightMax = 0;
            // 计算当前柱子左侧的柱子中的最大高度
            for (int j = 0; j <= i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }
            // 计算当前柱子右侧的柱子中的最大高度
            for (int j = i; j < length; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }
            // 结果中累加当前柱子顶部可以储水的高度，
            // 即 当前柱子左右两边最大高度的较小者 - 当前柱子的高度。
            res += Math.min(leftMax, rightMax) - height[i];
        }
        return res;
    }
}
