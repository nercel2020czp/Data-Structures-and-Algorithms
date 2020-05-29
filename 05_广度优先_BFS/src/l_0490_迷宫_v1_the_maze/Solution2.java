package l_0490_迷宫_v1_the_maze;

import java.util.LinkedList;
import java.util.Queue;

/*
方法二：广度优先搜索

我们同样可以使用广度优先搜索，实现细节与深度优先搜索类似，同样会使用一个二维布尔数组 visited，
若 visited[i, j] = true，则表示曾经到达过位置 (i, j)。

作者：LeetCode
链接：https://leetcode-cn.com/problems/the-maze/solution/mi-gong-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

复杂度分析
时间复杂度：O(MN)O(MN)，其中 MM 和 NN 是迷宫的高和宽。
空间复杂度：O(MN)O(MN)。

 */

public class Solution2 {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int[][] dirs={{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        Queue < int[] > queue = new LinkedList < > ();
        queue.add(start);
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int[] s = queue.remove();
            if (s[0] == destination[0] && s[1] == destination[1])
                return true;
            for (int[] dir: dirs) {
                int x = s[0] + dir[0];
                int y = s[1] + dir[1];
                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                }
                if (!visited[x - dir[0]][y - dir[1]]) {
                    queue.add(new int[] {x - dir[0], y - dir[1]});
                    visited[x - dir[0]][y - dir[1]] = true;
                }
            }
        }
        return false;
    }
}

/*作者：LeetCode
链接：https://leetcode-cn.com/problems/the-maze/solution/mi-gong-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
