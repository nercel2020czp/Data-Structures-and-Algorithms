package c04_第四章_高频面试题.c01_如何高效寻找素数;

import java.util.Arrays;

public class Solution1 {
	int countPrimes(int n) {
	    boolean[] isPrim = new boolean[n];
	    Arrays.fill(isPrim, true);
	    for (int i = 2; i * i < n; i++) 
	        if (isPrim[i]) 
	            for (int j = i * i; j < n; j += i) 
	                isPrim[j] = false;

	    int count = 0;
	    for (int i = 2; i < n; i++)
	        if (isPrim[i]) count++;

	    return count;
	}
	
/*	该算法的时间复杂度比较难算，显然时间跟这两个嵌套的 for 循环有关，其操作数应该是：
	  n/2 + n/3 + n/5 + n/7 + ...
	= n × (1/2 + 1/3 + 1/5 + 1/7...)
	括号中是素数的倒数。其最终结果是 O(N * loglogN)，有兴趣的读者可以查一下该算法的时间复杂度证明。
	以上就是素数算法相关的全部内容。怎么样，是不是看似简单的问题却有不少细节可以打磨呀？
	致力于把算法讲清楚！欢迎关注我的微信公众号 labuladong，查看更多通俗易懂的文章：*/
}
