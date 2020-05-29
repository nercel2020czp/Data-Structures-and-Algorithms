package 面试题10_II_青蛙跳台阶问题;

import org.junit.Test;

//方法四：斐波那契数

/*
时间复杂度：O(N)。我们计算了从 0 到 n 的值。
空间复杂度：O(1)。

*/
public class Solution4 {
    public int numWays(int n) {
        if(n == 0)
            return 1;
        if(n <= 2)
            return n;
        long fibOne = 1;
        long fibTow = 2;
        long res = 0;
        for (int i = 3; i <= n; i++) {
            res = (fibOne + fibTow) % 1000000007;
            fibOne = fibTow;
            fibTow = res;
        }
        return (int) res;
    }
/*    
    执行用时 :
    	0 ms
    	, 在所有 Java 提交中击败了
    	100.00%
    	的用户
    	内存消耗 :
    	36.7 MB
    	, 在所有 Java 提交中击败了
    	100.00%
    	的用户
  */  
    @Test
    public void test1() {
    	System.out.println(numWays(10));
    }
    
    

/*作者：z1m
链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/solution/dong-tai-gui-hua-by-ml-zimingmeng/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
