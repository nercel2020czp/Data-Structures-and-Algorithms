package sort06_归并排序_MergeSort;
//归并排序优化，当data[center] > data[center+1]时，才进行合并操作，
//这对于近乎有序的元素序列来说，能够提升性能
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import utils.Utils;

public class MergeSort3 {
	
	public static void main(String[] args) {
		// 为了容量理解，我们把冒泡排序的演变过程，给大家展示

		// 测试一下冒泡排序的速度O(n^2), 给80000个数据，测试
		// 创建要给80000个的随机的数组
		boolean isPrintArr = true;
		
//		//长数组
//		int[] arr = new int[Utils.NUM];
//		int arrLength = arr.length;
//		isPrintArr = false;
//		for (int i = 0; i < arrLength; i++) {
//			arr[i] = (int) (Math.random() * arrLength); // 生成一个[0, 8000000) 数
//		}
//		
		//短数组
		int[] arr = new int[] { 10, 5, 1, 2, 4, 9, 8, 7, 6, 3 };

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
		mergeSort(arr);
		long endTime = System.currentTimeMillis();
		System.out.println("-----------MergeSort优化【递归】排序前后【分割线】------------");
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
	
	public static void mergeSort(int[] data) {
		// 归并排序
		sort(data, 0, data.length - 1);
	}

	//归并排序优化，当data[center] > data[center+1]时，才进行合并操作，
	//这对于近乎有序的元素序列来说，能够提升性能
	private static void sort(int[] data, int left, int right) {
		if(left >= right) return;
		// 找出中间索引
		int center = (left + right) / 2;
		sort(data, left, center);
		sort(data, center + 1, right);
		// 合并【优化了】这对于近乎有序的元素序列来说，能够提升性能
		if(data[center] > data[center+1])
			merge(data, left, right);
	}

	// 将两个数组进行归并，归并前两个数组已经有序，归并后依然有序
	private static void merge(int[] data, int left, int right) {
		int center = (left + right) / 2;
		int[] tempArr = new int[data.length];
		int mid = center + 1;
		int third = left;
		int temp = left;
		while (left <= center && mid <= right) {
			if (data[left] - data[mid] <= 0) {
				tempArr[third++] = data[left++];
			} else {
				tempArr[third++] = data[mid++];
			}
		}
		while (mid <= right) {
			tempArr[third++] = data[mid++];
		}
		while (left <= center) {
			tempArr[third++] = data[left++];
		}
		while (temp <= right) {
			data[temp] = tempArr[temp++];
		}
	}
}
