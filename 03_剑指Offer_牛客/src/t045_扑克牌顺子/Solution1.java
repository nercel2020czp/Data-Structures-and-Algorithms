package t045_扑克牌顺子;
//不排序方式：【见图1.png】
/*
class Solution {
public:
    bool isStraight(vector<int>& nums) {
        bool m[15];
        memset(m, 0, sizeof(m));
        int minValue = 14, maxValue = 0;
        for (int item : nums) {
            if (item == 0) {
                continue;
            }
            if (m[item]) {
                return false;
            }
            m[item] = true;
            minValue = min(minValue, item);
            maxValue = max(maxValue, item);            
        }
        return maxValue - minValue + 1 <= 5;
    }
};

作者：huwt
链接：https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/solution/bu-ke-pai-zhong-de-shun-zi-pai-xu-fang-shi-he-bu-p/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Solution1 {

}
