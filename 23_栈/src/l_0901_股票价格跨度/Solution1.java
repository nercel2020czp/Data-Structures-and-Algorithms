package l_0901_股票价格跨度;

import java.util.Stack;

/*这道题利用了 单调增栈每次插入新数据时，会一次性将比自己小的元素全部排出 的特性
这个特性正好和题目里的 价格小于或等于今天价格的最大连续日 是刚好吻合的

换句话说，我们单次插入某值时抛弃的元素组，就是该值前的一段连续日
所以每次插入新数据，都会将栈顶 折叠 一次，你可以想象成俄罗斯方块消层那种感觉

问题在于，因为单调栈是要把元素都丢弃的，状态都被“折叠”了，我们会丢失长度，所以容易想到，
我们需要cache一下之前栈内元素被折叠的长度cache有很多种方式，
可以用hash表等数据结构，也可以用动态规划
但这题的更优解是，使用另一个同步栈来缓存，读者可以根据下面第一版的代码，
动笔推导一下折叠过程，就能体会同步栈工作的原理了。

都说编程旷世难题是取名字，名字取好了，问题也就解决了一半（才怪
我们可以将两个栈分别命名为 prices 和 cache

<hr/>

我们如果发现插入元素满足本身栈的递减需求，则折叠栈直接插入1，因为该值前一个值是比它大的，他们间隔1天
如果不满足，则开始折叠，并将折叠栈中，值比它小的所有段落的折叠长度都累计起来，再重新插入折叠栈中保存

作者：jiuchenm
链接：https://leetcode-cn.com/problems/online-stock-span/solution/dan-diao-zhan-tao-lu-xie-fa-you-hua-wei-guan-fang-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
public class Solution1 {
/*	执行用时 :
		44 ms
		, 在所有 Java 提交中击败了
		52.50%
		的用户
		内存消耗 :
		48.9 MB
		, 在所有 Java 提交中击败了
		100.00%
		的用户*/
	class StockSpanner {
	    private Stack<Integer> prices;
	    private Stack<Integer> cache;

	    public StockSpanner() {
	        prices = new Stack<Integer>();
	        cache = new Stack<Integer>();
	    }
	    
	    public int next(int price) {
	        int ans = 1;
	        while(prices.size() > 0 && prices.peek() <= price) {
	            prices.pop();
	            ans += cache.pop();
	        }
	        cache.push(ans);
	        prices.push(price);
	        return ans;
	    }
	}

/*	作者：jiuchenm
	链接：https://leetcode-cn.com/problems/online-stock-span/solution/dan-diao-zhan-tao-lu-xie-fa-you-hua-wei-guan-fang-/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
