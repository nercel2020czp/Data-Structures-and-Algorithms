package t001_二维数组中的查找;
///剑指offer_力扣/src/面试题04_二维数组中的查找/Solution1.java
/*
解题思路：
若使用暴力法遍历矩阵 matrix ，则时间复杂度为 O(N*M)。暴力法未利用矩阵 “从上到下递增、
从左到右递增” 的特点，显然不是最优解法。本题解利用矩阵特点引入标志数，并通过标志数性质降
低算法时间复杂度。

标志数引入： 此类矩阵中左下角和右上角元素有特殊性，称为标志数。
	左下角元素： 为所在列最大元素，所在行最小元素。
	右上角元素： 为所在行最大元素，所在列最小元素。
标志数性质： 将 matrix 中的左下角元素（标志数）记作 flag ，则有:
	1.若 flag > target ，则 target 一定在 flag 所在行的上方，即 flag 所在行可被消去。
	2.若 flag < target ，则 target 一定在 flag 所在列的右方，即 flag 所在列可被消去。
	本题解以左下角元素为例，同理，右上角元素 也具有行（列）消去的性质。	

算法流程： 根据以上性质，设计算法在每轮对比时消去一行（列）元素，以降低时间复杂度。
	1.从矩阵 matrix 左下角元素（索引设为 (i, j) ）开始遍历，并与目标值对比：
		当 matrix[i][j] > target 时： 行索引向上移动一格（即 i--），即消去矩阵第 i 行元素；
		当 matrix[i][j] < target 时： 列索引向右移动一格（即 j++），即消去矩阵第 j 列元素；
		当 matrix[i][j] == target 时： 返回 true 。
	2.若行索引或列索引越界，则代表矩阵中无目标值，返回 false。

算法本质： 每轮 i 或 j 移动后，相当于生成了“消去一行（列）的新矩阵”， 索引(i,j) 指向新矩阵的左下角元素
	       （标志数），因此可重复使用以上性质消去行（列）

复杂度分析：
	时间复杂度 O(M+N) ：其中，N 和 M 分别为矩阵行数和列数，此算法最多循环 M+N 次。
	空间复杂度 O(1) : i, j 指针使用常数大小额外空间。
	
	
作者：jyd
链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/solution/mian-shi-ti-04-er-wei-shu-zu-zhong-de-cha-zhao-zuo/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

*/

public class Solution2 {
	public boolean Find(int target, int[][] array) {
		int rows = array.length;
		if (rows == 0) {
			return false;
		}
		int cols = array[0].length;
		if (cols == 0) {
			return false;
		}
		// 左下
		int row = rows - 1;
		int col = 0;
		while (row >= 0 && col < cols) {
			if (array[row][col] < target) {
				col++;//往右边走
			} else if (array[row][col] > target) {
				row--;//往左边走
			} else {
				return true;
			}
		}
		return false;
	}
}