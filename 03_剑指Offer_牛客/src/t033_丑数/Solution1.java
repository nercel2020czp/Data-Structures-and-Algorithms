package t033_丑数;

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
	
	
	链接：https://www.nowcoder.com/questionTerminal/6aa9e04fc3794f68acf8778237ba065b?answerType=1&f=discussion
来源：牛客网

这道题目自己是有思路的，丑数能够分解成2^x3^y5^z,
所以只需要把得到的丑数不断地乘以2、3、5之后并放入他们应该放置的位置即可，
而此题的难点就在于如何有序的放在合适的位置。
1乘以 （2、3、5）=2、3、5；2乘以（2、3、5）=4、6、10；3乘以（2、3、5）=6,9,15；5乘以（2、3、5）=10、15、25；
从这里我们可以看到如果不加策略地添加丑数是会有重复并且无序，
而在2x，3y，5z中，如果x=y=z那么最小丑数一定是乘以2的，但关键是有可能存在x》y》z的情况，所以我们要维持三个指针来记录当前乘以2、
乘以3、乘以5的最小值，然后当其被选为新的最小值后，要把相应的指针+1；因为这个指针会逐渐遍历整个数组，因此最终数组中的每一个值都会
被乘以2、乘以3、乘以5，也就是实现了我们最开始的想法，只不过不是同时成乘以2、3、5，而是在需要的时候乘以2、3、5.
	
	*/
	
  public int GetUglyNumber_Solution(int index) {
	  if(index <= 0) return 0;//这种判断条件是一定要注意的
      int[] dp = new int[index];
      dp[0] = 1;
      int i2 = 0, i3 = 0, i5 = 0;
      for (int i = 1; i < index; i++) {
          int min = Math.min(dp[i2] * 2, Math.min(dp[i3] * 3, dp[i5] * 5));
//          System.out.println("dp[" + i + "] = min{dp[" + i2 + "]*2, dp[" + i3 + "]*3, dp[" + i5 + "]*5} = min{" 
//          +dp[i2] * 2 +", " + dp[i3] * 3 + ", " + dp[i5] * 5 + "} = " + min);
          if (min == dp[i2] * 2) i2++;
          if (min == dp[i3] * 3) i3++;
          if (min == dp[i5] * 5) i5++;
          dp[i] = min;
      }
      return dp[index - 1];
  }
  @Test
  public void test1() {
	  GetUglyNumber_Solution(15);
  }
}
