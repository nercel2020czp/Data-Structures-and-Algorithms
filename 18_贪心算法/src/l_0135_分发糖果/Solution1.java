package l_0135_分发糖果;

import java.util.Arrays;

/*
 * 
 * 
 * 解题思路：
	规则定义： 设学生 AA 和学生 BB 左右相邻，AA 在 BB 左边；
		左规则： 当 ratings_B>ratings_A ,BB 的糖比 AA 的糖数量多。
		右规则： 当 ratings_A>ratings_B ，AA 的糖比 BB 的糖数量多。
	相邻的学生中，评分高的学生必须获得更多的糖果 等价于 所有学生满足左规则且满足右规则。
	
	算法流程：
		1.先从左至右遍历学生成绩 ratings，按照以下规则给糖，并记录在 left 中：
			1.1先给所有学生 11 颗糖；
			1.2若 ratings_i>ratings_{i-1},则第 ii 名学生糖比第 i - 1i−1 名学生多 11 个。
			1.3若 ratings_i<=ratings_{i-1}，则第 ii 名学生糖数量不变。（交由从右向左遍历时处理。）
			经过此规则分配后，可以保证所有学生糖数量 满足左规则 。
		2.同理，在此规则下从右至左遍历学生成绩并记录在 right 中，可以保证所有学生糖数量 满足右规则 。
		3.最终，取以上 22 轮遍历 left 和 right 对应学生糖果数的 最大值 ，这样则 同时满足左规则和右规则 ，
		    即得到每个同学的最少糖果数量。
		    
    复杂度分析：

时间复杂度 O(N)O(N) ： 遍历两遍数组即可得到结果；
空间复杂度 O(N)O(N) ： 需要借用left，right的线性额外空间。
 */
public class Solution1 {
/*	执行用时 :
		4 ms
		, 在所有 Java 提交中击败了
		55.67%
		的用户
		内存消耗 :
		40.6 MB
		, 在所有 Java 提交中击败了
		16.67%
		的用户*/
	class Solution {
		public int candy(int[] ratings) {
			int[] left = new int[ratings.length];
			int[] right = new int[ratings.length];
			Arrays.fill(left, 1);
			Arrays.fill(right, 1);
			for (int i = 1; i < ratings.length; i++)
				if (ratings[i] > ratings[i - 1])
					left[i] = left[i - 1] + 1;
			int count = left[ratings.length - 1];
			for (int i = ratings.length - 2; i >= 0; i--) {
				if (ratings[i] > ratings[i + 1])
					right[i] = right[i + 1] + 1;
				count += Math.max(left[i], right[i]);
			}
			return count;
		}
	}

/*	作者：jyd
	链接：https://leetcode-cn.com/problems/candy/solution/candy-cong-zuo-zhi-you-cong-you-zhi-zuo-qu-zui-da-/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
