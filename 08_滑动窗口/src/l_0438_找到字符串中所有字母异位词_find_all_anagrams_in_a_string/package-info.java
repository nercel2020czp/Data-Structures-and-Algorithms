/**
 * 
 */
/**
 * @author 15753
 *
 */
package l_0438_找到字符串中所有字母异位词_find_all_anagrams_in_a_string;
/*

https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/

给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。

字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。

说明：

字母异位词指字母相同，但排列不同的字符串。
不考虑答案输出的顺序。

示例 1:

输入:
s: "cbaebabacd" p: "abc"

输出:
[0, 6]

解释:
起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。

-------------------------------------

示例 2:

输入:
s: "abab" p: "ab"

输出:
[0, 1, 2]

解释:
起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。

class Solution {
    public List<Integer> findAnagrams(String s, String p) {

    }
}
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

-----------------题目解析-------------------
呵呵，这个所谓的字母异位词，不就是排列吗，搞个高端的说法就能糊弄人了吗？
相当于，输入一个串S，一个串T，找到S中所有T的排列，返回它们的起始索引。

直接默写一下框架，明确刚才讲的 4 个问题，即可秒杀这道题：

*/