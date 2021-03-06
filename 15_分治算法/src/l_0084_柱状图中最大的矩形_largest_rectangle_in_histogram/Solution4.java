package l_0084_柱状图中最大的矩形_largest_rectangle_in_histogram;
/*
  方法 4：优化的分治
  
  算法

可以观察到，方法 3 中大的问题被分解成更小的子问题来求解，所以分治方法会有一定程度的优化。
但是如果数组本身是升序或者降序的，将没有优化作用，原因是每次我们都需要在一个很大的 O(n)
 级别的数组里找最小值。因此，最坏情况下总的时间复杂度变成了 O(n^2) 。我们可以用线段树代
 替遍历来找到区间最小值。单词查询复杂度就变成了O(logn) 。

对于具体实现，可以查看 这里 。

复杂度分析

时间复杂度：O(nlogn) 。 对于长度为 n 	 的查询，线段树需要 logn 的时间。

空间复杂度：O(n)。这是线段树的空间开销。

  */
public class Solution4 {

}
