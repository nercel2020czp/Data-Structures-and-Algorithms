package t043_左旋转字符串;
/*解题思路
先用String类的substring方法进行字符串切片，
再用StringBuffer的拼接，
主要字符串切片的下标不要写错。
时间复杂度：O(1)
空间复杂度：O(n)，n是字符串的长度

作者：abner-42
链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/solution/javaqie-pian-pin-jie-fa-by-abner-42/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
public class Solution2 {
	public String reverseLeftWords(String s, int n) {
		return new StringBuffer(s.substring(n, s.length())).append(s.substring(0, n)).toString();
	}

}
