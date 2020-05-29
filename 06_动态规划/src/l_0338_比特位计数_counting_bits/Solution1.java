package l_0338_比特位计数_counting_bits;
/*
思路
对于所有的数字，只有两类：
	1.奇数：二进制表示中，奇数一定比前面那个偶数多一个 1，因为多的就是最低位的 1。
		举例： 
		0 = 0       1 = 1
		2 = 10      3 = 11
	2.偶数：二进制表示中，偶数中 1 的个数一定和除以 2 之后的那个数一样多。因为最低位是 0，
	    除以 2 就是右移一位，也就是把那个 0 抹掉而已，所以 1 的个数是不变的。
	         举例：
        2 = 10       4 = 100       8 = 1000
        3 = 11       6 = 110       12 = 1100

另外，0 的 1 个数为 0，于是就可以根据奇偶性开始遍历计算了。

 	作者：duadua
	链接：https://leetcode-cn.com/problems/counting-bits/solution/hen-qing-xi-de-si-lu-by-duadua/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

*/	
public class Solution1 {
	  public int[] countBits(int num) {
		  int[] ans = new int[num + 1];
		  ans[0] = 0;
		  for (int i = 1; i <= num; ++i) {
//				  奇偶性判断建议用i&1的结果来进行判断
			  if((i & 1) == 1) {
				  ans[i] = ans[i-1] + 1;
			  }else {
				  ans[i] = ans[i >> 1];
			  }
		  }
		  return ans;
	  }
	  public int[] countBits1(int num) {
	      int[] ans = new int[num + 1];
	      for (int i = 1; i <= num; ++i)
	        ans[i] = ans[i >> 1] + (i & 1); // x / 2 is x >> 1 and x % 2 is x & 1
	      return ans;
	  }
}
