package t046_孩子们的游戏_圆圈中最后剩下的数;

import java.util.ArrayList;
import java.util.List;

/*解法1：常规解法（模拟一）
【核心思想】
	用链表模拟这个游戏

【数据结构】
	链表
	
【思路】
	将[0,n]依次存储在链表中
	只要链表的长度不为1，就一直循环，如果到了第m个就remove；否则将其添加到链表尾部
	时间复杂度为O(nm)

作者：yuanninesuns   
链接：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/si-chong-fang-fa-xiang-xi-jie-da-by-yuanninesuns/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
public class Solution1 {
	public int lastRemaining(int n, int m) {
	     List<Integer> list=new ArrayList<Integer>();
	     for(int i=0;i<n;i++)
	         list.add(i);
	     while(list.size()>1){
	         for(int j=0;j<m;j++){
	             if(j!=m-1)
	                 list.add(list.get(0));
	             list.remove(0);
	         }
	     }
	     return list.get(0);
	 }
//	这个模拟的方法虽然简单，但是超时。怎么办？我们稍微改一下逻辑。
}
