package t028_数组中出现次数超过一半的数字;

import java.util.Arrays;
import java.util.stream.IntStream;

/*

利用Arrays工具类和IntStream流求解
	排序，取中间的数字，设为i
	用i过滤数组，如果为i的个数超过半数，则i为所求，否则结果为0

实用技巧
	Arrays.sort(array);可以对数组进行排序
	Stream实例.filter(过滤规则)可对流中的数据进行筛选

*/
public class Solution2 {
	public int MoreThanHalfNum_Solution(int[] array) {

		Arrays.sort(array);
		int i = array[array.length / 2];
		return IntStream.of(array).filter(k -> k == i).count() > array.length / 2 ? i : 0;
	}
}
