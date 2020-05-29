package l_0218_天际线问题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

/*扫描线法

使用扫描线，从左至右扫过。
如果遇到左端点，将高度入堆，如果遇到右端点，则将高度从堆中删除。
使用 last 变量记录上一个转折点。

可以参考下面的图，扫描线下方的方格就是堆。
图1.gif
作者：ivan_allen
链接：https://leetcode-cn.com/problems/the-skyline-problem/solution/218tian-ji-xian-wen-ti-sao-miao-xian-fa-by-ivan_al/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/

public class Solution1 {
	public List<List<Integer>> getSkyline(int[][] buildings) {
		// x轴从小到大排序，如果x相等，则按照高度从低到高排序
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
		for (int[] building : buildings) {
			// 左端点和高度入队，高度为负值说明是左端点
			pq.offer(new int[] { building[0], -building[2] });
			// 右端点和高度入队
			pq.offer(new int[] { building[1], building[2] });
		}

		List<List<Integer>> res = new ArrayList<>();

		// 降序排列
		TreeMap<Integer, Integer> heights = new TreeMap<>((a, b) -> b - a);
		heights.put(0, 1);
		int left = 0, height = 0;

		while (!pq.isEmpty()) {
			int[] arr = pq.poll();
			// 如果是左端点
			if (arr[1] < 0) {
				// 高度 --> 高度 + 1
				heights.put(-arr[1], heights.getOrDefault(-arr[1], 0) + 1);
			}
			// 右端点
			else {
				// 高度 --> 高度 - 1
				heights.put(arr[1], heights.get(arr[1]) - 1);
				// 说明左右端点都已经遍历完
				if (heights.get(arr[1]) == 0)
					heights.remove(arr[1]);
			}
			// heights是以降序的方式排列的，所以以下会获得最大高度
			int maxHeight = heights.keySet().iterator().next();
			// 如果最大高度不变，则说明当前建筑高度在一个比它高的建筑下面，不做操作
			if (maxHeight != height) {
				left = arr[0];
				height = maxHeight;
				res.add(Arrays.asList(left, height));
			}
		}
		return res;
	}

/*	执行用时 :
		40 ms
		, 在所有 Java 提交中击败了
		41.68%
		的用户
		内存消耗 :
		44.2 MB
		, 在所有 Java 提交中击败了
		50.00%
		的用户*/
}
