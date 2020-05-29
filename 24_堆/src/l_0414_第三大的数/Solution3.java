package l_0414_第三大的数;

/*
1. 思想
   Quick select算法通常用来在未排序的数组中寻找第k小/第k大的元素。
   Quick select和Quick sort类似，核心是partition。 

   1. 什么是partition？（如下图，选44为pivot，把数组分为2部分，左边比44小，右边比44大）

图1.png

从数组中选一个数据作为pivot，根据每个数组的元素与该pivot的大小将整个数组分为两部分：
   左半部分，都比pivot大，右半部分，都比pivot小 。
   
   2. 用分治思路实现排序
   
pivotIndex 是pivot在数组的下标

   pivotIndex大于k，说明array[pivotIndex]左边的元素都大于k，只递归array[0, pivotIndex-1]第k大的元素即可；

   pivotIndex小于k，说明第k大的元素在array[pivotIndex]的右边，只递归array[pivotIndex +1, n]第k-pivotIndex大的元素即可；
————————————————
版权声明：本文为CSDN博主「wengyupeng」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/wengyupeng/article/details/84774657
————————————————
版权声明：本文为CSDN博主「wengyupeng」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/wengyupeng/article/details/84774657
 */

import java.util.Arrays;
import java.util.TreeSet;
public class Solution3 {
	 
	public static void main(String[] args) {
		int arr[] = { 7, 10, 4, 3, 20, 15 };

		int pivotIndex = new Solution3().quickSelect(arr, 4, 0, arr.length - 1);
		System.out.println("pivotIndex=" + pivotIndex);
	}

	private int getPivotByPartition(int[] elements, int start, int end) {
		int pivot = start;
		int lessThan = start;

		for (int i = start; i <= end; i++) {
			int currentElement = elements[i];
			if (currentElement < elements[pivot]) {
				lessThan++;
				int tmp = elements[lessThan];
				elements[lessThan] = elements[i];
				elements[i] = tmp;
			}
		}
		int tmp = elements[lessThan];
		elements[lessThan] = elements[pivot];
		elements[pivot] = tmp;
		// System.out.println(" --- array = " +Arrays.toString(elements));
		return lessThan;
	}

	private int quickSelect(int[] elements, int k, int start, int end) {

		int pivot = getPivotByPartition(elements, start, end);

		if (k == (pivot - start + 1)) {
			System.out.println("pivot value=" + elements[pivot]);
			return pivot;
		} else if (k < (pivot - start + 1)) {
			return quickSelect(elements, k, start, pivot - 1);
		} else {
			return quickSelect(elements, k - (pivot - start + 1), pivot + 1, end);
		}
	}
	public int thirdMax(int[] nums) {

		return quickSelect(nums, nums.length-3, 0, nums.length);
	}
}
