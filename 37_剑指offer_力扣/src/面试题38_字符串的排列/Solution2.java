package 面试题38_字符串的排列;

/*执行用时 :
41 ms
, 在所有 Java 提交中击败了
52.10%
的用户
内存消耗 :
45.6 MB
, 在所有 Java 提交中击败了
100.00%
的用户*/
import java.util.ArrayList;
import java.util.HashSet;

class Solution2 {
    public String[] permutation(String s) {
        ArrayList<String> list = new ArrayList<String>();
        backTrack(s, 0, s.length(), list);
        return list.toArray(new String[list.size()]);
    }
    private void backTrack(String s, int from, int to, ArrayList<String> list){
        if(from == to) {
            list.add(s);
        }else {
            HashSet<Character> set = new HashSet<>();
            for(int i=from;i < to; i++) {
                char c1 = s.charAt(i);
                if(!set.contains(c1)) {
                    // 交换字符
                    s = swap(s, from, i);
                    backTrack(s, from + 1, to, list);
                    s = swap(s, from, i);
                    set.add(c1);
                }
            }
        }
    }

    private String swap(String s, int i, int j) {
        if(i == j) return s;
        String c1 = s.charAt(i) + "";
        String c2 = s.charAt(j) + "";
        StringBuilder sb = new StringBuilder(s);
        sb.replace(i, i + 1, c2);
        sb.replace(j, j + 1, c1);
        return sb.toString();
    }
}

/*作者：hua-huo-10
链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/solution/zai-mei-ci-di-gui-zhong-she-zhi-yi-ge-hashsetji-lu/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
