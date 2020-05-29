package 面试题16_数值的整数次方;
/*
写法一：递归写法（分治思想）

*/
public class Solution1 {

    public double myPow(double x, int n) {
        // 特判，也可以认为是递归终止条件
        long N = n;
        if (N < 0) return 1 / myPow(x, -N);
        return myPow(x, N);
    }

    private double myPow(double x, long n) {
        if (n == 0) return 1;

        if (x == 1) return 1;

        // 根据指数是奇数还是偶数进行分类讨论
        // 使用位运算的 与 运算符代替了求余数运算

        if ((n & 1) == 0) {
            // 分治思想：分
            double square = myPow(x, n >>> 1);
            // 分治思想：合，下面同理
            return square * square;
        } else {
            // 是奇数的时候
            double square = myPow(x, (n - 1) >>> 1);
            return square * square * x;
        }
    }
 /*   
    执行用时 :
    	1 ms
    	, 在所有 Java 提交中击败了
    	90.63%
    	的用户
    	内存消耗 :
    	37.4 MB
    	, 在所有 Java 提交中击败了
    	100.00%
    	的用户
    
 */   
}

