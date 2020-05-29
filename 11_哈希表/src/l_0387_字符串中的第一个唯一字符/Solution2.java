package l_0387_字符串中的第一个唯一字符;

public class Solution2 {
	//用数组替代HashMap，我从52ms一下变成5ms
	public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        if (chars.length == 0) {
            return -1;
        }
        int[] map = new int[256];
        for (char aChar : chars) {
            map[aChar] += 1;
        }
        for (int i = 0; i < chars.length; i++) {
            if (map[chars[i]] == 1) {
                return i;
            }
        }
        return -1;
    }
}
