package l_0907_子数组的最小值之和;

import java.util.Stack;

/*方法1:单调栈
维护一个单调栈，思路如图，举例转的这个栈
维护一个tmp变量记录每一轮的res值，res的全局变量记录结果，每次弹出或是添加元素的时候，维护好tmp和res

图1.png

作者：a-fei-8
链接：https://leetcode-cn.com/problems/sum-of-subarray-minimums/solution/leetcodebi-ji-java-py-si-ke-yi-dao-ti-907-zi-shu-3/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/

public class Solution1 {
/*	执行用时 :
		23 ms
		, 在所有 Java 提交中击败了
		87.95%
		的用户
		内存消耗 :
		47.5 MB
		, 在所有 Java 提交中击败了
		100.00%
		的用户*/
	
	class Solution {
	    int MOD = 1000000007;

	    public int sumSubarrayMins(int[] A) {
	        Stack<Pair> stack = new Stack<>();
	        int res = 0, tmp = 0;
	        for (int i = 0; i < A.length; i++) {
	            int count = 1;
	            while (!stack.empty() && stack.peek().val >= A[i]) {
	                Pair pop = stack.pop();
	                count += pop.count;
	                tmp -= pop.val * pop.count;
	            }
	            stack.push(new Pair(A[i], count));
	            tmp += A[i] * count;
	            res += tmp;
	            res %= MOD;
	        }
	        return res;
	    }
	}

	class Pair {
	    public int val;
	    public int count;

	    public Pair(int val, int count) {
	        this.val = val;
	        this.count = count;
	    }
	}


/*	作者：a-fei-8
	链接：https://leetcode-cn.com/problems/sum-of-subarray-minimums/solution/leetcodebi-ji-java-py-si-ke-yi-dao-ti-907-zi-shu-3/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
