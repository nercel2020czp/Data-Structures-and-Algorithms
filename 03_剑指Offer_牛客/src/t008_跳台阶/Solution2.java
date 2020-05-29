package t008_跳台阶;
/*
方法二：斐波那契数
算法

在上述方法中，我们使用 dp 数组，其中 dp[i]=dp[i-1]+dp[i-2]。可以很容易通过分析得出 dp[i]
 其实就是第 i 个斐波那契数。

Fib(n)=Fib(n-1)+Fib(n-2)

现在我们必须找出以 1 和 2 作为第一项和第二项的斐波那契数列中的第 n 个数，也就是说 Fib(1)=1 且 Fib(2)=2。

作者：LeetCode
链接：https://leetcode-cn.com/problems/climbing-stairs/solution/pa-lou-ti-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

*/
public class Solution2 {
    public int JumpFloor(int target) {
        if (target == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= target; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}
