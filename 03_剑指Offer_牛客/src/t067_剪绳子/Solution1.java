package t067_剪绳子;

/*1. 暴力搜索
对于给定的一个整数n，穷举它的每一种分解情况，然后对所有情况，求最大值。
并且我们知道，n可以拆成如下情况：【见图1.png】

通过上图，我们很容易得到一个递归表达式：

F(n) = max {i * F(n - i)}，i = 1，2，...，n - 1

		自然，就不难得到如下代码：
*/	
public class Solution1 {
// 暴力解法
public int cutRope(int n) {
    if (n == 2) {
        return 1;
    }
    int res = -1;
    for (int i = 1; i <= n - 1; i++) {
        res = Math.max(res, Math.max(i * (n - i), i * cutRope(n - i)));
    }
    return res;
}
/*
作者：97wgl
链接：https://leetcode-cn.com/problems/integer-break/solution/bao-li-sou-suo-ji-yi-hua-sou-suo-dong-tai-gui-hua-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
