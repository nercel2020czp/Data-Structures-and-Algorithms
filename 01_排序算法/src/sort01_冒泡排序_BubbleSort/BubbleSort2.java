package sort01_冒泡排序_BubbleSort;
//优化1：如果序列已经完全有序，可以提前终止冒泡排序
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import utils.Utils;

public class BubbleSort2 {
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
		bubbleSort(arr);
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

	// 优化1：如果序列已经完全有序，可以提前终止冒泡排序
	public static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			boolean flag = false; // 标识变量，表示是否进行过交换
			for (int j = 0; j < arr.length - 1 - i; j++) {
				// 如果前面的数比后面的数大，则交换
				if (arr[j] > arr[j + 1]) {
					flag = true;//改变标志位
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}

			}
			// 在一趟排序中，一次交换都没有发生过
			if (!flag) break;
		}
	}
}
