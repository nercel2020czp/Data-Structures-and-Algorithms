package l_0210_课程表_II;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
//拓扑排序（广度优先遍历）
/*
拓扑排序（广度优先遍历） + 深度优先遍历（Java、Python）
	先说最重要的部分：

	1.	「拓扑排序」是专门应用于有向图的算法；
	2.	这道题用 BFS 和 DFS 都可以完成，只需要掌握 BFS 的写法就可以了，BFS 的写法很经典；
	3.	BFS 的写法就叫「拓扑排序」，这里还用到了贪心算法的思想，贪的点是：当前让入度为 0 的那些结点入队；
	4.	「拓扑排序」的结果不唯一；
	5.	删除结点的操作，通过「入度数组」体现，这个技巧要掌握；
	6.	「拓扑排序」的一个附加效果是：能够顺带检测有向图中是否存在环，这个知识点非常重要，如果在面试的过程中遇到这个问题，要把这一点说出来。
		具有类似附加功能的算法还有：Bellman-Ford 算法附加的作用是可以用于检测是否有负权环（在这里不展开了，我也不太熟）。

图1.gif

图2.png

如果优先图中，存在环，拓扑排序不能继续得到入度值为 0 的节点，退出循环，此时图中存在没有遍历到的节点，说明图中存在环。

此时说明课程设计不合理，有循环依赖。

图3.png

拓扑排序实际上应用的是贪心算法，贪心算法简而言之：每一步最优，则全局最优。

具体到拓扑排序，每一次都从图中删除没有前驱的顶点，这里并不需要真正的做删除操作，
我们可以设置一个入度数组，每一轮都输出入度为 0 的结点，并移除它、修改它指向的结点的入度（-1−1即可），
依次得到的结点序列就是拓扑排序的结点序列。如果图中还有结点没有被移除，则说明“不能完成所有课程的学习”。

拓扑排序保证了每个活动（在这题中是“课程”）的所有前驱活动都排在该活动的前面，并且可以完成所有活动。
拓扑排序的结果不唯一。拓扑排序还可以用于检测一个有向图是否有环。相关的概念还有 AOV 网，这里就不展开了。

算法流程：
1、在开始排序前，扫描对应的存储空间（使用邻接表），将入度为 0 的结点放入队列。
2、只要队列非空，就从队首取出入度为 0 的结点，将这个结点输出到结果集中，
	并且将这个结点的所有邻接结点（它指向的结点）的入度减 1，在减 1 以后，
	如果这个被减 1 的结点的入度为 0 ，就继续入队。
3、当队列为空的时候，检查结果集中的顶点个数是否和课程数相等即可。
（思考这里为什么要使用队列？如果不用队列，还可以怎么做，会比用队列的效果差还是更好？）

在代码具体实现的时候，除了保存入度为 0 的队列，我们还需要两个辅助的数据结构：
1、邻接表：通过结点的索引，我们能够得到这个结点的后继结点；
2、入度数组：通过结点的索引，我们能够得到指向这个结点的结点个数。
这个两个数据结构在遍历题目给出的邻边以后就可以很方便地得到。

作者：liweiwei1419
链接：https://leetcode-cn.com/problems/course-schedule-ii/solution/tuo-bu-pai-xu-shen-du-you-xian-bian-li-python-dai-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
public class Solution1 {
/*	执行用时 :
		6 ms
		, 在所有 Java 提交中击败了
		88.86%
		的用户
		内存消耗 :
		40.9 MB
		, 在所有 Java 提交中击败了
		93.33%
		的用户*/
/*	算法流程：
	1、在开始排序前，扫描对应的存储空间（使用邻接表），将入度为 0 的结点放入队列。
	2、只要队列非空，就从队首取出入度为 0 的结点，将这个结点输出到结果集中，
		并且将这个结点的所有邻接结点（它指向的结点）的入度减 1，在减 1 以后，
		如果这个被减 1 的结点的入度为 0 ，就继续入队。
	3、当队列为空的时候，检查结果集中的顶点个数是否和课程数相等即可。
	（思考这里为什么要使用队列？如果不用队列，还可以怎么做，会比用队列的效果差还是更好？）*/
	class Solution {
	    public int[] findOrder(int numCourses, int[][] prerequisites) {
	        if (numCourses <= 0) {
	            return new int[0];
	        }

	        @SuppressWarnings("unchecked")
			HashSet<Integer>[] adj = new HashSet[numCourses];
	        for (int i = 0; i < numCourses; i++) {
	            adj[i] = new HashSet<>();
	        }

	        
	        // [1,0] 0 -> 1
	        int[] inDegree = new int[numCourses];
	        for (int[] p : prerequisites) {
	            adj[p[1]].add(p[0]);
	            inDegree[p[0]]++;//课程p[0]	的先修课程数目加1
	        }

	        //1、在开始排序前，扫描对应的存储空间（使用邻接表），将入度为 0 的结点放入队列。
	        Queue<Integer> queue = new LinkedList<>();
	        for (int i = 0; i < numCourses; i++) {
	            if (inDegree[i] == 0) {
	                queue.offer(i);
	            }
	        }

	        int[] res = new int[numCourses];
	        // 当前结果集列表里的元素个数，正好可以作为下标
	        int count = 0;

/*	        	2、只要队列非空，就从队首取出入度为 0 的结点，将这个结点输出到结果集中，
			并且将这个结点的所有邻接结点（它指向的结点）的入度减 1，在减 1 以后，
			如果这个被减 1 的结点的入度为 0 ，就继续入队。
*/	        while (!queue.isEmpty()) {
	            // 当前入度为 0 的结点
	            Integer head = queue.poll();
	            res[count] = head;
	            count++;

	            Set<Integer> successors = adj[head];
	            for (Integer nextCourse : successors) {
	                inDegree[nextCourse]--;
	                // 马上检测该结点的入度是否为 0，如果为 0，马上加入队列
	                if (inDegree[nextCourse] == 0) {
	                    queue.offer(nextCourse);
	                }
	            }
	        }
	        
	        // 3.	如果结果集中的数量不等于结点的数量，就不能完成课程任务，这一点是拓扑排序的结论
	        if (count == numCourses) {
	            return res;
	        }
	        return new int[0];
	    }
	}
	
/*	复杂度分析：

	时间复杂度：O(E+V)。这里 E 表示邻边的条数，V 表示结点的个数。初始化入度为 0 的集合需要遍历整张图，具体做法是检查每个结点和每条边，因此复杂度为 O(E+V)O(E+V)，然后对该集合进行操作，又需要遍历整张图中的每个结点和每条边，复杂度也为 O(E+V)O(E+V)；
	空间复杂度：O(V)：入度数组、邻接表的长度都是结点的个数 V，即使使用队列，队列最长的时候也不会超过 V，因此空间复杂度是 O(V)。

	作者：liweiwei1419
	链接：https://leetcode-cn.com/problems/course-schedule-ii/solution/tuo-bu-pai-xu-shen-du-you-xian-bian-li-python-dai-/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
