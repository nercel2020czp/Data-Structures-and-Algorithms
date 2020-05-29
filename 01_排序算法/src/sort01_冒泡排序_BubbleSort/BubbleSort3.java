package sort01_冒泡排序_BubbleSort;
//冒泡排序【优化2】：如果序列尾部已经局部有序，可以记录最后1次交换的位置，减少比较次数
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import utils.Utils;


public class BubbleSort3 {
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
	
	//冒泡排序【优化2】：如果序列尾部已经局部有序，可以记录最后1次交换的位置，减少比较次数
	public static void bubbleSort(int[] arr) {
		// 冒泡排序 的时间复杂度 O(n^2), 自己写出
		for (int i = arr.length - 1; i > 0; i--) {
			int sortedIndex = 1;//尾部有序序列的最小下标
			for (int j = 0; j < i; j++) {
				// 如果前面的数比后面的数大，则交换
				if (arr[j] > arr[j + 1]) {
					sortedIndex = j + 1;//已经发生交换了
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			//更改外层循环的结束下标
			i = sortedIndex;
		}
/*		for (int end = arr.length - 1; end > 0; end--) {
			int sortedIndex = 1;
			for (int begin = 1; begin <= end; begin++) {
				// if (array[begin] < array[begin - 1]) {
				if (cmp(begin, begin - 1) < 0) {
					swap(begin, begin - 1);
					sortedIndex = begin;
				}
			}
			end = sortedIndex;
		}*/
	}
}
