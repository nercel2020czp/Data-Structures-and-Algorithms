package l_0215_数组中的第K个最大元素;
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
/*
方法二：快速选择:

快速选择算法 的平均时间复杂度为 {O}(N)O(N)。
就像快速排序那样，本算法也是 Tony Hoare 发明的，因此也被称为 Hoare选择算法。

本方法大致上与快速排序相同。
简便起见，注意到第 k 个最大元素也就是第 N - k 个最小元素，因此可以用第 k 小算法来解决本问题。

首先，我们选择一个枢轴，并在线性时间内定义其在排序数组中的位置。这可以通过 划分算法 的帮助来完成。

为了实现划分，沿着数组移动，将每个元素与枢轴进行比较，并将小于枢轴的所有元素移动到枢轴的左侧。

这样，在输出的数组中，枢轴达到其合适位置。所有小于枢轴的元素都在其左侧，所有大于或等于的元素都在其右侧。

这样，数组就被分成了两部分。如果是快速排序算法，会在这里递归地对两部分进行快速排序，时间复杂度为 {O}(N \log N)O(NlogN)。

而在这里，由于知道要找的第 N - k 小的元素在哪部分中，我们不需要对两部分都做处理，这样就将平均时间复杂度下降到 {O}(N)O(N)。

最终的算法十分直接了当 :

	随机选择一个枢轴。
	
	使用划分算法将枢轴放在数组中的合适位置 pos。将小于枢轴的元素移到左边，大于等于枢轴的元素移到右边。
	
	比较 pos 和 N - k 以决定在哪边继续递归处理。
	
	! 注意，本算法也适用于有重复的数组
	
图1.png



作者：LeetCode
链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/shu-zu-zhong-de-di-kge-zui-da-yuan-su-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

import java.util.Random;
public class Solution2 {
	
/*	执行用时 :
		2 ms
		, 在所有 Java 提交中击败了
		94.01%
		的用户
		内存消耗 :
		40 MB
		, 在所有 Java 提交中击败了
		6.12%
		的用户*/
	
	class Solution {
	  int [] nums;

	  public void swap(int a, int b) {
	    int tmp = this.nums[a];
	    this.nums[a] = this.nums[b];
	    this.nums[b] = tmp;
	  }


	  public int partition(int left, int right, int pivot_index) {
	    int pivot = this.nums[pivot_index];
	    // 1. move pivot to end
	    swap(pivot_index, right);
	    int store_index = left;

	    // 2. move all smaller elements to the left
	    for (int i = left; i <= right; i++) {
	      if (this.nums[i] < pivot) {
	        swap(store_index, i);
	        store_index++;
	      }
	    }

	    // 3. move pivot to its final place
	    swap(store_index, right);

	    return store_index;
	  }

	  public int quickselect(int left, int right, int k_smallest) {
	    /*
	    Returns the k-th smallest element of list within left..right.
	    */

	    if (left == right) // If the list contains only one element,
	      return this.nums[left];  // return that element

	    // select a random pivot_index
	    Random random_num = new Random();
	    int pivot_index = left + random_num.nextInt(right - left); 
	    
	    pivot_index = partition(left, right, pivot_index);

	    // the pivot is on (N - k)th smallest position
	    if (k_smallest == pivot_index)
	      return this.nums[k_smallest];
	    // go left side
	    else if (k_smallest < pivot_index)
	      return quickselect(left, pivot_index - 1, k_smallest);
	    // go right side
	    return quickselect(pivot_index + 1, right, k_smallest);
	  }

	  public int findKthLargest(int[] nums, int k) {
	    this.nums = nums;
	    int size = nums.length;
	    // kth largest is (N - k)th smallest
	    return quickselect(0, size - 1, size - k);
	  }
	}
	
/*	复杂度分析

	时间复杂度 : 平均情况 {O}(N)O(N)，最坏情况 {O}(N^2)O(N 
	2
	 )。
	空间复杂度 : {O}(1)O(1)。*/
	
}
