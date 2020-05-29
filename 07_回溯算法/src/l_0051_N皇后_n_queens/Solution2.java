package l_0051_N皇后_n_queens;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
/**
 *   优化isValid的查询,通过3个set来分别记录列;主对角线;副对角线上Q的情况,减少迭代的查询
 * Key值：colIndex, [r-c], [r + c] 作为set的key
 */
/*执行用时 :
7 ms
, 在所有 Java 提交中击败了
35.81%
的用户
内存消耗 :
40.5 MB
, 在所有 Java 提交中击败了
8.57%
的用户*/
public class Solution2 {
	private static List<String> charToString(char[][] array) {
        List<String> result = new LinkedList<>();
        for (char[] chars : array) {
            result.add(String.valueOf(chars));
        }
        return result;
    }


    private List<List<String>> res = new LinkedList<>();
    private Set<Integer> colSet = new HashSet<>();
    private Set<Integer> masterSet = new HashSet<>();
    private Set<Integer> slaveSet = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] chars : board) Arrays.fill(chars, '.');
        backtrack(board, 0);
        return res;
    }

    /**
     * path: board in [0, row -1]
     * choices for a row : every cols
     * time to end: row == board.length
     *
     * @param board
     * @param row
     */
    private void backtrack(char[][] board, int row) {
        if (row == board.length) {
            res.add(charToString(board));
            return;
        }
        for (int col = 0; col < board[row].length; col++) {
            if (!isValide(board, row, col)) continue;
            updateRecords(board, row, col);
            backtrack(board, row + 1);
            updateRecords(board, row, col);
        }
    }

    private void updateRecords(char[][] board, int row, int col) {
        if (colSet.contains(col)) {
            board[row][col] = '.';
            colSet.remove(col);
            masterSet.remove(row - col);
            slaveSet.remove(row + col);
        } else {
            board[row][col] = 'Q';
            colSet.add(col);
            masterSet.add(row - col);
            slaveSet.add(row + col);
        }
    }

    private boolean isValide(char[][] board, int row, int col) {
        return !colSet.contains(col)
                && !masterSet.contains(row - col)
                && !slaveSet.contains(row + col);
    }

}
