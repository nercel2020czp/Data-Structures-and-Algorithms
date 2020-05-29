/**
 * 
 */
/**
 * @author 15753
 *
 */
package l_1036_逃离大迷宫_escape_a_large_maze;
/*

在一个 10^6 x 10^6 的网格中，每个网格块的坐标为 (x, y)，其中 0 <= x, y < 10^6。

我们从源方格 source 开始出发，意图赶往目标方格 target。每次移动，我们都可以走到网格中在四个
方向上相邻的方格，只要该方格不在给出的封锁列表 blocked 上。

只有在可以通过一系列的移动到达目标方格时才返回 true。否则，返回 false。

示例 1：

输入：blocked = [[0,1],[1,0]], source = [0,0], target = [0,2]
输出：false
解释：
从源方格无法到达目标方格，因为我们无法在网格中移动。
-----------------------------
示例 2：

输入：blocked = [], source = [0,0], target = [999999,999999]
输出：true
解释：
因为没有方格被封锁，所以一定可以到达目标方格。
-----------------------------------
提示：

0 <= blocked.length <= 200
blocked[i].length == 2
0 <= blocked[i][j] < 10^6
source.length == target.length == 2
0 <= source[i][j], target[i][j] < 10^6
source != target
-----------------------------------
class Solution {
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {

    }
}

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/escape-a-large-maze
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

*/