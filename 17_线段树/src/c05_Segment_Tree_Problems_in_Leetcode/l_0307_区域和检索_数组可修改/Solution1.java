package c05_Segment_Tree_Problems_in_Leetcode.l_0307_区域和检索_数组可修改;
/*执行结果：
通过
显示详情
执行用时 :
124 ms
, 在所有 Java 提交中击败了
21.11%
的用户
内存消耗 :
45.4 MB
, 在所有 Java 提交中击败了
100.00%
的用户*/
//超时
class NumArray {

    private int[] data;
    private int[] sum;
    public NumArray(int[] nums) {

        data = new int[nums.length];
        for(int i = 0 ; i < nums.length ; i ++)
            data[i] = nums[i];

        sum = new int[nums.length + 1];
        sum[0] = 0;
        for(int i = 1 ; i <= nums.length ; i ++)
            sum[i] = sum[i - 1] + nums[i - 1];
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }

    public void update(int index, int val) {
        data[index] = val;
        for(int i = index + 1 ; i < sum.length ; i ++)
            sum[i] = sum[i - 1] + data[i - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
public class Solution1 {

}
