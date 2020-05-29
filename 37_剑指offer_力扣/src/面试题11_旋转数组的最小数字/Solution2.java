package 面试题11_旋转数组的最小数字;
/*方法二：分治
我写分治的时候，还是写成了二分。因为二分的减治思想本来就是分治思想的特殊情况。*/
public class Solution2 {

    public int minArray(int[] numbers) {
        int len = numbers.length;
        if (len == 0) {
            return 0;
        }

        return minArray(numbers, 0, len - 1);
    }

    /**
     * 在子区间 [left, right] 里查找最小值
     *
     * @param numbers
     * @param left
     * @param right
     * @return
     */
    private int minArray(int[] numbers, int left, int right) {
        if (left == right) {
            return numbers[left];
        }

        int mid = (left + right) >>> 1;
        /*    @seekleetcode 您好，我是故意这样写的，>>> 是无符号右移，即使溢出了，高位依然是补 0，因此结论正确。我也是参考了 JDK 的源码。
        今天早上还看了一篇公众号的文章，即使是 /2，只要是 2 的方幂，Java 的编译器都会转成位运算去计算它，哈哈哈，这些东西知道就好了。*/
        if (numbers[mid] > numbers[right]) {
            return minArray(numbers, mid + 1, right);
        } else if (numbers[mid] == numbers[right]) {
            return minArray(numbers, left, right - 1);
        } else {
            return minArray(numbers, left, mid);
        }
    }
    
/*    执行用时 :
    	0 ms
    	, 在所有 Java 提交中击败了
    	100.00%
    	的用户
    	内存消耗 :
    	39.1 MB
    	, 在所有 Java 提交中击败了
    	100.00%
    	的用户*/
}

/*作者：liweiwei1419
链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/solution/er-fen-jian-zhi-si-xiang-fen-zhi-si-xiang-by-liwei/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
