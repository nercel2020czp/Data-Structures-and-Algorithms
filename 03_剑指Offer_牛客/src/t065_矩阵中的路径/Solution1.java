package t065_矩阵中的路径;
//【参考】/剑指offer_力扣/src/面试题12_矩阵中的路径/Solution1.java
/*说明：
1、偏移量数组在二维平面内是经常使用的，可以把它的设置当做一个技巧，
	并且在这个问题中，偏移量数组内的 4 个偏移的顺序无关紧要；
	说明：类似使用这个技巧的问题还有：
	「力扣」第 130 题：被围绕的区域、https://leetcode-cn.com/problems/surrounded-regions/
	「力扣」第 200 题：岛屿数量。https://leetcode-cn.com/problems/number-of-islands/

2、对于这种搜索算法，我认为理解 DFS 和状态重置并不难，代码编写也相对固定，难在代码的编写和细节的处理，
      建议多次编写，自己多总结多思考，把自己遇到的坑记下。

作者：liweiwei1419
链接：https://leetcode-cn.com/problems/word-search/solution/zai-er-wei-ping-mian-shang-shi-yong-hui-su-fa-pyth/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
public class Solution1 {

	private boolean[] visited;
	// 左上右下
	private int[][] d = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	int m, n;

	public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		m = rows;
		n = cols;
		visited = new boolean[matrix.length];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (dfs(matrix, rows, cols, str, 0, i, j)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean dfs(char[] matrix, int rows, int cols, char[] str, int index, int startx, int starty) {
		if (index == str.length - 1) {
			return matrix[startx * cols + starty] == str[index];
		}
		if (matrix[startx * cols + starty] == str[index]) {
			visited[startx * cols + starty] = true;
			// 四个方向寻找
			for (int i = 0; i < 4; i++) {
				int newx = startx + d[i][0];
				int newy = starty + d[i][1];
				if (inArea(newx, newy) && !visited[newx * cols + newy]) {
					if (dfs(matrix, rows, cols, str, index + 1, newx, newy)) {
						return true;
					}
				}
			}
			visited[startx * cols + starty] = false;
		}
		return false;
	}

	private boolean inArea(int x, int y) {
		return x >= 0 && x < m && y >= 0 && y < n;
	}
}
