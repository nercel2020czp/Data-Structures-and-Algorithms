/**
 * 
 */
/**
 * @author 15753
 *
 */
package c04_第四章_高频面试题.c01_如何高效寻找素数;
/*

素数的定义看起来很简单，如果一个数如果只能被 1 和它本身整除，那么这个数就是素数。
不要觉得素数的定义简单，恐怕没多少人真的能把素数相关的算法写得高效。比如让你写这样一个函数：

你会如何写这个函数？我想大家应该会这样写：
int countPrimes(int n) {
	int count = 0;
	for (int i = 2; i < n; i++)
	if (isPrim(i)) count++;
	return count;
}
// 判断整数 n 是否是素数
boolean isPrime(int n) {
	for (int i = 2; i < n; i++)
		if (n % i == 0)
			// 有其他整除因⼦
			return false;
	return true;
}
这样写的话时间复杂度 O(n^2)，问题很大。
首先你用 isPrime 函数来辅助的思路就不够高效；
而且就算你要用 isPrime 函数，这样写算法也是存在计算冗余的。

先来简单说下如果你要判断一个数是不是素数，应该如何写算法。
只需稍微修改一下上面的 isPrim 代码中的 for 循环条件：

boolean isPrime(int n) {
    for (int i = 2; i * i <= n; i++)
        ...
}

换句话说，i 不需要遍历到 n，而只需要到 sqrt(n) 即可。为什么呢，我们举个例子，假设 n = 12。

12 = 2 × 6
12 = 3 × 4
12 = sqrt(12) × sqrt(12)
12 = 4 × 3
12 = 6 × 2

可以看到，后两个乘积就是前面两个反过来，反转临界点就在 sqrt(n)。

换句话说，如果在 [2,sqrt(n)] 这个区间之内没有发现可整除因子，
就可以直接断定 n 是素数了，因为在区间 [sqrt(n),n] 也一定不会发现可整除因子。

现在，isPrime 函数的时间复杂度降为 O(sqrt(N))，但是我们实现 countPrimes 
函数其实并不需要这个函数，以上只是希望读者明白 sqrt(n) 的含义，因为等会还会用到。

高效实现 countPrimes
高效解决这个问题的核心思路是和上面的常规思路反着来：

首先从 2 开始，我们知道 2 是一个素数，那么 2 × 2 = 4, 3 × 2 = 6, 4 × 2 = 8... 都不可能是素数了。
然后我们发现 3 也是素数，那么 3 × 2 = 6, 3 × 3 = 9, 3 × 4 = 12... 也都不可能是素数了。
看到这里，你是否有点明白这个排除法的逻辑了呢？先看我们的第一版代码：

int countPrimes(int n) {
	boolean[] isPrim = new boolean[n];
	// 将数组都初始化为 true
	Arrays.fill(isPrim, true);
	for (int i = 2; i < n; i++)
		if (isPrim[i])
			// i 的倍数不可能是素数了
			for (int j = 2 * i; j < n; j += i)
				isPrim[j] = false;
	int count = 0;
	for (int i = 2; i < n; i++)
		if (isPrim[i]) count++;
	return count;
}
*/