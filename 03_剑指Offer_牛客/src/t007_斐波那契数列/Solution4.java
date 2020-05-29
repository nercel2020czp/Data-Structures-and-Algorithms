package t007_斐波那契数列;
/*4. 持续优化
1. 分析
链接：https://www.nowcoder.com/questionTerminal/c6c7742f5ba7442aada113136ddea0c3?answerType=1&f=discussion
来源：牛客网

观察上一版发现，sum 只在每次计算第 n 项的时候用一下，其实还可以利用 sum 存储第 n-1 项，例如当计算完 f(5) 时 sum 存储的是 f(5) 的值，当需要计算 f(6) 时，f(6) = f(5) + f(4)，sum 存储的 f(5)，f(4) 存储在 one 中，由 f(5)-f(3) 得到
如图：*/
public class Solution4 {

	public int Fibonacci(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}
		int sum = 1;
		int one = 0;
		for (int i = 2; i <= n; i++) {
			sum = sum + one;
			one = sum - one;
		}
		return sum;
	}
/*	3. 复杂度
	时间复杂度：O(n)
	空间复杂度：O(1)*/
}
