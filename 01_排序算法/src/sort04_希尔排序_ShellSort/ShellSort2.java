package sort04_希尔排序_ShellSort;
//对交换式的希尔排序进行优化->移位法
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import utils.Utils;

public class ShellSort2 {
	
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
		System.out.println("-----------ShellSort【位移式】排序前后【分割线】------------");
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
	
	// 对交换式的希尔排序进行优化->移位法
	public static void shellSort(int[] arr) {
		// 增量gap, 并逐步的缩小增量
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			// 从第gap个元素，逐个对其所在的组进行直接插入排序
			for (int i = gap; i < arr.length; i++) {
				int j = i;
				int temp = arr[j];
				if (arr[j] < arr[j - gap]) {
					while (j - gap >= 0 && temp < arr[j - gap]) {
						// 移动
						arr[j] = arr[j - gap];
						j -= gap;
					}
					// 当退出while后，就给temp找到插入的位置
					arr[j] = temp;
				}

			}
		}
	}
}
