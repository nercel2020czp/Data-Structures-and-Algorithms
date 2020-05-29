package 面试题06_从尾到头打印链表;

import java.util.ArrayList;

/*方法一：递归法
解题思路：
	利用递归： 先走至链表末端，回溯时依次将节点值加入列表 ，这样就可以实现链表值的倒序输出。
	Java 算法流程：
		1.递推阶段： 每次传入 head.next ，以 head == null（即走过链表尾部节点）
		    为递归终止条件，此时直接返回。
	    2.回溯阶段： 层层回溯时，将当前节点值加入列表，即tmp.add(head.val)。
	    3.最终，将列表 tmp 转化为数组 res ，并返回即可。
	    
复杂度分析：
	时间复杂度 O(N)： 遍历链表，递归 N 次。
	空间复杂度 O(N)： 系统递归需要使用 O(N) 的栈空间。
	
作者：jyd
链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/solution/mian-shi-ti-06-cong-wei-dao-tou-da-yin-lian-biao-d/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}
public class Solution1 {
    ArrayList<Integer> tmp = new ArrayList<Integer>();
    public int[] reversePrint(ListNode head) {
        recur(head);
        int[] res = new int[tmp.size()];
        for(int i = 0; i < res.length; i++)
            res[i] = tmp.get(i);
        return res;
    }
    void recur(ListNode head) {
        if(head == null) return;
        recur(head.next);
        tmp.add(head.val);
    }
/*    
    执行用时 :
    	2 ms
    	, 在所有 Java 提交中击败了
    	66.21%
    	的用户
    	内存消耗 :
    	40.5 MB
    	, 在所有 Java 提交中击败了
    	100.00%
    	的用户
    
  */  
}
