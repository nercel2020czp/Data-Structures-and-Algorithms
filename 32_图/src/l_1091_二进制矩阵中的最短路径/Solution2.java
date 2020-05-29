package l_1091_二进制矩阵中的最短路径;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
/*	执行用时 :
		15 ms
		, 在所有 Java 提交中击败了
		93.96%
		的用户
		内存消耗 :
		41.6 MB
		, 在所有 Java 提交中击败了
		100.00%
		的用户*/
	
	
	class Solution {
	    private int[][] directions = {{0,1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
	    private int row, col;
	    public int shortestPathBinaryMatrix(int[][] grid) {
	        row = grid.length;
	        col = grid[0].length;
	        if(grid[0][0] == 1 || grid[row - 1][col - 1] == 1) return -1;
	        Queue<int[]> pos = new LinkedList<>();
	        grid[0][0] = 1; // 直接用grid[i][j]记录从起点到这个点的最短路径长。按照题意 起点也有长度1
	        pos.add(new int[]{0,0});
	        while(!pos.isEmpty() && grid[row - 1][col - 1] == 0){ // 求最短路径 使用BFS
	            int[] xy = pos.remove();
	            int preLength = grid[xy[0]][xy[1]]; // 当前点的路径长度
	            for(int i = 0; i < 8; i++){
	                int newX = xy[0] + directions[i][0];
	                int newY = xy[1] + directions[i][1];
	                if(inGrid(newX, newY) && grid[newX][newY] == 0){
	                    pos.add(new int[]{newX, newY});
	                    grid[newX][newY] = preLength + 1; // 下一个点的路径长度要+1
	                }
	            }
	        }
	        return grid[row - 1][col - 1] == 0 ? -1 : grid[row - 1][col - 1]; // 如果最后终点的值还是0，说明没有到达
	    }

	    private boolean inGrid(int x, int y){
	        return x >= 0 && x < row && y >= 0 && y < col;
	    }
	}

/*
	作者：ustcyyw
	链接：https://leetcode-cn.com/problems/shortest-path-in-binary-matrix/solution/1091java-bfszhi-jie-da-bai-98-xiang-jie-by-ustcyyw/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
