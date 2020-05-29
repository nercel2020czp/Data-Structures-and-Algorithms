package t035_数组中的逆序对;
/*



二路归并即merge，是将两个有序的序列合并为一个有序的序列，在两个子序列left、
right合并过程中，当left中当前元素A小于right中当前元素B时，因为right序
列已经有序，所以不用比较，A一定是left、right两个子序列当前剩余元素中最小的
元素，这省去了A与B后其他元素比较的操作。

对于本题，在两个子序列left、right合并过程中，当left中当前元素A大于right中
当前元素B时，因为right序列已经有序，所以不用比较，A一定大于right序列当前所有
剩余元素，其全部可以与A组成逆序对，即通过一次比较可到一批逆序对，加速统计过程。


自己做的时候一直想用dp的方法来做：用dp（i）表示以i开头的逆序对，然后在获得dp（j）(j=i-1)的时候，
寻找序号大于j的第一个小于等于array（j）的序号i，dp（j） = dp（i）+if(array(i)<array(j))，
但是这样的想法是不对的，用这样的动态规划转移方程式会漏掉一部分数据，因为在i之后可能会存在大于array(i)
但小于array(j)的数，这部分数字和array(j)可以组成逆序对，但是却不会被计算在dp（j）中，所以这个思路是有问题的。
所以不得已只能用大家提供的归并排序的思路来做这道题目以实现o（nlogn）的复杂度。

在归并排序的过程中 后一个数组的数如小于前一个数组的数，则一定能够构成逆序对且逆序对的数目可计算，因为待归并的
两个数组提前已经归并排序过，所以不会出现像前面那样少统计或者多统计的情况出现。
思路：[A，B]中的逆序对=[A]的逆序对+[B]中的逆序对+将A，B混排在一起的逆序对
而将A，B混排在一起的逆序对求解看下面：

*/
public class Solution1 {

	private int cnt;

	private void MergeSort(int[] array, int start, int end) {
		if (start >= end)
			return;
		int mid = (start + end) / 2;
		MergeSort(array, start, mid);
		MergeSort(array, mid + 1, end);
		MergeOne(array, start, mid, end);
	}

	private void MergeOne(int[] array, int start, int mid, int end) {
		int[] temp = new int[end - start + 1];
		int k = 0, i = start, j = mid + 1;
		while (i <= mid && j <= end) {
			// 如果前面的元素小于后面的不能构成逆序对
			if (array[i] <= array[j])
				temp[k++] = array[i++];
			else {
				// 如果前面的元素大于后面的，那么在前面元素之后的元素都能和后面的元素构成逆序对
				temp[k++] = array[j++];
				cnt = (cnt + (mid - i + 1)) % 1000000007;
			}
		}
		while (i <= mid)
			temp[k++] = array[i++];
		while (j <= end)
			temp[k++] = array[j++];
		for (int l = 0; l < k; l++) {
			array[start + l] = temp[l];
		}
	}

	public int InversePairs(int[] array) {
		MergeSort(array, 0, array.length - 1);
		return cnt;
	}
}
