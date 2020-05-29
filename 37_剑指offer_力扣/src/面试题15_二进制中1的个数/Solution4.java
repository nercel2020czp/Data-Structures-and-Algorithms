package 面试题15_二进制中1的个数;

public class Solution4 {
    public int hammingWeight(int n) {
        int res = 0;
        while(n != 0) {
            res++;
            n &= n - 1;
        }
        return res;
    }
/*    执行用时 :
    	1 ms
    	, 在所有 Java 提交中击败了
    	99.10%
    	的用户
    	内存消耗 :
    	36.5 MB
    	, 在所有 Java 提交中击败了
    	100.00%
    	的用户*/
}

/*作者：jyd
链接：https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/solution/mian-shi-ti-15-er-jin-zhi-zhong-1de-ge-shu-wei-yun/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/