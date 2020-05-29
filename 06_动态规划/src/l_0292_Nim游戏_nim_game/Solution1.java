package l_0292_Nim游戏_nim_game;

public class Solution1 {
	boolean canWinNim(int n) {
	    // 如果上来就踩到 4 的倍数，那就认输吧
	    // 否则，可以把对方控制在 4 的倍数，必胜
	    return (n & 3) != 0;
	}
	/*
算法如下：
　　x&3==0，则是4的倍数。
原理：
先来看一组数字的二进制表示
　　4　　　　0100
　　8　　　　1000
   12      1100
　　16     10000
　　20     10100
由此可见 4 的倍数的二进制表示的后 2 为一定为 0。
作者：windliang
链接：https://leetcode-cn.com/problems/nim-game/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-54/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
	 */
}
