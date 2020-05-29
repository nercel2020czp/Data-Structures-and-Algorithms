/**
 * 
 */
/**
 * @author 15753
 *
 */
package c01_单调栈;
/*
https://www.jianshu.com/p/6bbd3653a57f
单调栈和应用实践

什么是单调栈
单调栈的定义：单调栈即满足单调性的栈结构。与单调队列相比，其只在一端进行进出。

如何使用单调栈
单调栈分为单调递增栈和单调递减栈，顾名思义，就是栈内元素是升序还是降序排列的，也涉及到出栈的逻辑。
如下图，分别插入6,10,3,7,4,12的时候，单调递增栈和单调递减栈的情况分别是样子的：
6857764-002221afed9bdadd.webp

//获取左边第一个小于自己的数，构造一个单调递减栈
private int[] getLeftMinNum(int[] src) {
    int[] result = new int[src.length];
    Stack<Integer> monotoneStack = new Stack<>();
    for (int i = 0; i < src.length; i++) {
        if (monotoneStack.isEmpty()) {
            monotoneStack.push(src[i]);
            result[i] = 0;
        } else {
            while (!monotoneStack.isEmpty() && src[i] < monotoneStack.peek()) {
                monotoneStack.pop();
            }
            if (!monotoneStack.isEmpty()) {
                result[i] = monotoneStack.peek();
            } else {
                result[i] = -1;
            }
            monotoneStack.push(src[i]);
        }
    }
    return result;
}
*/