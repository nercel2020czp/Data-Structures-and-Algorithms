package l_0056_合并区间;

import java.util.Arrays;

/*
 * 
 * 
2 个区间的关系有以下 6 种，但是其实可以变成上面 3 种情况（只需要假设 第一个区间的起始位置 \leq≤ 第二个区间的起始位置，
如果不满足这个假设，交换这两个区间）。这 3 种情况的合并的逻辑都很好写。

图1.png

作者：sweetiee
链接：https://leetcode-cn.com/problems/merge-intervals/solution/chi-jing-ran-yi-yan-miao-dong-by-sweetiee/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

public class Solution1 {
	class Solution {
	    public int[][] merge(int[][] intervals) {
	        // 先按照区间起始位置排序
	        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
	        // 遍历区间
	        int[][] res = new int[intervals.length][2];
	        int idx = -1;
	        for (int[] interval: intervals) {
	            // 如果结果数组是空的，或者当前区间的起始位置 > 结果数组中最后区间的终止位置，
	            // 则不合并，直接将当前区间加入结果数组。
	            if (idx == -1 || interval[0] > res[idx][1]) {
	                res[++idx] = interval;
	            } else {
	                // 反之将当前区间合并至结果数组的最后区间
	                res[idx][1] = Math.max(res[idx][1], interval[1]);
	            }
	        }
	        return Arrays.copyOf(res, idx + 1);
	    }
	}

/*	作者：sweetiee
	链接：https://leetcode-cn.com/problems/merge-intervals/solution/chi-jing-ran-yi-yan-miao-dong-by-sweetiee/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
