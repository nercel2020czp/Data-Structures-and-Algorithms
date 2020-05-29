package t013_调整数组顺序使奇数位于偶数前面;
/*题目描述

输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分。



思路

1，非进阶
利用快速排序的思想，数组头尾各设置一个标记，头标记只会向右走，尾标记只会向左走，当头标记发现偶数，
尾标记发现奇数的时候进行交换，直到头标记的位置大于尾标记。
*/
public class Solution0 {
    public void reOrderArray(int [] array) {
        if(array==null||array.length==0){
            return;
        }
        int start = 0;
        int end = array.length-1;
        while(start <end){
            while(array[start]%2 ==0&&start <end){
                start++;
            }
            while(array[end]%2 !=0&&start <end){
                end--;
            }
            if(start < end){
                swap(array, start, end);
            }
        }
    }

    static public void swap(int[] array, int i , int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
/*    2,进阶
    要想保证顺序，那么交换只能发生在相邻元素之间或顺序移动，同样的使用两个标记，
    第一个标记start从数组头出发，当找到第一个偶数后，第二个标记end从找到偶数的后
    一个位置出发找奇数，然后将start到end-1的元素整体后移，将end的元素赋予
    start位置.*/
	public void reOrderArray1(int[] array) {
		if (array == null || array.length == 0) {
			return;
		}
		int start = 0;
		int end = 0;
		while (start < array.length) {
			while (start < array.length && (array[start] % 2 != 0)) {
				start++;
			}
			end = start + 1;
			while (end < array.length && (array[end] % 2 == 0)) {
				end++;
			}
			if (end < array.length) {
				int temp = array[end];
				for (int i = end - 1; i >= start; i--) {
					array[i + 1] = array[i];
				}
				array[start++] = temp;
			} else {
				break;
			}
		}
	}
    
}
