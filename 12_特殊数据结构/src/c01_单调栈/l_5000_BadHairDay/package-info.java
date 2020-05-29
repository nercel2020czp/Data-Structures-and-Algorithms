/**
 * 
 */
/**
 * @author 15753
 *
 */
package c01_单调栈.l_5000_BadHairDay;
/*
https://links.jianshu.com/go?to=http%3A%2F%2Fpoj.org%2Fproblem%3Fid%3D3250

Some of Farmer John's N cows (1 ≤ N ≤ 80,000) are having a bad hair day! 
Since each cow is self-conscious about her messy hairstyle, 
FJ wants to count the number of other cows that can see the top of other cows' heads.

Each cow i has a specified height hi (1 ≤ hi ≤ 1,000,000,000) and 
is standing in a line of cows all facing east (to the right in our diagrams). 
Therefore, cow i can see the tops of the heads of cows in front of her 
(namely cows i+1, i+2, and so on), for as long as these cows are strictly 
shorter than cow i.

每头牛只能看见右边的牛的头
假如牛的高度分别为 [10，3，7，4，12，2]

捕获.PNG

所以总的count = 3+1+1 = 5
思路：找到能看到的最大的牛的index，比如10就只需要找到右边第一个比自己高的牛的index，然后index-1就是自己能看到的最远的那头牛。
所以这个问题就简化为找到右边第一个比自己大的数的index，正好就是单调递增栈的功能。

作者：YocnZhao
链接：https://www.jianshu.com/p/6bbd3653a57f
来源：简书
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

*/