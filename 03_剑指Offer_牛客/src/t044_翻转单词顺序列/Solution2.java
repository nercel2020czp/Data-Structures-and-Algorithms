package t044_翻转单词顺序列;


/*需要注意的是 如果字符串前面有空格 split() 会产生一个 ""
如果中间有连续的三个空格 会产生两个""
另外 String类型 用"=="无效 要使用equals() 方法判断

作者：Z_X_C
链接：https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/solution/javati-jie-by-z_x_c/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/


class Solution2 {
	public String reverseWords(String s) {
		String[] a = s.split(" ");
		StringBuilder sb = new StringBuilder(s.length());
		for (int i = a.length - 1; i >= 0; i--) {
			if (!a[i].equals("")) {
				sb.append(a[i]);
				sb.append(" ");
			}
		}
		return sb.toString().trim();
	}
/*	执行用时 :
		2 ms
		, 在所有 Java 提交中击败了
		98.90%
		的用户
		内存消耗 :
		41.6 MB
		, 在所有 Java 提交中击败了
		5.06%
		的用户*/
}

