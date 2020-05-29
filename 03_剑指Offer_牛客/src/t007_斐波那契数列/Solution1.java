package t007_斐波那契数列;
/*1. 递归法
1. 分析
斐波那契数列的标准公式为：F(1)=1，F(2)=1, F(n)=F(n-1)+F(n-2)（n>=3，n∈N*）
根据公式可以直接写出：

3. 复杂度
时间复杂度：O(2^n)
空间复杂度：O(1)
*/
public class Solution1 {
    public int Fibonacci(int n) {
        if(n<=1){
            return n;
        }
        return Fibonacci(n-1) + Fibonacci(n-2);
    }
}
