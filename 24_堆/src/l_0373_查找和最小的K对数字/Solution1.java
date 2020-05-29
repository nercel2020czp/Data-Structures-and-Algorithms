package l_0373_查找和最小的K对数字;
/*
方法一：暴力法

思路：
设数组nums1的长度为n1,数组num2的长度为n2。我们可以暴力枚举全部的n1*n2对数字，
然后对他们的和按照由小到大的顺序进行排序，然后选取前K对数来解决该问题。

算法：
暴力枚举全部n1*n2对数字，排序后取其前K对。
时间复杂度O(n1 * n2)，空间复杂度O(n1 * n2)

作者：KLEA
链接：https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums/solution/cha-zhao-he-zui-xiao-de-kdui-shu-zi-by-lenn123/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {
	class Solution {
	    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
	        int n1 = nums1.length, n2 = nums2.length;
	        List<List<Integer>> result = new ArrayList<>();
	        
	        
	        if (n1 == 0 || n2 == 0 || k == 0) return result;
	        
	        int[][] arr = new int[n1 * n2][2];
	        int idx = 0;

	        for (int i = 0; i < n1; i++) {
	        	for (int j = 0; j < n2; j++) {
	        		arr[idx][0] = nums1[i];
	        		arr[idx][1] = nums2[j];
	        		idx++;
	        	}
	        }

	        //lamda表达式要学会着用
	        Arrays.sort(arr, (o1, o2) -> (o1[0] + o1[1]) - (o2[0] + o2[1]));

	        for (int i = 0; i < Math.min(k, arr.length); i++) {
	        	List<Integer> temp = new ArrayList<>();
	        	temp.add(arr[i][0]);
	        	temp.add(arr[i][1]);
	        	result.add(temp);
	        }

	        return result;
	    }
	}
/*
	作者：KLEA
	链接：https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums/solution/cha-zhao-he-zui-xiao-de-kdui-shu-zi-by-lenn123/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
