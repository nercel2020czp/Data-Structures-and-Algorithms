package sort08___堆排序_HeapSort;
//自下而上的下滤【建堆】
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import utils.Utils;

public class HeapSort1 {
	public static void main(String[] args) {
		// 为了容量理解，我们把冒泡排序的演变过程，给大家展示

//		// 测试一下冒泡排序的速度O(n^2), 给80000个数据，测试
//		// 创建要给80000个的随机的数组
		boolean isPrintArr = true;
//		
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
		heapSort(arr);
		long endTime = System.currentTimeMillis();
		System.out.println("-----------HeapSort排序前后【分割线】------------");
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

	// 编写一个堆排序的方法
	public static void heapSort(int arr[]) {
		//建堆【自下而上的建堆】
		heapify(arr);
		//开始排序
		for(int i = arr.length - 1; i > 0; i--) {
			//取出堆顶元素
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			//对剩下的元素进行siftDown操作
			siftDown(arr, 0, i);
		}
		
	}

	////建堆【自下而上的建堆】
	private static void heapify(int[] arr) {
		if(arr == null) return;
		int size = arr.length;
		for(int i = (size >> 1) - 1; i >= 0; i--)
			//自下而上
			siftDown(arr, i, size);//下滤
	}

	private static void siftDown(int[] arr, int index, int size) {
		if(arr == null) return;
		
		int element = arr[index];
		int half = size >> 1;
		
		while(index < half) {//index必须是非叶子节点
			//默认是左边跟父节点比
			int childIndex = (index << 1) + 1;
			int child = arr[childIndex];
			
			int rightChildIndex = childIndex + 1;
			//右子节点比左子节点大
			if(rightChildIndex < size 
					&& arr[rightChildIndex] > child) {
				child = arr[childIndex = rightChildIndex];
			}
			
			//如果index处的元素大于等于子节点
			if(element >= child) break;
			
			arr[index] = child;
			index = childIndex;
			
		}
		arr[index] = element;
	}
}
