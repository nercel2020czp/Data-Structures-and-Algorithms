package t067_剪绳子;

/*2. 记忆化搜索
	对于暴力搜索，通过图1不难得出该方法的时间复杂度为指数级别，显然不能满足题目要求。
	那么如此耗时的原因也是因为在递归的过程中计算了很多重复值。例如，图1中F(n-2)和F(n-3)
	至少重复计算了两次，并且在后面会有更多次重复运算，而这部分重复运算完全是没有必要的，
	如果我们每次求完一个F(i)，都将其保存起来，下次再求的时候直接读取保存的值就行了，
	这显然会节省大量时间。既然有这个想法，那么相应的代码应该也不难实现，我们只要用一个数组存放
	每次的F(i)，具体实现如下：


通过上述代码我们可以看出，记忆化搜索是将目标F(n)不断转化为求F(n-1),F(n-2),...,F(2),F(1)，
中将计算过的值存起来，从图1的递归树中看出来这是一个从上到下的过程，一般将之称为"自顶向下"。

作者：97wgl
链接：https://leetcode-cn.com/problems/integer-break/solution/bao-li-sou-suo-ji-yi-hua-sou-suo-dong-tai-gui-hua-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

*/
public class Solution2 {
	// 记忆化搜索-自顶向下
	int[] memory;
	public int cutRope(int n) {
	    memory = new int[n + 1];
	    return cutRopeHelper(n);
	}
	public int cutRopeHelper(int n) {
	    if (n == 2) {
	        return 1;
	    }
	    // 记忆化的核心
	    if (memory[n] != 0) {
	        // memory的初始值为0，如果它不为0，说明已经计算过了，直接返回即可
	        return memory[n];
	    }
	    int res = -1;
	    for (int i = 1; i <= n - 1; i++) {
	        res = Math.max(res, Math.max(i * cutRopeHelper(n - i), i * (n - i)));
	    }
	    memory[n] = res;
	    return res;
	}
}
