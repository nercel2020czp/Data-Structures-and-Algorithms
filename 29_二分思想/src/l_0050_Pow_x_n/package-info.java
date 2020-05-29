/**
 * 
 */
/**
 * @author 15753
 *
 */
package l_0050_Pow_x_n;
/*
https://leetcode-cn.com/problems/powx-n/

50. Pow(x, n)
实现 pow(x, n) ，即计算 x 的 n 次幂函数。

示例 1:

输入: 2.00000, 10
输出: 1024.00000
示例 2:

输入: 2.10000, 3
输出: 9.26100
示例 3:

输入: 2.00000, -2
输出: 0.25000
解释: 2-2 = 1/22 = 1/4 = 0.25
说明:

-100.0 < x < 100.0
n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。

class Solution {
    public double myPow(double x, int n) {

    }
}
----------------------【题目解析】-------------------------
📖文字题解
前言
本题的方法被称为「快速幂算法」，有递归和迭代两个版本。这篇题解会从递归版本的开始讲起，再逐步引出迭代的版本。

当指数 nn 为负数时，我们可以计算 x^{-n}x 
−n
  再取倒数得到结果，因此我们只需要考虑 nn 为自然数的情况。

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/powx-n/solution/powx-n-by-leetcode-solution/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/