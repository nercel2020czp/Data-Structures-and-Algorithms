package c01_单调栈.l_1124_表现良好的最长时间段;

import java.util.Stack;

/*
https://www.jianshu.com/p/d0dabea38302
这个思路是看的解题思路里面一个Python3大佬的答案写的。
https://leetcode-cn.com/problems/longest-well-performing-interval/solution/
大佬就是大佬，即使给出了思路，我还是看了好久好久才看懂，期间还去补习了单调栈和前缀和的知识才看懂思路。
不了解或者不够熟悉推荐再去补一下相关知识：
单调栈和应用实践:https://www.jianshu.com/p/6bbd3653a57f
前缀和:https://www.jianshu.com/p/d0dabea38302

首先根据时间是否大于8，量化成1和-1利与计算， [9, 9, 6, 0, 6, 6, 9] => [1, 1, -1, -1, -1, -1, 1]，所以hours当前是[1, 1, -1, -1, -1, -1, 1]。
这个操作比较好理解，其实理解题意，我们要做的就是得到一个区间，这个区间里1和-1加起来要大于0。怎么方便的得到一个区间的和？很明显，这就是前缀和存在的意义。
转化成前缀和prefixSrc = [0, 1, 2, 1, 0, -1, -2, -1]，我们在前缀和前面加了一个0，是为了好操作。那如何得到一个区间呢？如果要得到[1,3]区间,根据前缀和定义需要用prefixSrc[3]-prefixSrc[1]，所以我们需要得到数组中所有prefixSrc[b]-prefixSrc[a] > 0的[a,b]区间，就是我们需要的结果。

作者：YocnZhao
链接：https://www.jianshu.com/p/c548dbae322d
来源：简书
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

作者：YocnZhao
链接：https://www.jianshu.com/p/c548dbae322d
来源：简书
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

*/
public class Solution1 {
    /**
    * 使用前缀和+单调栈
    *
    * @param src 源数组
    */
   public int longestWPI(int[] hours) {
       int max = 0;
       Stack<Integer> stack = new Stack<>();
       int[] prefixSrc = new int[hours.length + 1];
       //大于8的置为1，否则置为-1
       for (int i = 0; i < hours.length; i++) {
           if (hours[i] > 8) {
               max = 1;
               hours[i] = 1;
           } else {
               hours[i] = -1;
           }
           //初始化前缀和数组
           prefixSrc[0] = 0;
           prefixSrc[i + 1] = prefixSrc[i] + hours[i];
       }
       for (int i = 0; i < prefixSrc.length - 1; i++) {
           //实现单调栈
           if (stack.isEmpty()) {
               stack.push(i);
           } else {
               if (prefixSrc[i] < prefixSrc[stack.peek()]) {
                   stack.push(i);
               }
           }
       }
       //开始寻找,从后往前遍历
       for (int i = prefixSrc.length - 1; i >= 0; i--) {
           int last = i;
           while (!stack.isEmpty() && prefixSrc[i] > prefixSrc[stack.peek()]) {
               last = stack.pop();
           }
           if (last != i) {
               int width = i - last;
               max = max > width ? max : width;
           }
       }
       return max;
   }
}
