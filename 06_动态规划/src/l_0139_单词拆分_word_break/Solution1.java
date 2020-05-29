package l_0139_单词拆分_word_break;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
方法 4：使用动态规划
算法
这个方法的想法是对于给定的字符串（s）可以被拆分成子问题 s1 和 s2 。
如果这些子问题都可以独立地被拆分成符合要求的子问题，那么整个问题 s 也可以满足。
也就是，如果 "catsanddog" 可以拆分成两个子字符串 "catsand" 和 "dog" 。
子问题 "catsand" 可以进一步拆分成 "cats" 和 "and" ，这两个独立的部分都是
字典的一部分，所以 "catsand" 满足题意条件，再往前， "catsand" 和 "dog" 
也分别满足条件，所以整个字符串 "catsanddog" 也满足条件。

现在，我们考虑 dp 数组求解的过程。我们使用 n+1 大小数组的 dp ，其中 n 是给定字符串的长度。
我们也使用 2 个下标指针 i 和 j ，其中 i 是当前字符串从头开始的子字符串（s'）的长度， j 是当
前子字符串（s'）的拆分位置，拆分成 s'(0,j)和 s'(j+1,i)。

为了求出 dp 数组，我们初始化 dp[0] 为 true ，这是因为空字符串总是字典的一部分。 dp 数组剩余
的元素都初始化为 false 。

我们用下标 i 来考虑所有从当前字符串开始的可能的子字符串。对于每一个子字符串，我们通过下标 j 
将它拆分成 s1'和 s2'（注意 i 现在指向 s2' 的结尾）。为了将 dp[i] 数组求出来，我们依次检
查每个 dp[j] 是否为 true ，也就是子字符串 s1'是否满足题目要求。如果满足，我们接下来检查 s2'
是否在字典中。如果包含，我们接下来检查 s2'是否在字典中，如果两个字符串都满足要求，我们让dp[i]
为true ，否则令其为false 。

作者：LeetCode
链接：https://leetcode-cn.com/problems/word-break/solution/dan-ci-chai-fen-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

*/
public class Solution1 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet=new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    
/*    复杂度分析

    时间复杂度：O(n^2) 。求出dp 数组需要两重循环。

    空间复杂度：O(n)。 dp 数组的长度是 n+1 。
    
    */
}
