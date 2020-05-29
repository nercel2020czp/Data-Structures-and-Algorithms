package 面试题13_机器人的运动范围;
/*
面试题13. 机器人的运动范围（ DFS / BFS ，清晰图解）

//////////////////////////////////////////////////////
方法一：深度优先遍历 DFS
	深度优先搜索： 可以理解为暴力法模拟机器人在矩阵中的所有路径。DFS 通过递归，
	先朝一个方向搜到底，再回溯至上个节点，沿另一个方向搜索，以此类推。
	剪枝： 在搜索中，遇到数位和超出目标值、此元素已访问，则应立即返回，称之为 可行性剪枝 。

算法解析：
	递归参数： 当前元素在矩阵中的行列索引 i 和 j ，两者的数位和 si, sj 。
	
	终止条件： 当 ① 行列索引越界 或 ② 数位和超出目标值 k 或 ③ 当前元素已访
	问过 时，返回 0 ，代表不计入可达解。
	
	递推工作：
		1.标记当前单元格 ：将索引 (i, j) 存入 Set visited 中，代表此单元格已被访问过。
		2.搜索下一单元格： 计算当前元素的 下、右 两个方向元素的数位和，并开启下层递归 。
	
	回溯返回值： 返回 1 + 右方搜索的可达解总数 + 下方搜索的可达解总数，代表从本单元格递归搜索的可达解总数。

见如下链接：
	https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/solution/mian-shi-ti-13-ji-qi-ren-de-yun-dong-fan-wei-dfs-b/
	
复杂度分析：
	M,N 分别为矩阵行列大小。
	1.时间复杂度 O(MN) ： 最差情况下，机器人遍历矩阵所有单元格，此时时间复杂度为 O(MN)。
	2.空间复杂度 O(MN) ： 最差情况下，Set visited 内存储矩阵所有单元格的索引，使用 O(MN) 的额外空间。
	
代码：
	Java 代码中 visited 为辅助矩阵，Python 中为 Set 。

作者：jyd
链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/solution/mian-shi-ti-13-ji-qi-ren-de-yun-dong-fan-wei-dfs-b/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
public class Solution1 {
	class Solution {
	    int m, n, k;
	    boolean[][] visited;
	    public int movingCount(int m, int n, int k) {
			this.m = m;
			this.n = n;
			this.k = k;
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
//		递归参数： 当前元素在矩阵中的行列索引 i 和 j ，两者的数位和 si, sj 。
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
//	        回溯返回值： 返回 1 + 右方搜索的可达解总数 + 下方搜索的可达解总数，代表从本单元格递归搜索的可达解总数。
	        return 1 + 
	        		dfs(i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj) 
	        		+ dfs(i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8);
	    }
	}
/*	
	执行用时 :
		1 ms
		, 在所有 Java 提交中击败了
		98.71%
		的用户
		内存消耗 :
		35.8 MB
		, 在所有 Java 提交中击败了
		100.00%
		的用户
	*/
}
