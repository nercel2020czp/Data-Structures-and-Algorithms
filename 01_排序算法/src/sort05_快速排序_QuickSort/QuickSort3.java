package sort05_快速排序_QuickSort;
/*
当递归到规模较小时，可以使用插入排序算法进行优化
*/
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Stack;

import utils.Utils;

public class QuickSort3 {
	public static void main(String[] args) {
		// 为了容量理解，我们把冒泡排序的演变过程，给大家展示

		// 测试一下冒泡排序的速度O(n^2), 给80000个数据，测试
		// 创建要给80000个的随机的数组
		boolean isPrintArr = true;
		
		//长数组
		int[] data = new int[Utils.NUM];
		int dataLength = data.length;
		isPrintArr = false;
		for (int i = 0; i < dataLength; i++) {
			data[i] = (int) (Math.random() * dataLength); // 生成一个[0, 8000000) 数
		}
//		
//		//短数组
//		int[] data = new int[] { 10, 5, 1, 2, 4, 9, 8, 7, 6, 3 };

		System.out.println("排序前：");
		if(isPrintArr) {
			System.out.println(Arrays.toString(data));
		}
		Date date1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(date1);
		System.out.println("排序前的时间是=" + date1Str);

		System.out.println("开始排序....");
		// 测试冒泡排序
		long startTime = System.currentTimeMillis();
		quickSort(data);
		long endTime = System.currentTimeMillis();
		System.out.println("-----------QuickSort【非递归】排序前后【分割线】------------");
		System.out.println("结束排序....");
		
		System.out.println("排序前后：");
		Date date2 = new Date();
		String date2Str = simpleDateFormat.format(date2);
		if(isPrintArr) {
			System.out.println(Arrays.toString(data));
		}
		System.out.println("排序后的时间是=" + date2Str);
		System.out.println("排序所花时间是=" + (endTime - startTime) + "ms");
	}
	//快速排序【非递归版】
	public static void quickSort(int[] data){
		if (data == null || data.length == 0) {
            return;
        }
        int left = 0;
        int right = data.length - 1;
        Stack<Integer> stack = new Stack<>();
        stack.push(left);
        stack.push(right);
        while (!stack.isEmpty()) {
            // 取出栈顶元素
            right = stack.pop();
            left = stack.pop();
            if (left < right) {
                int criticalPoint = partition(data, left, right);
                stack.push(left);
                stack.push(criticalPoint - 1);
                stack.push(criticalPoint + 1);
                stack.push(right);
            }
        }
	}
	
	private static int partition(int[] data, int start, int end) {
		int pivot = data[start];
		int low = start;
		int high = end + 1;
		while (true) {
			// 从左往右，找到第一个大于pivot的数
			while (low < end && data[++low] - pivot <= 0);
			// 从右往左，找到第一个小于pivot的数
			while (high > start && data[--high] - pivot >= 0);
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
				swap(data, start, high);
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
