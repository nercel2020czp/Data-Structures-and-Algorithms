package l_0283_移动零;
/*
一次遍历:
这里参考了快速排序的思想，快速排序首先要确定一个待分割的元素做中间点x，然后把所有小于等于x的元素放到x的左边，大于x的元素放到其右边。
这里我们可以用0当做这个中间点，把不等于0(注意题目没说不能有负数)的放到中间点的左边，等于0的放到其右边。
这的中间点就是0本身，所以实现起来比快速排序简单很多，我们使用两个指针i和j，只要nums[i]!=0，我们就交换nums[i]和nums[j]
请对照动态图来理解：

时间复杂度:O(n)
空间复杂度:O(1)
代码实现:

作者：wang_ni_ma
链接：https://leetcode-cn.com/problems/move-zeroes/solution/dong-hua-yan-shi-283yi-dong-ling-by-wang_ni_ma/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Solution2 {
	class Solution {
		public void moveZeroes(int[] nums) {
			if(nums==null) {
				return;
			}
			//两个指针i和j
			int j = 0;
			for(int i=0;i<nums.length;i++) {
				//当前元素!=0，就把其交换到左边，等于0的交换到右边
				if(nums[i]!=0) {
					int tmp = nums[i];
					nums[i] = nums[j];
					nums[j++] = tmp;
				}
			}
		}
		//第二种解法看了确实很精彩。我看了一下国际站的讨论，搬运了一个可优化解法二的代码。代码如下：
//		其实优化的地方就是#1处。它避免了数组开头是非零元素的交换也就是阻止（i==j）时交换。
//				当i > j 时，只需要把 i 的值赋值给j 并把原位置的值置0。
//				同时这里也把交换操作换成了赋值操作，减少了一条操作语句，理论上能更节省时间。
		public void moveZeroes1(int[] nums)  {
		    int length;
		    if (nums == null || (length = nums.length) == 0) {
		        return;
		    }
		    int j = 0;
		    for (int i = 0; i < length; i++) {
		        if (nums[i] != 0) {
		            if (i > j) {// #1
		                nums[j] = nums[i];
		                nums[i] = 0;
		            }
		            j++;
		        }
		    }
/*		    执行用时 :
		    	0 ms
		    	, 在所有 Java 提交中击败了
		    	100.00%
		    	的用户
		    	内存消耗 :
		    	40.7 MB
		    	, 在所有 Java 提交中击败了
		    	5.62%
		    	的用户*/
		}
	}	
}
