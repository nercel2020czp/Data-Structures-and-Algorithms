package l_0921_使括号有效的最少添加;
/*方法一： 平衡法
思路和算法

保证左右括号数量的 平衡： 计算 '(' 出现的次数减去 ')' 出现的次数。如果值为 0，那就是平衡的，如果小于 0，就要在前面补上缺少的 '('。

计算 S 每个前缀子数组的 平衡度。如果值是负数（比如说，-1），那就得在前面加上一个 '('。同样的，如果值是正数（比如说，+B），那就得在末尾处加上 B 个 ')' 。

JavaPython


作者：LeetCode
链接：https://leetcode-cn.com/problems/minimum-add-to-make-parentheses-valid/solution/shi-gua-hao-you-xiao-de-zui-shao-tian-jia-by-leetc/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
public class Solution1 {
	class Solution {
	    public int minAddToMakeValid(String S) {
	        int ans = 0, bal = 0;
	        for (int i = 0; i < S.length(); ++i) {
	            bal += S.charAt(i) == '(' ? 1 : -1;
	            // It is guaranteed bal >= -1
	            if (bal == -1) {
	                ans++;
	                bal++;
	            }
	        }

	        return ans + bal;
	    }
	}
/*	执行用时 :
		0 ms
		, 在所有 Java 提交中击败了
		100.00%
		的用户
		内存消耗 :
		37.5 MB
		, 在所有 Java 提交中击败了
		100.00%
		的用户*/
/*	作者：LeetCode
	链接：https://leetcode-cn.com/problems/minimum-add-to-make-parentheses-valid/solution/shi-gua-hao-you-xiao-de-zui-shao-tian-jia-by-leetc/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
