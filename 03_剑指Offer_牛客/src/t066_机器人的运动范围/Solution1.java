package t066_机器人的运动范围;

public class Solution1 {
    int m, n, k;
    boolean[][] visited;
    public int movingCount(int rows, int cols, int threshold) {
		this.m = rows;
		this.n = cols;
		this.k = threshold;
		this.visited = new boolean[m][n];
		return dfs(0, 0, 0, 0);
    }

    /*
     * @Description
     * @author BruceChen
     * @date 2020年2月27日下午12:13:09
     * @param i
     * @param j
     * @param si
     * @param sj
     * @return
     */
//	递归参数： 当前元素在矩阵中的行列索引 i 和 j ，两者的数位和 si, sj 。
    public int dfs(int i, int j, int si, int sj) {
/*	    	终止条件： 当 
					① 行列索引越界 或 
					② 数位和超出目标值 k 或
					③ 当前元素已访问过 时，
					返回 0 ，代表不计入可达解。*/
        if(i < 0 || i >= m || j < 0 || j >= n 
        		|| k < si + sj || visited[i][j]) 
        	return 0;
/*	    	递推工作：
				1.标记当前单元格 ：将索引 (i, j) 存入 Set visited 中，代表此单元格已被访问过。
				2.搜索下一单元格： 计算当前元素的 下、右 两个方向元素的数位和，并开启下层递归 。
 			*/
        visited[i][j] = true;
//        回溯返回值： 返回 1 + 右方搜索的可达解总数 + 下方搜索的可达解总数，代表从本单元格递归搜索的可达解总数。
        return 1 + 
        		dfs(i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj) 
        		+ dfs(i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8);
    }
}
