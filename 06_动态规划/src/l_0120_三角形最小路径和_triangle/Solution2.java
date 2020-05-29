package l_0120_三角形最小路径和_triangle;

import java.util.List;

/*改进,避免重复计算
 * 自顶向下, 记忆化搜索 【AC】
 * 
 * */
public class Solution2 {
	int row;
	Integer[][] memo;

	public int minimumTotal(List<List<Integer>> triangle) {
	    row = triangle.size();
	    memo = new Integer[row][row];
	    return helper(0,0, triangle);
	}
	private int helper(int level, int c, List<List<Integer>> triangle){
	    // System.out.println("helper: level="+ level+ " c=" + c);
	    if (memo[level][c]!=null)
	        return memo[level][c];
	    if (level==row-1){
	        return memo[level][c] = triangle.get(level).get(c);
	    }
	    int left = helper(level+1, c, triangle);
	    int right = helper(level+1, c+1, triangle);
	    return memo[level][c] = Math.min(left, right) + triangle.get(level).get(c);
	}

/*	作者：crsm
	链接：https://leetcode-cn.com/problems/triangle/solution/di-gui-ji-yi-hua-sou-suo-zai-dao-dp-by-crsm/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
