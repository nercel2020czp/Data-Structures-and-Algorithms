package sort03_插入排序_InsertSort;
//交换法式的直接插入排序
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import utils.Utils;

public class InsertSort2 {
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
		insertSort(arr);
		long endTime = System.currentTimeMillis();
		System.out.println("-----------InsertSort【交换式】排序前后【分割线】------------");
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
	
/*	1.插入排序非常类似于扑克牌的排序
	2.执行流程
		① 在执行过程中，插入排序会将序列分为2部分
			✓ 头部是已经排好序的，尾部是待排序的
		② 从头开始扫描每一个元素
			✓ 每当扫描到一个元素，就将它插入到头部合适的位置，使得头部数据依然保持有序
		【见图2.png】*/
	//这种方法，性能稍慢
	public static void insertSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int cur = i;
			while(cur > 0 && arr[cur] - arr[cur - 1] < 0) {
				int temp = arr[cur];
				arr[cur] = arr[cur - 1];
				arr[cur - 1] = temp;
				cur--;
			}
		}
	}
}
