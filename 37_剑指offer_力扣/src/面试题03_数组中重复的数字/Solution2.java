package 面试题03_数组中重复的数字;

import java.util.Arrays;

import org.junit.Test;

/*
思路 2【原地置换，时间空间100%】
标签：哈希

从题目描述中我们可以看出，因为所有数字都在 0 ～ n-1 的范围内，
其实完全可以省掉额外的空间开辟，将每个位置的数交换映射到其对应的数组下标下面，
当出现新的元素与其对应的下标中的数字相等时，即为重复数字

这本质还是哈希的思想，思路 1 是使用库函数申请额外空间，思路 2 则是数组本身做哈希表，
达到了节省空间的目的

此处会用到 while 循环，原因是保证交换过来的新元素位置也要正确

时间复杂度：O(n)，空间复杂度：O(1)

作者：guanpengchn
链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/solution/hua-jie-suan-fa-mian-shi-ti-3-shu-zu-zhong-zhong-f/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

*/
public class Solution2 {
    public int findRepeatNumber(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
                System.out.println(Arrays.toString(nums));
            }
        }
        return -1;
    }
    
    @Test
    public void test1() {
    	int[] nums = new int[] {2, 3, 1, 0, 2, 5, 3};
    	findRepeatNumber(nums);
    }
    
/*    
    ------------------------------
    i         0  1  2  3  4  5  6
    nums[i]  [2, 3, 1, 0, 2, 5, 3]
    nums[i]  [1, 3, 2, 0, 2, 5, 3]
    nums[i]  [3, 1, 2, 0, 2, 5, 3]
    nums[i]  [0, 1, 2, 3, 2, 5, 3]
    
    */
    
/*    执行用时 :
    	0 ms
    	, 在所有 Java 提交中击败了
    	100.00%
    	的用户
    	内存消耗 :
    	50 MB
    	, 在所有 Java 提交中击败了
    	100.00%
    	的用户*/
    
}
