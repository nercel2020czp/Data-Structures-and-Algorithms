package 面试题15_二进制中1的个数;

/*
//方法三：逐位判断
根据 与运算 定义，设二进制数字 n ，则有：
	若 n&1=0 ，则 n 二进制 最右一位 为 0 ；
	若 n&1=1 ，则 n 二进制 最右一位 为 1 。
	
根据以上特点，考虑以下 循环判断 ：
	1.判断 n 最右一位是否为 1 ，根据结果计数。
	2.将 n 右移一位（本题要求把数字 n 看作无符号数，因此使用 无符号右移 操作）。

算法流程：
	1.初始化数量统计变量 res=0 。
	2.循环逐位判断： 当 n=0 时跳出。
		2.1 res += n & 1 ： 即若 n&1=1 ，则统计数 res 加一。
		2.2 n >>= 1 ： 将二进制数字  无符号右移一位（ Java 中无符号右移为 ">>>" ） 。
	3.返回统计数量 res 。
	
复杂度分析：
	时间复杂度 O(log_2 n) ： 此算法循环内部仅有 移位、与、加 等基本运算，占用 O(1) ；逐位判断需循环 (log_2 n)次，
	其中 (log_2 n) 代表数字 n 最高位 1 的所在位数（例如 (log_2 4) = 2, (log_2 16) = 4）。
	空间复杂度 O(1) ： 变量 res 使用常数大小额外空间。

	

作者：jyd
链接：https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/solution/mian-shi-ti-15-er-jin-zhi-zhong-1de-ge-shu-wei-yun/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

*/
public class Solution3 {
    public int hammingWeight(int n) {
        int res = 0;
        while(n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }
}

