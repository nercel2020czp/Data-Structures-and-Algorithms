package l_0264_丑数II_ugly_number_ii;

import org.junit.Test;

//Java题解--动态规划+三指针
public class Solution1 {

    /**
     * 丑数求解过程：首先除2，直到不能整除为止，然后除5到不能整除为止，然后除3直到不能整除为止。
     * 最终判断剩余的数字是否为1，如果是1则为丑数，否则不是丑数
     * <p>
     * 解题思路：
     * 从1开始遍历，按丑数求解过程找出满足条件的第n个丑数（提交超时）
     * 思路优化（如何利用之前的计算）
     * 解题二：动态规划+三指针
     * dp保存按序排列的丑数，三指针分别是*2，*3，*5，找出下一个丑数
     *
     * @param n
     * @return
     */
/*	
	dp[1] = min{dp[0]*2, dp[0]*3, dp[0]*5} = min{2, 3, 5} = 2
	dp[2] = min{dp[1]*2, dp[0]*3, dp[0]*5} = min{4, 3, 5} = 3
	dp[3] = min{dp[1]*2, dp[1]*3, dp[0]*5} = min{4, 6, 5} = 4
	dp[4] = min{dp[2]*2, dp[1]*3, dp[0]*5} = min{6, 6, 5} = 5
	dp[5] = min{dp[2]*2, dp[1]*3, dp[1]*5} = min{6, 6, 10} = 6
	dp[6] = min{dp[3]*2, dp[2]*3, dp[1]*5} = min{8, 9, 10} = 8
	dp[7] = min{dp[4]*2, dp[2]*3, dp[1]*5} = min{10, 9, 10} = 9
	dp[8] = min{dp[4]*2, dp[3]*3, dp[1]*5} = min{10, 12, 10} = 10
	dp[9] = min{dp[5]*2, dp[3]*3, dp[2]*5} = min{12, 12, 15} = 12
	dp[10] = min{dp[6]*2, dp[4]*3, dp[2]*5} = min{16, 15, 15} = 15
	dp[11] = min{dp[6]*2, dp[5]*3, dp[3]*5} = min{16, 18, 20} = 16
	dp[12] = min{dp[7]*2, dp[5]*3, dp[3]*5} = min{18, 18, 20} = 18
	dp[13] = min{dp[8]*2, dp[6]*3, dp[3]*5} = min{20, 24, 20} = 20
	dp[14] = min{dp[9]*2, dp[6]*3, dp[4]*5} = min{24, 24, 25} = 24
	
	*/
	
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < n; i++) {
            int min = Math.min(dp[i2] * 2, Math.min(dp[i3] * 3, dp[i5] * 5));
            System.out.println("dp[" + i + "] = min{dp[" + i2 + "]*2, dp[" + i3 + "]*3, dp[" + i5 + "]*5} = min{" 
            +dp[i2] * 2 +", " + dp[i3] * 3 + ", " + dp[i5] * 5 + "} = " + min);
            if (min == dp[i2] * 2) i2++;
            if (min == dp[i3] * 3) i3++;
            if (min == dp[i5] * 5) i5++;
            dp[i] = min;
        }
        return dp[n - 1];
    }
    @Test
    public void test1() {
    	nthUglyNumber(15);
    }
}
