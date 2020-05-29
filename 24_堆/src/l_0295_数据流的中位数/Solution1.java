package l_0295_数据流的中位数;
import java.util.PriorityQueue;
/*
思路分析：
	一种最容易想到的思路是，数据流新进来一个数，都把它与已经读出来的数进行一次排序，
	这样中位数就可以很容易得到。这样做“不好”的地方是：
	
	排序的时间复杂度为 O(NlogN)，但事实上，我对除了中位数以外的其它位置的元素并不关心。
	
事实上，我们只关心在中间的那两个数（或者一个数），其它数没有必要进行 “比较” 和 “交换” 的操作。	

在我们学习过的数据结构里，堆就有类似的性质，每次都从堆里得到一个 “最值” 而其它元素无需排序，
这样就可以以 O(logN) 的复杂度每次都从堆中取出最值。

请读者在看完以上思路之后思考：
	1、数据是如何在两个堆之间流动的，脑子里要建立如下动态的过程：
	     为了找到添加新数据以后，数据流的中位数，我们让这个新数据在
	     大顶堆和小顶堆中都走了一遍。而为了让大顶堆的元素多 1 个，
	     我们让从小顶堆中又拿出一个元素“送回”给大顶堆；
	
	2、将元素放入优先队列以后，优先队列会以对数时间复杂度自行调整，
	      把“最优值”放入堆顶，这是使用优先队列解决这个问题的原因。
	      如果不太熟悉优先队列的朋友们，请复习一下优先队列的相关知识，
	      包括基本操作，理解上浮和下沉。
	      
说明： 这道题使用 Java 编码看起来思路更清晰一些，在 Python 中的堆只有小顶堆，
在构造大顶堆的时候，要绕一个弯子，具体请看如下参考代码。

作者：liweiwei1419
链接：https://leetcode-cn.com/problems/find-median-from-data-stream/solution/you-xian-dui-lie-python-dai-ma-java-dai-ma-by-liwe/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

作者：liweiwei1419
链接：https://leetcode-cn.com/problems/find-median-from-data-stream/solution/you-xian-dui-lie-python-dai-ma-java-dai-ma-by-liwe/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

*/
public class Solution1 {
/*	1、数据是如何在两个堆之间流动的，脑子里要建立如下动态的过程：
    为了找到添加新数据以后，数据流的中位数，我们让这个新数据在
    大顶堆和小顶堆中都走了一遍。而为了让大顶堆的元素多 11 个，
    我们让从小顶堆中又拿出一个元素“送回”给大顶堆；*/
}



class MedianFinder {

    /**
     * 当前大顶堆和小顶堆的元素个数之和
     */
    private int count;
    private PriorityQueue<Integer> maxheap;
    private PriorityQueue<Integer> minheap;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        count = 0;
        maxheap = new PriorityQueue<>((x, y) -> y - x);
        minheap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        count += 1;
        maxheap.offer(num);
        minheap.add(maxheap.poll());
        // 如果两个堆合起来的元素个数是奇数，小顶堆要拿出堆顶元素给大顶堆
        if ((count & 1) != 0) {
            maxheap.add(minheap.poll());
        }
    }

    public double findMedian() {
        if ((count & 1) == 0) {
            // 如果两个堆合起来的元素个数是偶数，数据流的中位数就是各自堆顶元素的平均值
            return (double) (maxheap.peek() + minheap.peek()) / 2;
        } else {
            // 如果两个堆合起来的元素个数是奇数，数据流的中位数大顶堆的堆顶元素
            return (double) maxheap.peek();
        }
    }
}

/*作者：liweiwei1419
链接：https://leetcode-cn.com/problems/find-median-from-data-stream/solution/you-xian-dui-lie-python-dai-ma-java-dai-ma-by-liwe/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
