package t049_把字符串转换成整数;
//解法1：捕捉异常（有些钻空子嫌疑，但是很好用。。。。在题解中看到的）
public class Solution1 {

	@SuppressWarnings("finally")
	public int StrToInt(String str) {
		Integer res = 0;
		try {
			res = new Integer(str);
		} catch (NumberFormatException e) {

		} finally {
			return res;
		}
	}
}
