/**
 * 
 */
/**
 * @author 15753
 *
 */
package l_0567_字符串的排列_permutation_in_string;
/*
LeetCode 567 题，Permutation in String，难度 Medium：
567. 字符串的排列[中等]
leetcode-cn.com/problems/permutation-in-string/
给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。

换句话说，第一个字符串的排列之一是第二个字符串的子串。

示例1:

输入: s1 = "ab" s2 = "eidbaooo"
输出: True
解释: s2 包含 s1 的排列之一 ("ba").
 

示例2:

输入: s1= "ab" s2 = "eidboaoo"
输出: False
 

注意：

输入的字符串只包含小写字母
两个字符串的长度都在 [1, 10,000] 之间

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutation-in-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

class Solution {
    public boolean checkInclusion(String s1, String s2) {

    }
}
----------------------------------------------
注意哦，输入的s1是可以包含重复字符的，所以这个题难度不小。

这种题目，是明显的滑动窗口算法，相当给你一个S和一个T，
请问你S中是否存在一个子串，包含T中所有字符且不包含其他字符？

首先，先复制粘贴之前的算法框架代码，然后明确刚才提出的 4 个问题，即可写出这道题的答案：
*/