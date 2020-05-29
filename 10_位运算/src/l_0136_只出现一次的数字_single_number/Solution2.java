package l_0136_只出现一次的数字_single_number;
//异或有交换律定理，相当于将相同的数字先异或，这样两两异或就只剩0了，然后0再和最后的一个数字异或得到最终值，膜拜大佬

//异或解法：异或运算满足交换律，a^b^a=a^a^b=b,因此ans相当于nums[0]^nums[1]^nums[2]^nums[3]^nums[4]..... 
//然后再根据交换律把相等的合并到一块儿进行异或（结果为0），然后再与只出现过一次的元素进行异或，这样最后的结果就是，
//只出现过一次的元素（0^任意值=任意值）

/*

异或是一种基于二进制的位运算，用符号XOR或者 ^ 表示，
其运算法则是对运算符两侧数的每一个二进制位，同值取0，异值取1。
它与布尔运算的区别在于，当运算符两侧均为1时，布尔运算的结果为1，异或运算的结果为0。
一、异或的性质
交换律：a ^ b = b ^ a
结合律：a ^ b ^ c = a ^ (b ^ c) = (a ^ b) ^ c【待证明】
d = a ^ b ^ c 可以推出 a = d ^ b ^ c
自反性：a ^ b ^ a = b
————————————————
版权声明：本文为CSDN博主「changeyourmind」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/changyourmind/article/details/52437565


 */

public class Solution2 {
	public int singleNumber(int[] nums) {
		int ans = nums[0];
		if (nums.length > 1) {
			for (int i = 1; i < nums.length; i++) {
				ans = ans ^ nums[i];
			}
		}
		return ans;
	}
}
