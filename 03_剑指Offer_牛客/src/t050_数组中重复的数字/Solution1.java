package t050_数组中重复的数字;

import java.util.Arrays;

/*1. 分析
将输入数组排序，再判断相邻位置是否存在相同数字，如果存在，对 duplication 赋值返回，否则继续比较

3. 复杂度
时间复杂度：O(nlogn)
空间复杂度：O(1)

*/
public class Solution1 {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication:
	//      (Output) the duplicated number in the array number,length of duplication array is 1,
	//         so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, 
	//                  duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false

	public boolean duplicate(int numbers[], int length, int[] duplication) {
		if (numbers == null || length == 0) {
			return false;
		}
		Arrays.sort(numbers);
		for (int i = 0; i < length - 1; i++) {
			if (numbers[i] == numbers[i + 1]) {
				duplication[0] = numbers[i];
				return true;
			}
		}
		return false;
	}
}
