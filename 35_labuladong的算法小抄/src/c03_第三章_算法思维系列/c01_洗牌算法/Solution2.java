package c03_第三章_算法思维系列.c01_洗牌算法;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

public class Solution2 {
	public static void main(String[] args) {
		Solution2 s = new Solution2();
//		for(int i = 0; i < 100; i++) {
//			System.out.println(s.randInt(0, 1));
//		}
		HashMap<String, Integer> map = new HashMap<>();
		for(int i = 0; i < 2400000; i++) {
			int[] arr = {1,2,3,4,5};
			s.shuffle(arr);
//			System.out.println(Arrays.toString(arr));
			String key = Arrays.toString(arr);
			map.put(key, map.getOrDefault(key, 0) + 1);
		}
		for(Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.toString());
		}
	}
	public int randInt(int min, int max) {
		//注意：(int)(Math.random()*(max - min) + min)
		//产生的区间范围是[min, max) 前闭后开
		return (int)(Math.random()*(max - min + 1) + min);
	}

	// 第一种写法
	private void shuffle(int[] arr) {
	    int n = arr.length;
	    /******** 区别只有这两行 ********/
	    for (int i = 0 ; i < n - 1; i++) {
	        // 从 i 到最后随机选一个元素
	        int rand = randInt(i, n - 1);
	        /*************************/
	        swap(arr, i, rand);
	    }
	}
	private void swap(int[] arr, int i, int rand) {
		// TODO Auto-generated method stub
		int temp = arr[i];
		arr[i] = arr[rand];
		arr[rand] = temp;
		
	}
}
