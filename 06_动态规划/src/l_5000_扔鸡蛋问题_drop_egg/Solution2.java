package l_5000_扔鸡蛋问题_drop_egg;

/*
首先我们根据 dp(K, N) 数组的定义（有 K 个鸡蛋面对 N 层楼，最少需要扔几次），
很容易知道 K 固定时，这个函数一定是单调递增的，无论你策略多聪明，楼层增加测试次数一定要增加。
那么注意 dp(K - 1, i - 1) 和 dp(K, N - i) 这两个函数，其中 i 是从 1 到 N 单增的，
如果我们固定 K 和 N，把这两个函数看做关于 i 的函数，前者随着 i 的增加应该也是单调递增的，
而后者随着 i 的增加应该是单调递减的：


def superEggDrop(self, K: int, N: int) -> int:
	memo = dict()
	def dp(K, N):
		if K == 1: return N
		if N == 0: return 0
		if (K, N) in memo:
			return memo[(K, N)]
		res = float('INF')
		# 用分搜索代替线性搜索
		lo, hi = 1, N
		while lo <= hi:
			mid = (lo + hi) // 2
			broken = dp(K - 1, mid - 1) # 碎
			not_broken = dp(K, N - mid) # 没碎
		# res = min(max(碎， 没碎) + 1)
		if broken > not_broken:
			hi = mid - 1
			res = min(res, broken + 1)
		else:
			lo = mid + 1
			res = min(res, not_broken + 1)
		memo[(K, N)] = res
		return res
	return dp(K, N)


 */

public class Solution2 {

}
