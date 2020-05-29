package l_0461_汉明距离_hamming_distance;

public class Solution1 {
    //1.两个数字异或之后可以得到 不同二进制位的数字
    //2.计算该数字中1的个数，即是汉明距离
    //计算1的个数时，有几种方法，1：不断和左移的1 进行 与，判断该位是否为1.
    //                        2:  n&(n-1)就是把n最右边的bit 1 位去掉，看能去掉几次，就有几个1位。

/*	执行结果：
	通过
	显示详情
	执行用时 :
	0 ms
	, 在所有 Java 提交中击败了
	100.00%
	的用户
	内存消耗 :
	36.5 MB
	, 在所有 Java 提交中击败了
	6.45%
	的用户	*/
	
//作者：lou-ding-_shai-tai-yang
//链接：https://leetcode-cn.com/problems/hamming-distance/solution/shuang-bai-100-fang-fa-by-lou-ding-_shai-tai-yang/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
	public int hammingDistance(int x, int y) {
		int n = x ^ y;
		int res = 0;
		while (n != 0) {
			n = n & (n - 1);
			res++;
		}
		return res;
	}
}
