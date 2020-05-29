package 面试题15_二进制中1的个数;
/*
不借助库方法。
Java库方法有Integer.bitCount(n)，后附源码，可参考。
----------------------------------
*/
/*	作者：hteason
链接：https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/solution/javayi-wei-yun-suan-by-hteason/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
public class Solution1 {
    public int hammingWeight(int n) {
		int count = 0;
		while (n != 0) {
			//如果二进制最后一位是1的话count+1，否则是0则+0(相当于不加)
			count += (n & 1);//res += n & 1;
			n = n >>> 1;//n >>>= 1;
		}
		return count;
    }
    public int hammingWeight1(int n) {
        int res = 0;
        while(n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }
    
/*    执行用时 :
    	1 ms
    	, 在所有 Java 提交中击败了
    	99.10%
    	的用户
    	内存消耗 :
    	36 MB
    	, 在所有 Java 提交中击败了
    	100.00%
    	的用户*/
}

