package l_0895_最大频率栈;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*方法：栈
思路

显然，我们更关心元素的频率。令 freq 作为 xx 到 xx 的出现次数的映射 Map。

此外，我们也（可能）关心 maxfreq，即栈中任意元素的当前最大频率。
这是理所应当的事情，因为我们必须弹出频率最高的元素。

那么当前主要的问题就变成了：
在具有相同的（最大）频率的元素中，怎么判断那个元素是最新的？
我们可以使用栈来查询这一信息：靠近栈顶的元素总是相对更新一些。

为此，我们令 group 作为从频率到具有该频率的元素的映射。
到目前，我们已经实现了 FreqStack 的所有必要的组件。

算法

实际上，作为实现层面上的一点细节，如果 x 的频率为 f，
那么我们将获取在所有 group[i] (i <= f) 中的 x,而不仅仅是栈顶的那个。
这是因为每个 group[i] 都会存储与第 i 个 x 副本相关的信息。

此后，我们仅仅需要如上所述维护 freq，group，以及 maxfreq。

作者：LeetCode
链接：https://leetcode-cn.com/problems/maximum-frequency-stack/solution/zui-da-pin-lu-zhan-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
public class Solution1 {
/*	复杂度分析

	时间复杂度：对于 push 和 pop 操作，O(1)O(1)。

	空间复杂度：O(N)O(N)，其中 N 为 FreqStack 中元素的数目。

	作者：LeetCode
	链接：https://leetcode-cn.com/problems/maximum-frequency-stack/solution/zui-da-pin-lu-zhan-by-leetcode/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
/*	执行用时 :
		42 ms
		, 在所有 Java 提交中击败了
		68.33%
		的用户
		内存消耗 :
		49.3 MB
		, 在所有 Java 提交中击败了
		100.00%
		的用户*/
	class FreqStack {
	    Map<Integer, Integer> freq;
	    Map<Integer, Stack<Integer>> group;
	    int maxfreq;

	    public FreqStack() {
	        freq = new HashMap<>();
	        group = new HashMap<>();
	        maxfreq = 0;
	    }

	    public void push(int x) {
	        int f = freq.getOrDefault(x, 0) + 1;
	        freq.put(x, f);
	        if (f > maxfreq)
	            maxfreq = f;

	        group.computeIfAbsent(f, z-> new Stack<>()).push(x);
	    }

	    public int pop() {
	        int x = group.get(maxfreq).pop();
	        freq.put(x, freq.get(x) - 1);
	        if (group.get(maxfreq).size() == 0)
	            maxfreq--;
	        return x;
	    }
	}

/*	作者：LeetCode
	链接：https://leetcode-cn.com/problems/maximum-frequency-stack/solution/zui-da-pin-lu-zhan-by-leetcode/
	来源：力扣（LeetCode）
	著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
