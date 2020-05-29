package l_1036_逃离大迷宫_escape_a_large_maze;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution1 {
	
/*	执行用时 :
		466 ms
		, 在所有 Java 提交中击败了
		44.49%
		的用户
		内存消耗 :
		48.3 MB
		, 在所有 Java 提交中击败了
		25.00%
		的用户*/
	
    static int dirs[][] = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
    static int limit = (int)1e6;
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<String> blocks = new HashSet<>();
        for(int block[] : blocked)
            blocks.add(block[0] + ":" + block[1]);
        return bfs(source, target, blocks) && bfs(target, source, blocks);
    }
    public boolean bfs(int[] source, int[] target, Set<String> blocks){
        Set<String> seen = new HashSet<>();
        seen.add(source[0] + ":" + source[1]);
        Queue<int[]> bfs = new LinkedList<>();
        bfs.offer(source);
        
        while(!bfs.isEmpty()){
            int cur[] = bfs.poll();
            for(int dir[] : dirs){
                int nextX = cur[0] + dir[0];
                int nextY = cur[1] + dir[1];
                if(nextX < 0 || nextY < 0 || nextX >= limit || nextY >= limit) continue;
                String key = nextX + ":" + nextY;
                if(seen.contains(key) || blocks.contains(key)) continue;
                if(nextX == target[0] && nextY == target[1]) return true;
                bfs.offer(new int[]{nextX, nextY});
                seen.add(key);
            }
            // 因为 blocked 的 length 是 200
            // 如果使用这 200 个 block 可以围成最大的区域是 19900，如下：
            /*
                0th      _________________
                        |O O O O O O O X
                        |O O O O O O X
                        |O O O O O X
                        |O O O O X
                        |O O O X
                        |O O X
                        |O X
                200th   |X
            从上面可以计算出 block（即 X）可以围城的最大区域(是一个角的三角形)，大小计算如下：
            1 + 2 + 3 + 4 + ... + 199 = (1 + 199) * 199 / 2 = 19900
            这里我们向上取整为 20000。
            */
            // 也就是说，如果迭代了 20000 步还能继续走的话，那么是肯定可以到达 target 的
            if(seen.size() == 20000) return true;
        }
        return false;
    }
}
