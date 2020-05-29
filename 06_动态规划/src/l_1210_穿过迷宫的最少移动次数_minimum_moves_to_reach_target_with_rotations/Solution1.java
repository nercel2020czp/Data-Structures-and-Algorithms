package l_1210_穿过迷宫的最少移动次数_minimum_moves_to_reach_target_with_rotations;

/*
 * 动态规划，详细注释解答，便于理解

分析：
这是一道较难的动态规划困难题，代码量非常的多。
首先先找状态，状态有三个，分别是当蛇的尾巴在哪个点上的时候蛇是处于水平还是垂直。
所以有dp数组为i, j, k。i代表尾巴的横坐标，j代表尾巴的纵坐标，k代表蛇是水平还是垂直状态。
然后是选择，选择就是可以向右移一格或向下移一格或水平边垂直以及垂直边水平。
每一种选择进行后答案就会+1，所以状态选择方程就是将当前状态进行每一次选择，看看当前状态次数+1之后是否比那种状态下的次数小，小就更新那种状态。
思路并非是自己想出来的，借鉴了别人的思路。

作者：ripple-zjw
链接：https://leetcode-cn.com/problems/minimum-moves-to-reach-target-with-rotations/solution/dong-tai-gui-hua-xiang-xi-zhu-shi-jie-da-bian-yu-l/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

代码：


 */

class Solution1 {
	public int minimumMoves(int[][] grid) {
		int n = grid.length;
		int[][][] dp = new int[n][n][2]; // 放上三种状态，尾巴的横纵坐标和垂直或水平,0表示水平,1表示垂直。
		int[] dx = { 0, 1 }, dy = { 1, 0 }; // 如果让蛇向右移动一格，那么蛇整个身体x轴不变，y轴+1，同理向下也一样。
		dp[0][0][0] = 1;
		// base case是1，为什么是一呢，因为java开辟数组时默认会把所有数组归为0，本来应该是0，但是为了方便先让他比答案多1，最后返回时再-1就行了
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// Rotate
				for (int k = 0; k < 2; k++) {
					if (dp[i][j][k] == 0)
						continue; // 等于0说明当前位置不可达，不用计算。
					if (i + 1 >= n || j + 1 >= n)
						continue; // 如果i+1或j+1超出边界，说明它不可能做翻转操作，因为另一种状态以及越界了。
					if (k == 0) { // 水平位置判断下面以及右下位置是否有障碍，没有才能更新
						if (grid[i + 1][j] != 1 && grid[i + 1][j + 1] != 1)
							// 如果要更新的状态本来里面存的次数要少，那就不用更新了。
							if (dp[i][j][1 - k] == 0 || dp[i][j][1 - k] > dp[i][j][k] + 1)
								dp[i][j][1 - k] = dp[i][j][k] + 1;
					} else { // 垂直位置判断右边以及右下位置
						if (grid[i][j + 1] != 1 && grid[i + 1][j + 1] != 1)
							if (dp[i][j][1 - k] == 0 || dp[i][j][1 - k] > dp[i][j][k] + 1)
								dp[i][j][1 - k] = dp[i][j][k] + 1;
					}
				}

				// move
				for (int k = 0; k < 2; k++) {
					if (dp[i][j][k] == 0)
						continue; // 同理当前位置不可达，结束
					int[] nx = new int[2], ny = new int[2]; // nx,ny表示蛇身体的位置，前一个是尾巴，后一个是头
					for (int w = 0; w < 2; w++) { // w循环表示蛇向右移动和向下移动
						boolean flag = true; // 用于判断蛇是否能到达，就是有没有障碍物
						nx[0] = i;
						nx[1] = i + dx[k]; // 计算蛇的身体位置。
						ny[0] = j;
						ny[1] = j + dy[k];
						for (int mv = 0; mv < 2; mv++) { // mv循环表示移动蛇的尾巴和头，先移尾巴后头。
							nx[mv] += dx[w];
							ny[mv] += dy[w]; // 计算移动后的位置。
							if (nx[mv] < 0 || nx[mv] >= n || ny[mv] < 0 || ny[mv] >= n)
								flag = false;
							// 如果移动后身体的某个位置超出数组，说明不可达。
							else if (grid[nx[mv]][ny[mv]] == 1)
								flag = false; // 同样有障碍也不可达。
						}
						if (flag == false)
							continue; // 不可达就不能更新。
						if (dp[nx[0]][ny[0]][k] == 0 || dp[nx[0]][ny[0]][k] > dp[i][j][k] + 1)
							dp[nx[0]][ny[0]][k] = dp[i][j][k] + 1;
					}
				}
			}
		}
		return dp[n - 1][n - 2][0] - 1; // 蛇最后结束的位置就是尾巴在(n-1, n-2)上处于水平状态。然后别忘了之前的-1。
	}
}
