package t013_调整数组顺序使奇数位于偶数前面;
/*链接：https://www.nowcoder.com/questionTerminal/beb5aa231adc45b2a5dcc5b62c93f593?answerType=1&f=discussion
来源：牛客网

思路：参考快速排序

	i++往前走碰到偶数停下来，j = i+1          【此时a[i]为偶数】
	若 a[j]为偶数，j++前进，直到碰到奇数      【此时a[j]为奇数, 并且从a[i,j)都是偶数】
		a[j]对应的奇数插到a[i]位置，j经过的j-i个偶数依次后移
	如果 j==len-1 时还没碰到奇数，证明i和j之间都为偶数了，完成整个移动
*/
public class Solution1 {

	/*    2,进阶
    要想保证顺序，那么交换只能发生在相邻元素之间或顺序移动，同样的使用两个标记，
    第一个标记start从数组头出发，当找到第一个偶数后，第二个标记end从找到偶数的后
    一个位置出发找奇数，然后将start到end-1的元素整体后移，将end的元素赋予
    start位置.*/
	public void reOrderArray(int[] array) {
		if (array == null || array.length == 0) {
			return;
		}
		int start = 0;
		int end = 0;
		while (start < array.length) {
			while (start < array.length && (array[start] % 2 != 0)) {
				start++;
			}
			end = start + 1;
			while (end < array.length && (array[end] % 2 == 0)) {
				end++;
			}
			if (end < array.length) {
				int temp = array[end];
				for (int i = end - 1; i >= start; i--) {
					array[i + 1] = array[i];
				}
				array[start++] = temp;
			} else {
				break;
			}
		}
	}
}
