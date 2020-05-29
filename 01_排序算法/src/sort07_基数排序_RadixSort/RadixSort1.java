package sort07_基数排序_RadixSort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import utils.Utils;

public class RadixSort1 {
	
	public static void main(String[] args) {
		// 为了容量理解，我们把冒泡排序的演变过程，给大家展示

		// 测试一下冒泡排序的速度O(n^2), 给80000个数据，测试
		// 创建要给80000个的随机的数组
		boolean isPrintArr = true;
		
//		//长数组
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
		radixSort(arr);
		long endTime = System.currentTimeMillis();
		System.out.println("-----------RadixSort排序前后【分割线】------------");
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
	
	
	// 基数排序方法
	public static void radixSort(int[] arr) {
		// 根据前面的推导过程，我们可以得到最终的基数排序代码

		// 1. 得到数组中最大的数的位数
		int max = arr[0]; // 假设第一数就是最大数
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		// 得到最大数是几位数
		int maxLength = (max + "").length();

		// 定义一个二维数组，表示10个桶, 每个桶就是一个一维数组
		// 说明
		// 1. 二维数组包含10个一维数组
		// 2. 为了防止在放入数的时候，数据溢出，则每个一维数组(桶)，大小定为arr.length
		// 3. 名明确，基数排序是使用空间换时间的经典算法
		int[][] bucket = new int[10][arr.length];

		// 为了记录每个桶中，实际存放了多少个数据,我们定义一个一维数组来记录各个桶的每次放入的数据个数
		// 可以这里理解
		// 比如：bucketElementCounts[0] , 记录的就是 bucket[0] 桶的放入数据个数
		int[] bucketElementCounts = new int[10];

		// 这里我们使用循环将代码处理

		for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
			// (针对每个元素的对应位进行排序处理)， 第一次是个位，第二次是十位，第三次是百位..
			for (int j = 0; j < arr.length; j++) {
				// 取出每个元素的对应位的值
				int digitOfElement = arr[j] / n % 10;
				// 放入到对应的桶中
				bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
				bucketElementCounts[digitOfElement]++;
			}
			// 按照这个桶的顺序(一维数组的下标依次取出数据，放入原来数组)
			int index = 0;
			// 遍历每一桶，并将桶中是数据，放入到原数组
			for (int k = 0; k < bucketElementCounts.length; k++) {
				// 如果桶中，有数据，我们才放入到原数组
				if (bucketElementCounts[k] != 0) {
					// 循环该桶即第k个桶(即第k个一维数组), 放入
					for (int l = 0; l < bucketElementCounts[k]; l++) {
						// 取出元素放入到arr
						arr[index++] = bucket[k][l];
					}
				}
				// 第i+1轮处理后，需要将每个 bucketElementCounts[k] = 0 ！！！！
				bucketElementCounts[k] = 0;

			}
			// System.out.println("第"+(i+1)+"轮，对个位的排序处理 arr =" + Arrays.toString(arr));

		}
	}
}
