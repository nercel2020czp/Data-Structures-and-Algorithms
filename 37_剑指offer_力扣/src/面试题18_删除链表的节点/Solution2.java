package 面试题18_删除链表的节点;
/*
2. val: ListNode 解法：信息交换法
首先说明，本人第一次接触这个方法，也是比较懵，但是细细想来还觉得有一番道理，
这道题其实考察了我们对链表的操作和时间复杂度的理解。如果以下论述有不当之处，
恳请各位多多指正。

一般来讲，正常的解法时间复杂度都是 O(N)，因为我们要找到待删除节点，不得不牺牲 O(N) 的时间复杂度。
那么 O(1) 的时间复杂度是如何实现的呢？这里有一个信息交换法，即：
假如 head 为 4 -> 5 -> 1 -> 9，val 为 5 -> 1 -> 9，表示我们要删除结点 5，
这时我们使用信息交换，把 val 改为 1 -> 9的信息就行了。

作者：z1m
链接：https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/solution/cong-on-dao-o1-by-ml-zimingmeng/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
class deleteNode {public static ListNode deleteNode(ListNode head, ListNode val){
    if (head == null || val == null){
        return null;
    }
    if (val.next != null){   // 待删除节点不是尾节点
        ListNode next = val.next;
        val.val = next.val;
        val.next = next.next;
    } else if (head == val){   // 待删除节点只有一个节点，此节点为头节点
        head = null;
    } else {   // 待删除节点为尾节点
        ListNode cur = head;
        while (cur.next != val){
            cur = cur.next;
        }
        cur.next = null;
    }
    return head;
}
/*
复杂度分析
时间复杂度：O(1)O(1)。平均时间复杂度为：(O(1)\times(n-1) + O(n))/n = O(1)(O(1)×(n−1)+O(n))/n=O(1)，仍然为 O(1)O(1)。
空间复杂度：O(1)O(1)。
欢迎补充 C++ 代码~如有问题，欢迎讨论~

作者：z1m
链接：https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/solution/cong-on-dao-o1-by-ml-zimingmeng/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/


}
