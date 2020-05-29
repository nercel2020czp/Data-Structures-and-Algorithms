package l_0378_有序矩阵中第K小的元素;

import java.util.Collections;
import java.util.PriorityQueue;

/*
1.优先队列的使用
思路分析：

要找第k小的元素，一种最常规的做法就是使用优先队列。
找第k小的元素，就保留k个最小的元素，其中最大的那个就是答案，所以可以使用最大优先队列。
遍历矩阵中的元素，将元素添加到队列中，如果队列中元素数目MaxPQ.size() > k，就将堆点最大的元素弹出。
遍历结束后弹出堆顶元素，就是最小的k个元素中最大的，即第k小的元素。
这里可以利用矩阵的有序性做一点小的优化：
如果在遍历的过程中，队列中的元素数目已经为k了，且如果当前元素大于堆顶元素，这个元素放入队列中还会被弹出，所以就没必要放入。
并且遍历的内循环是从某一行的从左到右遍历，当前元素的右边元素比当前元素更大，也没必要放入队列，所以当MaxPQ.size() == k && num > MaxPQ.peek()，直接打断内循环，进行下一行的遍历。
时间复杂度为O(n^2log(k))O(n 
2
 log(k))，空间复杂度为O(k)O(k)。
运行结果：

执行用时 :21 ms, 在所有 Java 提交中击败了34.35%的用户
内存消耗 :45.8 MB, 在所有 Java 提交中击败了7.69%的用户

作者：ustcyyw
链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/solution/378java-er-fen-fa-tu-jie-you-xian-dui-lie-liang-ch/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

*/
public class Solution1 {
	public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> MaxPQ = new PriorityQueue<>(Collections.reverseOrder());
        for (int[] row : matrix) {
            for (int num : row) {
                if (MaxPQ.size() == k && num > MaxPQ.peek())
                    break;
                MaxPQ.add(num);
                if (MaxPQ.size() > k)
                    MaxPQ.remove();
            }
        }
        return MaxPQ.remove();
    }

//作者：ustcyyw
//链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/solution/378java-er-fen-fa-tu-jie-you-xian-dui-lie-liang-ch/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
