package 面试题12_矩阵中的路径;
/*
解题思路：
	本问题是典型的矩阵搜索问题，可使用 深度优先搜索（DFS）+ 剪枝 解决。

算法原理：
	深度优先搜索： 可以理解为暴力法遍历矩阵中所有字符串可能性。
	DFS 通过递归，先朝一个方向搜到底，再回溯至上个节点，沿另一个方向搜索，以此类推。
	剪枝： 在搜索中，遇到 这条路不可能和目标字符串匹配成功 的情况（例如：此矩阵元素和目
	标字符不同、此元素已被访问），则应立即返回，称之为 可行性剪枝 。

算法剖析：
	递归参数： 当前元素在矩阵 board 中的行列索引 i 和 j ，当前目标字符在 word 中的索引 k 。
	
	终止条件：
		1.返回 false ： ① 行或列索引越界 或 
					 ② 当前矩阵元素与目标字符不同 或 
					 ③ 当前矩阵元素已访问过 （③ 可合并至 ② ） 。
		2.返回 true ： 字符串 word 已全部匹配，即 k = len(word) - 1 。
		
	递推工作：
		1.标记当前矩阵元素： 将 board[i][j] 值暂存于变量 tmp ，并修改为字符 '/' ，
		    代表此元素已访问过，防止之后搜索时重复访问。
	    2.搜索下一单元格： 朝当前元素的 上、下、左、右 四个方向开启下层递归，使用 或 
	             连接 （代表只需一条可行路径） ，并记录结果至 res。
        3.还原当前矩阵元素： 将 tmp 暂存值还原至 board[i][j] 元素。
        
	回溯返回值： 返回 res，代表是否搜索到目标字符串。
	
图解中【见链接】，从每个节点 DFS的顺序为：下、上、右、左。
https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/solution/mian-shi-ti-12-ju-zhen-zhong-de-lu-jing-shen-du-yo/

复杂度分析：
	M,N 分别为矩阵行列大小， K 为字符串 word 长度。
	
	1.时间复杂度 O(MN*3^K)O： 最差情况下，需要遍历矩阵中长度为 K 字符串的所有方案，时间复杂度为 O(3^K)；
	    矩阵中共有 MN 个起点，时间复杂度为 O(MN)。
	    	方案数计算： 设字符串长度为 K，搜索中每个字符有上、下、左、右四个方向可以选择，
	    	      舍弃回头（上个字符）的方向，剩下 3 种选择，因此方案数的复杂度为 O(3^K)。
    2.空间复杂度 O(K) ： 搜索过程中的递归深度不超过 K ，因此系统因函数调用累计使用的栈空间占用 O(K) 
            （因为函数返回后，系统调用的栈空间会释放）。最坏情况下 K=MN ，递归深度为 MN ，此时系统栈使用 O(MN) 的额外空间。

作者：jyd
链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/solution/mian-shi-ti-12-ju-zhen-zhong-de-lu-jing-shen-du-yo/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
public class Solution1 {
/*	解题思路：
	本问题是典型的矩阵搜索问题，可使用 深度优先搜索（DFS）+ 剪枝 解决。*/
    public boolean exist(char[][] board, String word) {
/*    	算法原理：
    	深度优先搜索： 可以理解为暴力法遍历矩阵中所有字符串可能性。
    	DFS 通过递归，先朝一个方向搜到底，再回溯至上个节点，沿另一个方向搜索，以此类推。
    	剪枝： 在搜索中，遇到 这条路不可能和目标字符串匹配成功 的情况（例如：此矩阵元素和目
    	标字符不同、此元素已被访问），则应立即返回，称之为 可行性剪枝 。*/
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }
    

    /*
     * @Description
     * @author BruceChen
     * @date 2020年2月27日上午8:34:48
     * @param board
     * @param word
     * @param i 在矩阵 board 中的行列索引 i 和 j
     * @param j 在矩阵 board 中的行列索引 i 和 j
     * @param k 当前目标字符在 word 中的索引 k 
     * @return
     */
//  递归参数： 当前元素在矩阵 board 中的行列索引 i 和 j ，当前目标字符在 word 中的索引 k 。
    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
/*    	终止条件：
		1.返回 false ： ① 行或列索引越界 或 
					 ② 当前矩阵元素与目标字符不同 或 
					 ③ 当前矩阵元素已访问过 （③ 可合并至 ② ） 。
		2.返回 true ： 字符串 word 已全部匹配，即 k = len(word) - 1 。*/
    	
        if(i >= board.length || i < 0 || j >= board[0].length 
        		|| j < 0 || board[i][j] != word[k]) 
        	return false;
        if(k == word.length - 1) return true;
        
        
        /*        
    	递推工作：
		1.标记当前矩阵元素： 将 board[i][j] 值暂存于变量 tmp ，并修改为字符 '/' ，
		    代表此元素已访问过，防止之后搜索时重复访问。
	    2.搜索下一单元格： 朝当前元素的 上、下、左、右 四个方向开启下层递归，使用 或 
	             连接 （代表只需一条可行路径） ，并记录结果至 res。
        3.还原当前矩阵元素： 将 tmp 暂存值还原至 board[i][j] 元素。
         */
        char tmp = board[i][j];
        board[i][j] = '/';
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) 
        		|| dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
        board[i][j] = tmp;
        return res;
    }
/*    
    执行用时 :
    	5 ms
    	, 在所有 Java 提交中击败了
    	98.07%
    	的用户
    	内存消耗 :
    	43.5 MB
    	, 在所有 Java 提交中击败了
    	100.00%
    	的用户
   */ 
}
