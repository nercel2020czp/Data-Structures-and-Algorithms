package t028_数组中出现次数超过一半的数字;

import org.junit.Test;

/*链接：https://www.nowcoder.com/questionTerminal/e8a1b01a2df14cb2b228b30ee6a92163?answerType=1&f=discussion
来源：牛客网

思路：用一般的排序也可以完成这道题目，但是如果那样完成的话就可能太简单了。
用preValue记录上一次访问的值，count表明当前值出现的次数，如果下一个值和当前值相同那么count++；
如果不同count--，减到0的时候就要更换新的preValue值了，因为如果存在超过数组长度一半的值，
那么最后preValue一定会是该值。

方法二：不正常思路的话，用target记录上一次访问的值，count表明当前值出现的次数，
如果下一个值和当前值相同那么count++；如果不同count--，减到0的时候就要更换新的target值了，
因为如果存在超过数组长度一半的值，那么最后target一定会是该值。可以这样理解，count的自加和自
减就是在描述一种抵消关系，由于超过一半的出现次数，导致最后的target一定会是该值。
（这种方法的时间复杂度自然会小些）
*/
public class Solution1 {
	public int MoreThanHalfNum_Solution(int[] array) {
		if (array == null || array.length == 0)
			return 0;
		int preValue = array[0];// 用来记录上一次的记录
		int count = 1;// preValue出现的次数（相减之后）
		for (int i = 1; i < array.length; i++) {
			if (array[i] == preValue)
				count++;
			else {
				count--;
				if (count == 0) {
					preValue = array[i];
					count = 1;
				}
			}
		}
		int num = 0;// 需要判断是否真的是大于1半数
		for (int i = 0; i < array.length; i++)
			if (array[i] == preValue)
				num++;
		return (num > array.length / 2) ? preValue : 0;

	}
	@Test
	public void test1() {
		int[] arr = {1,2,3,2,2,2,5,4,2};
		MoreThanHalfNum_Solution(arr);
	}
}
