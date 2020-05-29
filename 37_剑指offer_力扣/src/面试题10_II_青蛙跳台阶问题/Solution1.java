package 面试题10_II_青蛙跳台阶问题;
/*
 * 方法一：暴力
 * 复杂度分析
时间复杂度：O(2^n)
空间复杂度：O(n)。
 */
public class Solution1 {
    public int numWays(int n) {
        return climb_Stairs(0, n);
    }
    public int climb_Stairs(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
    }
}
