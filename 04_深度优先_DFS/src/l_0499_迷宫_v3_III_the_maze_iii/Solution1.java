package l_0499_迷宫_v3_III_the_maze_iii;

import java.util.PriorityQueue;
import java.util.Queue;

/*
 * 广度优先遍历
解题思路
1：定义PriorityQueue进行BFS。
2：定义director方便四个方向扩展
3：定义directStr方便获取ways的字符
4：定义对象Point，并重写compareTo，方便后续进行对象操作
5：定义二维数组dp[][]，用来存储到达该坐标的最小对象。（通过compareTo比较，不断刷新）
6：如果更新了dp[][]，该坐标重新加入queue
注意：起始点的坐标不要重新加入queue。（判断：(nextX != point.x || nextY != point.y)）

作者：aidenmum
链接：https://leetcode-cn.com/problems/the-maze-iii/solution/bfsbing-tong-guo-er-wei-shu-zu-ji-lu-guo-cheng-ji-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

public class Solution1 {
/*	执行用时 :
		14 ms
		, 在所有 Java 提交中击败了
		47.17%
		的用户
		内存消耗 :
		39.2 MB
		, 在所有 Java 提交中击败了
		66.67%
		的用户*/
    private int[][] maze;

    private int[] hole;

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        if (null == maze || maze.length == 0) {
            return "impossible";
        }
        this.maze = maze;
        this.hole = hole;
        //按字典序定义方向:下->左->右->上
        int[][] director = new int[][]{
                {1, 0}, {0, -1}, {0, 1}, {-1, 0}
        };
        //按字典序定义方向
        String[] directStr = new String[]{"d", "l", "r", "u"};
        
        Point ballPoint = new Point(ball[0], ball[1]);
        Queue<Point> queue = new PriorityQueue<Point>(
                (p1, p2) -> (p1.compareTo(p2)));
        queue.add(ballPoint);
        int rows = maze.length;
        int cols = maze[0].length;
        //存储从球到位置[i][j]的最小步数。不断刷新最小步数的值
        Point[][] dp = new Point[rows][cols];
        boolean[][] visited = new boolean[rows][cols];
        visited[ballPoint.x][ballPoint.y] = true;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < director.length; i++) {
                //下一个节点
                int nextX = point.x + director[i][0];
                int nextY = point.y + director[i][1];

                //如果这个节点的坐标坐标在范围内
                while (nextX >= 0 && nextX < rows && nextY >= 0 && nextY < cols && maze[nextX][nextY] == 0) {
                    //如果是洞，返回
                    if (nextX == hole[0] && nextY == hole[1]) {
                        nextX = nextX + director[i][0];
                        nextY = nextY + director[i][1];
                        break;
                    }
                    nextX = nextX + director[i][0];
                    nextY = nextY + director[i][1];
                }
                //可能是墙，可能是洞，可能是边。坐标往后回退一位
                nextX = nextX - director[i][0];
                nextY = nextY - director[i][1];
                int steps = point.count + Math.abs(point.x - nextX) + Math.abs(point.y - nextY);
                Point tempPoint = new Point(nextX, nextY);
                tempPoint.count = steps;
                tempPoint.addWays(point.ways, directStr[i]);
                //刷新最小步数，刷新了步数的，都需要加入队列中重新计算，
                if (dp[nextX][nextY] == null || tempPoint.compareTo(dp[nextX][nextY]) < 0) {
                    dp[nextX][nextY] = tempPoint;
                    //不要把某个阶段的起点加进去！！
                    if (!tempPoint.isHole() && (nextX != point.x || nextY != point.y)) {
                        queue.offer(tempPoint);
                    }
                }
            }
        }
        if (null == dp[hole[0]][hole[1]] || dp[hole[0]][hole[1]].count <= 0) {
            return "impossible";
        }
        return dp[hole[0]][hole[1]].ways;
    }

    class Point implements Comparable<Point> {
        int x;

        int y;

        int count;

        String ways;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
            ways = new String();
        }

        boolean isHole() {
            return x == hole[0] && y == hole[1];
        }

        void addWays(String oldWays, String director) {
            if (oldWays.length() == 0) {
                ways = director;
                return;
            }
            String last = oldWays.substring(oldWays.length() - 1);
            if (!last.equals(director)) {
                ways = oldWays + director;
            } else {
                ways = oldWays;
            }
        }

        @Override
        public int compareTo(Point o) {
            if (this.count == o.count) {
                return this.ways.compareTo(o.ways);
            }
            return this.count - o.count;
        }
    }
}
