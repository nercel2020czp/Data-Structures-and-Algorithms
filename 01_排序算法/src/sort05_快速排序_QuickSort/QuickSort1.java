package sort05_快速排序_QuickSort;
//快速排序【递归版】
/*
 	1.一般来说，非递归算法性能比递归版本要好
 	2.但是，此处的快速排序递归版本的性能比非递归版本的要好
 	3.这是因为，此处的递归版本并没有出现重复计算和浪费空间的情况
 */
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import utils.Utils;

public class QuickSort1 {
	
	public static void main(String[] args) {
		// 为了容量理解，我们把冒泡排序的演变过程，给大家展示

		// 测试一下冒泡排序的速度O(n^2), 给80000个数据，测试
		// 创建要给80000个的随机的数组
		boolean isPrintArr = true;
		
		//长数组
		int[] arr = new int[Utils.NUM];
		int arrLength = arr.length;
		isPrintArr = false;
		for (int i = 0; i < arrLength; i++) {
			arr[i] = (int) (Math.random() * arrLength); // 生成一个[0, 8000000) 数
		}
		
		
////		
//		//短数组
//		int[] arr = new int[] { 10, 5, 1, 2, 4, 9, 8, 7, 6, 3 };

		System.out.println("排序前：");
		if(isPrintArr) {
			System.out.println(Arrays.toString(arr));
		}
		Date date1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(date1);
		System.out.println("排序前的时间是=" + date1Str);

		System.out.println("开始排序....");
		// 测试冒泡排序
		long startTime = System.currentTimeMillis();
		quickSort(arr);
		long endTime = System.currentTimeMillis();
		System.out.println("-----------QuickSort【递归】排序前后【分割线】------------");
		System.out.println("结束排序....");
		
		System.out.println("排序前后：");
		Date date2 = new Date();
		String date2Str = simpleDateFormat.format(date2);
		if(isPrintArr) {
			System.out.println(Arrays.toString(arr));
		}
		System.out.println("排序后的时间是=" + date2Str);
		System.out.println("排序所花时间是=" + (endTime - startTime) + "ms");
	}

	public static void quickSort(int[] data) {
		quickSort(data, 0, data.length - 1);
	}
	
	private static void quickSort(int[] data, int left, int right) {
		if (left >= right)
			return;
		int pivotIndex = partition(data, left, right);
		quickSort(data, left, pivotIndex - 1);// 递归调用
		quickSort(data, pivotIndex + 1, right);
	}
	
	private static int partition(int[] data, int left, int right) {
		int pivot = data[left];
		int low = left;
		int high = right + 1;
		while (true) {
			// 从左往右，找到第一个大于pivot的数
			while (low < right && data[++low] - pivot <= 0);
			// 从右往左，找到第一个小于pivot的数
			while (high > left && data[--high] - pivot >= 0);
			if (low < high) {
				swap(data, low, high);
			} else {
				/*
				//此时:
				 	1. low > high, 不是 low >= high, 证明如下：
				 		因为 data[high] < pivot < data[low] (1)
				 		假设 low = high, 则有 data[high] = data[low]
				 		这与(1)式矛盾
					2. pivot = data[start] > data[high]
				*/
				swap(data, left, high);
				break;
			}
		}
		return high;
	}
	private static void swap(int[] data, int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
}
