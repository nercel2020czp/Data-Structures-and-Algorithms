package c01_单调栈.l_0042_接雨水_trapping_rain_water;
/*

3、双指针  时间O(N) 空间O(1) 

在上述的动态规划方法中，我们用二维数组来存储每个柱子左右两侧的最大高度，
但我们递推累加每个柱子的储水高度时其实只用到了 dp[i][0]和 dp[i][1] 两个值，
因此我们递推的时候只需要用 int leftMax 和 int rightMax 两个变量就行了。
即将上述代码中的递推公式：
res += Math.min(dp[i][0], dp[i][1]) - height[i];
优化成：
res += Math.min(leftMax, rightMax) - height[i];
注意这里的 leftMax 是从左端开始递推得到的，而 rightMax 是从右端开始递推得到的。
因此遍历每个柱子，累加每个柱子的储水高度时，也需要用 left 和 right 两个指针从两端开始遍历。

 */
public class Solution3 {
	public int trap(int[] height) {
        int res = 0, leftMax = 0, rightMax = 0, left = 0, right = height.length - 1;
        while (left <= right) {
            if (leftMax <= rightMax) {
                leftMax = Math.max(leftMax, height[left]);
                res += leftMax - height[left++];
            } else {
                rightMax = Math.max(rightMax, height[right]);
                res += rightMax - height[right--];
            }
        } 
        return res;
    }
	//以上，就将空间复杂度从 O(N) 优化成了 O(1)。

}
