package sort02_选择排序_SelectSort;
// 选择排序：方法1【从无序序列中找出最小的那个元素，然后与无序序列最前面的那个元素交换位置】
//从前往后排序
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import utils.Utils;

public class SelectSort1 {
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
//		
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
		selectSort(arr);
		long endTime = System.currentTimeMillis();
		System.out.println("-----------排序前后【分割线】------------");
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

	// 选择排序：方法1【从无序序列中找出最小的那个元素，然后与无序序列最前面的那个元素交换位置】
	//从前往后排序
	public static void selectSort(int[] arr) {
		//在推导的过程，我们发现了规律，因此，可以使用for来解决
		//选择排序时间复杂度是 O(n^2)
		for (int i = 0; i < arr.length - 1; i++) {
			int minIndex = i;
			int min = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				if (min > arr[j]) { // 说明假定的最小值，并不是最小
					min = arr[j]; // 重置min
					minIndex = j; // 重置minIndex
				}
			}
			// 将最小值，放在arr[0], 即交换
			if (minIndex != i) {
				arr[minIndex] = arr[i];
				arr[i] = min;
			}
			//System.out.println("第"+(i+1)+"轮后~~");
			//System.out.println(Arrays.toString(arr));// 1, 34, 119, 101
		}
	}
}
