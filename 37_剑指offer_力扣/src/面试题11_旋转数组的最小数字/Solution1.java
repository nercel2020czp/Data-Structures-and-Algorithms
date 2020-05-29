package 面试题11_旋转数组的最小数字;
//方法一：二分（减治思想）
/*
题目中给出的是半有序数组，虽然传统二分告诉我们二分只能用在有序数组中，但事实上，只要是可以减治的问题，仍然可以使用二分思想。

思路：数组中最特殊的位置是左边位置 left 和右边位置 right，将它们与中间位置 mid 的值进行比较，进而判断最小数字出现在哪里。
	用左边位置 left 和中间位置 mid 的值进行比较是否可以？

举例：[3, 4, 5, 1, 2] 与 [1, 2, 3, 4, 5] ，此时，中间位置的值都比左边大，但最小值一个在后面，一个在前面，
因此这种做法不能有效地减治。
	用右边位置 right 和中间位置 mid 的值进行比较是否可以？
	
举例：[1, 2, 3, 4, 5]、[3, 4, 5, 1, 2]、[2, 3, 4, 5 ,1]，用右边位置和中间位置的元素比较，可以进一步缩小搜索的范围。


补充说明：遇到 nums[mid] == nums[right] 的时候，不能草率地下定结论最小数字在哪一边，
但是可以确定的是，把 right 舍弃掉，并不影响结果。


作者：liweiwei1419
链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/solution/er-fen-jian-zhi-si-xiang-fen-zhi-si-xiang-by-liwei/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

*/
public class Solution1 {

    // [3, 4, 5, 1, 2]
    // [1, 2, 3, 4, 5]
    // 不能使用左边数与中间数比较，这种做法不能有效地减治

    // [1, 2, 3, 4, 5]
    // [3, 4, 5, 1, 2]
    // [2, 3, 4, 5 ,1]

    public int minArray(int[] numbers) {
        int len = numbers.length;
        if (len == 0) {
            return 0;
        }
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            /*    @seekleetcode 您好，我是故意这样写的，>>> 是无符号右移，即使溢出了，高位依然是补 0，因此结论正确。我也是参考了 JDK 的源码。

            今天早上还看了一篇公众号的文章，即使是 /2，只要是 2 的方幂，Java 的编译器都会转成位运算去计算它，哈哈哈，这些东西知道就好了。*/
            if (numbers[mid] > numbers[right]) {
            	// 说明了最小值在区间 [mid + 1, right]
                // [3, 4, 5, 1, 2]，mid 以及 mid 的左边一定不是最小数字
                // 下一轮搜索区间是 [mid + 1, right]
                left = mid + 1;
            } else if (numbers[mid] == numbers[right]) {
                // 只能把 right 排除掉，下一轮搜索区间是 [left, right - 1]
                right = right - 1;
            } else {
                // 此时 numbers[mid] < numbers[right]
                // mid 的右边一定不是最小数字，mid 有可能是，下一轮搜索区间是 [left, mid]
                right = mid;
            }
        }

        // 最小数字一定在数组中，因此不用后处理
        return numbers[left];
    }
    
    

    
}

