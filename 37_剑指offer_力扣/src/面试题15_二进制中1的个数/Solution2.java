package 面试题15_二进制中1的个数;
//Java库方法
public class Solution2 {
	public static int hammingWeight(int i) {
	    // HD, Figure 5-2
	    i = i - ((i >>> 1) & 0x55555555);
	    i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
	    i = (i + (i >>> 4)) & 0x0f0f0f0f;
	    i = i + (i >>> 8);
	    i = i + (i >>> 16);
	    return i & 0x3f;
	}
/*	
	执行用时 :
		1 ms
		, 在所有 Java 提交中击败了
		99.10%
		的用户
		内存消耗 :
		36.7 MB
		, 在所有 Java 提交中击败了
		100.00%
		的用户*/
	
	
/*	作者：hteason
	链接：https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/solution/javayi-wei-yun-suan-by-hteason/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
