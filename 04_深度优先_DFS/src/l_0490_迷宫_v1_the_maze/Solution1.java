package l_0490_迷宫_v1_the_maze;

/*
方法一：深度优先搜索

我们可以用搜索树的形式来展开搜索空间。如下图所示，根节点代表起始位置，每个节点有 4 个孩子，
表示 4 种不同的路线：左、右、上、下。经过某条路线到达一个新的节点，就表示在迷宫中选择某个方
向滚动直到停止。
【见图3.png】

我们可以使用深度优先搜索对整颗搜索树进行遍历。我们从起始位置开始，每次选择一条路线进行搜索，
并用一个二维布尔数组 visited 表示是否曾经到达过位置 (i, j) ，若在某一次搜索到位置 (i, j) 
时，visited[i, j] = true，那么我们可以进行回溯，不必继续搜索下去。



作者：LeetCode
链接：https://leetcode-cn.com/problems/the-maze/solution/mi-gong-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

复杂度分析

时间复杂度：O(MN)O(MN)，其中 MM 和 NN 是迷宫的高和宽。

空间复杂度：O(MN)O(MN)。

 */

public class Solution1 {
/*	执行用时 :
		2 ms
		, 在所有 Java 提交中击败了
		95.49%
		的用户
		内存消耗 :
		40.1 MB
		, 在所有 Java 提交中击败了
		100.00%
		的用户*/
	
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return dfs(maze, start, destination, visited);
    }
    public boolean dfs(int[][] maze, int[] start, int[] destination, boolean[][] visited) {
        if (visited[start[0]][start[1]])
            return false;
        if (start[0] == destination[0] && start[1] == destination[1])
            return true;
        visited[start[0]][start[1]] = true;
        int r = start[1] + 1, l = start[1] - 1, u = start[0] - 1, d = start[0] + 1;
        while (r < maze[0].length && maze[start[0]][r] == 0) // right
            r++;
        if (dfs(maze, new int[] {start[0], r - 1}, destination, visited))
            return true;
        while (l >= 0 && maze[start[0]][l] == 0) //left
            l--;
        if (dfs(maze, new int[] {start[0], l + 1}, destination, visited))
            return true;
        while (u >= 0 && maze[u][start[1]] == 0) //up
            u--;
        if (dfs(maze, new int[] {u + 1, start[1]}, destination, visited))
            return true;
        while (d < maze.length && maze[d][start[1]] == 0) //down
            d++;
        if (dfs(maze, new int[] {d - 1, start[1]}, destination, visited))
            return true;
        return false;
    }
    
}

/*作者：LeetCode
链接：https://leetcode-cn.com/problems/the-maze/solution/mi-gong-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
