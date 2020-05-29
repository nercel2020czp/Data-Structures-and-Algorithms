package t034_第一个只出现一次的字符位置;
//刚开始还以为有什么特殊的解法，没想到当年也是按照hash的思想来做的，先统计出现的次数，然后在返回相应的index
public class Solution1 {

	public int FirstNotRepeatingChar(String str) {
		if (str == null || str.length() == 0)
			return -1;
		int[] count = new int[256];
		// 用一个类似hash的东西来存储字符出现的次数，很方便
		for (int i = 0; i < str.length(); i++)
			count[str.charAt(i)]++;
		// 其实这个第二步应该也是ka我的地方，没有在第一时间想到只要在遍历一遍数组并访问hash记录就可以了
		for (int i = 0; i < str.length(); i++)
			if (count[str.charAt(i)] == 1)
				return i;
		return -1;
	}
	
}
