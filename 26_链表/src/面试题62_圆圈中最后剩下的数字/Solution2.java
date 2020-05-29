package 面试题62_圆圈中最后剩下的数字;

import java.util.ArrayList;
import java.util.List;

/*解法2：常规解法（模拟二）
【核心思想】
	用链表模拟这个游戏

【数据结构】
	链表

【思路】
	将[0,n]依次存储在链表中
	通过举例可以得出第一次删除的数字下标为(m-1)%n记为c，之后每一次删除的数字下标均为(c+m-1)%list.size()

【备注】
	这个模拟的方法可以通过oj的检测，但是还不是最佳的方案。这道题是一道约瑟夫环的问题，我们可以用数学的方法来解决。


作者：yuanninesuns
链接：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/si-chong-fang-fa-xiang-xi-jie-da-by-yuanninesuns/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
public class Solution2 {
	public int lastRemaining(int n, int m) {
		if (n == 0 || m == 0)
			return -1;
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++)
			list.add(i);
		int c = (m - 1) % n;
		while (list.size() != 1) {
			list.remove(c);
			c = (c + m - 1) % list.size();
		}
		return list.get(0);
	}
}
