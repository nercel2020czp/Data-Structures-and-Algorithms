package l_0051_N皇后_n_queens;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

//import org.junit.Test;

/*执行用时 :
3 ms
, 在所有 Java 提交中击败了
89.02%
的用户
内存消耗 :
39.8 MB
, 在所有 Java 提交中击败了
14.29%
的用户*/

public class Solution1 {
	
	private void printResult(List<List<String>> result) {
		// TODO Auto-generated method stub
		
		for(List<String> temp : result) {
			Iterator<String> iter = temp.iterator();
			while(iter.hasNext()) {
				System.out.print(iter.next() + "\t\t\t\t");
				System.out.println();
			}
			System.out.println("******************");
		}
		
		System.out.println(result.size());

	}
	
	public static void main(String[] args) {
		Solution1 s = new Solution1();
		s.printResult(s.solveNQueens(8));
		
	}
	
	private static List<String> charToString(char[][] array) {
		List<String> result = new LinkedList<>();
		for (char[] chars : array) {
			result.add(String.valueOf(chars));
		}
		return result;
	}

	/**
	 * 思考路径： 1. 定位这是backtrack problem 2. 思考决策树的构建过程 3. 思考回溯的模板
	 */
	// 决策树的每一层表示棋盘上的每一行；每个节点可以做出的选择是，在该行的任意一列放置一个皇后。
	List<List<String>> res;

	public List<List<String>> solveNQueens(int n) {
		if (n <= 0)
			return null;
		res = new LinkedList<>();
		char[][] board = new char[n][n];
		for (char[] chars : board)
			Arrays.fill(chars, '.');
		backtrack(board, 0);
		return res;
	}

	/**
	 * 路径：board中小于row的那些行都已经成功放置了皇后 可选择列表: 第row行的所有列都是放置Q的选择 结束条件: row超过board的最后一行
	 *
	 * @param board
	 * @param row
	 */
	private void backtrack(char[][] board, int row) {
		if (row == board.length) {
			res.add(charToString(board));
			return;
		}
		int n = board[row].length;
		for (int col = 0; col < n; col++) {
			if (!isValid(board, row, col))
				continue;
			board[row][col] = 'Q';
			backtrack(board, row + 1);
			board[row][col] = '.';
		}
	}

	private boolean isValid(char[][] board, int row, int col) {
		int rows = board.length;
		// check is valid in col
		for (char[] chars : board)
			if (chars[col] == 'Q')
				return false;
		// check is valide upright
		for (int i = row - 1, j = col + 1; i >= 0 && j < rows; i--, j++) {
			if (board[i][j] == 'Q')
				return false;
		}
		// check is valide upleft
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 'Q')
				return false;
		}
		return true;
	}

}
