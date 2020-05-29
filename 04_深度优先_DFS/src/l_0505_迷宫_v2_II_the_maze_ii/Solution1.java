package l_0505_迷宫_v2_II_the_maze_ii;

import java.util.Arrays;

/*
 * 方法一：深度优先搜索
我们可以用搜索树的形式来展开搜索空间。如下图所示，根节点代表起始位置，每个节点有 4 个孩子，
表示 4 种不同的路线：左、右、上、下。经过某条路线到达一个新的节点，就表示在迷宫中选择某个方
向滚动直到停止。
【见图2.png】
我们可以使用深度优先搜索对整颗搜索树进行遍历。我们从起始位置开始，每次选择一条路线进行搜索，并用计数器 count 记录当前的步数。为了防止重复搜索，我们需要使用一个二维数组 distance 记录从起始位置到 (i, j) 的最小步数 distance[i, j]，若在某一次搜索到位置 (i, j) 时，distance[i, j] 的值小于等于 count，那么我们可以进行回溯，不必继续搜索下去。


复杂度分析:
	时间复杂度：O(MN\max(M,N))O(MNmax(M,N))，其中 MM 和 NN 是迷宫的高和宽。
	空间复杂度：O(MN)O(MN)。

作者：LeetCode
链接：https://leetcode-cn.com/problems/the-maze-ii/solution/mi-gong-ii-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

public class Solution1 {
	
/*	执行用时 :
		465 ms
		, 在所有 Java 提交中击败了
		25.37%
		的用户
		内存消耗 :
		41.2 MB
		, 在所有 Java 提交中击败了
		100.00%
		的用户*/
	
    public int shortestDistance(int[][] maze, int[] start, int[] dest) {
        int[][] distance = new int[maze.length][maze[0].length];
        for (int[] row: distance)
            Arrays.fill(row, Integer.MAX_VALUE);
        distance[start[0]][start[1]] = 0;
        dfs(maze, start, distance);
        return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
    }

    public void dfs(int[][] maze, int[] start, int[][] distance) {
        int[][] dirs={{0,1}, {0,-1}, {-1,0}, {1,0}};
        for (int[] dir: dirs) {
            int x = start[0] + dir[0];
            int y = start[1] + dir[1];
            int count = 0;
            while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                x += dir[0];
                y += dir[1];
                count++;
            }
            if (distance[start[0]][start[1]] + count < distance[x - dir[0]][y - dir[1]]) {
                distance[x - dir[0]][y - dir[1]] = distance[start[0]][start[1]] + count;
                dfs(maze, new int[]{x - dir[0],y - dir[1]}, distance);
            }
        }
    }
}

