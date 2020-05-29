package c01_单调栈.l_0556_下一个更大元素_III;

import java.util.ArrayList;
import java.util.Collections;

/*
方法 1：暴力 [Time Limit Exceeded]
为了解决给定的问题，我们将给定的数字当做字符串 ss。在这种方法中，我们找出所有 ss 给定元素的排列，得到一个字符串列表 listlist，它包含了所有可能的排列。然后我们将 listlist 排序并找到恰好大于当前字符串的字符串。但这个方法非常粗糙，因为我们需要找到所有可能的排列，这会消耗大量时间。

作者：LeetCode
链接：https://leetcode-cn.com/problems/next-greater-element-iii/solution/xia-yi-ge-geng-da-yuan-su-iii-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

复杂度分析

时间复杂度： O(n!)O(n!)。一个 nn 位数字的可能排列总共有 n!n! 种。

空间复杂度： O(n!)O(n!)。 nn 位字符串总共有 n!n! 种可能的排列，每个排列有 nn 位。

作者：LeetCode
链接：https://leetcode-cn.com/problems/next-greater-element-iii/solution/xia-yi-ge-geng-da-yuan-su-iii-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Solution1 {
	public String swap(String s, int i0, int i1) {
        if (i0 == i1)
            return s;
        String s1 = s.substring(0, i0);
        String s2 = s.substring(i0 + 1, i1);
        String s3 = s.substring(i1 + 1);
        return s1 + s.charAt(i1) + s2 + s.charAt(i0) + s3;
    }
    ArrayList < String > list = new ArrayList < > ();
    void permute(String a, int l, int r) {
        int i;
        if (l == r)
            list.add(a);
        else {
            for (i = l; i <= r; i++) {
                a = swap(a, l, i);
                permute(a, l + 1, r);
                a = swap(a, l, i);
            }
        }
    }
    public int nextGreaterElement(int n) {
        String s = "" + n;
        permute(s, 0, s.length() - 1);
        Collections.sort(list);
        int i;
        for (i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).equals("" + n))
                break;
        }
        return i == list.size() - 1 ? -1 : Integer.parseInt(list.get(i + 1));
    }
}
