package t007_斐波那契数列;
/*2. 优化递归
1. 分析
递归会重复计算大量相同数据，我们用个数组把结果存起来8！

3. 复杂度：
时间复杂度：O(n)
空间复杂度：O(n)
*/
public class Solution2 {

    public int Fibonacci(int n) {
        int ans[] = new int[40];
        ans[0] = 0;
        ans[1] = 1;
        for(int i=2;i<=n;i++){
            ans[i] = ans[i-1] + ans[i-2];
        }
        return ans[n];
    }
}
