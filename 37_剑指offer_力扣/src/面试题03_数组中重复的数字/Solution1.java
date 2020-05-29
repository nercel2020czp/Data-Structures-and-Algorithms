package 面试题03_数组中重复的数字;

import java.util.HashSet;
import java.util.Set;

/*画解算法：面试题3. 数组中重复的数字
思路 1
标签：哈希
使用 HashSet 来进行处理，因为 HashSet 本身不允许出现重复元素，
所以当添加元素失败或已经包含该数字时，则表示出现了重复元素，将其返回即可。
思路较为简单，就不给图了
时间复杂度：O(n)，空间复杂度：O(n)
*/
public class Solution1 {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for(int num: nums) {
            if(!numsSet.add(num)) {
                return num;
            }
        }
        return -1;
    }
}
