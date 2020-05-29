package l_0026_删除排序数组中的重复项;


/*
 * 
 */

public class Solution1 {
	int removeDuplicates(int[] nums) {
	    int n = nums.length;
	    if (n == 0) return 0;
	    int slow = 0, fast = 1;
	    while (fast < n) {
	        if (nums[fast] != nums[slow]) {
	            slow++;
	            // 维护 nums[0..slow] 无重复
	            nums[slow] = nums[fast];
	        }
	        fast++;
	    }
	    // 长度为索引 + 1
	    return slow + 1;
	}
}
