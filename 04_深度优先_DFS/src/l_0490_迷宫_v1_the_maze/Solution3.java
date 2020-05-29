package l_0490_迷宫_v1_the_maze;

import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

/*



 */
public class Solution3 {
	/**
	 * @author SHQ
	 * 
	 *         迷宫问题求解
	 * 
	 *         思路 递归+回溯
	 * 
	 *         按照右-->左-->下-->上的顺序寻路，已走过的路径用5标志
	 * 
	 * 
	 */

	public static void main(String[] args) {
		int maxRow, maxLine, p;
		Scanner in = new Scanner(System.in);
		Pattern pattern = Pattern.compile("[ ]+");
		String s = in.nextLine();
		String[] str = pattern.split(s);
		// 获取行
		maxRow = Integer.parseInt(str[0]);
		// 获取列
		maxLine = Integer.parseInt(str[1]);
		// 获取能量值
//	        p = Integer.parseInt(str[2]);

		int[][] array = new int[maxRow][maxLine];
		for (int i = 0; i < maxRow; i++) {
			for (int j = 0; j < maxLine; j++) {
				array[i][j] = in.nextInt();
			}
		}

		Long start = System.currentTimeMillis();
		new Solution3().check(0, 0, array, maxRow, maxLine);
		Long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - start) + "ms");
	}

	/**
	 * 制定走的规则
	 * 
	 * @param i
	 * @param j
	 * @param array
	 * @param maxRow
	 * @param maxLine
	 */
	private void check(int i, int j, int[][] array, int maxRow, int maxLine) {
		// 递归出口(如果到达右下角出口)
		if (i == maxRow - 1 && j == maxLine - 1) {
			print(array, maxRow, maxLine);
			return;
		}

		// 向右走
		if (canMove(i, j, i, j + 1, array, maxRow, maxLine)) {
			// 已走过的点置标志位5
			array[i][j] = 5;
			// 从下一个点继续寻路
			check(i, j + 1, array, maxRow, maxLine);
			// 均不可行，则恢复现场
			array[i][j] = 0;
		}
		// 向左走
		if (canMove(i, j, i, j - 1, array, maxRow, maxLine)) {
			// 标记为已走
			array[i][j] = 5;
			// 递归调用
			check(i, j - 1, array, maxRow, maxLine);
			array[i][j] = 0;
		}
		// 向下走
		if (canMove(i, j, i + 1, j, array, maxRow, maxLine)) {
			array[i][j] = 5;
			check(i + 1, j, array, maxRow, maxLine);
			array[i][j] = 0;
		}
		// 向上走
		if (canMove(i, j, i - 1, j, array, maxRow, maxLine)) {
			array[i][j] = 5;
			check(i - 1, j, array, maxRow, maxLine);
			array[i][j] = 0;
		}
	}

	/**
	 * 判断[i,j]-->[targetI,targetJ]是否可行
	 * 
	 * @param i
	 * @param j
	 * @param targetI
	 * @param targetJ
	 * @param array
	 * @param maxRow
	 * @param maxLine
	 * @return boolean 可否通过
	 */
	private boolean canMove(int i, int j, int targetI, int targetJ, int[][] array, int maxRow, int maxLine) {
//	        System.out.println("从第" + (i + 1) + "行第" + (j + 1) + "列，走到第" + (targetI + 1) + "行第" + (targetJ + 1) + "列");  
		if (targetI < 0 || targetJ < 0 || targetI >= maxRow || targetJ >= maxLine) {
//	            System.out.println("到达最左边或最右边，失败了");  
			return false;
		}
		if (array[targetI][targetJ] == 1) {
//	            System.out.println("目标是墙，失败了");  
			return false;
		}
		// 避免在两个空格间来回走
		if (array[targetI][targetJ] == 5) {
//	            System.out.println("来回走，失败了");  
			return false;
		}

		return true;
	}

	/**
	 * 打印可行路径
	 * 
	 * @param array
	 * @param maxRow
	 * @param maxLine
	 */
	private void print(int[][] array, int maxRow, int maxLine) {
		System.out.println("得到一个解：");
		for (int i = 0; i < maxRow; i++) {
			for (int j = 0; j < maxLine; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}

}