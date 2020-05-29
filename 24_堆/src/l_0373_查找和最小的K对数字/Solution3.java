package l_0373_查找和最小的K对数字;

import java.util.ArrayList;
import java.util.List;

public class Solution3 {
	class Solution {
	    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
	    	
	    	
	        int n1 = nums1.length, n2 = nums2.length;
	        List<List<Integer>> result = new ArrayList<>();
	        
	        if(nums1.length == 0 || nums2.length == 0) return result;
	        
	        int p1 = 0, p2 = 0;
			while (k > 0) {
				List<Integer> temp = new ArrayList<>();
				temp.add(nums1[p1]);
				temp.add(nums2[p2]);
				result.add(temp);
				if(p1+1 < n1 && p2+1 < n2) {
					if (nums1[p1 + 1] + nums2[p2] < nums1[p1] + nums2[p2 + 1]) {
						p1++;
					}else {
						p2++;
					}
				}
				k--;
			}

	        return result;
	    }
	}
}
