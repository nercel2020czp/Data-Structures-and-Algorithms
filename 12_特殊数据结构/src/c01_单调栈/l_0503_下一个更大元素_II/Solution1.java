package c01_单调栈.l_0503_下一个更大元素_II;
/*

https://leetcode-cn.com/problems/next-greater-element-ii/solution/dan-diao-zhan-jie-jue-next-greater-number-yi-lei-2/
单调栈解决 Next Greater Number 一类问题
labuladong
发布于 10 个月前
5.8k
做本题的前提「下一个更大元素 I」

同样是 Next Greater Number，现在假设给你的数组是个环形的，如何处理？

给你一个数组 [2,1,2,4,3][2,1,2,4,3]，你返回数组 [4,2,4,-1,4][4,2,4,−1,4]。拥有了环形属性，最后一个元素 3 绕了一圈后找到了比自己大的元素 44。

首先，计算机的内存都是线性的，没有真正意义上的环形数组，但是我们可以模拟出环形数组的效果，一般是通过 \%% 运算符求模（余数），获得环形特效：
int[] arr = {1,2,3,4,5};
int n = arr.length, index = 0;
while (true) {
    print(arr[index % n]);
    index++;
}


回到 Next Greater Number 的问题，增加了环形属性后，问题的难点在于：这个 Next 的意义不仅仅是当前元素的右边了，有可能出现在当前元素的左边（如上例）。

明确问题，问题就已经解决了一半了。我们可以考虑这样的思路：将原始数组 “翻倍”，就是在后面再接一个原始数组，这样的话，按照之前“比身高”的流程，每个元素不仅可以比较自己右边的元素，而且也可以和左边的元素比较了。

怎么实现呢？你当然可以把这个双倍长度的数组构造出来，然后套用算法模板。但是，我们可以不用构造新数组，而是利用循环数组的技巧来模拟。

直接看代码吧：
vector<int> nextGreaterElements(vector<int>& nums) {
    int n = nums.size();
    vector<int> res(n); // 存放结果
    stack<int> s;
    // 假装这个数组长度翻倍了
    for (int i = 2 * n - 1; i >= 0; i--) {
        while (!s.empty() && s.top() <= nums[i % n])
            s.pop();
        res[i % n] = s.empty() ? -1 : s.top();
        s.push(nums[i % n]);
    }
    return res;
}

作者：labuladong
链接：https://leetcode-cn.com/problems/next-greater-element-ii/solution/dan-diao-zhan-jie-jue-next-greater-number-yi-lei-2/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
作者：labuladong
链接：https://leetcode-cn.com/problems/next-greater-element-ii/solution/dan-diao-zhan-jie-jue-next-greater-number-yi-lei-2/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
public class Solution1 {

}
