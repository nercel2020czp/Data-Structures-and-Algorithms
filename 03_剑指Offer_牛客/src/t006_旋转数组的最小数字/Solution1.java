package t006_旋转数组的最小数字;
/*链接：https://www.nowcoder.com/questionTerminal/9f3231a991af4f55b95579b44b7a01ba?answerType=1&f=discussion
来源：牛客网

分析：二分查找变种，没有具体的值用来比较。那么用中间值和高低位进行比较，看处于递增还是递减序列，进行操作缩小范围。
处于递增：low上移
处于递减：high下移（如果是high-1，则可能会错过最小值，因为找的就是最小值）
其余情况：low++缩小范围

【见图1.png】



*/
public class Solution1 {

	public int minNumberInRotateArray(int[] array) {
		int i = 0, j = array.length - 1;
		while (i < j) {
			if (array[i] < array[j]) {
				return array[i];
			}
			int mid = (i + j) >> 1;
			if (array[mid] > array[i]) {
				i = mid + 1;
			} else if (array[mid] < array[j]) {
				j = mid; // 如果是mid-1，则可能会错过最小值，因为找的就是最小值
			} else
				i++; // 巧妙避免了offer书上说的坑点（1 0 1 1 1）
		}
		return array[i];
	}

	public int minNumberInRotateArray1(int[] array) {
		if (array == null || array.length == 0)
			return 0;

		int low = 0;
		int high = array.length - 1;
		int mid = 0;

		while (low < high) {
			// 子数组是非递减的数组，10111
			if (array[low] < array[high])
				return array[low];
			mid = low + (high - low) / 2;
			if (array[mid] > array[low])
				low = mid + 1;
			else if (array[mid] < array[high])
				high = mid;
			else
				low++;
		}
		return array[low];
	}
}
