/**
 * 
 */
/**
 * @author 15753
 *
 */
package l_0316_去除重复字母;
/*
https://leetcode-cn.com/problems/remove-duplicate-letters/
316. 去除重复字母
给你一个仅包含小写字母的字符串，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。

 

示例 1:

输入: "bcabc"
输出: "abc"
示例 2:

输入: "cbacdcbc"
输出: "acdb"
 

注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同

class Solution {
    public String removeDuplicateLetters(String s) {

    }
}


思路分析：

首先解释一下字典序。字典序是指从前到后比较两个字符串大小的方法。
	首先比较第 1 个字符，如果不同则第 1 个字符较小的字符串更小；
	如果相同则继续比较第 2 个字符 …… 如此继续，比较整个字符串的大小。
	
观察示例 1：bcabc。

字符 a 在字符串中只出现一次，根据题目要求，字符 a 必须被选取；
字符 b 出现了两次，显然选择 a后面的那个，因为字典序 ab 在 ba 前面。同理，有两个相同的字符 c ，我们选择后一个。因此，输出就是 abc。

再观察示例 2：cbacdcbc。

有 4 个字符：a、b、c、d。其中 a 和 d 只出现一次，必须被选取；
b 出现 2 次，一个在 a 前面，一个在 a 后面，显然保留在 a 后面的；
c 出现 4 次，我们把几种可能都列出来观察一下：
情况 1：cadb
情况 2：acdb（字典序最小）
情况 3：adcb
情况 4：adbc


作者：liweiwei1419
链接：https://leetcode-cn.com/problems/remove-duplicate-letters/solution/zhan-by-liweiwei1419/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/