package sort04_希尔排序_ShellSort;
////希尔排序时， 对有序序列在插入时采用交换法, 

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import utils.Utils;

public class ShellSort1 {
	public static void main(String[] args) {
		// 为了容量理解，我们把冒泡排序的演变过程，给大家展示

		// 测试一下冒泡排序的速度O(n^2), 给80000个数据，测试
		// 创建要给80000个的随机的数组
		boolean isPrintArr = true;
		
		//长数组
//		int[] arr = new int[Utils.NUM];
//		int arrLength = arr.length;
//		isPrintArr = false;
//		for (int i = 0; i < arrLength; i++) {
//			arr[i] = (int) (Math.random() * arrLength); // 生成一个[0, 8000000) 数
//		}
//		
//		//短数组
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
		shellSort(arr);
		long endTime = System.currentTimeMillis();
		System.out.println("-----------ShellSort【交换式】排序前后【分割线】------------");
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
	//// 希尔排序时， 对有序序列在插入时采用交换法, 
	public static void shellSort(int[] arr) {
		int temp = 0;
		// 根据前面的逐步分析，使用循环处理
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < arr.length; i++) {
				// 遍历各组中所有的元素(共gap组，每组有个元素), 步长gap
				for (int j = i - gap; j >= 0; j -= gap) {
					// 如果当前元素大于加上步长后的那个元素，说明交换
					if (arr[j] > arr[j + gap]) {
						temp = arr[j];
						arr[j] = arr[j + gap];
						arr[j + gap] = temp;
					}
				}
			}
			//System.out.println("希尔排序第" + (++count) + "轮 =" + Arrays.toString(arr));
		}
	}
}
