package l_0752_打开转盘锁_open_the_lock;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*

题目中描述的就是我们生活中常见的那种密码锁，若果没有任何约束，
最少的拨动次数很好算，就像我们平时开密码锁那样直奔密码拨就行了。

但现在的难点就在于，不能出现deadends，应该如何计算出最少的转动次数呢？

第一步，我们不管所有的限制条件，不管deadends和target的限制，
就思考一个问题：如果让你设计一个算法，穷举所有可能的密码组合，你怎么做？

穷举呗，再简单一点，如果你只转一下锁，有几种可能？总共有 4 个位置，
每个位置可以向上转，也可以向下转，也就是有 8 种可能对吧。

比如说从"0000"开始，转一次，可以穷举出"1000", "9000", "0100", "0900"...共 8 种密码。
然后，再以这 8 种密码作为基础，对每个密码再转一下，穷举出所有可能…

仔细想想，这就可以抽象成一幅图，每个节点有 8 个相邻的节点，又让你求最短距离，
这不就是典型的 BFS 嘛，框架就可以派上用场了，先写出一个「简陋」的 BFS 框架代码再说别的：

		// 将 s[j] 向上拨动一次
		String plusOne(String s, int j) {
		    char[] ch = s.toCharArray();
		    if (ch[j] == '9')
		        ch[j] = '0';
		    else
		        ch[j] += 1;
		    return new String(ch);
		}
		// 将 s[i] 向下拨动一次
		String minusOne(String s, int j) {
		    char[] ch = s.toCharArray();
		    if (ch[j] == '0')
		        ch[j] = '9';
		    else
		        ch[j] -= 1;
		    return new String(ch);
		}
		
		// BFS 框架，打印出所有可能的密码
		void BFS(String target) {
		    Queue<String> q = new LinkedList<>();
		    q.offer("0000");
		
		    while (!q.isEmpty()) {
		        int sz = q.size();
		        //将当前队列中的所有节点向周围扩散
		        for (int i = 0; i < sz; i++) {
		            String cur = q.poll();
		            //判断是否到达终点 
		            System.out.println(cur);
		
		            //将一个节点的相邻节点加入队列 
		            for (int j = 0; j < 4; j++) {
		                String up = plusOne(cur, j);
		                String down = minusOne(cur, j);
		                q.offer(up);
		                q.offer(down);
		            }
		        }
		        //在这里增加步数
		    }
		    return;
		}
PS：这段代码当然有很多问题，但是我们做算法题肯定不是一蹴而就的，
而是从简陋到完美的。不要完美主义，咱要慢慢来，好不。

这段 BFS 代码已经能够穷举所有可能的密码组合了，但是显然不能完成题目，
有如下问题需要解决：

	1、会走回头路。比如说我们从"0000"拨到"1000"，但是等从队列拿出
	"1000"时，还会拨出一个"0000"，这样的话会产生死循环。
	
	2、没有终止条件，按照题目要求，我们找到target就应该结束并返回拨动的次数。
	
	3、没有对deadends的处理，按道理这些「死亡密码」是不能出现的，
	     也就是说你遇到这些密码的时候需要跳过。

 */
public class Solution1 {
	// 将 s[j] 向上拨动一次
	String plusOne(String s, int j) {
		char[] ch = s.toCharArray();
		if (ch[j] == '9')
			ch[j] = '0';
		else
			ch[j] += 1;
		return new String(ch);
	}

	// 将 s[i] 向下拨动一次
	String minusOne(String s, int j) {
		char[] ch = s.toCharArray();
		if (ch[j] == '0')
			ch[j] = '9';
		else
			ch[j] -= 1;
		return new String(ch);
	}

	public int openLock(String[] deadends, String target) {
		// 记录需要跳过的死亡密码
		Set<String> deads = new HashSet<>();
		for (String s : deadends)
			deads.add(s);
		// 记录已经穷举过的密码，防止走回头路
		Set<String> visited = new HashSet<>();
		Queue<String> q = new LinkedList<>();
		// 从起点开始启动广度优先搜索
		int step = 0;
		q.offer("0000");
		visited.add("0000");

		while (!q.isEmpty()) {
			int sz = q.size();
			/* 将当前队列中的所有节点向周围扩散 */
			for (int i = 0; i < sz; i++) {
				String cur = q.poll();

				/* 判断是否到达终点 */
				if (deads.contains(cur))
					continue;
				if (cur.equals(target))
					return step;

				/* 将一个节点的未遍历相邻节点加入队列 */
				for (int j = 0; j < 4; j++) {
					String up = plusOne(cur, j);
					if (!visited.contains(up)) {
						q.offer(up);
						visited.add(up);
					}
					String down = minusOne(cur, j);
					if (!visited.contains(down)) {
						q.offer(down);
						visited.add(down);
					}
				}
			}
			/* 在这里增加步数 */
			step++;
		}
		// 如果穷举完都没找到目标密码，那就是找不到了
		return -1;
	}
}
