package t047_求1_plus_2_plus_3_plus__plus_n;
/*&& 的短路特性
A && B
A 为 true，则返回表达式 B 的 bool 值
A 为 false，则返回 false


解题思路
1.循环，但是不能使用for、while，所以循环不行
2.等差数列前n项和公式，但是不能使用乘除，所以不行
3.递归，但是不能使用if判断，没有递归结束条件，所以使用 && 的短路原则作为递归的结束条件

作者：code_l
链接：https://leetcode-cn.com/problems/qiu-12n-lcof/solution/li-yong-duan-lu-yuan-ze-by-code_l/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

*/
public class Solution1 {
    public int sumNums(int n) {
        int result = 0;
        boolean b = n > 0 && (result = n + sumNums(n-1)) > 0;
        return result;
    }
}
