package 面试题16_数值的整数次方;

/*

写法二：非递归写法（将指数看成二进制数）
把指数 n 做“二进制分解”，在底数不断自身乘以自身的过程中，将最终结果需要的部分保存下来。
【见图1.png】

*/
public class Solution2 {

    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N *= -1;
        }

        double res = 1;
        while (N > 0) {
            if ((N & 1) == 1) {
                res *= x;
            }

            x *= x;
            N >>>= 1;
        }
        return res;
    }
/*    
    执行用时 :
    	1 ms
    	, 在所有 Java 提交中击败了
    	90.63%
    	的用户
    	内存消耗 :
    	37.7 MB
    	, 在所有 Java 提交中击败了
    	100.00%
    	的用户
    
  */  
}
