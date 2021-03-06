package 面试题14_I_剪绳子;
/*//解题思路：
首先，任何一个数字 n，都可以被分为有限个小数字之和 n = n_1 + n_2 + ... + n_M
	根据常理： 一般这 M 个数字的乘积要大于原数字 n。
其次，所有数字n 都可以通过对一个因子 x 求整数部分 a（a = n / x） 和余数部分 b （ b = n % x）；
	即得出数字 n 由 a 个 x 和 1 个 b 相加而成。
问题转化： 是否有优先级最高的因子 x 存在？若有，我们就可以把问题转化为求 x^a * b这个表达式的最大值。
	例如：2=1+1，1 * 1 < 2，因此 2 比 1+1 更优；
	例如：3=1+2，1 * 2 < 3，因此 3 比 1 和 2 更优；
	例如：4=2+2，2 * 2 = 4，因此可以认为 4 与 2 等价，因此见到 4 就拆分；
	例如：5=2+3；因为每个 5 都可以拆分为 2+3，而 2 * 3 = 6 > 5，因此见到 5 就拆分。
	例如：6=3+3=2+2+2；因为 3 * 3 > 2 * 2 * 2 > 6。因此见到 6 就拆分，并且 3 是比 2 更优的因子。
	易推出： 大数字都可以被拆分为多个小因子，以获取更大的乘积，只有 2 和 3 不需要拆分。
	见图2.png
	
观察以上枚举，我们可以列出以下贪心法则：
	第一优先级： 3；把数字 n 拆成尽可能多的 3 之和；
		特殊情况： 拆完后，如果余数是 1；则应把最后的 3+1 替换为2+2，因为后者乘积更大；
	第二优先级： 2；留下的余数如果是 2，则保留，不再拆为 1+1。	
	
算法流程：

	1.当 n<=3 时，按照贪心规则应直接保留原数字，但由于题目要求必须拆分，因此必须拆出一个 1，即直接返回 n−1；
	2.求 n 除以 3 的整数部分 a 和余数部分 b；
	3.当b==0 时，直接返回 3^a 
	4.当b==1 时，要将一个 1+3 转换为 2+2，此时返回 3^{a-1} * 2
	5.当b==2 时，返回 3^a * b
	
复杂度分析：
	时间复杂度 O(1) ： 仅有求整、求余、次方运算。
		求整和求余运算：查阅资料，提到不超过机器数的整数可以看作是 O(1) ；
		https://stackoverflow.com/questions/35189851/time-complexity-of-modulo-operator-in-python
		次方运算：查阅资料，提到不超过机器数的整数可以看作是 O(1) 。
		https://stackoverflow.com/questions/32418731/java-math-powa-b-time-complexity
	空间复杂度 O(1) ： a 和 b 使用常数大小额外空间。

	作者：jyd
	链接：https://leetcode-cn.com/problems/integer-break/solution/343-zheng-shu-chai-fen-tan-xin-by-jyd/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
class Solution4 {
    public int integerBreak(int n) {
    	//1.当 n<=3 时，按照贪心规则应直接保留原数字，但由于题目要求必须拆分，因此必须拆出一个 1，即直接返回 n−1；
        if(n <= 3) return n - 1;
        //2.求 n 除以 3 的整数部分 a 和余数部分 b；
        int a = n / 3, b = n % 3;
        //3.当b==0 时，直接返回 3^a 
        if(b == 0) return (int)Math.pow(3, a);
        //4.当b==1 时，要将一个 1+3 转换为 2+2，此时返回 3^{a-1} * 2
        if(b == 1) return (int)Math.pow(3, a - 1) * 4;
        //5.当b==2 时，返回 3^a * b
        return (int)Math.pow(3, a) * 2;
    }
/*    执行用时 :
    	0 ms
    	, 在所有 Java 提交中击败了
    	100.00%
    	的用户
    	内存消耗 :
    	36.5 MB
    	, 在所有 Java 提交中击败了
    	5.31%
    	的用户*/
    
    
}

