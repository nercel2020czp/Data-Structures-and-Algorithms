package l_0983_最低票价;
/*[java] 动态规划思路步骤 (从后向前迭代)
动态规划
关键图
img1.png
思路
	今天不需要出门，不用买票
	今天如果要出门，需要买几天？
		看往后几天（最多30天内）要不要出门
			30天内都没有要出行的，那只买今天就好
			有要出门的（不同决策）
				这次 和 后面几次 分开买更省
				这次 和 后面几次 一起买更省



作者：lzhlyle
链接：https://leetcode-cn.com/problems/minimum-cost-for-tickets/solution/java-dong-tai-gui-hua-si-lu-bu-zou-cong-hou-xiang-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
public class Solution1 {
	class Solution {
	    public int mincostTickets(int[] days, int[] costs) {
	        int len = days.length, maxDay = days[len - 1], minDay = days[0];
	        int[] dp = new int[maxDay + 31]; // 多扩几天，省得判断 365 的限制
	        // 只需看 maxDay -> minDay，此区间外都不需要出门，不会增加费用
	        for (int d = maxDay, i = len - 1; d >= minDay; d--) {
	            // i 表示 days 的索引
	            // 也可提前将所有 days 放入 Set，再通过 set.contains() 判断
	            if (d == days[i]) {
	                dp[d] = Math.min(dp[d + 1] + costs[0], dp[d + 7] + costs[1]);
	                dp[d] = Math.min(dp[d], dp[d + 30] + costs[2]);
	                i--; // 别忘了递减一天
	            } else dp[d] = dp[d + 1]; // 不需要出门
	        }
	        return dp[minDay]; // 从后向前遍历，返回最前的 minDay
	    }
	}

/*	作者：lzhlyle
	链接：https://leetcode-cn.com/problems/minimum-cost-for-tickets/solution/java-dong-tai-gui-hua-si-lu-bu-zou-cong-hou-xiang-/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
