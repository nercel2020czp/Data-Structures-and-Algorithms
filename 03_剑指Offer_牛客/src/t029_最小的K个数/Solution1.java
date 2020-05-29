package t029_最小的K个数;

import java.util.ArrayList;

/*链接：https://www.nowcoder.com/questionTerminal/6a296eb82cf844ca8539b57c23e6e9bf?answerType=1&f=discussion
来源：牛客网

对于n个整数中最小的K个数的查找，可以使用各种排序算法：冒泡/堆排/快排/希尔排序等等。
将此n个整数从小到大排序之后，前k个数就是所求的结果。
但是当原数组中的数据顺序不可修改，并且n的值过于大的时候，各种排序算法要将n个数加载到内存中，
即：如果是海量数据中查找出最小的k个数，那么这种办法是效率很低的。接下来介绍另外一种算法：
** 创建一个大小为k的数组，遍历n个整数，如果遍历到的数小于大小为k的数组的最大值，则将此数与其最大值替换。**
由于每次都要拿n个整数和数组中的最大值比较，所以选择大根堆这一数据结构
(大家要分清楚大根堆这一数据结构和堆排序之间的区别：堆排序是在大根堆这一数据结构上进行排序的一种排序算法，一个是数据结构，一个是算法)*/
public class Solution1 {
	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		ArrayList<Integer> list = new ArrayList<>();
		if (input == null || input.length == 0 || k > input.length || k == 0)
			return list;
		int[] arr = new int[k + 1];// 数组下标0的位置作为哨兵，不存储数据
		// 初始化数组
		for (int i = 1; i < k + 1; i++)
			arr[i] = input[i - 1];
		buildMaxHeap(arr, k + 1);// 构造大根堆
		for (int i = k; i < input.length; i++) {
			if (input[i] < arr[1]) {
				arr[1] = input[i];
				adjustDown(arr, 1, k + 1);// 将改变了根节点的二叉树继续调整为大根堆
			}
		}
		for (int i = 1; i < arr.length; i++) {
			list.add(arr[i]);
		}
		return list;
	}

	public void buildMaxHeap(int[] arr, int length) {
		if (arr == null || arr.length == 0 || arr.length == 1)
			return;
		for (int i = (length - 1) / 2; i > 0; i--) {
			adjustDown(arr, i, arr.length);
		}
	}

	public void adjustDown(int[] arr, int k, int length) {
		arr[0] = arr[k];// 哨兵
		for (int i = 2 * k; i <= length; i *= 2) {
			if (i < length - 1 && arr[i] < arr[i + 1])
				i++;// 取k较大的子结点的下标
			if (i > length - 1 || arr[0] >= arr[i])
				break;
			else {
				arr[k] = arr[i];
				k = i; // 向下筛选
			}
		}
		arr[k] = arr[0];
	}
}
