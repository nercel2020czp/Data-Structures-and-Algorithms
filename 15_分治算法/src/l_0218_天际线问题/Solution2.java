package l_0218_天际线问题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 方法：分治
想法

这个题是一道经典的分治算法题，通常如同归并排序一样。

我们依据下面的算法流程来求解分治问题：

定义基本问题。

将问题分解为子问题，并递归地分别求解。

将子问题合并成原问题的解。

算法

求解 n 栋楼的天际线：

如果 n == 0：返回一个空列表

如果 n == 1：返回一栋楼的天际线

leftSkyline = 求解前 n/2 栋楼的天际线。

rightSkyline = 求解后 n/2 栋楼的天际线。

合并 leftSkyline 和 rightSkyline.

现在，让我们进一步讨论每一个步骤的细节：

基本问题

最基本的情况就是建筑物列表为空，此时天际线也是一个空列表。

第二种基本情况就是列表中只有一栋楼，天际线是很显然的。

图2.PNG

如何拆分问题

与归并排序的想法类似：在每一步将列表恰好拆分成两个部分：从 0 到 n/2 和 n/2 到 n ，对每一部分分别求解天际线。

图3.PNG

如何合并两部分的天际线

合并的过程十分直接明了，基于相同的归并排序的逻辑：结果天际线的高度永远是左天际线和右天际线的较大值。

图4.PNG

我们这里用两个指针 pR 和 pL 分别记录两个天际线的当前元素，
再用三个整数变量 leftY，rightY 和 currY 分别记录 左 天际线、 右 天际线和 合并 天际线的当前高度。



作者：LeetCode
链接：https://leetcode-cn.com/problems/the-skyline-problem/solution/tian-ji-xian-wen-ti-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

作者：LeetCode
链接：https://leetcode-cn.com/problems/the-skyline-problem/solution/tian-ji-xian-wen-ti-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

/*
 *执行用时 :
16 ms
, 在所有 Java 提交中击败了
86.11%
的用户
内存消耗 :
42 MB
, 在所有 Java 提交中击败了
50.00%
的用户
 */

public class Solution2 {
	class Solution {
		/**
		 * Divide-and-conquer algorithm to solve skyline problem, which is similar with
		 * the merge sort algorithm.
		 */
		public List<List<Integer>> getSkyline(int[][] buildings) {
			int n = buildings.length;
			List<List<Integer>> output = new ArrayList<List<Integer>>();

			// The base cases
			if (n == 0)
				return output;
			if (n == 1) {
				int xStart = buildings[0][0];
				int xEnd = buildings[0][1];
				int y = buildings[0][2];

				output.add(new ArrayList<Integer>() {
					{
						add(xStart);
						add(y);
					}
				});
				output.add(new ArrayList<Integer>() {
					{
						add(xEnd);
						add(0);
					}
				});
				// output.add(new int[]{xStart, y});
				// output.add(new int[]{xEnd, 0});
				return output;
			}

			// If there is more than one building,
			// recursively divide the input into two subproblems.
			List<List<Integer>> leftSkyline, rightSkyline;
			leftSkyline = getSkyline(Arrays.copyOfRange(buildings, 0, n / 2));
			rightSkyline = getSkyline(Arrays.copyOfRange(buildings, n / 2, n));

			// Merge the results of subproblem together.
			return mergeSkylines(leftSkyline, rightSkyline);
		}

		/**
		 * Merge two skylines together.
		 */
		public List<List<Integer>> mergeSkylines(List<List<Integer>> left, List<List<Integer>> right) {
			int nL = left.size(), nR = right.size();
			int pL = 0, pR = 0;
			int currY = 0, leftY = 0, rightY = 0;
			int x, maxY;
			List<List<Integer>> output = new ArrayList<List<Integer>>();

			// while we're in the region where both skylines are present
			while ((pL < nL) && (pR < nR)) {
				List<Integer> pointL = left.get(pL);
				List<Integer> pointR = right.get(pR);
				// pick up the smallest x
				if (pointL.get(0) < pointR.get(0)) {
					x = pointL.get(0);
					leftY = pointL.get(1);
					pL++;
				} else {
					x = pointR.get(0);
					rightY = pointR.get(1);
					pR++;
				}
				// max height (i.e. y) between both skylines
				maxY = Math.max(leftY, rightY);
				// update output if there is a skyline change
				if (currY != maxY) {
					updateOutput(output, x, maxY);
					currY = maxY;
				}
			}

			// there is only left skyline
			appendSkyline(output, left, pL, nL, currY);

			// there is only right skyline
			appendSkyline(output, right, pR, nR, currY);

			return output;
		}

		/**
		 * Update the final output with the new element.
		 */
		public void updateOutput(List<List<Integer>> output, int x, int y) {
			// if skyline change is not vertical -
			// add the new point
			if (output.isEmpty() || output.get(output.size() - 1).get(0) != x)
				output.add(new ArrayList<Integer>() {
					{
						add(x);
						add(y);
					}
				});
			// if skyline change is vertical -
			// update the last point
			else {
				output.get(output.size() - 1).set(1, y);
			}
		}

		/**
		 * Append the rest of the skyline elements with indice (p, n) to the final
		 * output.
		 */
		public void appendSkyline(List<List<Integer>> output, List<List<Integer>> skyline, int p, int n, int currY) {
			while (p < n) {
				List<Integer> point = skyline.get(p);
				int x = point.get(0);
				int y = point.get(1);
				p++;

				// update output
				// if there is a skyline change
				if (currY != y) {
					updateOutput(output, x, y);
					currY = y;
				}
			}
		}
	}

}
