package l_1091_二进制矩阵中的最短路径;

import java.util.LinkedList;
import java.util.Queue;

public class Solution1 {
	
/*	执行用时 :
		21 ms
		, 在所有 Java 提交中击败了
		64.68%
		的用户
		内存消耗 :
		41.5 MB
		, 在所有 Java 提交中击败了
		100.00%
		的用户*/
	
	class Solution {

	    private int[][] dirs = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1},
	                            {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
	    private int R, C;

	    public int shortestPathBinaryMatrix(int[][] grid) {
	        if(grid.length == 1 && grid[0].length == 1){
	            if(grid[0][0] == 0) return 1;
	            if(grid[0][0] == 1) return -1;
	        }

	        R = grid.length;
	        C = grid[0].length;
	        boolean[][] visited = new boolean[R][C];
	        int[][] dis = new int[R][C];

	        if(grid[0][0] == 1) return -1;
	        if(R == 0 && C == 0) return 1;

	        // BFS
	        Queue<Integer> queue = new LinkedList<>();
	        queue.add(0);
	        visited[0][0] = true;
	        dis[0][0] = 1;
	        while(!queue.isEmpty()){
	            int cur = queue.remove();
	            int curx = cur / C, cury = cur % C;
	            for(int d = 0; d < 8; d ++){
	                int nextx = curx + dirs[d][0];
	                int nexty = cury + dirs[d][1];
	                if(inArea(nextx, nexty) && !visited[nextx][nexty] && grid[nextx][nexty] == 0){
	                    queue.add(nextx * C + nexty);
	                    visited[nextx][nexty] = true;
	                    dis[nextx][nexty] = dis[curx][cury] + 1;

	                    if(nextx == R - 1 && nexty == C - 1)
	                        return dis[nextx][nexty];
	                }
	            }
	        }
	        return -1;
	    }

	    private boolean inArea(int x, int y){
	        return x >= 0 && x < R && y >= 0 && y < C;
	    }
	}
}
