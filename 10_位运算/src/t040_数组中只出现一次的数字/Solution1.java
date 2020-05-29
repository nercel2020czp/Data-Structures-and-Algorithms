package t040_数组中只出现一次的数字;

import java.util.HashMap;

//可以先用最简单的HashMap的方法来做，这样主要是为了联系Map的用法。
public class Solution1 {

	public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
		// 哈希算法
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < array.length; i++) {
			if (map.containsKey(array[i]))
				map.put(array[i], 2);
			else
				map.put(array[i], 1);
		}
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (map.get(array[i]) == 1) {
				if (count == 0) {
					num1[0] = array[i];
					count++;
				} else
					num2[0] = array[i];
			}
		}

	}
}
