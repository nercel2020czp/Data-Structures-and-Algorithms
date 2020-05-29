package l_0120_三角形最小路径和_triangle;

import java.util.List;

/*自底向上, DP 【AC】*/
public class Solution3 {
	public int minimumTotal(List<List<Integer>> triangle) {
	    int row = triangle.size();
	    int[] minlen = new int[row+1];
	    for (int level = row-1;level>=0;level--){
	        for (int i = 0;i<=level;i++){   //第i行有i+1个数字
	            minlen[i] = Math.min(minlen[i], minlen[i+1]) + triangle.get(level).get(i);
	        }
	    }
	    return minlen[0];
	}

/*	作者：crsm
	链接：https://leetcode-cn.com/problems/triangle/solution/di-gui-ji-yi-hua-sou-suo-zai-dao-dp-by-crsm/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
