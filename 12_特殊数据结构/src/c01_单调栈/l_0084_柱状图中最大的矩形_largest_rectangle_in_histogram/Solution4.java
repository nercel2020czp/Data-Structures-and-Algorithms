package c01_单调栈.l_0084_柱状图中最大的矩形_largest_rectangle_in_histogram;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
方法 4：优化的分治
算法

可以观察到，方法 3 中大的问题被分解成更小的子问题来求解，所以分治方法会有一定程度的优化。
但是如果数组本身是升序或者降序的，将没有优化作用，原因是每次我们都需要在一个很大的 O(n)O(n) 
级别的数组里找最小值。因此，最坏情况下总的时间复杂度变成了 O(n^2)O(n 2 ) 。
我们可以用线段树代替遍历来找到区间最小值。
单词查询复杂度就变成了O\big(\log n\big)O(logn) 。

作者：LeetCode
链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/zhu-zhuang-tu-zhong-zui-da-de-ju-xing-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

public class Solution4 {
	
	public int calculateArea(int[] heights, int start, int end) {
		if (start > end)
			return 0;
		int minindex = start;
		//替换成线段树
/*		for (int i = start; i <= end; i++)
			if (heights[minindex] > heights[i])
				minindex = i;*/
		segTree.query(start, end);
		return Math.max(heights[minindex] * (end - start + 1),
				Math.max(calculateArea(heights, start, minindex - 1), 
						calculateArea(heights, minindex + 1, end)));
	}
	SegmentTree<Integer> segTree = null;
	public int largestRectangleArea(int[] heights) {
		//先将int数组转换为数值流
		IntStream stream = Arrays.stream(heights);
		//流中的元素全部装箱，转换为流 ---->int转为Integer
		Stream<Integer> integerStream = stream.boxed();
		//将流转换为数组
		Integer[] integers = integerStream.toArray(Integer[]::new);
        segTree = new SegmentTree<Integer>(integers,(a, b) -> a < b ? a : b);
		return calculateArea(heights, 0, heights.length - 1);
	}
}
interface Merger<E> {
    E merge(E a, E b);
}
class SegmentTree<E> {

    private E[] tree;
    private E[] data;
    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger){

        this.merger = merger;

        data = (E[])new Object[arr.length];
        for(int i = 0 ; i < arr.length ; i ++)
            data[i] = arr[i];

        tree = (E[])new Object[4 * arr.length];
        buildSegmentTree(0, 0, arr.length - 1);
    }

    // 在treeIndex的位置创建表示区间[l...r]的线段树
    private void buildSegmentTree(int treeIndex, int l, int r){

        if(l == r){
            tree[treeIndex] = data[l];
            return;
        }

        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        // int mid = (l + r) / 2;
        int mid = l + (r - l) / 2;
        buildSegmentTree(leftTreeIndex, l, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, r);

        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    public int getSize(){
        return data.length;
    }

    public E get(int index){
        if(index < 0 || index >= data.length)
            throw new IllegalArgumentException("Index is illegal.");
        return data[index];
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index){
        return 2*index + 1;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index){
        return 2*index + 2;
    }

    // 返回区间[queryL, queryR]的值
    public E query(int queryL, int queryR){

        if(queryL < 0 || queryL >= data.length ||
                queryR < 0 || queryR >= data.length || queryL > queryR)
            throw new IllegalArgumentException("Index is illegal.");

        return query(0, 0, data.length - 1, queryL, queryR);
    }

    // 在以treeIndex为根的线段树中[l...r]的范围里，搜索区间[queryL...queryR]的值
    private E query(int treeIndex, int l, int r, int queryL, int queryR){

        if(l == queryL && r == queryR)
            return tree[treeIndex];
//        	return tree[treeIndex];

        int mid = l + (r - l) / 2;
        // treeIndex的节点分为[l...mid]和[mid+1...r]两部分

        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        if(queryL >= mid + 1)
            return query(rightTreeIndex, mid + 1, r, queryL, queryR);
        else if(queryR <= mid)
            return query(leftTreeIndex, l, mid, queryL, queryR);

        E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
        E rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
        return merger.merge(leftResult, rightResult);
    }
    


    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append('[');
        for(int i = 0 ; i < tree.length ; i ++){
            if(tree[i] != null)
                res.append(tree[i]);
            else
                res.append("null");

            if(i != tree.length - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }
}