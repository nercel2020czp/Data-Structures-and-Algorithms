package t045_扑克牌顺子;
//排序方式【见图2.png】
/*
class Solution {
public:
    bool isStraight(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        int zero = 0;
        for (int i = 0; i < 4; i ++) {
            if (nums[i] == 0) {
                zero++;
                continue;
            } 
            if (nums[i] == nums[i+1]) {
                return false;
            }
            zero -= nums[i+1]-nums[i] - 1;
        }
        return zero >= 0;
    }
};

作者：huwt
链接：https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/solution/bu-ke-pai-zhong-de-shun-zi-pai-xu-fang-shi-he-bu-p/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Solution2 {

}
