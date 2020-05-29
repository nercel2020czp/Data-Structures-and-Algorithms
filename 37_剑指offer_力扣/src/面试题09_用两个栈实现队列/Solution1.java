package 面试题09_用两个栈实现队列;

import java.util.LinkedList;

/*
面试题09. 用两个栈实现队列（清晰图解）
解题思路：
                            元素添加	                         元素删除
栈（先入后出）	   栈顶	                            栈顶
队列（先入先出）    队尾                                     队首

1.栈无法实现队列功能： 栈底元素（对应队首元素）无法直接删除，需要将上方所有元素出栈。
2.双栈可实现列表倒序： 设有含三个元素的栈 A = [1,2,3] 和空栈 B = []。若循环执行 A 
    元素出栈并添加入栈 B ，直到栈 A 为空，则 A = [] , B = [3,2,1] ，
    即 栈 B 元素实现栈 A 元素倒序
3.利用栈 B 删除队首元素： 倒序后，B 执行出栈则相当于删除了 A 的栈底元素，即对应队首元素。

函数设计：
	题目只要求实现 加入队尾appendTail() 和 删除队首deleteHead() 两个函数的正常工作，
	因此我们可以设计栈 A 用于加入队尾操作，栈 B 用于将元素倒序，从而实现删除队首元素。
	1.加入队尾 appendTail()函数： 将数字 val 加入栈 A 即可。
	2.删除队首deleteHead()函数： 有以下三种情况。
		1.1 当栈 B 不为空： B中仍有已完成倒序的元素，因此直接返回 B 的栈顶元素。
		1.2 否则，当 A 为空： 即两个栈都为空，无元素，因此返回 -1 。
		1.3 否则： 将栈 A 元素全部转移至栈 B 中，实现元素倒序，并返回栈 B 的栈顶元素。

复杂度分析：
	由于问题特殊，以下分析仅满足添加 N 个元素并删除 N 个元素，即栈初始和结束状态下都为空的情况。
	1.时间复杂度： appendTail()函数为 O(1) ；deleteHead() 函数在 N 次队首元素删除操作中总共需完成 N 个元素的倒序。
	2.空间复杂度 O(N) ： 最差情况下，栈 A 和 B 共保存 N 个元素。


我认为本题目 Java 使用 Stack/LinkedList/ArrayDeque 都是可以的，
因为题目的本意应该是让我们使用 先进后出 实现 先进先出 ，而不是考察对某一集合框架的具体使用。
以上三种类型的区别可参考 Stack，ArrayDeque，LinkedList的区别 ，文中指出：
频繁的插入和删除操作首选 LinkedList ，并且通常情况下不推荐使用Vector以及其子类 Stack 。
https://blog.csdn.net/cartoon_/article/details/87992743
*/
public class Solution1 {
	class CQueue {
	    LinkedList<Integer> A, B;
	    public CQueue() {
	        A = new LinkedList<Integer>();
	        B = new LinkedList<Integer>();
	    }
	    public void appendTail(int value) {
	        A.addLast(value);
	    }
	    public int deleteHead() {
	        if(!B.isEmpty()) return B.removeLast();
	        if(A.isEmpty()) return -1;
	        while(!A.isEmpty())
	            B.addLast(A.removeLast());
	        return B.removeLast();
	    }
	}
	
	
/*	
	执行用时 :
		88 ms
		, 在所有 Java 提交中击败了
		65.97%
		的用户
		内存消耗 :
		46.6 MB
		, 在所有 Java 提交中击败了
		100.00%
		的用户
		
*/
/*
	作者：jyd
	链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/solution/mian-shi-ti-09-yong-liang-ge-zhan-shi-xian-dui-l-2/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
