package 面试题13_机器人的运动范围;

import java.util.LinkedList;
import java.util.Queue;

/*方法二：广度优先遍历 BFS
	1.BFS/DFS ： 两者目标都是遍历整个矩阵，不同点在于搜索顺序不同。
	  DFS 是朝一个方向走到底，再回退，以此类推；BFS 则是按照“平推”的方式向前搜索。
	2.BFS 实现： 通常利用队列实现广度优先遍历。

算法解析：
	1.初始化： 将机器人初始点 (0,0) 加入队列 queue ；
	2.迭代终止条件： queue 为空。代表已遍历完所有可达解。
	3.迭代工作：
		3.1 单元格出队： 将队首单元格的 索引、数位和 弹出，作为当前搜索单元格。
		3.2 判断是否跳过： 若 ① 行列索引越界 或 ② 数位和超出目标值 k 或 ③ 
		        当前元素已访问过 时，执行 continue 。
        3.3 标记当前单元格 ：将单元格索引 (i, j) 存入 Set visited 中，
                          代表此单元格 已被访问过 。
        3.4 单元格入队： 将当前元素的 下方、右方 单元格的 索引、数位和 加入 queue 。
    4.返回值： Set visited 的长度 len(visited) ，即可达解的数量。
    
Java 使用了辅助变量 res 统计可达解数量； Python 直接返回 Set 的元素数即可。
见如下图
https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/solution/mian-shi-ti-13-ji-qi-ren-de-yun-dong-fan-wei-dfs-b/

复杂度分析：
	M,N 分别为矩阵行列大小。
	时间复杂度 O(MN) ： 最差情况下，机器人遍历矩阵所有单元格，此时时间复杂度为 O(MN) 。
	空间复杂度 O(MN) ： 最差情况下，Set visited 内存储矩阵所有单元格的索引，使用 O(MN) 的额外空间。
	
代码：
	Java 代码中 visited 为辅助矩阵，Python 中为 Set 。

*/
class Solution2 {
/*	方法二：广度优先遍历 BFS
	1.BFS/DFS ： 两者目标都是遍历整个矩阵，不同点在于搜索顺序不同。
	  DFS 是朝一个方向走到底，再回退，以此类推；BFS 则是按照“平推”的方式向前搜索。
	2.BFS 实现： 通常利用队列实现广度优先遍历。*/
    public int movingCount(int m, int n, int k) {
/*  算法解析：
    	1.初始化： 将机器人初始点 (0,0) 加入队列 queue ；
    	2.迭代终止条件： queue 为空。代表已遍历完所有可达解。
    	3.迭代工作：
    		3.1 单元格出队： 将队首单元格的 索引、数位和 弹出，作为当前搜索单元格。
    		3.2 判断是否跳过： 若 ① 行列索引越界 或 ② 数位和超出目标值 k 或 ③ 
    		        当前元素已访问过 时，执行 continue 。
            3.3 标记当前单元格 ：将单元格索引 (i, j) 存入 Set visited 中，
                              代表此单元格 已被访问过 。
            3.4 单元格入队： 将当前元素的 下方、右方 单元格的 索引、数位和 加入 queue 。
        4.返回值： Set visited 的长度 len(visited) ，即可达解的数量。*/
    	//1.初始化： 将机器人初始点 (0,0) 加入队列 queue ；
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        Queue<int[]> queue= new LinkedList<int[]>();
        queue.add(new int[] { 0, 0, 0, 0 });
        //2.迭代终止条件： queue 为空。代表已遍历完所有可达解。
        //3.迭代工作：
        while(queue.size() > 0) {
        	//3.1 单元格出队： 将队首单元格的 索引、数位和 弹出，作为当前搜索单元格。
            int[] x = queue.poll();
            int i = x[0], j = x[1], si = x[2], sj = x[3];
            //3.2 判断是否跳过： 若 ① 行列索引越界 或 ② 数位和超出目标值 k 或 ③ 
	        	//当前元素已访问过 时，执行 continue 。
            if(i < 0 || i >= m || j < 0 || j >= n 
            		|| k < si + sj || visited[i][j]) 
            	continue;
            //3.3 标记当前单元格 ：将单元格索引 (i, j) 存入 Set visited 中，
            	//代表此单元格 已被访问过 。
            visited[i][j] = true;
            res ++;
            //3.4 单元格入队： 将当前元素的 下方、右方 单元格的 索引、数位和 加入 queue 。
            queue.add(new int[] { i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj });
            queue.add(new int[] { i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8 });
        }
        //4.返回值： Set visited 的长度 len(visited) ，即可达解的数量。
        return res;
    }
/*    
    执行用时 :
    	8 ms
    	, 在所有 Java 提交中击败了
    	15.29%
    	的用户
    	内存消耗 :
    	37.5 MB
    	, 在所有 Java 提交中击败了
    	100.00%
    	的用户
    */
    
}

/*作者：jyd
链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/solution/mian-shi-ti-13-ji-qi-ren-de-yun-dong-fan-wei-dfs-b/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
