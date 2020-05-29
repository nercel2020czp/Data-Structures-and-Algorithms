package l_1020_飞地的数量;
//java 先把所有和边界相接的陆地淹没，剩下的就是飞陆了
public class Solution1 {
/*	执行用时 :
		4 ms
		, 在所有 Java 提交中击败了
		96.15%
		的用户
		内存消耗 :
		48.9 MB
		, 在所有 Java 提交中击败了
		100.00%
		的用户*/
	
	class Solution {
	    int row, col;
	    int[][] A;
	    public int numEnclaves(int[][] A) {
	        if(A == null || A.length == 0) return 0;
	        this.A = A;
	        this.row = A.length;
	        this.col = A[0].length;

	        // 淹没所有和边界相接的陆地
	        for (int i = 0; i < row; i++) {
	            dfs(i, 0);
	            dfs(i, col - 1);
	        }
	        for (int i = 0; i < col; i++) {
	            dfs(0, i);
	            dfs(row - 1, i);
	        }
	        // 统计剩下的飞陆
	        int count = 0;
	        for (int i = 0; i < row; i++) {
	            for (int j = 0; j < col; j++) {
	                if(A[i][j] == 1) count++;
	            }
	        }
	        return count;
	    }

	    /**
	     * 把此大陆淹没，即把 1 变成 0
	     * @param r,c DFS 起点
	     */
		public void dfs(int r, int c) {
			if (A[r][c] == 0)
				return;

			A[r][c] = 0;
			if (r > 0) {
				dfs(r - 1, c);
			}
			if (c > 0) {
				dfs(r, c - 1);
			}
			if (r < row - 1) {
				dfs(r + 1, c);
			}
			if (c < col - 1) {
				dfs(r, c + 1);
			}
		}
	}

/*	作者：TheWayshower
	链接：https://leetcode-cn.com/problems/number-of-enclaves/solution/java-xian-ba-suo-you-he-bian-jie-xiang-jie-de-lu-d/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
