package sort03_插入排序_InsertSort;
//移位法式的直接插入排序
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import utils.Utils;

/*7.7 插入排序
7.7.1 插入排序法介绍:
	插入式排序属于内部排序法， 是对于欲排序的元素以插入的方式找寻该元素的适当位置， 以达到排序的目的。
	
7.7.2 插入排序法思想:
	插入排序（Insertion Sorting） 的基本思想是： 
		1. 把 n 个待排序的元素看成为一个有序表和一个无序表， 
		2. 开始时有序表中只包含一个元素， 无序表中包含有 n-1 个元素， 
		3. 排序过程中每次从无序表中取出第一个元素，
			把它的排序码依次与有序表元素的排序码进行比较， 
			将它插入到有序表中的适当位置， 使之成为新的有序表*/

public class InsertSort1 {
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
		System.out.println("-----------InsertSort【位移式】排序前后【分割线】------------");
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
	
	// 插入排序
	/*	1.插入排序非常类似于扑克牌的排序
	2.执行流程
		① 在执行过程中，插入排序会将序列分为2部分
			✓ 头部是已经排好序的，尾部是待排序的
		② 从头开始扫描每一个元素
			✓ 每当扫描到一个元素，就将它插入到头部合适的位置，使得头部数据依然保持有序
		【见图2.png】*/
	public static void insertSort(int[] arr) {
		int insertVal = 0;
		int insertIndex = 0;
		// 使用for循环来把代码简化
		for (int i = 1; i < arr.length; i++) {
			// 定义待插入的数
			insertVal = arr[i];
			insertIndex = i - 1; // 即arr[1]的前面这个数的下标

			// 给insertVal 找到插入的位置
			// 说明
			// 1. insertIndex >= 0 保证在给insertVal 找插入位置，不越界
			// 2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
			// 3. 就需要将 arr[insertIndex] 后移
			while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
				arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex]
				insertIndex--;
			}
			// 当退出while循环时，说明插入的位置找到, insertIndex + 1
			// 举例：理解不了，我们一会 debug
			// 这里我们判断是否需要赋值
			if (insertIndex + 1 != i) {
				arr[insertIndex + 1] = insertVal;
			}

			// System.out.println("第"+i+"轮插入");
			// System.out.println(Arrays.toString(arr));
		}
	}
}
