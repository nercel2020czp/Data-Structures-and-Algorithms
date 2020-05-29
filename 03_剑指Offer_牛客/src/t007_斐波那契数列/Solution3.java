package t007_斐波那契数列;
/*3. 优化存储
1. 分析
其实我们可以发现每次就用到了最近的两个数，所以我们可以只存储最近的两个数

sum 存储第 n 项的值
one 存储第 n-1 项的值
two 存储第 n-2 项的值


3. 复杂度：
时间复杂度：O(n)
空间复杂度：O(1)
*/
public class Solution3 {
	public int Fibonacci(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}
		int sum = 0;
		int two = 0;
		int one = 1;
		for (int i = 2; i <= n; i++) {
			sum = two + one;
			two = one;
			one = sum;
		}
		return sum;
	}
}
