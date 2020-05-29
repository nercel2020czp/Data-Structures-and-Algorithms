package 面试题16_数值的整数次方;
/*解题思路:
	快速幂
	快速幂可以用位运算来实现

	n & 1:取n的二进制数最低位 , n & 1 =1 ，n为奇数，=0 为偶数 ,相当于 n % 2==0

	n >> 1:右移1位, 去掉 n 的二进制数最低位 , 相当于 n / 2

	当 n 为偶数时
	x ^ n = x ^( n / 2 ) * x ^( n / 2 )
	n >> 1 , n右移 1 位后，x 自己乘自己，因为二进制每位的差距是平方关系
	
	当 n 为奇数时
	需要再乘以多出来的一次，即 x ^ n = x * x ^( n - 1 )
	n - 1 , x 不更新，将 x 累乘到 ret

	作者：sakura-151
	链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/solution/golang-kuai-su-mi-die-dai-di-gui-by-sakura-151/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
public class Solution3 {
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
}
