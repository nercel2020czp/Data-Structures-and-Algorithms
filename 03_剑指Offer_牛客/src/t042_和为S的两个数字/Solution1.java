package t042_和为S的两个数字;
/*从第一个和最后一个元素开始算。
如果算出来的结果比目标大，那就最后一个往前移，否则就第一个目标往后移。

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {  // 双指针
        vector<int> result;
        int sum, i = 0, j = nums.size()-1;
        while(i < j){
            sum = nums[i]+nums[j];
            if(sum==target){
                result.push_back(nums[i]);
                result.push_back(nums[j]);
                break;
            }
            if(sum>target) j--;
            else i++;
        }
        
        return result;
    }
};

作者：logan-31
链接：https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/solution/cshuang-zhi-zhen-shuang-bai-jian-yi-jie-fa-by-loga/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

*/
import java.util.ArrayList;

public class Solution1 {
	public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		// 边界条件
		if (array == null || array.length <= 1) {
			return result;
		}
		int smallIndex = 0;
		int bigIndex = array.length - 1;
		while (smallIndex < bigIndex) {
			// 如果相等就放进去
			if ((array[smallIndex] + array[bigIndex]) == sum) {
				result.add(array[smallIndex]);
				result.add(array[bigIndex]);
				// 最外层的乘积最小，别被题目误导【和定积最大，当且仅当两个数相等时，积才最大】
				break;
			} else if ((array[smallIndex] + array[bigIndex]) < sum) {
				smallIndex++;
			} else {
				bigIndex--;
			}
		}
		return result;
	}
}
